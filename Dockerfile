FROM maven:3-openjdk-8 AS builder
WORKDIR /build
ADD . .
RUN mvn package spring-boot:repackage

FROM openjdk:8-jdk-alpine AS mapas-con-voz
WORKDIR /app
COPY --from=builder /build/target/*.jar ./target/demo-0.0.1-SNAPSHOT.jar
COPY ./initScript.sh initScript.sh
EXPOSE 8080/tcp
ENTRYPOINT ["sh","initScript.sh"]
