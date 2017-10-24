#!/bin/sh
#check @SERVERNAME@-server process and restart if down


DATE=`date -d "today" +"%Y-%m-%d-%H:%M"`
#用ps命令查看@SERVERNAME@进程
MM=`ps aux |grep "@SERVERNAME@" |grep -v "grep" |wc -l`
#if语句判断进程是否存在，如果不存在，输出日志记录并重启@SERVERNAME@服务
if [ "$MM" == "0" ]; then
    echo "$DATE The @SERVERNAME@ is problem and restart" >> /data/sh/@FILENAME@_check.logs
    curl -d 'k=GkSy123*1-!&s=@@HOST@  @SERVERNAME@ SERVER 有问题正在重启！' "http://api.ln12320.cn/operate/msg/send"
    @COMMAND@
else
    echo "@SERVERNAME@-SERVER IS RUNNING"
fi