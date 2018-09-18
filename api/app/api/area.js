
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /area");

        var areas = [
            {
                titulo: "engenharia",
                imagem: app.get("img-url") + "ic-engenharia.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/engenharia/"
            },
            {
                titulo: "atendimento",
                imagem: app.get("img-url") + "ic-atendimento.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/atendimento/"
            },
            {
                titulo: "comunicação e marketing",
                imagem: app.get("img-url") + "ic-comunicacao-mkt.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/comunicacao-e-marketing/"
                
            },
            {
                titulo: "desenvolvimento de vendedores",
                imagem: app.get("img-url") + "ic-desenvolvimento-vendedores.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/desenvolvimento-de-vendedores/"
            },
            {
                titulo: "design",
                imagem: app.get("img-url") + "ic-design.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/design/"
            },
            {
                titulo: "produto",
                imagem: app.get("img-url") + "ic-produto.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/produto/"
            },
            {
                titulo: "trust & safety",
                imagem: app.get("img-url") + "ic-trustnsafety.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/trust-and-safety/"
            },
            {
                titulo: "administrativo / financeiro",
                imagem: app.get("img-url") + "ic-adm-financeiro.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/administrativo-financeiro/"
            }
        ];

        res.send(areas);

    };


    return api;
};
