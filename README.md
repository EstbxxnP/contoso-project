DOCUMENTATION PROJECT IN SPRINGBOOT: CONTOSO-APP

Creation Date: 31/07/2024: 1:00AM
Author: Esteban Parrado
Mentor: Edier Sua


Introduction:

A continuación, se dará a conocer el seguimiento y procedimiento para la creación
del proyecto "contoso", diseñado principalmente como caso de estudio práctico para la
administración de compañías, departamentos y usuarios. Así mismo, se ejecutará a tráves
únicamente del uso Backend.


CREATE PROJECT:

Siguiendo las instrucciones de Spring Initializr, se genera un nuevo proyecto teniendo en cuenta
las siguientes características:

    -Project: Maven
    -Language: Java
    -Spring Boot: Versión estable(3.3.2)
    -Packaging: Jar
    -Java: Versión estable(22)



CREATING PACKAGES:

Inicialmente, en la ubicación raíz del proyecto, se procede a crear 3 carpetas donde son almacenados
los diferentes archivos para así asegurar una correcta utilización de la lógica, almacenamiento y acceso
a las diferentes entidades del proyecto. La creación de las carpetas anteriormente nombradas se reflejan y
resumen de la siguiente manera:

    -Models: Carpeta encargada de almacenar todos los archivos relacionados con la creación de las clases o "modelos"
             del proyecto en cuestión, seguido a ser utilizados para la lógica de negocio.

    -Services: Carpeta encargada de almacenar todos los archivos relacionados con la lógica de negocio y métodos
               para el proyecto en cuestión, siendo estos clave para el correcto funcionamiento de toda la administración
               funcionalidad y acciones del proyecto.

    -Controllers: Carpeta encargada de almacenar todos los archivos relacionados con la administración de acceso, rutas o
                  "endpoints a la lógica de negocio, de cara al cliente y sus solicitudes HTTP.



CLASSES / MODELS:

Primeramente, se trabaja en una lógica estructuración de las clases o "modelos" dentro de su
respectivo directorio, siendo así relacionadas y trabajadas en conjunto para un correcto funcionamiento
del proyecto.

Se encuentran las siguientes clases, en las cuales se puede hallar información de su
composición:

    -Class/Model Company
    -Class/Model Departament
    -Class/Model User



SERVICES:

Aquí, es generada toda la lógica de negocio correspondiente a cada modelo y/o requerimiento
para su correcto funcionamiento.


CONTROLLERS:

De cara al cliente, se generan todas las rutas correspondientes para el acceso a cada funcionalidad
del proyecto, relacionándose con los servicios y modelos.

EXECUTION;

Por último, se ejecuta a partir de una herramienta llamada "HttpClient", con la cual podemos
realizar todas las solicitudes correspondientes desde el mismo entorno de desarrollo. que en este caso,
es utilizado con IntellijIDEA.

8:53







