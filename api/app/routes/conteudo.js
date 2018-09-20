module.exports = function (app) {
    var api = app.api.conteudo;
    
    /**
     * @api {get} /conteudo/carreiras
     * @apiVersion 1.0.0
     * @apiName GetCarreiras
     * @apiGroup Conteudo
     * @apiPermission usuario
     *
     * @apiSuccess {String}   tituloCulturas            título de introdução das culturas.
     * @apiSuccess {String}   textoCulturas            texto de introdução das culturas.
     * @apiSuccess {String}   tituloAreas            título de introdução das áreas.
     * @apiSuccess {String}   tituloRodape            titulo do rodapé.
     * @apiExample Example usage:
     * curl -X GET http://localhost:3000/conteudo/carreiras
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *         {
     *             "tituloCulturas": "nossa cultura",
     *             "textoCulturas": "Somos orientados pela satisfação e fidelização de nossos clientes",
     *             "tituloAreas": "conheça nossas áreas",
     *             "tituloRodape": "conecte-se com a gente"
     *         }
     *
     * @apiErrorExample Response (example):
     *     HTTP/1.1 404 Not Found
     */
    
    app.route('/conteudo/carreiras')
            .get(api.getCarreiras);

};


