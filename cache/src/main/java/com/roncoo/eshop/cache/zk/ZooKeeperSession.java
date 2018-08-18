package com.roncoo.eshop.cache.zk;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @program: cache
 * @description: 封装单利
 * @author: Li YangLin
 * @create: 2018-08-18 10:55
 */
public class ZooKeeperSession {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;

    public ZooKeeperSession() {
        //去连接zookeeper server,创建回话的时候是异步的
        //
//    this.zooKeeper=new ZooKeeper("192.168.0.3:2181,192.168.0.4:2181,192.168.0.5:2181",50000,watcher);
    }

    private static class Singleton {
        private static ZooKeeperSession instance;

        static {
            instance = new ZooKeeperSession();
        }

        public static ZooKeeperSession getZooKeeperSession() {
            return instance;
        }
    }

    public static ZooKeeperSession getZooKeeperSession() {
        return Singleton.getZooKeeperSession();
    }

    public static void init() {
        getZooKeeperSession();
    }
}
