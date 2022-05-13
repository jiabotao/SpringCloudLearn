package org.example.hbase.service;

import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.NamespaceExistException;
import org.apache.hadoop.hbase.NamespaceNotFoundException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.log4j.Logger;
import org.example.hbase.configure.HbaseConfigure;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class HBaseNameSpaceTemplate {

    Logger logger=Logger.getLogger(this.getClass());

    @Resource
    Admin admin;

    public synchronized boolean createNameSpace(String namespace){
        boolean created = false;
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(namespace).build();
        try {
            admin.createNamespace(namespaceDescriptor);
            logger.info(namespace+"创建成功");
            created = true;
        } catch (NamespaceExistException e) {
            logger.error(namespace+" 命名空间已存在");
        }catch (IOException e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            return created;
        }
    }

    public synchronized boolean deleteNameSpace(String namespace){
        boolean deleted = false;
        try {
            admin.deleteNamespace(namespace);
            logger.info(namespace+" 命名空间删除成功");
            deleted = true;
        }catch (NamespaceNotFoundException e){
            logger.error(namespace+" 命名空间删除失败，该命名空寂不存在");
        }catch (IOException e) {
            logger.error(namespace+" 命名空间删除失败, "+e.getMessage());
        }finally {
            return deleted;
        }
    }
}
