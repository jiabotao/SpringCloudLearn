package org.example.hbase.service;

import org.apache.hadoop.hbase.TableName;
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

    public boolean tableExists(String nameSpace,String tableName) throws IOException {
        if(nameSpace==null||nameSpace.equals("")){
            nameSpace = defaultNameSpace;
        }
        String namespacedTbale = nameSpace+":"+tableName;
        TableName tablename = TableName.valueOf(namespacedTbale);
        boolean tableExists = admin.tableExists(tablename);
        return tableExists;
    }
}
