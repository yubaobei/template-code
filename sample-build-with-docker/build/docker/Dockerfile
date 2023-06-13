# 基础镜像
FROM  repo-host:6083/openjdk:8-jre
# author
MAINTAINER wutao

# 挂载目录
#VOLUME /home/app
# 创建目录
RUN mkdir -p /home/app
# 指定路径
WORKDIR /home/app

ADD app.tar.gz /home/app
# 启动系统服务
ENTRYPOINT ["java","-classpath","/home/app/*:/home/app/dependency/*", "com.wtao.App"]