// @flow
const path = require('path');
const { ui } = require('../__config__/paths');

module.exports = {
    parser: 'babel-eslint',
    env: { browser: true, node: true, es6: true },
    extends: [
        'plugin:flowtype/recommended',
        'prettier/flowtype',
        'prettier/react',
    ],
    plugins: ['flow-header', 'flowtype', 'prettier'],
    parserOptions: { ecmaVersion: '2017' },
    settings: {
        react: { pragma: 'h' },
        'import/resolver': {
            webpack: {
                config: path.resolve(ui, '__config__', 'webpack.config.js'),
            },
        },
    },
    rules: {
        'import/extensions': [
            'error',
            'always',
            {
                js: 'never',
                jsx: 'never',
            },
        ],
        'flow-header/flow-header': 'error',
        'react/react-in-jsx-scope': 'off',
        'react/prop-types': 'off',
    },
    globals: {
        BROWSER: true,
        SERVER: true,
    },
};
