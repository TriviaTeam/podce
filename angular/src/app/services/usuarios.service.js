'use strict';


function UsuarioService(Restangular) {

      const service = Restangular.withConfig(function(configurer){
        configurer.setBaseUrl(process.env.REST_BASE);
    }).service('/usuarios');


    function pesquisar() {
        return service.one("pesquisar").getList();
    }


    return {
        pesquisar,
    };
}
UsuarioService.$inject = ['Restangular'];
export default angular.module('UsuarioService', [])
    .service('UsuarioService', UsuarioService);
