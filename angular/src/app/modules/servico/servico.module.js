'use strict';

import Module from '../../../core/Module';
import bootstrap from './servico.bootstrap'
import ServicoController from './controllers/ServicoController'
import SwalFactory from '../../factory/swal.factory';
import AnexoController from '../../components/controllers/AnexoCadastrarController'
import AnexoFactory from '../../factory/anexo.factory'

let module = new Module('servico', [
    SwalFactory.name,
    AnexoFactory.name
]);

module.setControllers(
    ['servico.ServicoController',ServicoController],
    ['servico.AnexoController',AnexoController]
);

module.bootstrap(bootstrap);

export default module.getModule();



