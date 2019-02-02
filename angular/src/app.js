'use strict';

import App from './core/App';

import UsuarioModule from './app/modules/usuario/usuario.routes';
import DefaultModule from './app/modules/home/home.routes';

require('angular-ui-tree/dist/angular-ui-tree.js');
require('angularjs-slider/dist/rzslider.min');

new App(process.env.APP_NAME, [
    'ng-fx',
    'ngAnimate',
    'ngLocale',
    'ngMessages',
    'ui.router',
    'oc.lazyLoad',
    'ngSanitize',
    'restangular',
    'toastr',
    'datatables',
    'datatables.bootstrap',
    'pascalprecht.translate',
    'moment-picker',
    'angular-oauth2',
    'ui.utils.masks',
    'oitozero.ngSweetAlert',
    'ngIdle',
    'ui.router.grant',
    'ui.bootstrap',
    'ui.select',
    'blockUI',
    'ngFileUpload',
    'angle',
    'ui.tree',
    'rzModule',
    'toggle-switch',
    UsuarioModule.name,
    DefaultModule.name,
]);
