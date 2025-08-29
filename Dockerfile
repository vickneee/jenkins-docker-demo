# ---- Build stage ----
# Dockerfile should use the official Maven image
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set metadata information
LABEL authors="victoriavavulina"

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml /app/

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the entire project to the container
COPY . /app/

# Package your application
RUN mvn package -DskipTests

# ---- Run stage ----
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the packaged application from the build stage
COPY --from=build /app/target/jenkins-docker-demo.jar .

# Run the main class (assuming your application has a main class)
CMD ["java", "-jar", "jenkins-docker-demo.jar"]