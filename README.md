# Evaluación Parcial 3: Observabilidad y Entornos Reales en DevOps

Este proyecto consiste en la implementación de un microservicio basado en **Java (Spring Boot)**, desplegado en un entorno productivo simulado en **AWS EC2** mediante contenedores **Docker**. El sistema incorpora una estrategia completa de observabilidad con **AWS CloudWatch** y un pipeline CI/CD robusto para garantizar la calidad y el cumplimiento normativo.

## 📋 Integrantes
* **Nombre:** Mathias Cortes Manriquez
* **Asignatura:** Ingeniería DevOps (DOY0101)

---

## 🚀 Arquitectura y Tecnologías (IE2)
El proyecto utiliza una arquitectura de microservicios contenerizados sobre infraestructura en la nube, orquestada automáticamente:

* **Lenguaje:** Java 17 (Eclipse Temurin).
* **Framework:** Spring Boot 3.2.3.
* **Contenerización:** Docker.
* **Orquestación y CI/CD:** GitHub Actions.
* **Infraestructura Cloud:** AWS EC2 (Instancia t2.micro).
* **Observabilidad:** Micrometer + AWS CloudWatch Agent (CWAgent).

---

## 🛠️ Instrucciones de Despliegue y Ejecución

### 1. Ejecución Local (Pruebas Manuales)
Para levantar el proyecto en un entorno local con Docker:
2. Despliegue Automatizado (CI/CD)
La orquestación del despliegue se realiza automáticamente mediante GitHub Actions al detectar cambios en la rama master:

Build & Test: Se compila el código y se ejecutan las pruebas unitarias (mvn verify). Si alguna prueba falla, el pipeline se detiene automáticamente (Cumplimiento IE6).

Docker Push: Se construye la imagen y se sube al registro Docker Hub.

Deploy to AWS: El pipeline se conecta vía SSH a la instancia EC2, descarga la nueva imagen y reinicia el contenedor de forma transparente, garantizando la continuidad del servicio.

📡 Endpoints del Servicio
El microservicio se encuentra operativo y expuesto públicamente en:

Health Check (Estado del Servicio):

URL: http://54.87.44.95

Respuesta: Mensaje de confirmación "Microservicio Operativo v1.0".

Prueba de Alertas (Simulación de Fallos):

URL: http://54.87.44.95/error-test

Función: Genera una excepción controlada para verificar que los logs de error son capturados por CloudWatch y visualizados en el Dashboard, probando la trazabilidad del sistema.

📊 Estrategia de Observabilidad (IE1, IE3)
Se implementó un monitoreo integral utilizando el agente CWAgent y librerías Micrometer para capturar métricas de infraestructura y aplicación.

Dashboard en AWS CloudWatch: Evaluacion3_DevOps
El tablero de control (evidenciado en la entrega) consolida las siguientes métricas clave para la toma de decisiones técnicas:

Uso de Memoria (RAM): Monitoreo mediante métrica mem_used_percent (vía CWAgent).

Uso de CPU: Monitoreo de carga del procesador mediante métrica cpu_usage_active.

Tráfico de Red: Visualización de entrada/salida de datos (net_bytes_recv y net_bytes_sent).

Detección de Errores: Trazabilidad de logs de fallos críticos y disponibilidad del servicio.

🛡️ Políticas de Cumplimiento y Calidad (IE5, IE6)
Para asegurar la estabilidad del entorno productivo según la normativa del proyecto:

Branch Protection: La rama master está protegida, impidiendo merges directos sin validación previa.

Quality Gate Automatizado: El pipeline actúa como barrera de calidad; ante cualquier fallo en los tests unitarios o vulnerabilidad detectada en la fase de compilación, el proceso de despliegue se aborta inmediatamente, protegiendo la integridad del entorno en AWS.
```bash
# Compilar el proyecto y ejecutar pruebas
mvn clean package

# Construir la imagen Docker
docker build -t devops-eval3 .

# Ejecutar el contenedor mapeando el puerto 8080
docker run -p 8080:8080 devops-eval3
