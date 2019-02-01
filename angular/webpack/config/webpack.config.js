var path = require('path');
var plugins = require('./webpack.plugins');
var rules = require('./webpack.rules');
var autoprefixer = require('autoprefixer');

var config = {};

config.entry = {
    app: ['babel-polyfill', path.join(__dirname, '../../src/main.js')],
    vendor: [
        'angular',
        'jquery',
        'eonasdan-bootstrap-datetimepicker',
        'moment',
        'datatables.net',
        'angular-datatables',
        'angular-messages',
        'angular-cookies',
        'angular-oauth2',
        'angular-animate',
        'angular-toastr',
        'angularjs-captcha',
        'ui-router.grant',
        'oclazyload',
        'lodash',
        'restangular',
        'angular-moment-picker',
        'angular-i18n/angular-locale_pt-br.js',
        'angular-input-masks',
        'sweetalert',
        'angular-sweetalert',
        'angular-translate',
        'ng-idle',
        'ng-fx',
        'angular-sanitize',
        'angular-ui-bootstrap',
        'ui-select',
        'angular-block-ui',
        'ng-file-upload',
        'angular-file-saver',
        'html2canvas',
        'angular-toggle-switch'
    ]
};

config.output = {
    filename: '[name].[hash].js',
    chunkFilename: '[name].[hash].bundle.js',
    path: path.join(__dirname, '../../build/')
}

config.module = {
    rules: []
};

config.module.rules = rules;
config.plugins = plugins;

module.exports = config;