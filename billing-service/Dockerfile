FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar billing-service.jar
ENTRYPOINT ["java","-jar","billing-service.jar"]