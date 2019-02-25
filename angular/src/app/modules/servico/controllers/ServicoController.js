'use strict';


class ServicoController {
    constructor($scope, $state, $q, $filter, $uibModal, $timeout, $stateParams, SwalFactory, AnexoFactory,ServicoService) {
        let vm = this;
        vm.swal = SwalFactory;
        vm.modal = $uibModal;
        vm.anexos = [];
        vm.anexoFactory = AnexoFactory;
        vm.servico = {};
        vm.servicoService = ServicoService;
    }

    download(anexo){
        let vm = this;
        vm.anexoFactory.download(anexo);
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
            vm.servico.anexos.push(ret);
            window.onkeydown = null;
        });
    }

    salvar(){
        let vm = this;
        vm.servicoService.salvar(vm.servico).then(resp => {
            vm.swal.mostrarMensagemToast('success','Serviço salvo com sucesso!');
        }, error => {
            vm.swal.mostrarMensagemToast('warning','Erro ao salvar o serviço. tente novamente mais tarde.');
        })

    }
}
ServicoController.$inject = ['$scope', '$state', '$q', '$filter','$uibModal', '$timeout', '$stateParams','SwalFactory','AnexoFactory','ServicoService'];
export default ServicoController;