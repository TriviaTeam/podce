'use strict';
import IdleView from '../assets/layout/idle.html'
import IdleLogoutView from '../assets/layout/idle-logout.html'

function ngIdleConfig(IdleProvider, KeepaliveProvider, TitleProvider) {
    IdleProvider.idle(parseInt(process.env.IDLE_TIME)); // in seconds
    IdleProvider.timeout(parseInt(process.env.IDLE_TIMEOUT)); // in seconds
    KeepaliveProvider.interval(parseInt(process.env.IDLE_INTERVAL)); // in seconds
    TitleProvider.enabled(false);
}

function ngIdleRun($rootScope, $uibModal, OAuth, Idle, Keepalive){

    $rootScope.maxIdle = process.env.IDLE_TIMEOUT;

    function closeModals() {
        if ($rootScope.warning) {
            $rootScope.warning.close();
            $rootScope.warning = null;
        }

        if ($rootScope.timedout) {
            $rootScope.timedout.close();
            $rootScope.timedout = null;
        }
    }

    $rootScope.$on('IdleStart', function () {
        closeModals();

        $rootScope.warning = $uibModal.open({
            templateUrl: IdleView,
            windowClass: 'modal-danger'
        });
    });

    $rootScope.$on('IdleEnd', function () {
        closeModals();
    });

    $rootScope.$on('IdleTimeout', function () {
        closeModals();
        $rootScope.timedout = $uibModal.open({
            templateUrl: IdleLogoutView,
            windowClass: 'modal-danger'
        });

        $rootScope.$broadcast('logout');
    });

    Idle.watch();

    Keepalive.start();
}

ngIdleRun.$inject = ['$rootScope', '$uibModal', 'OAuth', 'Idle', 'Keepalive'];

ngIdleConfig.$inject = ['IdleProvider', 'KeepaliveProvider', 'TitleProvider'];

export default angular.module(process.env.APP_NAME).config(ngIdleConfig).run(ngIdleRun);