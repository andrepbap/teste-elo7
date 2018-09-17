var http = require('http');
var app = require('./config/express');
const PORTA = 3000;

var server = http.createServer(app)
        .listen(PORTA, function () {
            console.log('Servidor iniciado na porta ' + PORTA);
        });

