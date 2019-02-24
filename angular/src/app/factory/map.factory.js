'use strict';

function MapFactory($q) {
	let factory = {};
	let q = $q;

    function montaMapaTela(lat, long, elemento, marcadores){
		let map = L.map(elemento).setView([lat, long], 13);
		L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);

		marcadores.forEach(m => {
			L.marker([m.lat, m.long]).addTo(map).bindPopup(m.descricao).openPopup();
		});
    }

    factory.montaMapaTela = montaMapaTela;
    return factory;
}
MapFactory.$inject = ['$q'];
export default angular.module('MapFactory', []).factory('MapFactory', MapFactory);