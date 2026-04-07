FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY aeronaveV2 ./aeronaveV2

# 👇 entra na pasta correta
WORKDIR /app/aeronaveV2

RUN mvn clean package -DskipTests

# ----------- STAGE FINAL -----------

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# copia o jar gerado
COPY --from=build /app/aeronaveV2/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]