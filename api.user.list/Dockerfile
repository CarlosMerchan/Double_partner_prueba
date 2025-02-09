FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./target/api.user.list-0.0.1-SNAPSHOT.jar user-list.jar

EXPOSE 9001:9001


ENTRYPOINT ["java", "-jar", "user-list.jar"]