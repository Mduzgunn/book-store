#FROM openjdk:17-oracle
#VOLUME /tmp
#ADD target/book-store-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/book-store-0.0.1-SNAPSHOT.jar app.jar
#COPY mysql/mysql-connector-java-8.0.28.jar mysql-connector-java.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
