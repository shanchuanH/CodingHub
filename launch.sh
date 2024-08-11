#!/usr/bin/env bash

# Configuration
WEB_PATH="codinghub-web"
JAR_NAME="codinghub-web-0.0.1-SNAPSHOT.jar"
PID_FILE="pid.log"

# Function to start the application
function start() {
    echo "Pulling latest changes from Git..."
    git pull

    echo "Stopping any running instances..."
    if [ -f ${PID_FILE} ]; then
        cat ${PID_FILE} | xargs -I {} kill {}
        rm -f ${PID_FILE}
    fi

    echo "Backing up existing JAR..."
    if [ -f ${JAR_NAME} ]; then
        mv ${JAR_NAME} ${JAR_NAME}.bak
    fi

    echo "Building the project..."
    mvn clean install -Dmaven.test.skip=True
    cd ${WEB_PATH}
    mvn clean package spring-boot:repackage -Dmaven.test.skip=true
    cd -

    echo "Deploying the new JAR..."
    mv ${WEB_PATH}/target/${JAR_NAME} ./

    run
}

# Function to restart the application
function restart() {
    echo "Restarting the application..."
    if [ -f ${PID_FILE} ]; then
        cat ${PID_FILE} | xargs -I {} kill {}
        rm -f ${PID_FILE}
    fi

    run
}

# Function to run the application
function run() {
    echo "Starting the application..."
    nohup java -server -Xms1g -Xmx1g -Xmn512m -XX:NativeMemoryTracking=detail -XX:-OmitStackTraceInFastThrow -jar ${JAR_NAME} > /dev/null 2>&1 &
    echo $! > ${PID_FILE}
    echo "Application started with PID $(cat ${PID_FILE})"
}

# Main script execution
if [ $# == 0 ]; then
  echo "Missing command: start | restart"
elif [ $1 == 'start' ]; then
  start
elif [ $1 == 'restart' ];then
  restart
else
  echo "Illegal command. Supported commands: start | restart"
fi
