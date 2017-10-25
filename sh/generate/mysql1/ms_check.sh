#!/bin/sh
#check mysqld-server process and restart if down


DATE=`date -d "today" +"%Y-%m-%d-%H:%M"`
#用ps命令查看mysqld进程
MM=`ps aux |grep "mysqld" |grep -v "grep" |wc -l`
#if语句判断进程是否存在，如果不存在，输出日志记录并重启mysqld服务
if [ "$MM" == "0" ]; then
    echo "$DATE The mysqld is problem and restart" >> /data/sh/ms_check.logs
    curl -d 'k=GkSy123*1-!&s=@mysql1 mysqld SERVER 有问题正在重启！' "http://api.ln12320.cn/operate/msg/send"
    service mysqld start
else
    echo "mysqld-SERVER IS RUNNING"
fi