package com.test.datahub;

import com.aliyun.datahub.DatahubClient;
import com.aliyun.datahub.DatahubConfiguration;
import com.aliyun.datahub.auth.AliyunAccount;
import com.aliyun.datahub.common.data.FieldType;
import com.aliyun.datahub.common.data.Field;
import com.aliyun.datahub.common.data.RecordSchema;
import com.aliyun.datahub.common.data.RecordType;
import com.aliyun.datahub.exception.DatahubClientException;
import com.aliyun.datahub.exception.InvalidCursorException;
import com.aliyun.datahub.model.*;
import com.aliyun.datahub.wrapper.Topic;
import com.test.entity.SampleRetInfoOject;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class WriteDatahub {

    private static final Logger logger = Logger.getLogger(WriteDatahub.class);
    private static String accessId = "LTAI9cJvmFfwjxCs";
    private static String accessKey = "3R4Ujs6edemUDQ3lnHiPon7BPyPsrr";
    private static String endpoint = "http://dh-cn-hangzhou.aliyuncs.com";
    private DatahubClient client;
    private static String projectName = "test004";
    private static String topicName = "test001";
    private static String topicShardNum = "10";

    public WriteDatahub() {
        DatahubConfiguration conf = new DatahubConfiguration(new AliyunAccount(accessId, accessKey), endpoint);
        client = new DatahubClient(conf);
    }

    // 存数据到datahub指定topic
    public void putRecords(List<Object> list) {
        Topic topic = Topic.Builder.build(projectName, topicName, client);
        List<ShardEntry> shards = topic.listShard();
        RecordSchema schema = topic.getRecordSchema();
        List<RecordEntry> recordEntries = new ArrayList<RecordEntry>();

        // TODO test
        long begin = System.currentTimeMillis();
        SampleRetInfoOject sampe = null;
        for (int i = 0; i < list.size(); i++) {
            sampe = (SampleRetInfoOject)list.get(i);
            // RecordData
            RecordEntry entry = new RecordEntry(schema);
            entry.setString(0, sampe.getDevice_id());
            entry.setString(1, sampe.getEvent_id_list());

            // write record to different shard
            String shardId = shards.get(i % Integer.parseInt(topicShardNum)).getShardId();

            entry.setShardId(shardId);
//             entry.putAttribute("partition", "ds=2016");

            recordEntries.add(entry);
        }

        int retryCount = 3;
        PutRecordsResult result = topic.putRecords(recordEntries, retryCount);

        if (result.getFailedRecordCount() > 0) {
            // handle failed records
            logger.info("failed records:");
            for (RecordEntry record : result.getFailedRecords()) {
                logger.info(record.toJsonNode().toString());
            }
        } else {
            // all records done
            logger.info("successfully write all records");
        }
        // TODO test
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public static void main(String[] args) {
        WriteDatahub wirteDatahub = new WriteDatahub();
        List list = new ArrayList();
        SampleRetInfoOject test1 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0010,event_0011", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test2 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0020,event_0021", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test3 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0030,event_0031", "80", "116.496167", "39.917066", "800");
        list.add(test1);
        list.add(test2);
        list.add(test3);

        try {
            wirteDatahub.putRecords(list);
        } catch (DatahubClientException e) {
            e.printStackTrace();
        }
    }
}
