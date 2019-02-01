'use strict';


function UsuarioService(Restangular) {

      const service = Restangular.withConfig(function(configurer){
        configurer.setBaseUrl(process.env.REST_BASE);
    }).service('/usuarios');

    function salvar(obj) {
        return service.post(obj);
    }

    function pesquisar(obj)
    {
        return service.one('pesquisar').customPOST(obj);
    }

    function getUsuario(idusuario,idSistema=1)
    {
        return service.one(idusuario).one(idSistema+'').get();

    }


    function alterar(body, idUsuario, idperfil, idSistema=1)
    {
        return service.one(idUsuario+'').one(idperfil+'').one(idSistema+'').customPUT(body);
    }


    function inativar(obj)
    {
        return service.one('inativar').customPUT(obj);
    }

    function ativar(obj)
    {
        return service.one('ativar').customPUT(obj);
    }
    function pesquisarUsuarioPorCPF(cpf) {
        return service.one("pesquisarUsuarioPorCPF").get({cpf : cpf});
    }

    function listarPorUnidade(idUnidade) {
        return service.one(idUnidade+'').one("unidade").getList();
    }

    function listarRequisitantes() {
        return service.one("requisitantes").getList();
    }

    function listarServidores() {
        return service.one("servidores").getList();
    }

    function listarDemandantes() {
        return service.one("demandantes").getList();
    }
    
    function listarGestoresPorContrato(idContrato) {
        return service.one(idContrato).one("gestores").getList();
    }
    
    function listarPrepostosPorContrato(idContrato) {
        return service.one(idContrato).one("prepostos").getList();
    }

    const listarFiscaisPorContrato = (idContrato) => service.one(idContrato).one("fiscais").getList();
    const listarFuncoes = () => service.one("funcoes").getList();

    return {
        salvar,
        pesquisar,
        getUsuario,
        alterar,
        inativar,
        ativar,
        pesquisarUsuarioPorCPF,
        listarPorUnidade,
        listarGestoresPorContrato,
        listarPrepostosPorContrato,
        listarRequisitantes,
        listarFuncoes,
        listarFiscaisPorContrato,
        listarDemandantes,
        listarServidores
    };
}
UsuarioService.$inject = ['Restangular'];
export default angular.module('UsuarioService', [])
    .service('UsuarioService', UsuarioService);
