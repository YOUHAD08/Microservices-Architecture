FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar config-service.jar
ENTRYPOINT ["java","-jar","config-service.jar"]