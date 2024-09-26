# Desafio Back End - Planetas Star Wars
Este repositório contém a implementação de um desafio de back end inspirado na empresa Ame Digital. O desafio foi desenvolvido em Java e consome a API SWAPI para interagir com o universo de Star Wars.

## Funcionalidades
Este projeto oferece uma API REST que permite:

* Adicionar um planeta: Enviar informações sobre um novo planeta, incluindo nome, clima e terreno.
* Listar planetas: Recuperar uma lista de todos os planetas cadastrados.
* Buscar por nome: Localizar um planeta específico pelo seu nome.
* Buscar por ID: Encontrar um planeta específico usando seu identificador único.
* Remover planeta: Excluir um planeta do cadastro.
## Tecnologias Utilizadas
* Java 22 <br>
* Spring Boot: Para a construção da API REST. <br>
* JUnit e Mockito: Para os testes unitários. <br>
* Maven: Para gerenciamento de dependências. <br>
* MySQL: Para salvar os dados

# Como Executar o Projeto
## Pré-requisitos
* JDK 22.
* Maven instalado.
* MySQL instalado.
### Clone do repositório:
 ```bash
 git clone https://github.com/juliocesr/desafioBackEnd-AmeDigital.git
 ```
### Compile o projeto usando Maven:
 ```bash
 mvn clean install
 ```
### Execute a aplicação
```bash
mvn spring-boot:run
 ```
##Testes Unitarios:
```bash
mvn test
 ```

# Endpoins da API:
## Listar Planetas:
* Método: GET
* URL: /desafio/listar-planetas
  
## listar Planetas por ID:
* Método: GET
* URL: /desafio/listar-porID?id=1

## listar Planetas por nome:
* Método: GET
* URL: /desafio/listar-por-nome?nome=teste

## Quantidade de aparições do planeta nos filmes:
* Método: GET
* URL: /desafio/aparicao?id=1

## Adicionar planeta:
* Método: POST
* URL: /desafio/adicionar-planeta
* Body:
```bash
  {
      "nome": "Alderaan",
      "clima": "temperate",
      "terreno": "grasslands, mountains"
  }
```


## Remover planeta:
* Método: DELET
* URL: /desafio/remover-planeta?id=1












