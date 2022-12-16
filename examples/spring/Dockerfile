FROM maven:3-openjdk-17

WORKDIR /app

COPY . /app

EXPOSE 8080

RUN mvn clean package

ENTRYPOINT ["mvn", "spring-boot:run"]
