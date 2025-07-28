# Sistema de Control de Empleados – Backend

Este es el backend del sistema de gestión de empleados, desarrollado en **Spring Boot** y conectado a PostgreSQL (Railway).

---

## 🚀 Despliegue

- **API Backend:**  
  [https://control-empleados-backend.onrender.com](https://control-empleados-backend.onrender.com)

- **Frontend asociado:**  
  [https://control-empleados-frontend.vercel.app](https://control-empleados-frontend.vercel.app)

---

## 📦 Instalación local

1. **Clonar repositorio:**
   ```sh
   git clone https://github.com/xavcue/control-empleados-backend.git
   cd control-empleados-backend
Configura tu base de datos en src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://[HOST]:[PORT]/[DB]
spring.datasource.username=[USER]
spring.datasource.password=[PASSWORD]

Construir y correr el proyecto:

./mvnw clean package
java -jar target/backend-oficina-0.0.1-SNAPSHOT.jar

O con Docker:

docker build -t backend-empleados .
docker run -p 8080:8080 backend-empleados

📊 Monitoreo y métricas
https://control-empleados-backend.onrender.com/actuator/health
https://control-empleados-backend.onrender.com/actuator/metrics
https://control-empleados-backend.onrender.com/actuator/metrics/http.server.requests

Capturas de monitoreo:
<img width="796" height="269" alt="image" src="https://github.com/user-attachments/assets/f69928f2-96d7-48b0-af26-449d86e6dcd9" />
<img width="1304" height="974" alt="image" src="https://github.com/user-attachments/assets/08706ddc-7444-4a4e-b465-30a22a685ff9" />
<img width="843" height="960" alt="image" src="https://github.com/user-attachments/assets/f0eb996d-d19f-4498-92cf-32da87704455" />
