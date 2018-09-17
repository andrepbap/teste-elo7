define({ "api": [
  {
    "type": "get",
    "url": "/area",
    "title": "",
    "version": "1.0.0",
    "name": "GetAreas",
    "group": "Area",
    "permission": [
      {
        "name": "usuario"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "titulo",
            "description": "<p>título da área.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "imagem",
            "description": "<p>imagem da área.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n[\n    {\n        \"titulo\": \"engenharia\",\n        \"imagem\": \"@drawable/ic_engenharia\"\n    },\n    ...\n]",
          "type": "json"
        }
      ]
    },
    "examples": [
      {
        "title": "Example usage:",
        "content": "curl -X GET http://localhost:3000/area",
        "type": "json"
      }
    ],
    "error": {
      "examples": [
        {
          "title": "Response (example):",
          "content": "HTTP/1.1 404 Not Found",
          "type": "json"
        }
      ]
    },
    "filename": "app/routes/area.js",
    "groupTitle": "Area"
  },
  {
    "type": "get",
    "url": "/cultura",
    "title": "",
    "version": "1.0.0",
    "name": "GetCulturas",
    "group": "Cultura",
    "permission": [
      {
        "name": "usuario"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "titulo",
            "description": "<p>título da cultura.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "texto",
            "description": "<p>texto da cultura.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "imagem",
            "description": "<p>imagem da cultura.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n[\n    {\n        \"titulo\": \"criatividade\",\n        \"texto\": \"Estimulamos a intervenção humana\",\n        \"imagem\": \"@drawable/criatividade\"\n    },\n    ...\n]",
          "type": "json"
        }
      ]
    },
    "examples": [
      {
        "title": "Example usage:",
        "content": "curl -X GET http://localhost:3000/cultura",
        "type": "json"
      }
    ],
    "error": {
      "examples": [
        {
          "title": "Response (example):",
          "content": "HTTP/1.1 404 Not Found",
          "type": "json"
        }
      ]
    },
    "filename": "app/routes/cultura.js",
    "groupTitle": "Cultura"
  },
  {
    "type": "get",
    "url": "/social",
    "title": "",
    "version": "1.0.0",
    "name": "GetSocials",
    "group": "Social",
    "permission": [
      {
        "name": "usuario"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "nome",
            "description": "<p>nome da rede social.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "imagem",
            "description": "<p>imagem da rede social.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n[\n    {\n        \"nome\": \"facebook\",\n        \"imagem\": \"@drawable/facebook\"\n        \"link\": \"https://facebook.com/elo7\"\n    },\n    ...\n]",
          "type": "json"
        }
      ]
    },
    "examples": [
      {
        "title": "Example usage:",
        "content": "curl -X GET http://localhost:3000/social",
        "type": "json"
      }
    ],
    "error": {
      "examples": [
        {
          "title": "Response (example):",
          "content": "HTTP/1.1 404 Not Found",
          "type": "json"
        }
      ]
    },
    "filename": "app/routes/social.js",
    "groupTitle": "Social"
  }
] });