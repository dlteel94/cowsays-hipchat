FROM openjdk:10-jre-slim
RUN apt-get update && apt-get -y install cowsay && apt-get clean && ln -s /usr/games/cowsay /usr/bin/cowsay
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/hipchat.integration-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} cowsay.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cowsay.jar"]

