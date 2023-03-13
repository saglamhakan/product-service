FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FİLE=target/*.jar

WORKDIR /opt/app

COPY ${JAR_FİLE} app.jar

ENTRYPOİNT ["java", "-jar", "app.jar"]