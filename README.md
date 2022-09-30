### Consultoria Cravo & Canela 
<p align="center">

  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/frontend/assets/logo_cravo_canela2.png" alt="Logo Cravo & Canela"/>
</p>
<br/><br/>

   #### Gama Academy em parceria com McKinsey&Company - Bootcamp Mulheres em Cloud

<br> 

#### Sumário

  - [ONGs Projeto Cravo&Canela](#ongs-projeto-cravo&canela)
  - [O projeto](#o-projeto)
  - [Layout](#layout)
  - [Publicacao](#publicacao)
  - [Kaban](#kanban) 
  - [Instalacao](#instalacao) 
  - [Tecnologias Frontend](#tecnologias-frontend) 
  - [Documentacao do Banco de Dados](#documentacao-do-banco-de-dados)
  - [Endpoints](#endpoints) 
  - [Documentacao da API Swegger](#documentacao-da-api-swagger)  
  - [Clound](#clound) 
  - [Agradecimentos](#agradecimentos)
  - [Contatos](#contatos)
  
 <br> 
  
 #### ONGs Projeto Cravo&Canela 

 <p align="center">

  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/frontend/assets/home1.png" alt="Breve apresentação da aplicação"/>
</p>
 
<br> 


#### O projeto

<p>O projeto Cravo & Canela é inspirado no serviço de consultoria especializada em apadrinhamento de animais voltados a organizações do terceiro setor para maior expertise na captação de renda e manutenção de ONGs que objetivam a assistência e tratamento de animais de rua.
Através da aplicação é possível que ONGs cadastrem suas campanhas e causas relacionadas à PETs e com esta divulgação é possível maior alcance/visibilidade de pessoas interessadas em ajudar estes animais, apadrinhando um ou mais animais pelo período de tempo desejado enquanto a campanha estiver sendo veiculada no site. </p>

<br>
 
#### Layout

  - [Figma](https://www.figma.com/file/5Bh3kQpsM3wOOJjP7bu370/Projeto-Consultoria-Cravo-%26-Canela?node-id=27%3A387) 

<br/>
 
#### Publicacao

<br>  

#### Kaban

<p align="center">

  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/frontend/assets/kaban-g5.png" alt="kanban do projeto"/>
</p>

<br/>

  - [Projects Board](https://github.com/orgs/LovelaceTec/projects/2/views/1) 

<br> 
 

#### Instalacao
Ambiente ECS2 do tipo t2 micro, com Mysql, PHP e http.
Criado bash para realizar o deploy do frontend (https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/ScriptsAWS/deploy_front.sh)
<br> 

 
#### Tecnologias Frontend

  - [HTML](https://www.w3schools.com/html/)  - HTML (Linguagem de Marcação de HiperTexto), utlizada para definir a estrutura de sites. 
  - [CSS](https://www.w3schools.com/css/default.asp) - CSS (Cascading Style Sheets ou Folhas de Estilo em Cascata), utilizada para compor a estilização de sites.
  - [Java script](https://www.w3schools.com/js/default.asp) - Linguagem de programação interpretada e de alto nível com tipagem dinâmica e multiparadigma.
  - [Bootstrap](https://getbootstrap.com/docs/4.1/getting-started/introduction/) - Bootstrap é a estrutura mais popular do mundo para criar sites responsivos e voltados para dispositivos móveis.
  -
<br/>


#### Documentacao do Banco de Dados

 [<p align="center">
  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/SQL/modelagem_BD.PNG.png" alt="Logo Gama Academy"/>](https://www.gama.academy/)
 </p>
 
 - [SQL - Queries apadrinhamento v1](https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/SQL/banco_apadrinhe.sql) 
 - [SQL - Queries apadrinamento v2](https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/SQL/banco__apadrinhe_V2.sql) 

<br>


#### Endpoints

Para ONGs
- GET
/ong
- PUT
/ong
- POST
/ong
- GET
/ong/{id}
- DELETE
/ong/{id}


Para apadrinhamentos
- GET
/apadrinhamento
- PUT
/apadrinhamento
- POST
/apadrinhamento
- GET
/somatoria/idpet/{id_pet}
/somatoria/idpessoa/{id_pessoa}
/somatoria/idong/{id_ong}
/apadrinhamento/{id}
/apadrinhamento/idong/{id_ong}
- DELETE
/apadrinhamento/{id}


Para apadrinhadores
- GET
/apadrinhadores
/apadrinhadores/{id}
- PUT
/apadrinhadores
- POST
/apadrinhadores
- DELETE
/apadrinhadores/{id}
animais-controller

Para animais
- GET
/animais
/animais/{id}
- PUT
/animais
- POST
/animais
- DELETE
/animais/{id}

Para administrador
- GET
/administrador
/administrador/{id_adm}
- PUT
/administrador
- POST
/administrador
- DELETE
/administrador/{id}

<br>


#### Documentacao da API Swagger
 <p align="center">
  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/Swagger/Tela01.PNG" alt="Tela Swagger"/>
 </p>
 <p align="center">
  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/Swagger/Tela02.PNG" alt="Tela Swagger"/>
 </p>
 <p align="center">
  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/Swagger/Tela03.PNG" alt="Tela Swagger"/>
 </p>
 

<br>


#### Cloud
-API
Uso de AWS Elastic Beanstalk e Docker para ralizar o deploy. O ambiente é um EC2 do tipo micro t2, AWS Linux com Java 11 e Maven 3.8 e Elastic IP.
A imagem do docker está disponível no Docker Hub na tag priscilaco/lovelace_api.

-Banco de Dados
AWS RDS do tipo micro t3 MySQL Community 8 em AWS Linux.
<br>
 
#### Agradecimentos

 [<p align="center">
  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/frontend/assets/logo-gama-academy.png" alt="Logo Gama Academy" width="150" heigth="35"/>](https://www.gama.academy/)
 </p>

 
 [<p align="center">
  <img src="https://github.com/LovelaceTec/projeto-cravo-e-canela/blob/main/frontend/assets/logo-mckinsey.png" alt="Logo McKinsey & Company" width="150" heigth="35"/>](https://www.mckinsey.com.br/)
 </p>
<br>

 
#### Contatos

* Isabela Cammerer  - https://www.linkedin.com/in/isabella-ambros-cammerer-912880160/
* Laís Lopes - https://www.linkedin.com/in/laismaas/
* Luciana Midori - https://www.linkedin.com/in/luciana1992/
* Michele Farias - 
* Priscila Oliveira- https://www.linkedin.com/in/priscila-castro-de-oliveira-7671382a/
<br>










