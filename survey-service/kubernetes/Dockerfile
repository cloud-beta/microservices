FROM java:8
VOLUME /tmp
ADD out/survey-service-0.1.jar /app.jar
#ENV SPRING_PROFILES_ACTIVE docker
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]