#!/usr/bin/env node

/* eslint-disable no-console */

const {static: staticDir, root} = require('../../config').paths;

const fs = require('fs');
const path = require('path');
const glob = require('glob');
const btoa = require('btoa');
const SVGO = require('svgo');
const mkdirp = require('mkdirp');
const svgo = new SVGO();

function getSVG (iconPath) {
    return new Promise((resolve, reject) => {
        fs.readFile(iconPath, { encoding: 'utf-8' }, (err, data) => {
            if (err) { reject(err); }
            svgo.optimize(data, result => {
                resolve({
                    name: path.parse(iconPath).name,
                    data: result
                });
            });
        });
    });
}

function sortSVGs (svgs) {
    return svgs.sort((a, b) => {
        const aInfo = a.data.info;
        const bInfo = b.data.info;
        if (aInfo.height !== bInfo.height) {
            return aInfo.height - bInfo.height;
        } else if (aInfo.width !== bInfo.width) {
            return bInfo.width  - aInfo.width;
        } else {
            return a.name.localeCompare(b.name);
        }
    });
}

function generateSassForSVG (svg) {
    const {name, data: fileData, data: {info: {width = 0, height = 0}}} = svg;
    return `
            %svg-i-${name},
            .svg-i-${name} {
                background-image: url(data:image/svg+xml;base64,${btoa(fileData.data)});
                background-position: 0 0;
                width: ${width}px;
                height: ${height}px;
            }
            .svg .i-${name} {
                @extend %svg-i-${name} !optional;
            }
    `.replace(/ {8}/g, '');
}

function saveSass (sass, dest, fileName) {
    return new Promise((resolve, reject) => {
        fs.writeFile(path.join(dest, fileName), `
                // THIS FILE WAS AUTOMATICALLY GENERATED BY
                // ${path.relative(root, path.resolve(__filename))}
                // DO NOT EDIT IT!

                @if ($svg-support) {
                    ${sass}
                }
            `.trim().replace(/ {16}/g, ''), err => {
                if (err) reject(err);
                resolve();
            }
        );
    });
}

module.exports = {
    description: 'Create sprites',
    task: ['commercial', 'global', 'membership', 'video'].map(target => {
        return {
            description: `Spriting ${target}`,
            concurrent: true,
            task: () => {
                const src = path.join(staticDir, 'src', 'images', target);
                const dest = path.join(staticDir, 'src', 'stylesheets', 'icons');
                const fileName = `_${target}-icons-svg.scss`;

                const iconPaths = glob.sync(path.join(src, '*.svg'));

                mkdirp.sync(dest);

                return Promise.all(iconPaths.map(getSVG))
                    .then(sortSVGs)
                    .then(svgs => svgs.map(generateSassForSVG).join('').trim())
                    .then(sass => saveSass(sass, dest, fileName));
            }
        };
    })
};