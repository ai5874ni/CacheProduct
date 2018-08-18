package com.roncoo.eshop.cache.kafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @program: cache
 * @description: ${description}
 * @author: Li YangLin
 * @create: 2018-08-09 22:35
 */
public class KafkaConsumer implements Runnable {
    private ConsumerConnector consumerConnector;
    private String topic;
    public KafkaConsumer(String topic) {
        this.consumerConnector = Consumer.createJavaConsumerConnector(
                createConsumerConfig());
        this.topic = topic;
    }

    private ConsumerConfig createConsumerConfig() {
        System.out.println("===================createConsumerConfig");

        Properties props=new Properties();
        props.put("zookeeper.connect", "192.168.0.3:2181,192.168.0.4:2181,192.168.0.5:2181");
        props.put("group.id", "mm");
        props.put("zookeeper.session.timeout.ms", "1000000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        return new ConsumerConfig(props);
    }

    @Override
    public void run() {
        Map<String,Integer> topicCountMap=new HashMap<String, Integer>();
        topicCountMap.put(topic, 1);

        System.out.println("===================KafkaConsumer    run");
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
                consumerConnector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        for (KafkaStream stream : streams) {
            new Thread(new KafkaMessageProcessor(stream)).start();
        }

    }
}
