# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/app-0.0.4-SNAPSHOT.jar /app/cookies-app.jar

# Specify the command to run on container start
CMD ["java", "-jar", "cookies-app.jar", "pl.bratek20.cookies.app.web.WebCookiesApp"]