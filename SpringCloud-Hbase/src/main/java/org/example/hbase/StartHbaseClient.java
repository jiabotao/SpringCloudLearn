package org.example.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StartHbaseClient {
    public static void main(String[] args) throws IOException {
//        Configuration config = HBaseConfiguration.create();
//        config.set("hbase.rootdir", "hdfs://mycluster/hbase");
//        config.set("hbase.zookeeper.quorum", "mastera,masterb,masterc");
//        Connection conn = ConnectionFactory.createConnection(config);
//        Admin admin = conn.getAdmin();
//        String[] aaa = admin.listNamespaces();
//        TableName tablename = TableName.valueOf("test_table");
//        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(tablename);
//        ColumnFamilyDescriptor of = ColumnFamilyDescriptorBuilder.of("base_info");
//        tableDescriptorBuilder.setColumnFamily(of);
//        //创建列族  2
//        ColumnFamilyDescriptor of1 = ColumnFamilyDescriptorBuilder.of("emp_info");
//        tableDescriptorBuilder.setColumnFamily(of1);
//        //构建
//        TableDescriptor build = tableDescriptorBuilder.build();
//        admin.createTable(build);
//        boolean tableExists = admin.tableExists(tablename);
//        admin.close();
//        conn.close();
        SpringApplication.run(StartHbaseClient.class,args);

    }
}
