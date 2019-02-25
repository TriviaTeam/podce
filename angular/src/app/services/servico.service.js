'use strict';

function ServicoService(Restangular) {
      const service = Restangular.withConfig(function(configurer){
        configurer.setBaseUrl(process.env.REST_BASE);
    }).service('/servico');

    function salvar(obj) {
        return service.one("salvar").post(null,obj);
    }

    return {
        salvar,
    };
}
ServicoService.$inject = ['Restangular'];
export default angular.module('ServicoService', []).service('ServicoService', ServicoService);
