'use strict';

import Router from '../../../core/Router';
import Template from '../../assets/layout/app.html';
import usuarioVisualizarView from './views/usuario.html'


let loadModule = function(){
    let resolve = function ($q, $ocLazyLoad) {
        return $q(function (resolve) {
            require.ensure([], () => {
                let module = require('./usuario.module').default;
                $ocLazyLoad.load({name: module.name});
                resolve(module.name);
            });
        });
    };

    resolve.$inject = ['$q', '$ocLazyLoad'];
    return resolve;
};


let defaultRoute = new Router('usuario', {
    url: '/usuario',
    templateUrl: Template,
    abstract: true,
    resolve: {defaultModule: loadModule()}
});

defaultRoute.addRoute('visualizar', {
    url: '/visualizar',
    templateUrl: usuarioVisualizarView,
    controller: 'usuario.UsuarioController as vm',
});

export default angular.module('usuario.routes', []).config(defaultRoute.route());

