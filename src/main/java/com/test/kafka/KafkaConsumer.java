package com.test.kafka;

import com.test.util.ReadProperties;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fanzw on 2018年3月
 */
public class KafkaConsumer {

    private static String kkConf = "/consumer.properties";
    private ExecutorService executor;
    private ConsumerConnector connector;
    private Charset charset = Charset.forName("utf8");
    private static Properties properties = new Properties();

    // 初始化配置
    static  {
        properties = ReadProperties.getProperties(kkConf);
    }

    // kafka消费
    public void kafkaConsumer() throws Exception {

        ConsumerConfig config = new ConsumerConfig(properties);
        connector = Consumer.createJavaConsumerConnector(config);

        Map<String, Integer> topics = new HashMap<String, Integer>();
        topics.put("kafka_test001", 3);
        Map<String, List<KafkaStream<byte[], byte[]>>> streams = connector.createMessageStreams(topics);
        List<KafkaStream<byte[], byte[]>> partitions = streams.get("kafka_test001");
        executor = Executors.newFixedThreadPool(3);

        // 循环消费
        for (final KafkaStream<byte[], byte[]> stream : partitions) {
            executor.submit(new Runnable() {
                public void run() {
                    for (MessageAndMetadata<byte[], byte[]> msg : stream) {
                        // TODO 消费数据的方法
                        // TODO 解析成json格式，或对象
                        System.out.println(new String(msg.message(), charset));

                        connector.commitOffsets();
                    }
                }
            });
        }

    }


    public void close() {
        try {
            executor.shutdownNow();
        } catch (Exception e) {
            //
        } finally {
            connector.shutdown();
        }

    }

    public static void main(String[] args) throws Exception {
        KafkaConsumer kc = new KafkaConsumer();
        kc.kafkaConsumer();
    }

}