FROM openjdk:11
COPY target/spring-security-jwt-0.0.1-SNAPSHOT.jar SpringSecurityJwt.jar
ENTRYPOINT ["java","-jar","SpringSecurityJwt.jar"]


#docker build --tag=projectName --force-rm=true