
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /area");

        var areas = [
            {
                titulo: "engenharia",
                imagem: app.get("img-url") + "ic-engenharia.png"
            },
            {
                titulo: "atendimento",
                imagem: app.get("img-url") + "ic-atendimento.png"
            },
            {
                titulo: "comunicação e marketing",
                imagem: app.get("img-url") + "ic-comunicacao-mkt.png"
            },
            {
                titulo: "desenvolvimento de vendedores",
                imagem: app.get("img-url") + "ic-desenvolvimento-vendedores.png"
            },
            {
                titulo: "design",
                imagem: app.get("img-url") + "ic-design.png"
            },
            {
                titulo: "produto",
                imagem: app.get("img-url") + "ic-produto.png"
            },
            {
                titulo: "trust & safety",
                imagem: app.get("img-url") + "ic-trustnsafety.png"
            },
            {
                titulo: "administrativo / financeiro",
                imagem: app.get("img-url") + "ic-adm-financeiro.png"
            }
        ];

        res.send(areas);

    };


    return api;
};
