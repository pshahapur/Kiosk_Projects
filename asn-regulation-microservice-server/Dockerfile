# Tomcat based container with Java and Tomcat
FROM tomcat:8.5
MAINTAINER aiml-team
ADD target/asn-regulation-microservice-server.jar /opt
CMD ["java","-jar","/opt/asn-regulation-microservice-server.jar"]
