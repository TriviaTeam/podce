'use strict';

import Module from '../../../core/Module';
import bootstrap from './usuario.bootstrap'
import UsuarioService from '../../services/usuarios.service'
import UsuarioController from './controllers/UsuarioController'
import SwalFactory from '../../factory/swal.factory';
import MapFactory from '../../factory/map.factory';

let module = new Module('usuario', [
    'UsuarioService',
    SwalFactory.name,
    MapFactory.name
]);

module.setControllers(
    ['usuario.UsuarioController',UsuarioController]
);

module.bootstrap(bootstrap);

export default module.getModule();



