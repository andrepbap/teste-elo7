
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /cultura");

        var culturas = [
            {
                titulo: "criatividade",
                texto: "Estimulamos a intervenção humana como algo insubstituível. Nosso ambiente é inspirador",
                imagem: "@drawable/criatividade"
            },
            {
                titulo: "colaboração",
                texto: "Valorizamos o trabalho em equipe e as habilidades individuais. Incentivamos o empreendedorismo e formamos um time fora de série",
                imagem: "@drawable/colaboracao"
            },
            {
                titulo: "tecnologia e inovação",
                texto: "Utilizamos a tecnologia para melhorar continuamente nosso negócio. Transformamos e conectamos pessoas",
                imagem: "@drawable/tec_ino"
            }
        ];
        
        res.send(culturas);

    };


    return api;
};
