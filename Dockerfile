FROM java:8
EXPOSE 8081
ADD /target/docker-kubernetes-springboot-rest-0.0.1-SNAPSHOT.jar docker-kubernetes-springboot-rest.jar
VOLUME /tmp
ENTRYPOINT ["java","-jar","docker-kubernetes-springboot-rest.jar"]