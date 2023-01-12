FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=build/libs/book-market-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /web.jar
ENTRYPOINT ["java","-jar","/web.jar"]
