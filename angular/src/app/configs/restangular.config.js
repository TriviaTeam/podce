'use strict';

function restangularConfig($httpProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl(process.env.REST_BASE);
    RestangularProvider.setDefaultHttpFields({cache: false});

    RestangularProvider.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
        if (operation === 'getList') {
            var newResponse = [];
            if (data.dados) {
                newResponse = data.dados;
            }
            return newResponse;
        }
        return data;
    });
}

function RestangularRun(Restangular, $cookies, $state, $rootScope, SweetAlert) {
    Restangular.addFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {
        var access_token = !window.localStorage.getItem('token') ? '' :
                    JSON.parse(window.localStorage.getItem('token')).access_token;

        headers = {'Authorization': 'Bearer ' +  access_token};

        return {
            element: element,
            params: params,
            headers: headers,
            httpConfig: httpConfig
        };
    });

    Restangular.setErrorInterceptor(
        function ( response ) {
            if ( response.status == 401 ) {
                $state.go('login.main');
                $rootScope.$broadcast('logout');
                SweetAlert.swal({
                    title: 'Sua sessão expirou ou você não tem permissão para acessar essa funcionalidade.',
                    type: "warning",
                    closeOnConfirm: false
                });
            }
            if ( response.status == -1 ) {
                SweetAlert.swal({
                    title: 'Serviço indisponível. Tente novamente mais tarde.',
                    type: "warning",
                    closeOnConfirm: false
                });
            }
        }
    );
}

RestangularRun.$inject = ['Restangular', '$cookies', '$state', '$rootScope', 'SweetAlert'];

restangularConfig.$inject = ['$httpProvider', 'RestangularProvider'];

angular.module(process.env.APP_NAME).config(restangularConfig).run(RestangularRun);