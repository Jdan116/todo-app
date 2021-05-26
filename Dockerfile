FROM openjdk:11
ADD target/todos-0.0.1-SNAPSHOT.jar todos-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "todos-0.0.1-SNAPSHOT.jar"]