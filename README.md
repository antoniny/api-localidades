# API - Localidades

Projeto criado para realização de um desafio. Disponibiliza três url's de api para extração e consulta de dados referente a estados e municípios. 
Através das urls publicadas as consultas serão realizadas em api externa publica do IBGE e retornado os dados transformados em Json/CSV. 

## Visão geral

O projeto é uma aplicação back-end java com objetivo de demonstrar a construção de uma API utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Web](https://spring.io/projects/spring-ws) em conjunto.

---
#### Temas
1 - Tecnologias

2 - Contratos de API

3 - Setup da aplicação (local)

4 - Instalação da aplicação

5 - DockerHub

6 - Instalação da aplicação via build/compilação

---

## 1 - Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Web](https://spring.io/projects/spring-ws) é um produto da comunidade Spring focado na criação de serviços da Web controlados por documentos.

> Compilação do projeto realizado com Maven / IntelliJ IDEA

---
   
Estrutura do projeto
 ```
br.com.antoniny.localidades
config
controller.v1
integration
service
resources
 ```
---
Diagrama de Classes
>[Diagrama de classes do projeto](https://app.diagrams.net/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R7V1Zl5u4Ev41Pifz0H0Qm%2BGxuyedZKY7NzfbPNNGtplg8ADuZX79SGwGSdgCLMDdyp1zEwux1qeqr0ql0ky72Tx%2FiJzt%2Bj50oT9TFfd5pv0%2BU1XdshX0F255yVpUoNpZyyry3KwN7Bu%2Bef%2FCvDE%2FcbXzXBjXOiZh6Cfett64CIMALpJamxNF4VO92zL063fdOitINXxbOD7d%2BpfnJuus1VLn%2B%2FaP0FutizsDM3%2B%2FjVN0zt8kXjtu%2BFRp0t7PtJsoDJPsX5vnG%2Bjjr1d8l78%2Bvfzl3%2F0yP%2Fzx%2F%2Fgf58f1n98%2F%2F7zILnbb5pTyFSIYJJ0v7V39%2BGV%2BtV4c8PNZ%2BXF9%2F%2Benj8kFUNT85ZKX4otBF33A%2FGcYJetwFQaO%2F37feh2Fu8CF%2BLoK%2BrXvcxeGW9QIUOPfMElecjQ4uyRETetk4%2BdHXSdep%2BfjH3HiRMkVFjVqWPhOHHuLovnW84tzYOAWnYIwgFlLfhw%2FRvYe%2BOEJwR%2F5anm%2FONxFC3jgU9k5YtBjrWByoKOlluBAwwqGG5hEL%2BjECPpO4j3WH8%2FJ4b0q%2B%2BWnond1XiodtqEXJHHlyl9wA%2BqQD1UzR2kxThWrjobD3a0adtA%2FstsXvyrvsW9K8dUKa9q0sJbDqAo0pQ4013M2YeDWsAamhDXb7Im1isjbS9Qyzk2ge%2FUyrEDNQXUHNdovNJs53stLZA%2BWn0Wg4gRDP3%2F9R8ff5a%2FwHgnJDX9HsiURFD95G99JBbkMg6QAE5aS43urAEsRCQVGqOERRomHbP1VfiDBELperD3fvXNewh3%2B1OhGi1%2FFr%2Bt1GHn%2Foss6fhVAOdZUs9bjGz4zx1AEY9TnS4EHQDTdO8%2B1jndOnOQNi9D3nW3sPZSvsUEf2wuuwyQJNzXjhV8HPndAIA2YQvCmWhe8lv982nMhUGBjXeVBitIMsl5KY05h4SIF%2BMpzEBjQx7hC%2F%2F81%2FcmCB%2FpASSq2KPwFb0I%2FjPYDf4kGNNFUQMaHy6QRMPHWWXjB6i7t87u%2Bb%2FmafxDcFKJzl36qRdae68Ig1WWJkziZZLEYcyONHtS4Rv%2BhT3ijXBozAz34DfoN9r%2FRf7h7lNyEAXoXx0uFDBFsniCGDh8imgcbjYiCGJh8ACj6nd5oUPKnZOx7uR7HMi5YO%2Bgk4A0SVWp2col%2BT43MBaCkrtFS1xgS9p0H6H8JYy%2FxQnz9KOtLSH4s4Roqn3AtQbK1GbK9xk4gMugwit%2F9NsOw0kCm8vCROD%2BCXnwT%2FyZH%2B4kBYXKqe12Utgc6BYlm3d5g%2BpXeNp0Blddt5oFp8Qm%2B0BgnF7zKUAWmn2E9%2B9t5wENhgQinucrbi78LHZGxxJrS4IOMNgBb1JWxYFSFM%2Foyy%2BVSXSwoNYmOuOaDaZgigTcnHAuWwgEsfilM42hMfolOKbhl6uOUiMIHA3Tr8jD6iMgWED1ib%2BU7VBceY1WVQpPc3qDZavBzX%2Brm6BiKDFEgoq1WN5LaQsrTZKo9VUoH2ducshfFYY0%2BHNbhJrFSL3TBBoPVsLChi2I1QLEp8U5%2FvmSsqCdQeOPYQNHZgh8mkA2saUl1ujMTvIFsQXFs06jTTZ2wAtnzU3HstpNp1H3sw7NpVH%2BgWgQoBUyoFT7fIZYyAIyFaxGdE3N958IaZKvbDb71kcmT1qAzSBAZxIx%2ByxMEoU6XuvLEwD2Jsuyt44CtT1DJ6RzzBQPgj0W6vq%2B94DDxGiVRRQOcsNNH5VwmGF2O3VVHTR1NRqBZUtvwioRIJtLAEbt15AQxisSgA4OjA3DaikTntV%2B6PaYiMaSFaCtYm1OwxrgWQhldjmdiIbhH6mksBL9GP7mPRAUA9GO2xhjB1pjja6BzQS6vKhqL2xDwMUxjingbJbP6HPFmDKspe%2BNtrrR0ygfBm0oncXbI7rjfBd7C23oyweOMEjz4Mzw0pXlw9Estogl%2FtxQPAmpynrbFPG2DemyZwCEsC6hYpSgzOIRkcByWvsUpfVEpHIXmkTkcU9QN1thJHNbZzWCNlcDBHXmei5p7VbrFFU5FdIsPUNEkJWuVi9dmA2e1cy9nELd6TVOZ3HPjLaIwIhax3aeNcilbd0uiNQBkKmvZNI45JbmYrat4x17NprGywOVytjFH%2FOjr2XQaE8fUvOQEIjmBxlovMCwn0OklAxezG3V2pWxgXLICRAnStnvcJklBdxXRlLY0FVKg09UuJCk4mXjHJgU6a%2BpDkoIxR%2Fz4pIAONh%2FR8pITiOQEBjDG5gQGHYLOOcFuWVKBH0vJADrpg4Z8w6kwAIOOGkoGcDLxjs0AivtLBjCZET86AzDosABbuUvDL9Lwmzqv4QfCtENjMKBaQyRrYFUakYXwTqY0mrLXW9KEIuR3eqjIQIFA8c45bYIwRSADBVMb8XPOomjCaII9sYLJk64eMuetNWFrbKkPs0ppztLiWQ70tiZq858d3iogJ0iZeVe2z6mpx6M%2Fa79IxyU%2BpleO4aF%2FkQ9ofCzniOU1K9nVzgaPa5%2F%2BFcF%2FdniAIZk9o5MRgvDn2Hplr%2FoVil%2FpuQ9R5Q5ZS9FQ5sN8Qo%2B0ipzUGpTJ4LcP5ImobUu2rSP8pYq9I4qXAsz36%2F5lM0VYftqma7MeUMz9cmtQfsH43W45qycp%2F5b9uPOw4KrSrKchccqMaqm%2FK6Ga2BaDMCsV27BMdUPm12SyBGr%2B%2B9bZeD7Wwh%2Bh%2FwjxVesqquoLqTMqm9I1oOXqlO1DRyz1QTOFJsCTpdPVuXpJexmlC1q1I3NDlB3hqE8nDUvT17PUszAsxWNOxbCkd0bsMBBtbNDXIm5zzAZldWKlAepogLLPhz2SBmNT2a1BWprBLI0%2BAUNDJzh6Dyt4iUby5SOjgIvve9s4jTGsnS1MdXy4w0s%2Bn9ZeAr8h1xI3PkXOlpAKIQUHWkvmgjdzYcGHpVApkKW0i9hu1WtUWYEEYV7jxDyM9M4ejxXAGjlaYqHzqX3vuB4hdP43GD16C1i9kVT83Ir%2Fyvf3ur9wPFqrf9Zj04IT%2BeEmbG4ms5JXM3msC0uxzUXNk5fLvqbituxLFEytZA9QeKNhY5fSVaS1OhQlkwbrNKGyH0tWsKzZhh2Pl41hfSuhv3N6%2BKUXuJ%2Fc8qmuXz47aXmFd7jMQqWsR3vpfHK%2FwngbBjGUdOOs6YaqGTW6YRaplhW2oc8ZbMO2L0V5swCMUnP0HHc7BorByTd6L%2F3uKdK5FCmnSAFv3HtsCnl%2B2zGMNZXBvVH02CKVVeP5hylvScQ8CjneMGXVWHrznt5diKie5zou7Ovq0TeZiPO391%2F2L3vYgdn3a0nvJZVWVWtej9wx9vDW8jKRdSYtakKiZBKssjiEB0cIUOa%2FnxAYhmbXgKHz5ryKW%2FcGQNP%2Bmzfp8C91RFGwSSa4NuDh0Mib7tI3wNjwmZKzTGrvLOCxF78B0Gt%2FTJnWLgIUoy9%2Fs%2Bm1DrXpeUkDFAajNPD%2FWIzSTP%2Fk36bSnv0RSCjIOWJg0eqGOUUsbBv5YsdXgk5AOuEv5xWMVEAefVP76g1yOlvN0wtGBwZ8GxrChI04GqIw6nQRU7BSKZ2HUlJJ9xcwZpIUFgcS5uQorEW%2BqrJhLoXJFVPDOpnq2t8NgdAbZ7GGqUqgLkL3qF0J1q1vTTeWrc2bLuQq8nwVXh3UMP3DArVmarbm9iNnTZH1Zl3IRKshaplxuQv3AV1YwZFUiuJUmV7XZKx4DRsbougVUFib5xUpHlleR7ukjsPpHOyorvQAjyuZ1oSLCSRxhKu48vlM8I01Z1suHhhg0jY9te0mVNa8HlYuVkQ07UFF9R9iG3KgTmwt%2FZQBx7uNQ5NbJxhvVt0sFvGsRryR%2FZUh8Dbvn5SyCDdY%2FOm%2F%2F95ttsW5q3Q5VNqS4c7uBs54jej9U36Ds8xy17mz3I1R1%2BYCZpFfmftA5j78EYfBG8l%2FwK%2FaMgcCnyLzILi9J0D7T4wlTAX7GCgVorBF0iyIJDDcaY5N%2B0cMZBbs5pS44m%2FkHKKR4%2FswunLzOFzTBqlITySFrngfJF7y8v55Abc4cvjRCVwf2wK%2BcI3WOw7TpAZGic%2BMoHtsQOge1vJJnbU4H4jb5LJw8anozTqFx%2Bed76fcGUYlcPbBYAJK9UBNfQY%2FuxxCbgAXCXmptJZl%2B6t98uEqBU0CmVfset17iBQk0ler3QYJ%2FHOY%2FMRW9yRX9pD7FqwwtfEhGphphZMveMNImNKyrnco%2F4lLpQRuXFT%2BbDXw5QaVLaJpdusC4uyRDYTF7JlFpqV%2FQfoXN%2FHjG3Ev0Ju29C7QGRNZLopeBk8k3HrQd2P0TO%2BaHnb%2FgmVtZOkLNfhCRJkayzBYzpA%2BqDNk2q%2FFGZpwNFfndoZ6rw%2FqFM61CWTOjcJNFxyg7b%2B492zAN9riNH7wZQxmNE983n8%2B8mzQMJoq0rjRoPedWeoZpVPfDhpG0w38aOgdpetkmAAgCiyail23TB1OEWTMLGnMBjBm3IkYIwFWB%2FUiKoY6DJWy%2Bq%2FWPxv0jcfjudE38lz3vH%2BJlYmgYcLFWbhzdMZGg6W9FjRMWDfwT3iO4%2BMDhVyUoc2PUamjp4gyZqw52beCYKYywxf84uBFuUF6VVXRhwC1NVyxoiY%2BZdT5FFBMIhaaPVt%2B3h6afVMagVLPiT16gmYNkNOoKnSxBjJd4S5crWB1poRMUsAdvGC1T2ugBpfMSRgoJ0Fl1Vhk7hcgLiOBXneJ16P5OYqK6av0562zSEJ8U2K23UOK9pmeCTq2Wk1OfXNMfedDvvfUt7BNMUsrMamZ7xaVnfmnoaczjzm9Rb%2BA2oZDUVjZnoA1wUka9RPm99HqLdsK5dLfT9VfXl7SBPP8d0ZBo8u8rPOnuU0bnHIA1wtOCdMXJ9hTcyJsftKbppWB8OPs3RbD3lWd3O3bIMZ59hK9yfu%2BPFoBc%2B0weT92giDH1n41U5yvBfm9Q3PdgjEW4QcYmnUQr9QJxc7IgvH6tuLIZ4DX3rPyI%2BF1Ph9Ev76aFZ%2BvBa%2FWmeKVDP%2BJAiy9HGSfads%2BQPe6a7xMZ%2BNPYJFbsxm55qlGYSyGowsEerqAwlIWyCvwhBevkgWm7thHa6Wp9le4iR%2BbL1A9eLBIVnkuIxDTOmRYyroJHW8wZJirlVYhQxZYxRW4slUKq5TEuWoOt5D0NAsP91ReneRv0TEgpvyFlSRmbFKcTSR8eP%2B91A70gppvPysLauqr7d79b5dsd8gQRtDZ0AWND16XqANAXLixCMDRu3zKK6in5biIYupkLS7ipuxyXJyVmKVW7DYqOE34XBU1LNRDbFDWQD2rGqiWPSdC7ypgTYeous1gieKC7yqbJbYrP9qS1XEqLVnOuYUya8oiO1DPmYU0cbPCBaM7BcXjRcCZULzTKKVOuGDUL2XiQhj1U1nUTyqI4YFAsx0mEMTVHzVoJLCqBRwKCkjuM0nuA1SDpD4aa6k7a4MBgdTHaMp0oyg2FdtiU6BFGOCPV%2FHQvocpYvPzb6jj6VGp7U6v7ZrmcZvpEBN94uiQwdqFSdIh0XToCC4YdIiJC2F0yGBVJZUKYngg0HSICQRxdEg%2FFPwhKwRJHiQykZXIDdNMZuBGY8UGhdkPnY7bdLMfb3SXRr19vIQlYGGGQGeFS64zkom%2BxQ4vvGDMRfDPCsjdOVrAQdP54CCsUGhev%2BDgQi%2FnAX%2BVRXJwqVcBmImZDV2Zivs8XkU4e07UiigrlRzfDtoSpog0WhE1bwddc4djb%2BU72ZTBrD7PSXSM4Mpzws%2FoiQ%2F3a5w3ZfS7h3EYZRdmHL0No43DfDBOri1XprWosVIkRTGWmgy8t7nGEW2WrKmzhAGviMVpK9bm5XkF0xNubi01QEd80G71sPtcl3U5DrrVEyNHr8%2BntokJAc1iTQgM7FKrHGVGpHE4NrSm61JrdESNdqkzvpoqAKxDZ5X8FelbC8HF%2BL61fsgmVPbBklPPZzj1bBrkkneFVWd96Lw7nd62t%2FXks5wXOv28UNOCysnk0emnYily4viEuBg9j85gkRupIIYHwuh5dBqPh1tuXClpjEjyQUb056w95wZ2czWaeXQzIG%2FUzdWm7uayCIKcOR4JDgK9W%2FQzCnGxu%2FLYh8jZru9DF%2BIe%2FwE%3D)

 ---
 
## 2 - Contratos de API

Este projeto publica 3 urls para consumo e utiliza internamente 2 urls externas para coleta de dados.

Seguem abaixo as API's do projeto:

##### Host Local

 - /api/v1/localidades (GET)
    - Retorna um Json com todos os municípios/estados da federação em layout específico através de busca online em api's do IBGE. 
    
    exemplo:
    ```
    λ curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/v1/localidades'
    [
        {
            "idEstado": 11,
            "siglaEstado": "RO",
            "regiaoNome": "Norte",
            "nomeCidade": "Alta Floresta D'Oeste",
            "nomeMesorregiao": "Leste Rondoniense",
            "nomeFormatado": "Alta Floresta D'Oeste/RO"
        },
        {
        ...
        ...  
    ]
    ```
 ---
 - /api/v1/localidades/csv (GET)
    - Retorna um text/CSV com todos os municípios/estados da federação em layout específico através de busca online em api's do IBGE. 
    > Disponibiliza download de arquivo *.csv com todos os dados retornados.
    
    exemplo:
    ```
    λ curl http://localhost:8080/api/v1/localidades/csv
   
    > download file localidades.csv
     
    idEstado;siglaEstado;regiaoNome;nomeCidade;nomeMesorregiao;nomeFormatado
    11;RO;Norte;Alta Floresta D'Oeste;Leste Rondoniense;Alta Floresta D'Oeste/RO
    11;RO;Norte;Ariquemes;Leste Rondoniense;Ariquemes/RO
    11;RO;Norte;Cabixi;Leste Rondoniense;Cabixi/RO
    ...
    ...
    ... 
    ```

---
 - /api/v1/localidades/cidades/id (GET)
    - Retorna o id IBGE da cidade pesquisada atráves de uma parâmetro "nomeCidade" através de busca online em api's do IBGE. 
    
    > Devido ao fato de exitir em nossa federação cidades homônimas, essa irá retornar o id de todas essas cidades. 
     
    
    exemplo:
    ```
    λ curl http://localhost:8080/api/v1/localidades/cidades/id?nomeCidade=Palhoça
    [
      {
        "idCidade": 4211900
      }
    ]
    
    ```
 ---
 Layout(Json/Csv):
 ```
  idEstado
  siglaEstado
  regiaoNome
  nomeCidade
  nomeMesorregiao
  nomeFormatado {cidade/UF}   
```
 ---

##### Host Externo - Consumo interno da aplicação

Este projeto utiliza duas url's para consulta externa.

> Apesar de haver diversas url's no repositório do IBGE, este projeto utilizou somente as duas urls abaixo para consumo.

[Consulta de Estados](https://servicodados.ibge.gov.br/api/v1/localidades/estados)

[Consulta de Municípios](https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios)

[Documentação](https://servicodados.ibge.gov.br/api/docs/localidades)


---
 
 
# 3 - Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
Maven 3.1.0
```

## 4 - Instalação da aplicação 

Primeiramente, faça o clone do repositório:
```
https://github.com/antoniny/api-localidades.git
```
Acesse a pasta do projeto:
```
cd api-localidades
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```

A api já deverá estar disponível em 
>http://localhost:8080/


Swagger: http://localhost:8080/swagger-ui.html#/
```
Localidades : Obtem informações de localidadesShow/HideList OperationsExpand Operations

 GET /api/v1/localidades
 Obtém os municípios cadastros no IBGE no formato JSON.
 
 GET /api/v1/localidades/cidades/id
 Obtém o(s) código(s) ibge(id) do(s) município(s) através do nome do município.
 
 GET /api/v1/localidades/csv
 Obtém os municípios cadastros no IBGE no formato CSV.
 
 [ base url: / , api version: 1.0.0 ]
```

# 5 - DockerHub

[Repositorio DockerHub](https://hub.docker.com/r/antoniny/api-localidades) -> Acesso ao repositório do projeto no DockerHub


##### Executar servidor via Docker Client - pull image

Pré-requisito
```
Doker Client instalado e em execução
```
[Get Docker]((https://docs.docker.com/get-docker/))

Comandos para iniciar o servidor
```
##1 - Realiza o download e inicia o servidor em http://localhost:8080/swagger-ui.html

docker run --name api-localidades -it -p 8080:8080 antoniny/api-localidades:latest

##Nota: Caso não deseja a exibição de logs do servidor em seu terminal, execute o comando abaixo ( -d
docker run --name api-localidades -itd -p 8080:8080 antoniny/api-localidades:latest

##2 - Stop servidor

docker stop api-localidades

##3 - Listar imagens

docker images

##4 - Listar container ativos

docker container ls

##4 - Deletar container / image

 docker rm api-localidades
 docker rmi -f antoniny/api-localidades
```

### 6 - Instalação da aplicação via build/compilação

Baixar as dependência e criar imagem da aplicação

Considerando sistema operacional windows com docker cli instalado.

Nota 1: Docker Cli deve estar ativo (Container Linux) 

Nota 2: Ativar -> Docker Cli Win > Settings > General > Expose daemon on tcp://localhost:2375 without TLS 

Necessário para que o Maven consiga gerar a imagem no docker.
```
mvn clean package docker:build
```
Executar container da aplicação
```
docker run --name api-localidades -it -p 8080:8080 antoniny/api-localidades:latest
```
.



   
   
