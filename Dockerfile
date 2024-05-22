FROM openjdk:17
WORKDIR /app
COPY target/ProductAPI-0.0.1-SNAPSHOT.jar app/ProductRestApi.jar
ENTRYPOINT ["java" ,"-jar", "app/ProductRestApi.jar"]