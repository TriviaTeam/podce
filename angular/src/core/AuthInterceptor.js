'use strict';

function AuthInterceptor() {
    return {
        request: function (request) {
            try{
                var token = sessionStorage.getItem(process.env.APP_NAME + '_user_token') || false;
                token = token && JSON.parse(atob(token)) || false;
                if (token && request.url.search('private') >= 0)
                    request.headers.Authorization = token.token_type + " " + token.access_token;
            }
            catch (e){
                console.error(e);
            }
            return request;
        }
    }
}

AuthInterceptor.$inject = [];

angular.module(process.env.APP_NAME)
    .factory('AuthInterceptor', AuthInterceptor);