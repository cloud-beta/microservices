FROM java:8
VOLUME /tmp
ADD out/information-service-0.1.jar /app.jar
#ENV SPRING_PROFILES_ACTIVE docker
RUN bash -c 'touch /tmp/healthy'
RUN bash -c 'touch /app.jar'


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]