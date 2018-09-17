
module.exports = function (app) {

    var api = {};

    api.getAll = function (req, res) {

        var socials = [
            {
                nome: "facebook",
                img: "facebook.png",
                link: "#/"
            },
            {
                nome: "instagram",
                img: "instagram.png",
                link: "#/"
            },
            {
                nome: "googleplus",
                img: "googleplus.png",
                link: "#/"
            },
            {
                nome: "pinterest-light",
                img: "pinterest-light.png",
                link: "#/"
            },
            {
                nome: "twitter",
                img: "twitter.png",
                link: "#/"
            },
            {
                nome: "linkedin",
                img: "linkedin.png",
                link: "#/"
            },
            {
                nome: "blog",
                img: "BLOG.png",
                link: "#/"
            }
        ];

        res.send(socials);

    };


    return api;
};
