FROM  java:8
#EXPOSE 9090
EXPOSE 443

COPY salido-labor.jar salido-labor.jar
RUN ls -la
#ENTRYPOINT ["java" "-jar" "salido-labor.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Ddebug", "-jar", "-Dspring.profiles.active=prod", "/salido-labor.jar"]