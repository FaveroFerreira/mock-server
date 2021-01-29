FROM gradle:6.8.1-jdk11 AS GRADLE_BUILD

COPY build.gradle settings.gradle /workspace/
COPY src /workspace/src/

WORKDIR /workspace/

RUN gradle build

FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine

WORKDIR /app

COPY --from=GRADLE_BUILD /workspace/build/libs/mock-server*.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "mock-server-1.0.0.jar"]
