FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/ticket.grahpql-0.0.1-SNAPSHOT.jar ticket-app.jar

EXPOSE 9001:9001


ENTRYPOINT ["java", "-jar", "ticket-app.jar"]