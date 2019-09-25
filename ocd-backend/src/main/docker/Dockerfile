FROM openjdk:8-alpine
MAINTAINER OCD
RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV API_OCD /opt/app
COPY ./target/api-ocd-cadastros-1.0.0-SNAPSHOT.jar $API_OCD
WORKDIR  $API_OCD
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod","ocd-api-1.0.0-SNAPSHOT.jar"]