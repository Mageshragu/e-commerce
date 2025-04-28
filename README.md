# e-commerce
# Spring Boot Microservices Project
(Eureka Server, API Gateway, Client Feign, Product Service, Order Service)

# About the project

<ul style="list-style-type:disc">
  <li>This project is based Spring Boot Microservices</li>
  <li>User can modify products and place orders through api gateway</li>
  <li>User can send any request to relevant service through api gateway</li>
</ul>

4 services whose name are shown below have been devised within the scope of this project.

- Eureka Server
- API Gateway
- Product Service
- Order Service

### Used Dependencies

* Core
    * Spring
        * Spring Boot
        * Spring Web
            * FeignClient
        * Spring Data
            * Spring Data JPA
            * PostgreSQL
        * Spring Cloud
            * Spring Cloud Gateway Server
            * Spring Cloud Config Server
            * Spring Cloud Config Client
    * Netflix
        * Eureka Server
        * Eureka Client
* Database
    * PostgreSQL

### 🔨 Run the App

<b>Local</b>

<b>1 )</b> Clone project `git clone https://github.com/devsyx/spring-boot-microservices.git`

<b>2 )</b> Go to the project's home directory :  `cd spring-boot-microservices`

<b>3 )</b> Run <b>Eureka Server</b>

<b>4 )</b> Run <b>Gateway</b>

<b>5 )</b> Run <b>Config Server</b>

<b>6 )</b> Run other services (<b>product-service</b>, <b>order-service</b>)

