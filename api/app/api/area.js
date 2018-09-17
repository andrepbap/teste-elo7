
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /area");

        var areas = [
            {
                titulo: "engenharia",
                imagem: "@drawable/ic_engenharia"
            },
            {
                titulo: "atendimento",
                imagem: "@drawable/ic_atendimento"
            },
            {
                titulo: "comunicação e marketing",
                imagem: "@drawable/ic_comunicacao_mkt"
            },
            {
                titulo: "desenvolvimento de vendedores",
                imagem: "@drawable/ic_desenvolvimento_vendedores"
            },
            {
                titulo: "design",
                imagem: "@drawable/ic_design"
            },
            {
                titulo: "produto",
                imagem: "@drawable/ic_produto"
            },
            {
                titulo: "trust & safety",
                imagem: "@drawable/ic_trustnsafety"
            },
            {
                titulo: "administrativo / financeiro",
                imagem: "@drawable/ic_adm_financeiro"
            }
        ];

        res.send(areas);

    };


    return api;
};
