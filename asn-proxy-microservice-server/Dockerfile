# Tomcat based container with Java and Tomcat
FROM tomcat:8.5
MAINTAINER aiml-team
ADD target/asn-proxy-microservice-server.jar /opt
EXPOSE 10006:10006
CMD ["java","-jar", "-Dserver.port=10006", "/opt/asn-proxy-microservice-server.jar"]

