'use strict';

import Router from '../../../core/Router';
import Template from '../../assets/layout/app.html';
import servicoView from './views/servico.html'
import anexoView from '../../components/views/anexo.cadastrar.html'


let loadModule = function(){
    let resolve = function ($q, $ocLazyLoad) {
        return $q(function (resolve) {
            require.ensure([], () => {
                let module = require('./servico.module').default;
                $ocLazyLoad.load({name: module.name});
                resolve(module.name);
            });
        });
    };

    resolve.$inject = ['$q', '$ocLazyLoad'];
    return resolve;
};


let defaultRoute = new Router('servico', {
    url: '/servico',
    templateUrl: Template,
    abstract: true,
    resolve: {defaultModule: loadModule()}
});

defaultRoute.addRoute('cadastrar', {
    url: '/cadastrar',
    templateUrl: servicoView,
    controller: 'servico.ServicoController as vm',
});

export default angular.module('servico.routes', []).config(defaultRoute.route());

