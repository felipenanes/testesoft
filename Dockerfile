FROM openjdk

WORKDIR /testesoft

ENV APP_NAME=testesoft-0.0.1-SNAPSHOT.jar

RUN mkdir /app

COPY target/${APP_NAME} /app/teste-soft-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/teste-soft-app.jar"]