
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {

        var areas = [
            {
                titulo: "engenharia",
                img: "ic-engenharia.png"
            },
            {
                titulo: "atendimento",
                img: "ic-atendimento.png"
            },
            {
                titulo: "comunicação e marketing",
                img: "ic-comunicacao-mkt.png"
            },
            {
                titulo: "desenvolvimento de vendedores",
                img: "ic-desenvolvimento-vendedores.png"
            },
            {
                titulo: "design",
                img: "ic-design.png"
            },
            {
                titulo: "produto",
                img: "ic-produto.png"
            },
            {
                titulo: "trust & safety",
                img: "ic-trustnsafety.png"
            },
            {
                titulo: "administrativo / financeiro",
                img: "ic-adm-financeiro.png"
            }
        ];

        res.send(areas);

    };


    return api;
};
