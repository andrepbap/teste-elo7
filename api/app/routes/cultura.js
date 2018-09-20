module.exports = function (app) {
    var api = app.api.cultura;
    
    /**
     * @api {get} /cultura
     * @apiVersion 1.0.0
     * @apiName GetCulturas
     * @apiGroup Cultura
     * @apiPermission usuario
     *
     * @apiSuccess {String}   titulo            título da cultura.
     * @apiSuccess {String}   texto            texto da cultura.
     * @apiSuccess {String}   imagem            url da imagem.
     * @apiExample Example usage:
     * curl -X GET http://localhost:3000/cultura
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     [
     *         {
     *             "titulo": "criatividade",
     *             "texto": "Estimulamos a intervenção humana",
     *             "imagem": "http://localhost:3000/cultura.png"
     *         },
     *         ...
     *     ]
     *
     * @apiErrorExample Response (example):
     *     HTTP/1.1 404 Not Found
     */
    
    app.route('/cultura/')
            .get(api.getAll);

};


