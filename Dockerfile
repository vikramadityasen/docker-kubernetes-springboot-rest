FROM java:8
EXPOSE 8081
VOLUME /tmp
ADD /target/docker-kubernetes-springboot-rest-0.0.1-SNAPSHOT.jar docker-kubernetes-springboot-rest.jar
ENTRYPOINT ["java","-jar","docker-kubernetes-springboot-rest.jar"]