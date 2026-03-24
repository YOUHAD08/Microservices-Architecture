FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar customer-service.jar
ENTRYPOINT ["java","-jar","customer-service.jar"]