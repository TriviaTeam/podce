var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var DotenvPlugin = require('webpack-dotenv-plugin');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var HtmlReplaceWebpackPlugin = require('html-replace-webpack-plugin')


const pkg = require('./../../package.json');
const version = require('./../../version.json');

var plugins = [];

plugins.push(new DotenvPlugin({
    path: './.env',
    sample:'./.env.development'
}));

plugins.push(
    new webpack.DefinePlugin({
        'process.env': {
            version: JSON.stringify(pkg.version),
            timestamp: JSON.stringify(version.date)
        }
    })
);

plugins.push(new webpack.ProvidePlugin({
    $: "jquery",
    jQuery: "jquery","window.jQuery": "jquery",_: "lodash",
    moment: 'moment',
    html2canvas : 'html2canvas',
    L: 'leaflet',
    swal : 'sweetalert2'
}));

plugins.push(
    new webpack.optimize.CommonsChunkPlugin({
        names: ['main', 'vendor'],
        minChunks: Infinity,
        children: false,
        async: false,
        deepChildren: false
    })
);

plugins.push(
    new HtmlWebpackPlugin({
        template: 'src/index.template.html',
        inject: true
    })
);

plugins.push(
    new ExtractTextPlugin({filename: '[name].[hash].css'})
);

plugins.push(
    new HtmlReplaceWebpackPlugin({
        pattern: '@rest_base@',
        replacement: process.env.REST_BASE
    })
)

module.exports = plugins;