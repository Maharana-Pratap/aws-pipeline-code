# ---- Build Stage ----
FROM eclipse-temurin:25-jdk-alpine
#RUN apk add curl
WORKDIR /app

# Copy Gradle/Maven descriptor first for caching
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# Copy sources & build
COPY src ./src
RUN ./mvnw -q dependency:go-offline

# ---- Runtime Stage ----
#FROM eclipse-temurin:25-jre AS runtime

#WORKDIR /app

# copy final jar from builder
#COPY --from=builder /app/target/*.jar app.jar

ADD target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]