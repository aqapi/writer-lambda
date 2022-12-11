# package
FROM gradle:jdk17-alpine AS build
WORKDIR /usr/app/
COPY build.gradle ./
# COPY gradle gradle
COPY src src
RUN gradle clean build
RUN ls build/**

# app
FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY --from=build /usr/app/build/libs/writer-lambda.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
