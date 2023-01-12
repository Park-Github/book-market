FROM eclipse-temurin:17-jdk-jammy
WORKDIR /book-market

COPY build.gradle ./build.gradle
COPY gradlew ./gradlew
COPY gradle ./gradle
COPY src ./src
RUN ./gradlew build

CMD ["./gradlew", "bootRun"]