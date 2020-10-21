FROM     zidanepirlo/centos7_jdk8
MAINTAINER junjie.chen <youaijj@163.com>

ENV TZ "Asia/Shanghai"
ENV LANG zh_CN.UTF-8

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
ADD images/start.sh start.sh

RUN mkdir -p /web/k8s/demo/logs

CMD ["sh","start.sh"]
