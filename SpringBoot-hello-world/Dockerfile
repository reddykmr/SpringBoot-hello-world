# Start with a base image containing Java runtime
FROM openjdk:8

# Make port 8080 available to the world outside this container
EXPOSE 8085

ADD target/SpringBoot-hello-world.jar SpringBoot-hello-world.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","SpringBoot-hello-world.jar"]