### LiterAlura - Catálogo de Libros

---

#### **Descripción del Proyecto**
LiterAlura es un emocionante desafío de programación en Java que te invita a desarrollar un catálogo interactivo de libros. A través de este proyecto, aprenderás a:
- Realizar solicitudes a una API de libros.
- Manipular datos en formato JSON.
- Guardar la información en una base de datos.
- Filtrar y mostrar libros y autores de interés de forma interactiva.

#### **Objetivo del Proyecto**
El objetivo es construir un Catálogo de Libros que permita interacción textual con los usuarios (vía consola) y ofrezca al menos 5 opciones de interacción. Los libros serán obtenidos a través de una API específica y los usuarios podrán realizar búsquedas, consultar detalles, y más.

---

#### **Características Clave**
1. **Interacción vía consola:** 
   - Al menos 5 opciones para que el usuario explore el catálogo de libros.
2. **Consumo de API:** 
   - Solicitud de datos a una API específica de libros.
3. **Gestión de datos:** 
   - Análisis de las respuestas en formato JSON.
   - Almacenamiento de datos en una base de datos local.
4. **Exhibición de resultados:**
   - Filtrado y presentación de datos relevantes para el usuario.

---

#### **Requisitos Técnicos**
- **Lenguaje:** Java.
- **Entorno de desarrollo:** Configuración de un entorno Java adecuado (e.g., IntelliJ IDEA, Eclipse o VS Code con extensiones).
- **Base de datos:** Uso de una base de datos para almacenar y consultar información (puede ser SQLite, MySQL, etc.).
- **Gestión de tareas:** Uso de Trello para organizar y monitorear el progreso de las actividades.

---

#### **Flujo de Desarrollo Ágil con Trello**
El sistema ágil de desarrollo será implementado a través de Trello con las siguientes columnas:
- **Listo para iniciar:** Tareas pendientes de desarrollo.
- **En desarrollo:** Tareas en progreso (mueve aquí la tarjeta al iniciar una tarea).
- **Pausado:** Tareas en pausa por cualquier motivo.
- **Concluido:** Tareas finalizadas.

> Nota: Trello es una herramienta de uso individual y no será evaluada como parte del proyecto, pero es útil para controlar tu progreso.

---

#### **Pasos para Desarrollar el Proyecto**
1. **Configuración del Ambiente Java:**
   - Configura tu entorno de desarrollo con las dependencias necesarias.
2. **Creación del Proyecto:**
   - Establece la estructura inicial del proyecto.
3. **Consumo de la API:**
   - Conecta y realiza solicitudes a la API de libros.
4. **Análisis de Respuesta JSON:**
   - Procesa los datos recibidos y extrae información relevante.
5. **Inserción y Consulta en Base de Datos:**
   - Guarda los datos obtenidos y realiza consultas para la interacción del usuario.
6. **Exhibición de Resultados:**
   - Desarrolla funcionalidades para mostrar libros y autores según los intereses del usuario.

---

#### **Implementaciones Clave**
El proyecto incluye las siguientes funciones para la búsqueda e inserción de datos en la base de datos:

```java
private DatosLibro getDatosLibro() {
    System.out.println("Ingresa el nombre del libro que deseas buscar");
    var nombreLibro = teclado.nextLine();
    var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));
    System.out.println(json);
    DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
    return datos;
}

private void buscarLibro() {
    DatosLibro datos = getDatosLibro();
    Libro libro = new Libro(datos);
    repositorio.save(libro);
    // datosSerie.add(datos);
    System.out.println(datos);
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(datos.idiomas());
}
```

Estas funciones permiten:
1. Solicitar al usuario el nombre de un libro.
2. Consumir la API para obtener información del libro en formato JSON.
3. Convertir los datos JSON a un objeto `DatosLibro`.
4. Guardar los datos del libro en la base de datos local y mostrar detalles al usuario.

---

#### **Herramientas y Recursos**
- **Lenguaje:** Java.
- **API de Libros:** Información específica será proporcionada en el backlog.
- **Base de datos:** A definir (recomendado: SQLite o MySQL).
- **Trello:** Para organización de tareas.

---

¡Sumérgete en este proyecto práctico y emocionante para fortalecer tus habilidades en desarrollo con Java! 🚀
