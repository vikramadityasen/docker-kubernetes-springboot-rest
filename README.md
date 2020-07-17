# docker-kubernetes-springboot-rest
rest api deployment using docker and kubernetes.

# Technology stack: 
Java, Rest API, Springboot, JPA, H2, docker, Kubernetes. 

CRUD operation for Employee & Department service with one-to-many mapping.

# Docker configuration : 

Docker Requirements:

Docker toolbox or Docker hub desktop

# Dockerfile
FROM java:8

EXPOSE 8081

ADD /target/docker-kubernetes-springboot-rest-0.0.1-SNAPSHOT.jar docker-kubernetes-springboot-rest.jar

VOLUME /tmp

ENTRYPOINT ["java","-jar","docker-kubernetes-springboot-rest.jar"]

# Commands

docker build -t docker-kubernetes-springboot-rest .

docker images

docker run -p 8081:9090 -t docker-kubernetes-springboot-rest

docker ps -a

docker stop

docker rm

docker rmi

# Kubernetes Requirements


Our OS should support virtualization and we should have VirtualBox or hyprev.

create directory c:/kube

download minikube-windows-amd64 and rename it as minikube.exe and save in c:/kube/

download kubectl and place it in c:/kube/

Starting minikube will take a few minutes initially, as it needs to create the virtual machine for the first time. The command will create the minikube cluster and one VM in the name of minikube. Once the cluster is started, we can verify the details of Kubernetes deployments, pods, and services in our browser locally by using the following command:

$minikube start

Below command will open the web interface of minikube in the browser:

$minikube dashboard 

# Running the Spring Boot Docker Image

Running the Docker image in the minikube has to be done in three steps.

1. Pull a Docker image and create a minikube deployment (we can use the Docker image published in the first part of the series)

2. Expose the deployment that will create a service inside the minikube cluster

3. Identify the URL of the service and access it from outside of the cluster

#Creating a Deployment Using an Existing Docker Image

The command to create and run a deployment, as shown below:

kubectl run kube-app --image=vikramaditaysen/docker-kubernetes-springboot-rest:kubeapp1 --port=8080

This command will use the tag kubeapp1 from the repository docker-kubernetes-springboot-rest  at deployment. 

#Creating a Service for the Deployment

To access the deployment created in the above section from outside the minikube cluster, we need to expose it as a service. The command to expose it is provided below:

kubectl expose deployment kube-app --target-port=8080 --type=NodePort

kubectl get services

The first command will create the service and the second command will display the list of services and their details. The service would be exposed at port 8080. 

#Accessing the Service

Once the service is available, we need to access it from outside the cluster, To identify the external URL for the service, use the following command:

minikube service kube-app --url

http://192.168.99.100:31167

