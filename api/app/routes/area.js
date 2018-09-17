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
     * @apiSuccess {String}   imagem            imagem da área.
     * @apiExample Example usage:
     * curl -X GET http://localhost:3000/area
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     [
     *         {
     *             "titulo": "engenharia",
     *             "imagem": "@drawable/ic_engenharia"
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


