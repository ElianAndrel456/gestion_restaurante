# Dev Container - Gestión de Restaurante

Este dev container está configurado para el desarrollo del proyecto Spring Boot de Gestión de Restaurante.

## 🚀 Características

- **Java 21** con herramientas de desarrollo
- **Spring Boot 3.5.3** con dependencias configuradas
- **MySQL 8.0** como base de datos
- **Maven** para gestión de dependencias
- **VS Code Extensions** preinstaladas para Java/Spring Boot
- **Hot Reload** habilitado para desarrollo ágil

## 📋 Prerequisitos

- Docker Desktop instalado y ejecutando
- VS Code con la extensión "Dev Containers" instalada

## 🛠️ Cómo usar

1. **Abrir en Dev Container:**
   - Abre VS Code en la carpeta del proyecto
   - Presiona `Ctrl+Shift+P` y selecciona "Dev Containers: Reopen in Container"
   - O haz clic en la notificación que aparece para reabrir en container

2. **Esperar la construcción:**
   - La primera vez tomará unos minutos mientras se descargan las imágenes
   - Se instalarán automáticamente las extensiones de VS Code
   - Se ejecutará `mvnw clean compile` automáticamente

3. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acceder a la aplicación:**
   - Aplicación: http://localhost:8080/api
   - Base de datos MySQL: localhost:3306

## 🗄️ Base de Datos

### Configuración MySQL
- **Host:** mysql (dentro del container) / localhost (desde el host)
- **Puerto:** 3306
- **Base de datos:** gestion_restaurante
- **Usuario:** root
- **Contraseña:** password
- **Usuario adicional:** restaurante_user / restaurante_pass

### Datos de prueba
El contenedor incluye datos de ejemplo:
- Categorías (Entradas, Platos Principales, Postres, Bebidas)
- Productos de ejemplo
- Mesas del restaurante

### Conectar desde cliente externo
```bash
mysql -h localhost -P 3306 -u root -p
# Contraseña: password
```

## 🔧 Comandos útiles

### Maven
```bash
# Compilar el proyecto
./mvnw clean compile

# Ejecutar tests
./mvnw test

# Ejecutar la aplicación
./mvnw spring-boot:run

# Empaquetar
./mvnw clean package
```

### Docker Compose (desde .devcontainer/)
```bash
# Ver logs de la aplicación
docker-compose logs app

# Ver logs de MySQL
docker-compose logs mysql

# Reiniciar servicios
docker-compose restart

# Limpiar y reconstruir
docker-compose down -v
docker-compose up --build
```

## 📁 Estructura del Dev Container

```
.devcontainer/
├── devcontainer.json      # Configuración principal del dev container
├── docker-compose.yml     # Servicios (app + MySQL)
├── Dockerfile            # Imagen personalizada para desarrollo
├── maven-settings.xml    # Configuración de Maven
└── init-scripts/         # Scripts de inicialización de BD
    └── 01-init.sql       # Tablas y datos de ejemplo
```

## 🔍 Extensiones incluidas

- Java Extension Pack
- Spring Boot Extension Pack
- REST Client
- Lombok Support
- Maven for Java
- Auto Rename Tag

## 🐛 Troubleshooting

### La aplicación no se conecta a MySQL
1. Verifica que el servicio MySQL esté corriendo:
   ```bash
   docker-compose ps
   ```

2. Verifica los logs de MySQL:
   ```bash
   docker-compose logs mysql
   ```

### Puerto 8080 ocupado
- El dev container mapea automáticamente el puerto 8080
- Si hay conflictos, cambia el puerto en `application.properties`

### Problemas con Maven dependencies
1. Limpia el caché de Maven:
   ```bash
   ./mvnw clean
   rm -rf ~/.m2/repository
   ./mvnw compile
   ```

## 📝 Configuración de desarrollo

### Profiles disponibles
- **dev** (por defecto): Configuración para desarrollo con base de datos local
- Puedes crear profiles adicionales en `application-{profile}.properties`

### Hot Reload
- Los cambios en el código se recargan automáticamente
- Spring DevTools está habilitado
- Para recargar cambios en configuración, reinicia la aplicación

## 🚀 Próximos pasos

1. Implementar las entidades JPA basadas en las tablas creadas
2. Crear los repositorios Spring Data JPA
3. Desarrollar los servicios de negocio
4. Implementar los controladores REST
5. Agregar validaciones y manejo de errores
6. Implementar pruebas unitarias e integración

## 📞 Soporte

Si encuentras problemas con el dev container, verifica:
1. Docker Desktop está ejecutándose
2. Tienes suficiente memoria disponible (al menos 4GB recomendado)
3. No hay conflictos de puertos (3306, 8080)
4. Las extensiones de VS Code están instaladas correctamente
