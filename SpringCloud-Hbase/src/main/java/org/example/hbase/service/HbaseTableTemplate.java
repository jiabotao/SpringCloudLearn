package org.example.hbase.service;

import org.apache.hadoop.hbase.DoNotRetryIOException;
import org.apache.hadoop.hbase.InvalidFamilyOperationException;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HbaseTableTemplate extends HBaseNameSpaceTemplate{

    protected static final String defaultNameSpace = "default";

    public boolean tableExists(String tableName) throws IOException {
        TableName tablename = TableName.valueOf(tableName);
        boolean tableExists = admin.tableExists(tablename);
        return tableExists;

    }

    public boolean createTable(String tableName,String... columnFamilies){
        boolean created = false;
        TableName tablename = TableName.valueOf(tableName);
        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(tablename);
        for(int i =0;i<columnFamilies.length;i++){
            ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.of(columnFamilies[i]);
            tableDescriptorBuilder.setColumnFamily(columnFamilyDescriptor);
        }
        TableDescriptor build = tableDescriptorBuilder.build();
        try {
            admin.createTable(build);
            created = true;
        }catch (TableExistsException e){
            logger.error("创建表："+tableName+"失败"+"，该表已存在");
        }catch (DoNotRetryIOException e){
            logger.error("Table 至少需要一个 column family");
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            return created;
        }
    }

    public boolean deleteTable(String tableName){
        boolean deleted = false;
        TableName tablename = TableName.valueOf(tableName);
        try {
            admin.disableTable(tablename);
            admin.deleteTable(tablename);
            deleted = true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return deleted;
        }
    }

    public void addColumnFamily(String tableName,String... columnFamilies){
        try{
            boolean exists =  this.tableExists(tableName);
            if(exists){
                TableName tablename = TableName.valueOf(tableName);
                for(int i =0;i<columnFamilies.length;i++){
                    ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.of(columnFamilies[i]);
                    try{
                        admin.addColumnFamily(tablename,columnFamilyDescriptor);
                    }catch (InvalidFamilyOperationException e){
                        logger.warn("添加\""+columnFamilies[i]+"\"---cloumnFamily失败，疑似重复，跳过此步骤");
                    }
                }
            }else {
                this.createTable(tableName,columnFamilies);
            }
        }catch (IOException e){
            logger.error("查询"+tableName+"表失败，原因："+e.getStackTrace());
        }
    }
}
