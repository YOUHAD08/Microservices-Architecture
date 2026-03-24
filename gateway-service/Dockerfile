FROM eclipse-temurin:21-jre
VOLUME /tmp
COPY target/*.jar gateway-service.jar
ENTRYPOINT ["java","-jar","gateway-service.jar"]