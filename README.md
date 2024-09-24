![GitHub Created At](https://img.shields.io/github/created-at/trcosta97/aluraflix-api)

![GitHub last commit](https://img.shields.io/github/last-commit/trcosta97/aluraflix-api)

![GitHub repo size](https://img.shields.io/github/repo-size/trcosta97/aluraflix-api)



# Challenge Alura 5° - Aluraflix

Após alguns testes com protótipos feitos pelo time de UX de uma empresa, foi requisitada a primeira versão de uma plataforma para compartilhamento de vídeos. A plataforma deve permitir ao usuário montar playlists com links para seus vídeos preferidos, separados por categorias.

Os times de frontend e UI já estão trabalhando no layout e nas telas. Para o backend, as principais funcionalidades a serem implementadas são:

- API com rotas implementadas segundo o padrão REST;
- Validações feitas conforme as regras de negócio;
- Implementação de base de dados para persistência das informações;
- Serviço de autenticação para acesso às rotas GET, POST, PUT e DELETE.

## Autores

- [@Thiago Ribeiro](https://www.github.com/octokatherine)


## Documentação da API

#### Cadastra um video

```http
  POST /video/
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `title` | `string` | **Obrigatório**. O título do vídeo |
| `desc` | `string` | A descrição do vídeo |
| `url` | `string` | **Obrigatório**. A url do vídeo |

#### Retorna todos os itens

```http
  GET /video/
```

#### Retorna um item

```http
  GET /video/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### Atualiza um video

```http
  PUT /video/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer atualizar |
| `title` | `string` | O título do vídeo |
| `desc` | `string` | A descrição do vídeo |
| `url` | `string` |  A url do vídeo |

#### Deleta um item

```http
  DELETE /video/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer deletar |






## Autores

- [@Thiago Ribeiro](https://www.github.com/trcosta97)


## Instalação

Instale Alura Flix API com springboot e gradle

```bash
  git clone https://github.com/trcosta97/aluraflix-api.git
  cd alura-flix-api
./gradlew bootRun

```
    
## Stack utilizada

**Back-end:** Java, Springboot, Gradle


## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  ./gradlew test

```


## Feedback

Se você tiver algum feedback, por favor me deixe saber por meio de trcosta97@hotmail.com

