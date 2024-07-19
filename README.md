# MS-BANK-ACCOUNT

El proyecto **MS-BANK-ACCOUNT fue creado con la finalidad de que el usuario pueda gestionar sus cuentas bancarias del proyecto  **NTT DATA**, usando como ayuda los proyectos `spring-boot, spring-config-client, spring-data, cuircuit-breaker y swagger`.

# Requisitos

* java version 14
* maven 3.6.3
* docker
* docker-compose

# Parametros de configuración

***aplication.properties***

* spring.application.name=xxxxxxxx
* server.port=XXXX
* server.servlet.context-path=/xxxxx/xxxx/xxxx

***bootstrap.application***

* spring.application.name=***nombre del properties centralizado***
* spring.profiles.active=***perfil***
* spring.cloud.config.uri=***url de el ms-parameter***

# Como levantar el contendor

Para ello necesitamos saber los siguientes puntos:

- Tener instalado Docker
- Tener instalado Docker Compose
- Path donde se encuentra el jar
- Nombre del jar
- Path donde se encuentra el archivo de conf `application.properties y bootstrap.properties`, (copiar el contenido del application.properties, del directorio src/main/resources/)

Dentro de la raíz del proyecto existe un archivo sin extencion con el nombre `Dockerfile` y un archivo YAML con el nombre `docker-compose.yml`, el cual esta detallado las configuraciones necesarias para que se levante el servicio de contenedor.

Ejecutamos cualquier de los siguientes comando en cada escenario:

- Se crea el conetenedor por primera vez se ejecuta el siguiente comando `docker-compose up`
- Se actualiza el jar del contenedor se ejecuta el siguiente comando `docker-compose up --build`
- Se desea recrear el contenedor se ejecuta el sisguiente comando `docker-compose up --force-recreate`

Luego de esto el contenedor estara iniciado.

# Swagger

***URL***

```
http://<IP-SERVER>:<PORT>/api/ms-comp-bank-account/core/v1.0/swagger-ui.html
```

```

```
