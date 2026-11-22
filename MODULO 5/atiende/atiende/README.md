# Atiende

## Qué es el proyecto

Atiende es una API REST para centralizar como tickets los mensajes recibidos por Grano Alto Café. En esta primera fase permite registrar y consultar tickets, filtrarlos por estado y cambiar su estado según las transiciones permitidas. Los canales se simulan mediante peticiones HTTP; no hay conexión real con WhatsApp ni correo.

Los tickets nuevos reciben automáticamente el estado `ABIERTO` y la prioridad `MEDIA`. El cliente proporciona el nombre, contacto, canal y mensaje.

## Requisitos

- Java 25.
- MySQL disponible en `localhost:3306`, con credenciales configuradas para la aplicación.
- El proyecto incluye Maven Wrapper (`mvnw`).

La configuración de base de datos está en `src/main/resources/application.properties`. La URL apunta a `atiende_db` y está configurada para crear esa base de datos si no existe.

## Cómo ejecutar

Desde la carpeta del proyecto, inicia la aplicación con Maven Wrapper:

```shell
# Windows
.\mvnw.cmd spring-boot:run

# Linux o macOS
./mvnw spring-boot:run
```

La API tiene como ruta base `/api/tickets`.

## Endpoints

| Método | Ruta | Descripción | Respuestas |
|---|---|---|---|
| `POST` | `/api/tickets` | Crea un ticket. | `201` creado; `400` datos inválidos. |
| `GET` | `/api/tickets?estado={estado}` | Lista tickets; el filtro `estado` es opcional y la lista se ordena de más recientes a más antiguos. | `200` lista. |
| `GET` | `/api/tickets/{id}` | Busca un ticket por su identificador. | `200` encontrado; `404` inexistente. |
| `PATCH` | `/api/tickets/{id}/estado` | Cambia el estado del ticket. | `200` actualizado; `400` petición inválida; `404` inexistente; `409` transición no permitida. |

Los canales válidos son `WHATSAPP`, `CORREO` y `CHAT_WEB`. Los estados son `ABIERTO`, `EN_PROCESO`, `RESUELTO` y `CERRADO`.

### Crear un ticket

```shell
curl -X POST http://localhost:8080/api/tickets -H "Content-Type: application/json" -d '{"clienteNombre":"Ana Pérez","clienteContacto":"ana@example.com","canal":"CORREO","mensaje":"Necesito ayuda con mi pedido"}'
```

### Cambiar el estado de un ticket

Reemplaza `1` por el identificador de un ticket existente que esté en `ABIERTO`.

```shell
curl -X PATCH http://localhost:8080/api/tickets/1/estado -H "Content-Type: application/json" -d '{"estado":"EN_PROCESO"}'
```

## Transiciones de estado

| Estado actual | Estado nuevo permitido |
|---|---|
| `ABIERTO` | `EN_PROCESO`, `CERRADO` |
| `EN_PROCESO` | `RESUELTO` |
| `RESUELTO` | `CERRADO`, `EN_PROCESO` |
| `CERRADO` | Ninguno; es un estado final. |

Cualquier otra transición se rechaza.

## Formato de error

Las respuestas de error tienen estos campos:

```json
{
  "codigo": "TRANSICION_NO_PERMITIDA",
  "error": "Transición no permitida",
  "mensaje": "No se puede cambiar el estado de ABIERTO a RESUELTO",
  "fecha": "2026-11-21T21:20:00"
}
```

## Tests

Ejecuta todos los tests desde la carpeta del proyecto:

```shell
# Windows
.\mvnw.cmd test

# Linux o macOS
./mvnw test
```

Para ejecutar solo los tests unitarios del enum y del servicio:

```shell
# Windows
.\mvnw.cmd -Dtest=EstadoTicketTest,TicketServicioTest test

# Linux o macOS
./mvnw -Dtest=EstadoTicketTest,TicketServicioTest test
```

Estos dos tests no levantan Spring. La suite completa también incluye un test de contexto (`@SpringBootTest`), por lo que requiere que la base de datos configurada esté disponible.
