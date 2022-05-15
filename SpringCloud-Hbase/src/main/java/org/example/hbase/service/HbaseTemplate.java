package org.example.hbase.service;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;

@Service
public class HbaseTemplate extends HbaseTableTemplate{


    public void scan(String tableName) throws IOException {
        Connection conn = admin.getConnection();
        Table table = conn.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        Iterator<Result> resultIterator = scanner.iterator();
        while (resultIterator.hasNext()){
            Result result = resultIterator.next();
            Cell[] cells = result.rawCells();
            for(Cell cell:cells){
                System.out.println("INFO:   "+cell);
                System.out.println(new String(CellUtil.cloneRow(cell)));  //  行键
                System.out.println(new String(CellUtil.cloneFamily(cell)));  //  列簇
                System.out.println(new String(CellUtil.cloneQualifier(cell))); //  字段
                System.out.println(new String(CellUtil.cloneValue(cell))); //  值
                System.out.println(cell.getTimestamp()); //  时间戳
            }
        }
        table.close();
    }

}
