FROM  java:8
#EXPOSE 443

WORKDIR /u01/labor/app/

COPY . . 
COPY salido-labor.jar salido-labor.jar

RUN pwd
RUN ls -la


#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Ddebug", "-jar", "-Dspring.profiles.active=prod", "/u01/labor/app/salido-labor.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Ddebug", "-jar", "/u01/labor/app/salido-labor.jar"]