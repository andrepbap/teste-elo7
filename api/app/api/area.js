
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /area");

        var areas = [
            {
                titulo: "Engenharia",
                imagem: app.get("img-url") + "ic-engenharia.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/engenharia/"
            },
            {
                titulo: "Atendimento",
                imagem: app.get("img-url") + "ic-atendimento.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/atendimento/"
            },
            {
                titulo: "Comunicação e marketing",
                imagem: app.get("img-url") + "ic-comunicacao-mkt.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/comunicacao-e-marketing/"
                
            },
            {
                titulo: "Desenvolvimento de vendedores",
                imagem: app.get("img-url") + "ic-desenvolvimento-vendedores.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/desenvolvimento-de-vendedores/"
            },
            {
                titulo: "Design",
                imagem: app.get("img-url") + "ic-design.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/design/"
            },
            {
                titulo: "Produto",
                imagem: app.get("img-url") + "ic-produto.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/produto/"
            },
            {
                titulo: "Trust & Safety",
                imagem: app.get("img-url") + "ic-trustnsafety.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/trust-and-safety/"
            },
            {
                titulo: "Administrativo / Financeiro",
                imagem: app.get("img-url") + "ic-adm-financeiro.png",
                link: "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/administrativo-financeiro/"
            }
        ];

        res.send(areas);

    };


    return api;
};
