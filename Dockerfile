FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ./target/swagger-spring-1.0.0.jar /build/swagger-spring-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/build/swagger-spring-1.0.0.jar"]
