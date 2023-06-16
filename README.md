# Calculadora

## Descripción

Implementación de un microservicio que expone un API que debe ser capaz, a partir de 3 parámetros de entrada realizar operaciones aritméticas. Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad.

## Endpoint

### Realizar operación entre dos números

Endpoint: /calculator/num1/{num1}/num2/{num2}/operator/{operator}

Método: GET

Descripción: Devuelve el resultado de una operación entre dos números.

## Parámetros

### Realizar operación entre dos números

productId: (obligatorio) ID del producto del que se desean obtener los productos similares.

## Respuestas

### Realizar operación entre dos números

200 OK: Devuelve el resultado de la operación

404 Not Found: Si la operación no se puede realizar

500 Internal Server Error: Si hay un error interno en el servidor.

## Ejecución

Las librerías necesarias para realizar la ejecución se encuentran en /lib.
Es necesario añadir la librería externa al proyecto.

Comando Maven:
clean install

Ejecucion:
java -jar .\appws-calculadora-boot\target\appws-calculadora-boot-1.0.0.jar

### Pruebas

Para realizar pruebas basta con copiar estas URLs en el navegador o alguna aplicación como Postman para hacer
peticiones GET.

Correcto:

- http://localhost:8080/calculator/num1/1.0/num2/1.0/operator/+
- http://localhost:8080/calculator/num1/1.0/num2/1.0/operator/

Error:

- http://localhost:8080/calculator/num1/1.0/num2/1.0/operator/*

### Swagger
Se han documentado los endpoints con swagger.  

http://localhost:8080/swagger-ui/index.html#/