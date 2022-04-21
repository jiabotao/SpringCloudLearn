package org.example.springcloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.locks.ReentrantLock;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
        System.out.println("配置中心客户端启动成功!");
        ReentrantLock s = new ReentrantLock();
    }

    public class Lock{
        boolean isLocked = false;
        Thread  lockedBy = null;
        int lockedCount = 0;
        public synchronized void lock()
                throws InterruptedException{
            Thread thread = Thread.currentThread();
            while(isLocked && lockedBy != thread){
                wait();
            }
            isLocked = true;
            lockedCount++;
            lockedBy = thread;
        }
        public synchronized void unlock(){
            if(Thread.currentThread() == this.lockedBy){
                lockedCount--;
                /**
                 *
                 */
                if(lockedCount == 0){//获得该锁的那个线程，获得了多少次该锁（即调用了几次lock方法，即重入了几次），就得unlock几次，即lockedCount=0，才会把那些wait（阻塞）的线程唤醒
                    isLocked = false;
                    notify();
                }
            }
        }
    }
}


