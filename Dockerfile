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
COPY --from=build /home/runner/work/SpringAlarm/SpringAlarm/target/*.jar /usr/local/lib/alarm.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/alarm.jar"]