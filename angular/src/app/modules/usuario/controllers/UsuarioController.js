'use strict';


class UsuarioController {
    constructor($scope, $state, $q, $filter, $uibModal, $timeout, UsuarioService, $stateParams, SwalFactory, MapFactory){
        let vm = this;
        vm.swal = SwalFactory;
        vm.map = MapFactory;
        vm.marcadores = [
            {lat:-15.8000,long:-47.9300, descricao: 'Testando o marcador <br> Paragrafo <br> Teste <br> Teste'},
            {lat:-15.8050,long:-47.9300, descricao: 'Testando outro marcador'},
            {lat:-15.8100,long:-47.9300, descricao: 'Botando terceiro marcadores'}
        ];
        vm.carregarMapa(-15.7801,-47.9292, 'map',vm.marcadores);
    }

    carregarMapa(lat, long, elemento, marcadores){
        let vm = this;
        vm.map.montaMapaTela(lat,long,elemento,marcadores);
    }
}
UsuarioController.$inject = ['$scope', '$state', '$q', '$filter','$uibModal', '$timeout','UsuarioService', '$stateParams','SwalFactory','MapFactory'];

export default UsuarioController;