FROM java:8
EXPOSE 8080:8080
ADD build/libs/rabbit_mq-0.0.1-SNAPSHOT.jar foo-service.jar
ENTRYPOINT ["java","-jar","foo-service.jar"]