
module.exports = function (app) {

    var api = {};

    api.getCarreiras = function (req, res) {
        
        console.log("Recebido GET request para /conteudo/carreiras");

        var conteudo = {
                tituloCulturas: "nossa cultura",
                textoCulturas: "Somos orientados pela satisfação e fidelização de nossos clientes",
                tituloAreas: "conheça nossas áreas",
                tituloRodape: "conecte-se com a gente"
            };

        res.send(conteudo);

    };


    return api;
};
