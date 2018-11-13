# Tomcat based container with Java and Tomcat
FROM tomcat:8.5
MAINTAINER aiml-team
ADD target/asn-discovery-microservice-server.jar /opt
EXPOSE 10007:10007
CMD ["java","-jar", "-Dserver.port=10007", "/opt/asn-discovery-microservice-server.jar"]
