FROM openjdk:8 As build
COPY . .
FROM maven:3.8.3-jdk-8-slim
COPY --from=build /target/plugsity-api-0.0.1-SNAPSHOT.jar plugsity-api.jar
EXPOSE 8080
#ENTRYPOINT ["java","-jar","plugsity-api.jar"]
ENTRYPOINT ["java", "-server", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-jar", "plugsity-api.jar"]