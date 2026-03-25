# 📦 Cosas API

Microservicio REST para la gestión de cosas/objetos pertenecientes a personas. Forma parte de un sistema de dos microservicios que se comunican entre sí mediante Feign Client. Esta API gestiona la información de cosas almacenada en MariaDB y se comunica con la **API de Personas** para obtener el detalle del propietario de cada cosa.

---

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3
- Maven
- MariaDB
- Spring Data JPA / Hibernate
- OpenFeign
- Lombok
- Swagger / OpenAPI 3

---

## ✅ Prerequisitos

Asegúrate de tener instalado:

- Java 17 o superior
- Maven 3.x
- MariaDB (local)
- **API de Personas** corriendo en el puerto `8080`

---

## ⚙️ Configuración

### 1. Clona el repositorio

```bash
git clone https://github.com/tuUsuario/cosas-api.git
cd cosas-api
```

### 2. Crea la base de datos en MariaDB

```bash
mysql -u root -p
```

```sql
CREATE DATABASE cosas;
```

### 3. Configura `application.properties`

Copia el archivo de ejemplo y edítalo con tus datos:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Edita el archivo con tus datos:

```properties
spring.application.name=cosas-api
server.port=8081

spring.datasource.url=jdbc:mariadb://localhost:3306/cosas
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
```

### 4. Inicia MariaDB

```bash
systemctl start mariadb
```

---

## 🚀 Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8081`

> **Nota:** Las tablas se crean automáticamente al iniciar la aplicación gracias a `spring.jpa.hibernate.ddl-auto=update`.

---

## 📋 Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/cosas` | Obtener todas las cosas |
| GET | `/cosas/{id}` | Obtener una cosa por ID (incluye datos del propietario) |
| POST | `/cosas` | Crear una nueva cosa |
| PUT | `/cosas/{id}` | Actualizar una cosa existente |
| DELETE | `/cosas/{id}` | Eliminar una cosa |
| GET | `/personas/{idPersona}/cosas` | Obtener todas las cosas de una persona |

### Ejemplo de request — Crear cosa

```json
POST /cosas
{
  "tipo": "electronico",
  "nombre": "Laptop",
  "descripcion": "Laptop Dell XPS",
  "propietario": "64f1a2b3c4d5e6f7a8b9c0d1",
  "status": true
}
```

### Ejemplo de response — Obtener cosa por ID

```json
{
  "idCosa": 1,
  "tipo": "electronico",
  "nombre": "Laptop",
  "descripcion": "Laptop Dell XPS",
  "propietario": "64f1a2b3c4d5e6f7a8b9c0d1",
  "status": true,
  "personaDTO": {
    "idPersona": "64f1a2b3c4d5e6f7a8b9c0d1",
    "nombre": "Alberto",
    "apellidos": "Madero Venegas",
    "edad": 34,
    "genero": "Masculino",
    "status": true
  }
}
```

---

## 📖 Documentación Swagger

Con la aplicación corriendo, accede a:

```
http://localhost:8081/swagger-ui/index.html
```

---

## 🔗 Relación con API de Personas

Esta API se comunica con la **API de Personas** (`http://localhost:8080`) mediante Feign Client para obtener los datos del propietario al consultar `GET /cosas/{id}` y `GET /personas/{idPersona}/cosas`.

Asegúrate de que la API de Personas esté corriendo antes de usar estos endpoints.