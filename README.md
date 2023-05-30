
![](https://i.ibb.co/h8ydy5q/Captura-de-pantalla-2023-05-30-a-la-s-18-42-48.png)

# Mi Proyecto de Java Spring Boot

Este proyecto utiliza Java Spring Boot para implementar un CRUD (Crear, Leer, Actualizar, Eliminar) de tareas. Proporciona una API REST para gestionar tareas.

## Descripción del Código

El archivo `TaskController.java` contiene el controlador principal llamado `TaskController`. Aquí se definen los endpoints de la API para realizar operaciones CRUD en la entidad `Task`.

### Endpoints

- `POST /api/tasks`: Crea una nueva tarea. Se espera un objeto `Task` en el cuerpo de la solicitud. Si la validación del objeto falla, se devuelve un código de estado 400 (Bad Request). Si la tarea se crea correctamente, se devuelve un código de estado 200 (OK) junto con la tarea creada.

- `GET /api/tasks/{id}`: Obtiene una tarea por su ID. Se espera el ID de la tarea en la URL. Si se encuentra la tarea, se devuelve un código de estado 200 (OK) junto con la tarea. Si no se encuentra la tarea, se devuelve un código de estado 404 (Not Found).

- `GET /api/tasks`: Obtiene todas las tareas. Se devuelve un código de estado 200 (OK) junto con la lista de tareas.

- `PUT /api/tasks/{id}`: Actualiza una tarea existente. Se espera el ID de la tarea en la URL y un objeto `Task` actualizado en el cuerpo de la solicitud. Si la validación del objeto falla, se devuelve un código de estado 400 (Bad Request). Si la tarea se actualiza correctamente, se devuelve un código de estado 200 (OK) junto con la tarea actualizada.

- `DELETE /api/tasks/{id}`: Elimina una tarea por su ID. Se espera el ID de la tarea en la URL. Si se encuentra la tarea, se elimina y se devuelve un código de estado 204 (No Content). Si no se encuentra la tarea, se devuelve un código de estado 404 (Not Found).

## Base de Datos H2

Este proyecto utiliza la base de datos H2, que es una base de datos en memoria y ligera. Puedes acceder a la consola de administración de H2 a través de la URL [http://localhost:7070/h2-console](http://localhost:7070/h2-console) para explorar y administrar la base de datos.

## Prueba de la Aplicación

Puedes probar la aplicación utilizando las siguientes herramientas:

- **Postman**: Puedes realizar solicitudes HTTP a la API utilizando Postman. Configura la URL base como [http://localhost:7070](http://localhost:7070) y utiliza los endpoints mencionados anteriormente para probar las operaciones CRUD en las tareas, hay una carpeta que se llama postman donde existe un archivo a_Postman.postman_collection.json el cual puedes importar dentro de postman para poder realizar las pruebas. 

- **Swagger**: La aplicación también ofrece una interfaz de usuario de Swagger para probar y explorar la API de manera interactiva. Puedes acceder a la interfaz de Swagger a través de la URL [http://localhost:7070/swagger-ui/index.html](http://localhost:7070/swagger-ui/index.html). Aquí encontrarás una descripción detallada de los endpoints disponibles y podrás enviar solicitudes directamente desde la interfaz.


