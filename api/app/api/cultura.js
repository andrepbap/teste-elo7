
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /cultura");

        var culturas = [
            {
                titulo: "criatividade",
                texto: "Estimulamos a intervenção humana como algo insubstituível. Nosso ambiente é inspirador",
                imagem: app.get("img-url") + "criatividade.png"
            },
            {
                titulo: "colaboração",
                texto: "Valorizamos o trabalho em equipe e as habilidades individuais. Incentivamos o empreendedorismo e formamos um time fora de série",
                imagem: app.get("img-url") + "colaboracao.png"
            },
            {
                titulo: "tecnologia e inovação",
                texto: "Utilizamos a tecnologia para melhorar continuamente nosso negócio. Transformamos e conectamos pessoas",
                imagem: app.get("img-url") + "tec-ino.png"
            }
        ];
        
        res.send(culturas);

    };


    return api;
};
