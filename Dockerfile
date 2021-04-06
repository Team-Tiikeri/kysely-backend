FROM openjdk:latest
EXPOSE 8080
COPY . .
WORKDIR /usr/src/app
CMD ["java", "-jar" ,"./target/kyselyapp-0.0.1-SNAPSHOT.jar"]