FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005
COPY ${JAR_FILE} iportal-be.jar
ENTRYPOINT ["java","-jar","/iportal-be.jar"]
