FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar discovery-service.jar
ENTRYPOINT ["java","-jar","discovery-service.jar"]