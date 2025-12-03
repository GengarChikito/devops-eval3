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

```bash
# Compilar el proyecto y ejecutar pruebas
mvn clean package

# Construir la imagen Docker
docker build -t devops-eval3 .

# Ejecutar el contenedor mapeando el puerto 8080
docker run -p 8080:8080 devops-eval3