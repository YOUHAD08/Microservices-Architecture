FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar inventory-service.jar
ENTRYPOINT ["java","-jar","inventory-service.jar"]