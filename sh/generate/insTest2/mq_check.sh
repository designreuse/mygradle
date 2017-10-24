#!/bin/sh
#check rabbitmq-server-server process and restart if down


DATE=`date -d "today" +"%Y-%m-%d-%H:%M"`
#用ps命令查看rabbitmq-server进程
MM=`ps aux |grep "rabbitmq-server" |grep -v "grep" |wc -l`
#if语句判断进程是否存在，如果不存在，输出日志记录并重启rabbitmq-server服务
if [ "$MM" == "0" ]; then
    echo "$DATE The rabbitmq-server is problem and restart" >> /data/sh/mq_check.logs
    curl -d 'k=GkSy123*1-!&s=@insTest2 rabbitmq-server SERVER 有问题正在重启！' "http://api.ln12320.cn/operate/msg/send"
    service rabbitmq-server start
else
    echo "rabbitmq-server-SERVER IS RUNNING"
fi