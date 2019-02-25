'use strict';

function AnexoFactory(Restangular,
                      Upload,
                      SwalFactory,
                      $q) {
    let factory = {};
    let q = $q;
    let up = Upload;

    function upload ($files,  $invalidFiles, vm){
        vm.msgAnexo = null;
        if($invalidFiles && $invalidFiles.length > 0) {
            $invalidFiles.forEach(function (file) {
                vm.msgAnexo = "O arquivo "+file.name+" deve possuir o tamanho de até 2MB.";
                vm.anexo.nome = null;
                vm.anexo.data = null;
                m.anexoInvalido = true;
            })
            return;
        }

        if($files) {
            angular.forEach($files, function(file) {
                if(file.type != 'application/pdf' && file.type != 'image/png' && file.type != 'image/jpeg' && file.type != 'image/jpg'){
                    vm.msgAnexo = "O arquivo " + file.name + " é inválido! Só podem ser anexados arquivos PDF, JPEG, JPG ou PNG.";
                    vm.anexoInvalido = true;
                    return;
                }else{
                    getData(file).then(function(byte){
                        vm.anexoInvalido = false;
                        vm.anexo.ativo = 'A';
                        vm.anexo.nome = file.name;
                        vm.anexo.data = byte;
                    })
                }
            });
        }
    }

    function getData (file){
        const defer = q.defer();
        let byte;
        up.base64DataUrl(file).then(
            function (url){
                byte = url.split(',')[1];
                defer.resolve(byte);
            });
        return defer.promise;
    };

    function download (file){
        if(file.data){
            download_base(file)
        }else{
            /*projetoService.download(file.id).then(ret => {
                download_base(ret.dados)
            })*/
        }

    }

    function download_base(file) {
        let fileType = 'image/png';
        if (window.atob(file.data).indexOf("PDF")>0){
            fileType = 'application/pdf';
        }
        var blob = up.dataUrltoBlob("data:"+fileType+";base64,"+file.data, file.nome);
        var FileSaver = require('file-saver');
        FileSaver.saveAs(blob, file.nome );
    }



    function removerAnexo (vm, indice) {
        vm.anexos[indice].ativo = 'I';
        vm.anexos.splice(indice, 1);
    }

    factory.download 						= download						;
    factory.removerAnexo 					= removerAnexo					;
    factory.upload 							= upload						;
    factory.getData 						= getData						;
    return factory;
}
AnexoFactory.$inject = ['Restangular',
    'Upload',
    'SwalFactory',
    '$q'];
export default angular.module('AnexoFactory', [])
    .factory('AnexoFactory', AnexoFactory);