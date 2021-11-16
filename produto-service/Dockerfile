FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
VOLUME /tmp
ARG JAR_FILE=target/produto-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
