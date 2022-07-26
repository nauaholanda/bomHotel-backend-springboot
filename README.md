<h1 align="center" >
  <img height="100" src="https://github.com/nauaholanda/bomhotel-frontend-reactjs/blob/main/src/images/logo_orange.png" />
</h1>

<h1 align="center">Bom Hotel - Back-end</h1>
<p align="center">API Rest desenvolvida com Spring Boot e testada automáticamente com JUnit 5 e Mockito</p>

<p align="center">
  <img src="https://img.shields.io/static/v1?label=SpringBoot&message=v.2.7.2&color=green&style=flat&logo=" />
  <img src="https://img.shields.io/static/v1?label=PostgreSQL&message=v.13.4&color=blue&style=flat&logo=" />
  <img src="https://img.shields.io/static/v1?label=Java&message=11&color=blue&style=flat&logo=" />
  <img src="https://img.shields.io/static/v1?label=JUnit&message=5&color=red&style=flat&logo=" />
</p>

<p align="center">
 <a href="#recursos-disponíveis">Recursos Disponíveis</a> •
 <a href="#tecnologias">Tecnologias</a> • 
 <a href="#pré-requisitos">Pré-requisitos</a> • 
 <a href="#autor">Autor</a>
</p>

<h2>Recursos Disponíveis</h2>
<h4>Login</h4>
<ul>
  <li>POST: /login - Autentica o usuário fornecido</li>
</ul>

<h4>User</h4>
<ul>
  <li>POST: /user - Insere o usuário fornecido na base de dados</li>
</ul>

<h4>Booking</h4>
<ul>
  <li>GET: /booking/{userId} - Retorna todas as reservas do usuário que possui o id informado</li>
  <li>POST: /booking - Insere a reserva fornecida na base de dados</li>
</ul>

<h4>Accommodation</h4>
<ul>
  <li>GET: /accommodation - Retorna todas as acomodações existentes na base de dados</li>
  <li>GET: /accommodation/{id} - Retorna a acomodação que possui o id fornecido</li>
  <li>GET: /accommodation/newest - Retorna as 5 últimas acomodações inseridas na base de dados</li>
  <li>GET: /accommodation/search - Recebe 4 parâmetros country, state, city e occupancy, e utiliza-os para fazer uma busca na base de dados</li>
  <li>POST: /accommodation - Insere a acomodação fornecida na base de dados</li>
  <li>PUT: /accommodation - Atualiza as informações da acomodação fornecida</li>
  <li>DELETE: /accommodation/{id} - remove a acomodação que possui o id fornecido da base de dados</li>
</ul>

<h2>Tecnologias</h2>
<ul>
  <li><a href="https://spring.io/">Spring boot</a></li>
  <li><a href="https://www.postgresql.org/">PostgreSQL</a></li>
  <li><a href="https://maven.apache.org/">Maven</a></li>
  <li><a href="https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html">Java</a></li>
  <li><a href="https://junit.org/junit5//">JUnit</a></li>
</ul>

<h2>Pré-requisitos</h2>
<p>Antes de instalar e executar a aplicação é necessário possuir três ferramentas: <a href="https://git-scm.com/">Git</a>, <a href="https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html">Kit de Desenvolvimento Java 11</a> e <a href="https://www.postgresql.org/">PostgreSQL</a>.</p>

<h4>Passo a passo para instalação e execução:</h4>

```bash
# Clone este repositório
$ git clone <https://github.com/nauaholanda/bomhotel-backend-springboot>

# Certifique-se que as configurações de banco de dados em bomhotel-backend-springboot/src/main/resources/application.properties estão corretas

# Execute o arquivo de inicialização bomhotel-backend-springboot/src/main/java/br/com/nauaholanda/bomHotel/BomHotelApplication.java

# O servidor iniciará na porta:8080 - acessível em <http://localhost:8080>
```
