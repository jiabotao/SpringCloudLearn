package com.example.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class TestZookeeper {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 2000, null);
        zookeeper.create("/a", "adasdas".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      //  countDownLatch.await();
        System.out.println("zookeeper connection success");
    }
}
