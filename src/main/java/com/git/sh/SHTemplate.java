package com.git.sh;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihao on 17/10/23.
 */
public class SHTemplate {

    public static void main(String[] args) throws Exception {

        List<ShBean> lists = new ArrayList<>();
//        ShBean shBeanes = new ShBean("elasticsearch", "file", "es");
        String command = "su  es -s /data/elasticsearch-5.5.0/bin/start.sh";
//        shBeanes.setCommand(command);


        ShBean nginx =  new ShBean("nginx", "insTest2", "nx");
        nginx.setCommand("service nginx start");


        ShBean rabbitmq =  new ShBean("rabbitmq-server", "insTest2", "mq");
        rabbitmq.setCommand("service rabbitmq-server start");
////
//        ShBean redis =  new ShBean("redis", "redis", "rd");
//        redis.setCommand("service redis start");

//        ShBean mongod =  new ShBean("mongod", "insMongodb", "mongo");
//        mongod.setCommand("rm -rf /var/run/mongodb/mongod.pid \n service mongod start");


//
//        ShBean mysqld =  new ShBean("mysqld", "backup", "ms");
//        mysqld.setCommand("service mysqld start");
//
//        ShBean memcached =  new ShBean("memcached", "cache", "mc");
//        memcached.setCommand("service memcached start");

        ShBean logstash = new ShBean("logstash", "insTest2", "log_stash");
         command = "cd /data/logstash/logstash-2.4.1/\n" +
                 "    nohup bin/logstash -f conf/logstash.conf &";
        logstash.setCommand(command);

//        lists.add(shBeanes);
        lists.add(nginx);
        lists.add(logstash);
        lists.add(rabbitmq);
//        lists.add(redis);
//        lists.add(mysqld);
//        lists.add(memcached);
//        lists.add(mongod);
        lists.forEach(bean -> {

            String template = null;
            try {
                template = FileUtils.readFileToString(new File("sh/template.sh"), Charsets.toCharset("utf-8"));
                template = template.replaceAll("@SERVERNAME@", bean.getServerName());
                template = template.replaceAll("@HOST@ ", bean.getHostName());
                template = template.replaceAll("@COMMAND@", bean.getCommand());
                template = template.replaceAll("@FILENAME@", bean.getFileName());
                File outFile = new File("sh/generate/"+bean.getHostName()+"/" + bean.getFileName() + "_check.sh");
                FileUtils.writeStringToFile(outFile, template, Charsets.toCharset("utf-8"));

                System.out.println(bean.getServerName() + "  success");
            } catch (IOException e) {
                e.printStackTrace();
            }


        });


    }

}
