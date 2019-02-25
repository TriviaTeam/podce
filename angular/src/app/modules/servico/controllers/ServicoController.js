'use strict';


class ServicoController {
    constructor($scope, $state, $q, $filter, $uibModal, $timeout, $stateParams, SwalFactory) {
        let vm = this;
        vm.swal = SwalFactory;
        vm.modal = $uibModal;
        vm.anexos = [];
    }

    adicionarAnexo(){
        let vm = this;
        vm.modalInstanceB = vm.modal.open({
            templateUrl: require('../../../components/views/anexo.cadastrar.html'),
            controller: 'servico.AnexoController',
            controllerAs: 'vm',
            size: 'lg',
            windowClass: 'show',
            backdropClass: 'show'
        });
        vm.modalInstanceB.result.then(ret => {
            vm.anexos.push(ret);
            window.onkeydown = null;
        });
    }
}
ServicoController.$inject = ['$scope', '$state', '$q', '$filter','$uibModal', '$timeout', '$stateParams','SwalFactory'];
export default ServicoController;