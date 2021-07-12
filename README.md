# Automatización de pruebas Travelocity

## Descripción y Contexto
Este proyecto es el desarrollo a la prueba técnica para el rol de ingeniero de calidad en Devco.
El proyecto cuenta con 5 pruebas automatizadas y 15 manuales sobre los módulos de vuelos y hospedaje de la página Travelocity.

##Prácticas de Automatización

###Detalles Generales de la Implementación

* ####Gherkin
  Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje comprensible por humanos y por ordenadores, con él vamos a definir el comportamiento de la página que vamos a automatizar.

* ####Cucumber
  Se utiliza cucumber como herramienta para automatizar las pruebas en BDD. Cucumber nos va a permitir ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas. Totalmente compatible con el lenguaje Gherkin.

* #### Estructura del proyecto
  La estructura completa del proyecto es la siguiente:

    * **Exceptions**: Clases en las cuales manejamos los diferentes errores que pueden surgir en las tasks.
    * **Interactions**: Clases que representan pequeñas interacciones que realiza el actor con la aplicación.
    * **Questions**: Clases con las cuales se realizan las validaciones de las pruebas.
    * **Tasks**: Clases que representan tareas que realiza el actor a nivel de proceso de negocio.
    * **User Interfaces**: Page Objects. Mapean los objetos de la interfaz de usuario
    * **Utils**: Clases que nos ayudan con la ejecución de la prueba y que se comparten en más de un paquete.
    * **Runners**: Clases con las que indicamos las propiedades que tendrá la prueba (feature, stepdefinitions, tags)
    * **Step Definitions**: Clases en las que configuramos los pasos a realizar durante la prueba.
    * **Features**: Aquí se encuentran los archivos en los que están definidos los escenarios de prueba en lenguaje Gherkin
    
### Requerimientos

Para correr el proyecto se necesita Java JDK 1.8 y Gradle preferiblemente con la versión 5.6.4.

## Build and test
Para correr el proyecto y generar el reporte de las pruebas nos movemos a la carpeta Travelocity y utilizamos el comando

    gradlew clean test aggregate

Si se requiere ejecutar cada runner por separado se utilizarían los comandos:

    gradlew clean test --tests "co.com.devco.certification.runners.TraveloCityBookingsRunner" aggregate

o

    gradlew clean test --tests "co.com.devco.certification.runners.TraveloCityManualRunner" aggregate

El reporte de ejecución de las pruebas se almacena en la carpeta `/target/site/serenity/`
