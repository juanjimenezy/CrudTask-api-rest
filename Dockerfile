FROM openjdk:8
COPY "./target/CrudTask-api-rest-0.0.1-SNAPSHOT.jar" "CRUDTASK.jar"
EXPOSE 8090
ENTRYPOINT ["java","-jar","CRUDTASK.jar"]