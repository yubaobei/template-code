FROM  openjdk:8-jre
# author
MAINTAINER wutao


ADD ./${app.name}*.tar.gz /opt
RUN mkdir -p /opt/${app.name}
WORKDIR /opt/${app.name}

# 启动系统服务
ENTRYPOINT ["bash","-c","./entrypoint.sh start && tail -f /dev/null"]
#CMD ["bash","-c","./entrypoint.sh start && tail -f /dev/null"]
