
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {
        
        console.log("Recebido GET request para /social");

        var socials = [
            {
                nome: "facebook",
                imagem: app.get("img-url") + "facebook.png",
                link: "https://www.facebook.com/Elo7br"
            },
            {
                nome: "instagram",
                imagem: app.get("img-url") + "instagram.png",
                link: "https://instagram.com/elo7br"
            },
            {
                nome: "googleplus",
                imagem: app.get("img-url") + "googleplus.png",
                link: "https://plus.google.com/+Elo7Br"
            },
            {
                nome: "pinterest",
                imagem: app.get("img-url") + "pinterest-light.png",
                link: "https://pinterest.com/elo7br/"
            },
            {
                nome: "twitter",
                imagem: app.get("img-url") + "twitter.png",
                link: "https://twitter.com/elo7"
            },
            {
                nome: "linkedin",
                imagem: app.get("img-url") + "linkedin.png",
                link: "https://br.linkedin.com/company/elo7"
            },
            {
                nome: "blog",
                imagem: app.get("img-url") + "BLOG.png",
                link: "https://blog.elo7.com.br/"
            }
        ];

        res.send(socials);

    };


    return api;
};
