FROM openjdk:7

MAINTAINER raju

ARG HOST_APP_JAR_LOC
ARG APP_HOME_DIR=/opt/app

ARG APP_CONFIG_DIR=/opt/config
RUN mkdir -p $APP_HOME_DIR \
    mkdir -p $APP_CONFIG_DIR \
    #ls -lrt /opt/app \
    echo $HOST_APP_JAR_LOC

VOLUME $APP_CONFIG_DIR

COPY $HOST_APP_JAR_LOC $APP_HOME_DIR/
RUN mv ${APP_HOME_DIR}/*.jar ${APP_HOME_DIR}/application.jar
RUN chmod 755 ${APP_HOME_DIR}/application.jar

ENTRYPOINT ["java","-jar","/opt/app/application.jar"]