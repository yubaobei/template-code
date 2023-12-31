#!/bin/bash

APP_BASE_PATH=$(cd `dirname $0`; pwd)

# 启动入口类，该脚本文件用于别的项目时要改这里
MAIN_CLASS=${main.class}
APP_NAME=${app.name}

if [[ "$MAIN_CLASS" == "" ]]; then
    echo "请先修改 MAIN_CLASS 的值为你自己项目启动Class，然后再执行此脚本。"
	exit 0
fi

COMMAND="$1"

if [[ "$COMMAND" != "start" ]] && [[ "$COMMAND" != "stop" ]] && [[ "$COMMAND" != "restart" ]]; then
	echo "Usage: $0 start | stop | restart"
	exit 0
fi


# JAVA环境变量
export JAVA_HOME=/usr/local/openjdk-8
export CLASSPATH=.:${JAVA_HOME}/lib
export PATH=${BASEDIR}:${JAVA_HOME}/bin:$PATH

# Java 命令行参数，根据需要开启下面的配置，改成自己需要的，注意等号前后不能有空格
JVM_OPTS="-Dname=$APP_NAME -Duser.timezone=Asia/Shanghai -Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps  -XX:+PrintGCDetails -XX:NewRatio=1 -XX:SurvivorRatio=30 -XX:+UseParallelGC -XX:+UseParallelOldGC"

# 设置class path 值
CP=${APP_BASE_PATH}/config:${APP_BASE_PATH}/lib/*

function start()
{
    # 运行为后台进程，并在控制台输出信息
#    java -Xverify:none ${JAVA_OPTS} -cp ${CP} ${MAIN_CLASS} &

    # 运行为后台进程，并且不在控制台输出信息
    nohup java -Xverify:none ${JVM_OPTS} -cp ${CP} ${MAIN_CLASS} >/dev/null 2>&1 &

    # 运行为后台进程，并且将信息输出到 output.log 文件
    # nohup java -Xverify:none ${JAVA_OPTS} -cp ${CP} ${MAIN_CLASS} > output.log &

    # 运行为非后台进程，多用于开发阶段，快捷键 ctrl + c 可停止服务
    # java -Xverify:none ${JAVA_OPTS} -cp ${CP} ${MAIN_CLASS}
}

function stop()
{
    # 支持集群部署
    kill `pgrep -f ${APP_BASE_PATH}` 2>/dev/null

    # kill 命令不使用 -9 参数时，会回调 onStop() 方法，确定不需要此回调建议使用 -9 参数
    # kill `pgrep -f ${MAIN_CLASS}` 2>/dev/null

    # 以下代码与上述代码等价
    # kill $(pgrep -f ${MAIN_CLASS}) 2>/dev/null
}

if [[ "$COMMAND" == "start" ]]; then
	start
elif [[ "$COMMAND" == "stop" ]]; then
    stop
else
    stop
    start
fi
