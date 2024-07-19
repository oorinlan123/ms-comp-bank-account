FROM openjdk:14-jdk-buster
LABEL autor="Israel Guacho"
LABEL email="israel.guachog@gmail.com"
LABEL project="NTT DATA"
LABEL company="NTT DATA"
ARG archivo_jar
ARG puerto
ADD target/$archivo_jar app.jar
RUN rm /etc/localtime && \
ln -s /usr/share/zoneinfo/America/Guayaquil /etc/localtime && \
mkdir -p app/build/config && \
mkdir -p app/build/log && \
chmod 777 app
EXPOSE $puerto
ENTRYPOINT ["java","-XX:+UseG1GC","-Dfile.encoding=UTF-8","-Duser.timezone=America/Guayaquil","-Dspring.cloud.bootstrap.location=/app/build/config/bootstrap.properties","-jar","/app.jar"]
