# NISUM TEST

Este proyecto ejemplifica el uso de la arquitectura hexagonal con Spring Boot, MapStruct, H2 Database en memoria y JWT para autenticación de tokens. Además, el proyecto incorpora excepciones personalizadas para manejar distintos casos.

## Requisitos

- Java 11
- Maven

## Ejecución

1. Clona este repositorio en tu máquina local:

git clone https://github.com/ezedev/nisum.git


2. Navega a la carpeta del proyecto:

    cd nisum
3. Ejecuta un mvn clean compile

3. Ejecuta la aplicación Spring Boot:

    mvn spring-boot:run o ejecuta la clase MAIN

    La aplicación se ejecutará en http://localhost:8080.

4. Abre tu navegador web y visita la URL http://localhost:8080/swagger-ui.html para acceder a la documentación de la API a través de Swagger.

## Características

- **Arquitectura Hexagonal:** El proyecto sigue una estructura de arquitectura hexagonal para separar responsabilidades y promover diseño modular.

- **MapStruct:** Se utiliza MapStruct para mapear automáticamente objetos DTO a entidades y viceversa.

- **H2 Database:** Se emplea H2 Database en memoria para almacenamiento de datos durante el desarrollo.

- **JWT Token:** Implementación de autenticación y autorización mediante tokens JWT para proteger endpoints.

- **Excepciones Personalizadas:** El proyecto maneja distintos casos de excepciones mediante excepciones personalizadas para mejor legibilidad y manejo de errores.

## Estructura del Proyecto

- `src/main/java/com/nisum/demo`: Contiene el código fuente de la aplicación.

- `src/main/resources`: Contiene archivos de configuración y propiedades.

- `src/test/java/com/nisum/demo`: Contiene pruebas unitarias.

## Observaciones

No se optó por utilizar las anotaciones `@Valid` o `@Validated` en este proyecto con el fin de demostrar la capacidad de implementar validaciones personalizadas. En un contexto real, se recomienda utilizar las validaciones estándar cuando sea necesario.

## Objetivo

El objetivo principal de este proyecto es demostrar mi experiencia y conocimientos en el desarrollo de aplicaciones utilizando tecnologías modernas y buenas prácticas. Este proyecto también está dirigido a los responsables del proceso de selección y evaluación, con el propósito de mostrar cómo puedo contribuir al equipo y brindar soluciones efectivas.

## CURL
Si deseas crear un usuario utilizando cURL, aquí tienes un ejemplo del comando:

```shell
curl --location --request POST 'localhost:8080/nisum/user' \
--header 'Content-Type: application/json' \
--data-raw '{
 "name": "John Doe",
 "email": "johndoe@example.com",
 "password": "Abc12345",
 "phones": [
     {
         "number": "123456789",
         "cityCode": "123",
         "countryCode": "+1"
     },
     {
         "number": "987654321",
         "cityCode": "456",
         "countryCode": "+1"
     }
 ]
}'


---
