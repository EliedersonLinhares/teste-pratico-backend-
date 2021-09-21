# Api Cadastro de candidatos a vagas de emprego

Api desenvolvida para o cadastro de candidatos a vaga de emprego
Os diagramas estão pasta "diagramas" do projeto

## Descrição

Api desenvolvida em Java com springBoot como um projeto para um teste prático.

## Prototipagem de algumas Telas

![](https://i.imgur.com/6S81hcm.png)
![](https://i.imgur.com/XrwyLeU.png)
![](https://i.imgur.com/sV2kurJ.png)

As demais estão na pasta "Telas" do projeto

### Requisitos

Este sistema atualmente roda com o SpringBoot e MySql

### Instalação

Para usar pela primeira vez execute os seguintes passos:

```
Usando seu gerenciador de BD crie o Banco de dados "candidatos"
```

```
Quando rodar o programa ele automaticamente criará as tabelas
```

```
Opcionalmente com o Docker instalado realizar um "docker-compose up" na pasta que está o arquivo
para criar uma imagem do Mysql e usar um framework com o HeidiSQL ou WorkBench
```

```
Para consultar os endpoints acesse http://localhost:8080/swagger-ui.html
```

### Instalação via docker

```
docker pull keasarge/candidatos:latest
```

## Testes

Neste sistema eu usei o JUnit para testar métodos durante a fase de desenvolvimento.
elas estão na pasta src/test/java

## Bugs

Não foi localizado nenhum bug aparente

## Softwares Usados

- [SpringBoot](https://spring.io/projects/spring-boot) - framework que agiliza criação de aplicações java
- [MySql](https://www.mysql.com) - Amarzenamento do banco de dados
- [Docker](https://www.docker.com) - Criação do banco de dados sem necessidade de instalação
- [Swagger](https://swagger.io) - Documentação dos endpoints
- [Junit](https://junit.org) - Para os testes
- [Quantum-UX](https://quant-ux.com) - Para criação das telas
- [Astah](https://astah.net) - Para criação dos diagramas

## Versão

A versão colocada aqui é a usada durante o desenvolvimento na versão 1.0

## Sobre o Projeto

- O projeto foi interessante por me ajudar a fixar alguns conceitos relativos dato,validações,testes...
- A parte do SpringSecurity com autorização e autenticação é bastante trabalhosa

## Futuro

- Usar algumas pesquisas em SQL para trazer resultados customizados
- Utilizar o React ou angular para poder criar o frontend

## Referências

As seguintes referências foram usadas no densenvolvimento desse projeto

- [Documentação do SpringBoot] (https://spring.io/projects/spring-boot)
- [Projeto anterior tambem feito springBoot] (https://github.com/EliedersonLinhares/cursospring)

## Autor

- **Eliederson Linhares** - (https://github.com/EliedersonLinhares)
- Email: eliederson250@gmail.com

## Licensa

Este projeto estará sobre a licença MIT.
