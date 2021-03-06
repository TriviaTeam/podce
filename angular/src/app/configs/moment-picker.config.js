'use strict';

function momentPickerConfig(momentPickerProvider) {
    momentPickerProvider.options({
        locale:        'pt-br',
        format:        'L',
        minView:       'decade',
        maxView:       'minute',
        startView:     'year',
    });
}

momentPickerConfig.$inject = ['momentPickerProvider']

angular.module(process.env.APP_NAME).config(momentPickerConfig);