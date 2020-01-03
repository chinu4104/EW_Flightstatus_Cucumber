FROM maven:alpine

COPY . /ewFlightStatus

WORKDIR /ewFlightStatus

RUN ls -al 

CMD ["mvn", "test"]