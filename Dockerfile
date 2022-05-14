#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/runner/work/SpringAlarm/SpringAlarm/src
COPY pom.xml /home/runner/work/SpringAlarm/SpringAlarm/
RUN mvn -f /home/runner/work/SpringAlarm/SpringAlarm/pom.xml clean package


#
# Run phase
#
FROM openjdk:11-jre-slim
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]