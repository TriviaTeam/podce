'use strict';

import App from './core/App';

import DefaultModule from './app/modules/home/home.routes';
import LoginModule from './app/modules/login/login.routes';
import SolicitacaoModule from './app/modules/solicitacao/solicitacao.routes'
import SolicitarAcessoModule from './app/modules/solicitacao/solicitar-acesso.routes'
import FuncaoModule from './app/modules/funcao/funcao.routes'
import PerfilModule from './app/modules/perfil/perfil.routes'
import UnidadeModule from './app/modules/unidade/unidade.routes'
import UsuarioModule from './app/modules/usuario/usuario.routes'
import GestaoModule from './app/modules/gestao/gestao.module'
import PlanejamentoModule from './app/modules/planejamento/planejamento.module'

import CnpjDirective from './app/directives/masks/cnpj.directive.js'
import CpfCnpjDirective from './app/directives/masks/cpf-cnpj.directive.js'
import CpfDirective from './app/directives/masks/cpf.directive'
import DateTimeDirective from './app/directives/masks/date-time.directive'
import HoraDirective from './app/directives/masks/hora.directive.js'
import PhoneBRDirective from './app/directives/masks/phone-br.directive'
import DateBRDirective from './app/directives/masks/date-br.directive'
import OnlyNumbersDirective from './app/directives/masks/only-numbers'
import CurrencyDirective from './app/directives/masks/currency-numbers'
import ValidarSenhaDirective from './app/directives/masks/validar-senha.directive'
import ToUpperCaseDirective from './app/directives/masks/to-upper-case.directive'
import InvalidFocusDirective from './app/directives/invalid-focus/invalid-focus.directive'
import MasksModule from './app/filters/masks/masks.module'
import SumsModule from './app/filters/sums/sums.module'
import HasAuthorityDirective from './app/directives/has-authority/has-authority.directive';
import LoginCPFDirective from './app/directives/masks/login-cpf.directive';
import SeiMask from './app/directives/masks/sei.directive';
import numeroOsMask from './app/directives/masks/numeroOs.directive';

import AssinaturaComponent from './app/components/assinaturas/assinaturas.component';
import AssinarDocumentoComponent from './app/components/assinar_documento/assinar_documento.component';

import PrinterComponent from './app/components/custom_printer/printer.component';

import BotaoExportarPDFDirective from './app/directives/masks/botao-exportar-pdf.directive.js';
import VisualizarOrdemServiso from './app/components/visualizar_ordem_servico/visualizar_ordem_servico.component';
import AcompanharOrdemDeServico from './app/components/acompanhar_ordem_servico/acompanhar_ordem_servico.component';
import CkEditorDiretive from './app/directives/ckeditor/ckeditor.directive'

require('angular-ui-tree/dist/angular-ui-tree.js');
require('angularjs-slider/dist/rzslider.min');

new App(process.env.APP_NAME, [
    'ng-fx',
    'ngAnimate',
    'ngLocale',
    'ngMessages',
    'ui.router',
    'oc.lazyLoad',
    'ngSanitize',
    'restangular',
    'toastr',
    'datatables',
    'datatables.bootstrap',
    'pascalprecht.translate',
    'moment-picker',
    'angular-oauth2',
    'ui.utils.masks',
    'oitozero.ngSweetAlert',
    'ngIdle',
    'ui.router.grant',
    'ui.bootstrap',
    'ui.select',
    'blockUI',
    'ngFileUpload',
    'angle',
    'ui.tree',
    'rzModule',
    'toggle-switch',
]);
