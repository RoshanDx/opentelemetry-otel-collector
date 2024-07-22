FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/user-*.jar user.jar

EXPOSE 8081

CMD ["java", "-jar", "user.jar"]