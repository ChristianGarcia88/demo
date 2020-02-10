FROM  openjdk:8
ADD target/demo-0.0.1-SNAPSHOT.jar  demo.jar
EXPOSE 1235
ENTRYPOINT ["java", "-jar","demo.jar"]