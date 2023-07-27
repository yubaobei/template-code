FROM  openjdk:8-jre
# author
MAINTAINER wutao


ADD ./web-*.tar.gz /opt
RUN mkdir -p /opt/web
WORKDIR /opt/web

# 启动系统服务
ENTRYPOINT ["bash","-c","./entrypoint.sh start && tail -f /dev/null"]
#CMD ["bash","-c","./entrypoint.sh start && tail -f /dev/null"]
