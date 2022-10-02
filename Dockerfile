FROM maven AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app

ARG DB_PORT
ENV DB_PORT ${DB_PORT}

ARG DB_SCHEMA
ENV DB_SCHEMA ${DB_SCHEMA}

ARG DB_NAME
ENV DB_NAME ${DB_NAME}

ARG DB_USER
ENV DB_USER ${DB_USER}

ARG DB_PASSWORD
ENV DB_PASSWORD ${DB_PASSWORD}

ARG DB_CONTAINER_NAME
ENV DB_CONTAINER_NAME ${DB_CONTAINER_NAME}

RUN mvn clean install

CMD mvn spring-boot:run
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM openjdk:11
#COPY --from=build /home/app/target/docker-template-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
