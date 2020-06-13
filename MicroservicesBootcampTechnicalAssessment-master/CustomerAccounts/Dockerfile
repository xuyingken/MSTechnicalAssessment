FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8090
ARG JAR_FILE=target/customerAccounts-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} customerAccounts-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customerAccounts-0.0.1-SNAPSHOT.jar"]