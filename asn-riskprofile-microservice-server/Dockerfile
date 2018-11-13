# Tomcat based container with Java and Tomcat
FROM tomcat:8.5
MAINTAINER aiml-team
ADD target/asn-riskprofile-microservice-server.jar /opt
CMD ["java","-jar", "/opt/asn-riskprofile-microservice-server.jar"]