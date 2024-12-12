# 📚 PracticaJavaEJB-Swing

Este proyecto es un ejemplo de una aplicación cliente-servidor utilizando Maven, WildFly y Java Swing. La aplicación permite registrar y obtener estudiantes a través de una interfaz gráfica y se comunica con el servidor utilizando HTTP.

## 📂 Estructura del Proyecto

### Servidor

El servidor está implementado utilizando Jakarta EE y se despliega en WildFly usando localhost.


### Cliente

El cliente está implementado utilizando Java Swing y se comunica con el servidor a través de HTTP.


## 🚀 Despliegue

### Servidor

1. Inicia WildFly desde la carpeta `servers`.
2. En la terminal del servidor, ejecuta el siguiente comando para compilar y desplegar la aplicación:

```sh
mvn clean install wildfly:deploy
```

3. Con esto, puedes hacer solicitudes POST y GET usando Postman.

### Cliente

1. En la terminal del cliente, ejecuta el siguiente comando para iniciar la aplicación Swing:

```sh
mvn exec:java -Dexec.mainClass="com.cliente.ui.ClienteSwing"
```

2. Esto abrirá una ventana Java hecha con Swing y podrás agregar datos a la base de datos de WildFly.

