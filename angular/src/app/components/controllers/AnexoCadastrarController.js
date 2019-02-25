'use strict';

class AnexoCadastrarController {
    constructor($scope, $state, $uibModalInstance, AnexoFactory) {
        let vm = this;
        vm.modal = $uibModalInstance;
        vm.anexoFactory = AnexoFactory;
        vm.anexoInvalido = true;
        vm.anexo = {
            ativo: null,
            nome: null,
            data: null,
            descricao: null
        };
    }


    salvar(form){
        let vm = this;
        if(form.$invalid || vm.anexoInvalido){
            form.$setSubmitted();
            return;
        }
        vm.modal.close(vm.anexo)
    }

    cancelar(){
        let vm = this;
        vm.modal.dismiss();
    }
}
AnexoCadastrarController.$inject = ['$scope', '$state','$uibModalInstance','AnexoFactory'];

export default AnexoCadastrarController;