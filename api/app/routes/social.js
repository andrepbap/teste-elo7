module.exports = function (app) {
    var api = app.api.social;
    
    /**
     * @api {get} /social
     * @apiVersion 1.0.0
     * @apiName GetSocials
     * @apiGroup Social
     * @apiPermission usuario
     *
     * @apiSuccess {String}   nome            nome da rede social.
     * @apiSuccess {String}   imagem            imagem da rede social.
     * @apiExample Example usage:
     * curl -X GET http://localhost:3000/social
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     [
     *         {
     *             "nome": "facebook",
     *             "imagem": "@drawable/facebook"
     *             "link": "https://facebook.com/elo7"
     *         },
     *         ...
     *     ]
     *
     * @apiErrorExample Response (example):
     *     HTTP/1.1 404 Not Found
     */
    
    app.route('/social/')
            .get(api.getAll);

};


