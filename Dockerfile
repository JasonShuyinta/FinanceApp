FROM eclipse-temurin:17-jdk-focal
RUN mkdir -p /app
WORKDIR /app
COPY src/main/resources/application.yml /app/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/budget-finance.jar
CMD ["java", "-jar", "budget-finance.jar"]
