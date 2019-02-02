'use strict';

import Module from '../../../core/Module';
import bootstrap from './usuario.bootstrap'
import UsuarioService from '../../services/usuarios.service'
import UsuarioController from './controllers/UsuarioController'

let module = new Module('usuario', [
    'UsuarioService',
]);

module.setControllers(
    ['usuario.Controller',UsuarioController]
);

module.bootstrap(bootstrap);

export default module.getModule();



