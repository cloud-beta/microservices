FROM java:8
VOLUME /tmp
ADD out/book-service-0.1.jar /app.jar
#ENV SPRING_PROFILES_ACTIVE docker
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.whsecurity.egd=file:/dev/./urandom","-jar","/app.jar"]