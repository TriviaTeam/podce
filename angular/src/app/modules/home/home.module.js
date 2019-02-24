'use strict';

import Module from '../../../core/Module';
import bootstrap from './home.bootstrap'
import HomeController from './controllers/HomeController'
import SwalFactory from '../../factory/swal.factory';
import MapFactory from '../../factory/map.factory';


let module = new Module('home', [SwalFactory.name, MapFactory.name]);

module.setControllers(
    ['home.HomeController', HomeController],
);

module.bootstrap(bootstrap);

export default module.getModule();



