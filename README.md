# Teste de programação Elo7

Nesse projeto,  foi criado um aplicativo Android que simula a página de carreiras da Elo7 (http://carreira.elo7.com.br)

Todo o conteúdo do layout, exceto as imagens referente ao logo e cabeçalho, é carregado dinamicamente no momento da criação da activity. Esse conteúdo vem como resposta de uma API que simula a obtenção desses objetos de uma banco de dados.

Esse aplicativo foi desenvolvido de forma a ser facilmente expandido e utiliza ferramentas e práticas que possibilitam um desenvolvimento simples e rápido.

## Instalação e execução da API

Para instalar a API que simula o retorno dos objetos de layout, é necessário ter o npm e o node instalados.

Com tudo configurado, acesse a pasta do projeto a partir do terminal e entre com os comandos:

    $ cd api
    $ npm i
    $ node main

O endereço de acesso à API será mostrado na última linha do console. A API também ficará disponível em http://localhost:3000

## Execução do aplicativo

Após importar o projeto Android, será necessário indicar o endereço da API para o módulo que cria o serviço HTTP. Para isso, substitua o conteúdo de "baseUrl()" no arquivo ApiModule.java localizado no pacote "module", pelo endereço obtido no momento da execução do servidor, conforme o código abaixo:

```java
    public ApiService getApiService () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://endereco-da-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

```
