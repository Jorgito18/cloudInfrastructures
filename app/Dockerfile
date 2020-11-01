FROM ubuntu:latest

MAINTAINER Jorge Ara Espes <jorgito98ara@gmail.com>

RUN sudo apt-get update && apt-get install -y openjdk-8-jdk 

RUN echo "JAVA_HOME=$(which java)" | sudo tee -a /etc/environment

COPY ["DatabaseGUI/", "/DatabaseGUI/"]
WORKDIR DatabaseGUI

RUN javac -cp "./lib/miglayout-3.5.5-swing-java14.jar:./lib/mysql-connector-java-5.1.48.jar" \
 person/Person.java person/PersonBean.java gui/AppMain.java gui/PersonUI.java

CMD java -cp ".:./lib/miglayout-3.5.5-swing-java14.jar:./lib/mysql-connector-java-5.1.48.jar" \
 gui.AppMain

