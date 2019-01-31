FROM java:8
VOLUME /tmp
ADD out/push-service-0.0.1-SNAPSHOT.jar /app.jar
#ENV SPRING_PROFILES_ACTIVE docker
RUN bash -c 'touch /app.jar'


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]