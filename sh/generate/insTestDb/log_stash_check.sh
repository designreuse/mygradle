#!/bin/sh
#check logstash-server process and restart if down


DATE=`date -d "today" +"%Y-%m-%d-%H:%M"`
#用ps命令查看logstash进程
MM=`ps aux |grep "logstash" |grep -v "grep" |wc -l`
#if语句判断进程是否存在，如果不存在，输出日志记录并重启logstash服务
if [ "$MM" == "0" ]; then
    echo "$DATE The logstash is problem and restart" >> /data/sh/log_stash_check.logs
    curl -d 'k=GkSy123*1-!&s=@insTestDb logstash SERVER 有问题正在重启！' "http://api.ln12320.cn/operate/msg/send"
    cd /data/logstash/logstash-2.4.1/
    nohup bin/logstash -f conf/logstash.conf &
else
    echo "logstash-SERVER IS RUNNING"
fi