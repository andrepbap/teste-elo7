var http = require('http');
var app = require('./config/express');
var ip = require("ip");
const PORTA = 3000;

var server = http.createServer(app)
        .listen(PORTA, function () {
            console.log('Servidor iniciado em ' + ip.address() + ':' + PORTA);
        });

