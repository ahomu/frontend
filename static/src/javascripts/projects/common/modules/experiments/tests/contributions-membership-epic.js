define([
    'bean',
    'qwery',
    'common/utils/$',
    'common/utils/template',
    'common/views/svg',
    'common/utils/fastdom-promise',
    'common/utils/mediator',
    'text!common/views/contributions-epic.html',
    'common/utils/robust',
    'inlineSvg!svgs/icon/arrow-right',
    'common/utils/config',
    'common/utils/cookies',
    'common/modules/experiments/embed',
    'common/utils/ajax',
    'common/modules/commercial/commercial-features'

], function (bean,
             qwery,
             $,
             template,
             svg,
             fastdom,
             mediator,
             contributionsEpic,
             robust,
             arrowRight,
             config,
             cookies,
             embed,
             ajax,
             commercialFeatures
) {


    return function () {

        this.id = 'ContributionsMembershipEpic';
        this.start = '2016-11-03';
        this.expiry = '2016-11-07';
        this.author = 'Jonathan Rankin';
        this.description = 'Find the optimal way of offering Contributions along side Membership in the Epic component';
        this.showForSensitive = true;
        this.audience = 0.15;
        this.audienceOffset = 0.71;
        this.successMeasure = 'Impressions to number of contributions/supporter signups';
        this.audienceCriteria = 'All users in US and UK';
        this.dataLinkNames = '';
        this.idealOutcome = 'One of the 3 variants proves to be a clear winner';
        this.canRun = function () {
            var userHasNeverContributed = !cookies.get('gu.contributions.contrib-timestamp');
            var worksWellWithPageTemplate = (config.page.contentType === 'Article'); // may render badly on other types
            return userHasNeverContributed && commercialFeatures.canReasonablyAskForMoney && worksWellWithPageTemplate;
        };

        var membershipUrl = 'https://membership.theguardian.com/supporter?';
        var contributeUrl = 'https://contribute.theguardian.com/?';

        var componentWriter = function (component) {
            ajax({
                url: 'https://api.nextgen.guardianapps.co.uk/geolocation',
                method: 'GET',
                contentType: 'application/json',
                crossOrigin: true
            }).then(function (resp) {
                if(resp.country === 'GB' || resp.country === 'US') {
                    fastdom.write(function () {
                        var submetaElement = $('.submeta');
                        component.insertBefore(submetaElement);
                        embed.init();
                        mediator.emit('contributions-embed:insert', component);
                    });
                }
            });
        };

        var makeUrl = function(urlPrefix, intcmp) {
            return urlPrefix + 'INTCMP=' + intcmp;
        };

        var completer = function (complete) {
            mediator.on('contributions-embed:insert', function () {
                bean.on(qwery('.js-submit-input-contribute')[0], 'click', function(){
                    complete();
                    require(['ophan/ng'], function (ophan) {
                        ophan.record({
                            component: 'contribute-button'
                        });
                    });

                });

                bean.on(qwery('.js-submit-input-membership')[0], 'click', function(){
                    complete();
                    require(['ophan/ng'], function (ophan) {
                        ophan.record({
                            component: 'membership-button'
                        });
                    });
                });
            });
        };

        this.variants = [

            {
                id: 'control',
                test: function () {
                    var component = $.create(template(contributionsEpic, {
                        linkUrl1: makeUrl(contributeUrl, 'co_ukus_epic_footer_control'),
                        linkUrl2: '',
                        p2: 'If everyone who reads our reporting, who likes it, helps to pay for it our future would be more secure. You can give money to the Guardian in less than a minute.',
                        p3: '',
                        cta1: 'Make a contribution',
                        cta2: '',
                        cta1Class: 'js-submit-input-contribute',
                        cta2Class: '',
                        hidden: 'hidden'
                    }));
                    componentWriter(component);
                },
                impression: function(track) {
                    mediator.on('contributions-embed:insert', track);
                },
                success: completer
            },
            {
                id: 'contribute-member',
                test: function () {
                    var component = $.create(template(contributionsEpic, {
                        linkUrl1: makeUrl(contributeUrl, 'co_ukus_epic_footer_contribute-main'),
                        linkUrl2: makeUrl(membershipUrl, 'gdnwb_copts_mem_epic_membership-alt'),
                        p2: 'If everyone who reads our reporting, who likes it, helps to pay for it our future would be more secure. You can give money to the Guardian in less than a minute.',
                        p3: 'Alternatively, you can join the Guardian and get even closer to our journalism by ',
                        cta1: 'Make a contribution',
                        cta2: 'becoming a Supporter.',
                        cta1Class: 'js-submit-input-contribute',
                        cta2Class: 'js-submit-input-membership',
                        hidden: ''
                    }));
                    componentWriter(component);
                },
                impression: function(track) {
                    mediator.on('contributions-embed:insert', track);
                },
                success: completer
            },
            {
                id: 'member-contribute',
                test: function () {
                    var component = $.create(template(contributionsEpic, {
                        linkUrl1: makeUrl(membershipUrl, 'gdnwb_copts_mem_epic_membership-main'),
                        linkUrl2: makeUrl(contributeUrl, 'co_ukus_epic_footer_contribute-alt'),
                        p2: 'If everyone who reads our reporting – who believes in it – helps to support it, our future would be more secure. Get closer to our journalism, be part of our story and join the Guardian.',
                        p3: 'Alternatively, you can ',
                        cta1: 'Become a Supporter',
                        cta2: 'make a one-off contribution.',
                        cta1Class: 'js-submit-input-membership',
                        cta2Class: 'js-submit-input-contribute',
                        hidden: ''
                    }));
                    componentWriter(component);
                },
                impression: function(track) {
                    mediator.on('contributions-embed:insert', track);
                },
                success: completer
            }
        ];
    };
});