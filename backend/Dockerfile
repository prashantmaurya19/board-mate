FROM ubuntu:noble

RUN apt update
RUN apt install openjdk-21-jdk -y
RUN apt install maven -y
RUN apt upgrade -y

WORKDIR /prelib

COPY ./lib/ .

# RUN cd PsoUtility/ && mvn clean install
# RUN cd pso-web-mvc-util/ && mvn clean install
RUN for d in */; do \
    echo "Building service in $d"; \
    (cd "$d" && mvn clean install && cd ..); \
done

WORKDIR /prerun

COPY ./api/ .
RUN for d in */; do \
    echo "Building service in $d"; \
    (cd "$d" && rm -rf target/ && ./mvnw clean install -DskipTests && cd ..); \
done


WORKDIR /app

ENTRYPOINT ["./mvnw","clean","spring-boot:run"]
