'use strict';

import VersionJSON from '../version.json';

function Bootstrap($rootScope, $location, DTOptionsBuilder) {
    $rootScope.pageTitle = 'PODCE';
    $rootScope.$version = VersionJSON;
    $rootScope.$version.buildDate = new Date($rootScope.$version.buildDate);
    $rootScope.primeiro_acesso = process.env.PRIMEIRO_ACESSO + "?voltar=" + $location.absUrl();
    $rootScope.datatable = {};
    $rootScope.datatable.options = DTOptionsBuilder
        .newOptions()
        .withLanguage(require('./app/i18n/datatable.pt_BR.json'))
        .withOption('bFilter', false)
        .withOption('bLengthChange', false)
        .withOption('ordering', false)
        .withBootstrap();
}

Bootstrap.$inject = ['$rootScope', '$location', 'DTOptionsBuilder'];

export default angular.module(process.env.APP_NAME).run(Bootstrap);
