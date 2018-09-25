# Start with a base image containing Java runtime
FROM java:8

# Add Maintainer Info
LABEL maintainer="ccbu-team-thanos@cisco.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8081

# The application's jar file
ARG JAR_FILE=target/org-management-1.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} org-management.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/org-management.jar"]

