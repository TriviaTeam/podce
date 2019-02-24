'use strict';

function SwalFactory($q) {
	let factory = {};
	let q = $q;

    function mostrarMensagemToast(tipo,mensagem){
		let swalConf = swal.mixin({toast: true,position: 'top',showConfirmButton:false,timer: 3000});
		swalConf.fire({type: tipo,width: 400,title: mensagem})
    }

    function mostraMensagemConfirmacao(titulo){
		const defer = q.defer();

		swal.fire({title: titulo,type: 'warning', showCancelButton: true,confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',confirmButtonText: 'Confirmar', cancelButtonText: 'Cancelar'
		}).then((result) => {
			defer.resolve(result);
		});

		return defer.promise;
	}

    factory.mostrarMensagemToast = mostrarMensagemToast;
	factory.mostraMensagemConfirmacao = mostraMensagemConfirmacao;
    return factory;
}
SwalFactory.$inject = ['$q'];
export default angular.module('SwalFactory', []).factory('SwalFactory', SwalFactory);