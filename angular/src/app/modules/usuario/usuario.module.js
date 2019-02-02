'use strict';

import Module from '../../../core/Module';
import bootstrap from './usuario.bootstrap'
import UsuarioService from '../../services/usuarios.service'
import UsuarioVisualizarController from './controllers/UsuarioVisualizarController'

let module = new Module('usuario', [
    'UsuarioService',
]);

module.setControllers(
    ['usuario.UsuarioVisualizarController',UsuarioVisualizarController]
);

module.bootstrap(bootstrap);

export default module.getModule();


