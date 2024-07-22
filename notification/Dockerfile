FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/notification-*.jar notification.jar

EXPOSE 8082

CMD ["java", "-jar", "notification.jar"]
