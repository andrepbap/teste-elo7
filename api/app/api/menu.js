
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /menu");

        var menu = [
            {
                nome: "Engenharia",
                link: "http://carreira.elo7.com.br/engenharia/"
            },
            {
                nome: "Eventos",
                link: "http://carreira.elo7.com.br/eventos-engenharia/"
            }
        ];

        res.send(menu);

    };


    return api;
};
