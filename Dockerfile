FROM openjdk:8
ADD target/bookstore-api.jar bookstore-api.jar
ENTRYPOINT ["java", "-jar", "bookstore-api.jar"]