FROM java:8-jdk-alpine

COPY ./target/notice-svc-1.0.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch notice-svc-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "notice-svc-1.0.0.jar"]