#!/bin/sh
#check nginx-server process and restart if down


DATE=`date -d "today" +"%Y-%m-%d-%H:%M"`
#用ps命令查看nginx进程
MM=`ps aux |grep "nginx" |grep -v "grep" |wc -l`
#if语句判断进程是否存在，如果不存在，输出日志记录并重启nginx服务
if [ "$MM" == "0" ]; then
    echo "$DATE The nginx is problem and restart" >> /data/sh/nx_check.logs
    curl -d 'k=GkSy123*1-!&s=@pay1 nginx SERVER 有问题正在重启！' "http://api.ln12320.cn/operate/msg/send"
    service nginx start
else
    echo "nginx-SERVER IS RUNNING"
fi