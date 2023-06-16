# Calculadora

## Descripción

Implementación de un microservicio que expone una API que debe ser capaz, a partir de 3 parámetros de entrada realizar operaciones aritméticas. Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad.

## Endpoint

### Realizar operación entre dos números

Endpoint: /calculator/num1/{num1}/num2/{num2}/operator/{operator}

Método: GET

Descripción: Devuelve el resultado de una operación entre dos números.

## Parámetros

### Realizar operación entre dos números

num1: (obligatorio) Primer operando.

num2: (obligatorio) Segundo operando.

operator: (obligatorio) Operador.

## Respuestas

### Realizar operación entre dos números

200 OK: Devuelve el resultado de la operación

400 Bad Request: Operador desconocido

500 Internal Server Error: Si hay un error interno en el servidor.

## Ejecución

Las librerías externas necesarias para realizar la ejecución se encuentran en /lib.

Gestión de librerías con Maven y ejecución y compilación con Java 19.0.2

Comando Maven:
**-clean install**

Ejecución:
**java -jar .\calculadora-boot\target\calculadora-boot-1.0.0.jar**

### Pruebas

Para realizar pruebas basta con copiar estas URLs en el navegador o alguna aplicación como Postman para hacer
peticiones GET.

Correcto:

- http://localhost:8080/calculator/num1/1.0/num2/1.0/operator/+
- http://localhost:8080/calculator/num1/1.0/num2/1.0/operator/-

Error:

- http://localhost:8080/calculator/num1/1.0/num2/1.0/operator/*

### Swagger
Se han documentado los endpoints con swagger.  

http://localhost:8080/swagger-ui/index.html#/