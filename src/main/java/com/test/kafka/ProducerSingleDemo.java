package com.test.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;


public class ProducerSingleDemo {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:7000");
		props.put("acks", "all");
		props.put("retries", 1);//重试次数
		props.put("batch.size", 16384);
		props.put("linger.ms", 2);//间隔时间
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		for(int i = 0; i < 100; i++)
			producer.send(
					new ProducerRecord<String, String>(
							"my-topic", Integer.toString(i), Integer.toString(i))
							,new Callback() {
						public void onCompletion(RecordMetadata metadata, Exception e) {
							if(e != null){
								e.printStackTrace();
							}else{
								System.out.println("------------------------生产者开始---------------------------");
								System.out.println("The offset of the record we just sent is: " + metadata.offset());
								System.out.println("The checkNum of the record we just sent is: " + metadata.checksum());
								System.out.println("The topic of the record we just sent is: " + metadata.topic());
								System.out.println("The partition of the record we just sent is: " + metadata.partition());
								System.out.println("The hashCode of the record we just sent is: " + metadata.hashCode());
								System.out.println("------------------------生产者结束---------------------------");
							}
								
							
						}
					});
		producer.close();
	}

}
