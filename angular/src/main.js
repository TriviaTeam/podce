'use strict';

import 'angular-datatables/dist/plugins/bootstrap/datatables.bootstrap.min.css'
import 'angular-ui-tree/dist/angular-ui-tree.min.css'
import 'pdfmake/build/pdfmake.js';
import 'pdfmake/build/vfs_fonts.js';
import './app';
import './bootstrap'
import './app/configs/restangular.config';
import './app/configs/blockUI.config';
import './app/configs/moment-picker.config';
import './app/assets/js/app'
import './app/assets/layout/footer.html'
import './app/assets/layout/header.html'
import './app/assets/less/app.less';

angular.bootstrap(document, [process.env.APP_NAME], {strictDi: true});