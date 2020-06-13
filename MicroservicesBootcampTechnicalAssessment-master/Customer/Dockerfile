FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/customer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} customer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customer-0.0.1-SNAPSHOT.jar"]