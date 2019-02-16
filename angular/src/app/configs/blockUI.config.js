'use strict';

function blockUIConfig(blockUIConfig) {
    blockUIConfig.template = "<div class=\"block-ui-overlay\"></div>\n" +
        "    <div class=\"block-ui-message-container\" aria-live=\"assertive\" aria-atomic=\"true\">\n" +
        "        <div>" +
        "           <div class=\"lds-spinner\">" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "               <div></div>" +
        "           </div>" +
        "       </div>" +
        "    </div>"
}

blockUIConfig.$inject = ['blockUIConfig'];

angular.module(process.env.APP_NAME).config(blockUIConfig);