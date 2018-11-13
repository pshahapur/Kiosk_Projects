# Tomcat based container with Java and Tomcat
FROM tomcat:8.5
MAINTAINER aiml-team
ADD target/asn-datasource-microservice-server.jar /opt
CMD ["java","-jar", "/opt/asn-datasource-microservice-server.jar"]