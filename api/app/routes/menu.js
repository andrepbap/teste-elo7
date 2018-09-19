module.exports = function (app) {
    var api = app.api.menu;
    
    /**
     * @api {get} /menu
     * @apiVersion 1.0.0
     * @apiName GetMenu
     * @apiGroup Menu
     * @apiPermission usuario
     *
     * @apiSuccess {String}   nome            nome do item do menu.
     * @apiSuccess {String}   link            link do item do menu.
     * @apiExample Example usage:
     * curl -X GET http://localhost:3000/area
     *
     * @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *     [
     *         {
     *             "nome": "engenharia",
     *             "link": "http://carreira.elo7.com.br/engenharia/"
     *         },
     *         ...
     *     ]
     *
     * @apiErrorExample Response (example):
     *     HTTP/1.1 404 Not Found
     */
    
    app.route('/menu/')
            .get(api.getAll);

};


