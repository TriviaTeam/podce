'use strict';
import EN_JSON from '../i18n/en.json'
import PT_BR_JSON from '../i18n/pt_BR.json'

function TranslateConfig($translateProvider) {
    $translateProvider.translations('en', EN_JSON);
    $translateProvider.translations('pt_BR', PT_BR_JSON);
    $translateProvider.preferredLanguage('pt_BR');
    $translateProvider.useSanitizeValueStrategy(null);

}

TranslateConfig.$inject = ['$translateProvider'];

angular.module(process.env.APP_NAME).config(TranslateConfig);