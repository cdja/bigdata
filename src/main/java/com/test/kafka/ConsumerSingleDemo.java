package com.test.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class ConsumerSingleDemo {

	public static void main(String[] args){
		automaticResetOffset();
//		manualResetOffset();
//		manualResetOffsetByPartition();
	}

	/**
	 * 系统自动更新offset
	 */
	public static void automaticResetOffset() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "node01:9092,node02:9092,node03:9092");
		props.put("group.id", "test_001");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "300");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("kafka_test001"));

		//消费多个topic主题的写法 consumer.subscribe(Arrays.asList("my-topic", "bar", "foo"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records){
				System.out.println("-------------消费者开始---------------");
				System.out.println("offset="+record.offset());
				System.out.println("partition="+record.partition());
				System.out.println("topic="+record.topic());
				System.out.println("key="+record.key());
				System.out.println("value="+record.value());
				System.out.println("=============消费者结束===============");
			}
		}
	}



	/**
	 * 手动设置offset
	 */
	public static void manualResetOffset(){
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:7000");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "false");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("my-topic"));
		//消费多个topic主题的写法 consumer.subscribe(Arrays.asList("my-topic", "bar", "foo"));
		final int minBatchSize = 200;
		List<ConsumerRecord<String, String>> buffer = new ArrayList<>();
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);//100为timeout时间
			for (ConsumerRecord<String, String> record : records) {
				System.out.println("-------------消费者开始---------------");
				System.out.println("offset="+record.offset());
				System.out.println("partition="+record.partition());
				System.out.println("topic="+record.topic());
				System.out.println("key="+record.key());
				System.out.println("value="+record.value());
				System.out.println("=============消费者结束===============");
				buffer.add(record);//消费者加入list
			}
			if (buffer.size() >= minBatchSize) {
				insertIntoDb(buffer);//插入数据库操作
				consumer.commitSync();//提交offset
				buffer.clear();//清空list
			}
		}
	}

	/**
	 * 此方法用来处理具体业务以及插入数据库操作
	 * @param buffer
	 */
	public static void insertIntoDb(List<?> buffer){
		try{
			//具体业务操作
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//执行
		}
	}

	/**
	 * 带有分区信息的更新offset
	 */
	public static void manualResetOffsetByPartition(){
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:7000");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "false");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("my-topic"));
		//消费多个topic主题的写法 consumer.subscribe(Arrays.asList("my-topic", "bar", "foo"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
			for (TopicPartition partition : records.partitions()) {
				List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
				for (ConsumerRecord<String, String> record : partitionRecords) {
					System.out.println("-------------消费者开始---------------");
					System.out.println("offset="+record.offset());
					System.out.println("partition="+record.partition());
					System.out.println("topic="+record.topic());
					System.out.println("key="+record.key());
					System.out.println("value="+record.value());
					System.out.println("=============消费者结束===============");
				}
				long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
				consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
			}
		}
	}

}
