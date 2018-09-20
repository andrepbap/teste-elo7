module.exports = function (app) {
    var api = app.api.area;
    
    /**
     * @api {get} /area
     * @apiVersion 1.0.0
     * @apiName GetAreas
     * @apiGroup Area
     * @apiPermission usuario
     *
     * @apiSuccess {String}   titulo            título da área.
     * @apiSuccess {String}   imagem            url da imagem.
     * @apiSuccess {String}   link            link da área.
     * @apiExample Example usage:
     * curl -X GET http://localhost:3000/area
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     [
     *         {
     *             "titulo": "Engenharia",
     *             "imagem": "http://localhost:3000/ic-engenharia.png"
     *             "link": "http://carreira.elo7.com.br/clkn/http/carreira.elo7.com.br/engenharia/"
     *         },
     *         ...
     *     ]
     *
     * @apiErrorExample Response (example):
     *     HTTP/1.1 404 Not Found
     */
    
    app.route('/area/')
            .get(api.getAll);

};


