FROM maven:3.8.6-jdk-11-slim
EXPOSE 8080
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
COPY . .
RUN mvn package
ENTRYPOINT ["java","-jar","target/Test-0.0.1-SNAPSHOT.jar"]