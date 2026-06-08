FROM eclipse-temurin:21-alpine-3.23 AS builder
WORKDIR /source
COPY . .
RUN ./gradlew build -x check

FROM eclipse-temurin:21-alpine-3.23
WORKDIR /app
COPY --from=builder /source/build/libs/*.jar app.jar

ENV SERVER_PORT=8080
ENV DB_URL=jdbc:postgresql://host.docker.internal:5432/saque-aniversario-fgts
ENV DB_USER=postgres
ENV DB_PASS=123
ENV JPA_SHOW_SQL=false
ENV JPA_FORMAT_SQL=false

RUN addgroup -S appgroup && adduser -S -G appgroup appuser
USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]