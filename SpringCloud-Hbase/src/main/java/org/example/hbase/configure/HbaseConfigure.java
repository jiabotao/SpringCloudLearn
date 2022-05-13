package org.example.hbase.configure;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@ConditionalOnClass(org.apache.hadoop.hbase.client.Admin.class)
@ConditionalOnProperty(prefix = "spring.hbase", name = "enabled", havingValue = "true",matchIfMissing = true)
@org.springframework.context.annotation.Configuration(proxyBeanMethods = false)
public class HbaseConfigure {

    Logger logger=Logger.getLogger(HbaseConfigure.class);

    @Value("${spring.hbase.rootdir}")
    String rootdir;

    @Value("${spring.hbase.zookeeper.quorum}")
    String zookeeperNodes;

    @Bean
    public synchronized Admin initHbase(){
        Admin admin = null;
        org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
        config.set("hbase.rootdir", rootdir);
        config.set("hbase.zookeeper.quorum", zookeeperNodes);
        Connection conn = null;
        try {
            conn = ConnectionFactory.createConnection(config);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            admin = conn.getAdmin();
            logger.info("初始化HbaseAdmin成功：hbase.rootdir："+rootdir+" zookeeper.quorum："+zookeeperNodes);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return admin;
    }
}
