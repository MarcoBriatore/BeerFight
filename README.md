# :beer: BeerFight :beer:

## Maven
>Maven es una herramienta de gestión de proyectos. Se basa en un fichero central, pom.xml, donde se define todo lo que necesita tu proyecto. Maven maneja las dependencias del proyecto, compila, empaqueta y ejecuta los test. Mediante plugins, permite hacer mucho mas, como por ejemplo generar los mapas de Hibernate a partir de una base de datos.

## POM
 >Un modelo de objeto de proyecto o POM es la unidad fundamental de trabajo en Maven. Es un archivo XML que contiene información sobre el proyecto y los detalles de configuración utilizados por Maven para construir el proyecto. Contiene valores por defecto para la mayoría de los proyectos. Ejemplos de esto es el directorio de compilación, que es target; el directorio fuente, que es src / main / java; el directorio fuente de prueba, que es src / test / java; y así. Al ejecutar una tarea o un objetivo, Maven busca el POM en el directorio actual. Lee el POM, obtiene la información de configuración necesaria y luego ejecuta el objetivo.

 Algunas de las configuraciones que se pueden especificar en el POM son las dependencias del proyecto, los complementos u objetivos que se pueden ejecutar, los perfiles de compilación. También se puede especificar otra información, como la versión del proyecto, descripción, desarrolladores, listas de correo y similares.

##  ArtifactId y Archetype

*Un arquetipo(Archetype) es un patrón o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo. 
Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías que los desarrolladores utilizan como base para escribir y organizar el código de la aplicación.*

*ID Artefacto (ArtifactId) es el nombre del jar sin versión,cada artefacto tiene una ID de grupo, una ID de artefacto (solo un nombre) y una cadena de versión. Los tres juntos identifican de forma única el artefacto(Artifact)._(Si se trata de un jar de un tercero, debe tomar el nombre del jar tal como se distribuye)_.*




## Goals
### Goal es un comando que recibe maven como parámetro para que ejecutar determinada accion.

    - mvn clean: Eliminar todos los archivos generados por la compilación anterior.
    - mvn compile: Compila el código fuente del proyecto.
    - mvn package: Toma el código compilado y lo empaqueta en su formato distribuible, como un JAR.
    - mvn install: Instala el paquete en el repositorio local, para usarlo como una dependencia en otros proyectos a nivel local.

## Scopes
### El scope sirve para indicar el alcance de nuestra dependencia y su transitividad:

- Compile: es la que tenemos por defecto sino especificamos scope. Indica que la dependencia es necesaria para compilar. La dependencia además se propaga en los proyectos dependientes.

- Provided: Es como la anterior, pero esperas que el contenedor ya tenga esa libreria. Un claro ejemplo es cuando desplegamos en un servidor de aplicaciones, que por defecto, tiene bastantes librerías que utilizaremos en el proyecto, así que no necesitamos desplegar la dependencia.

- Runtime: La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar.

- Test: La dependencia es solo para testing que es una de las fases de compilación con maven. JUnit es un claro ejemplo de esto.

- System: Es como provided pero tienes que incluir la dependencia explicitamente. Maven no buscará este artefacto en tu repositorio local. Habrá que especificar la ruta de la dependencia mediante la etiqueta <systemPath>
