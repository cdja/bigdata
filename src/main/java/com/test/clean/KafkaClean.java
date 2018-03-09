package com.test.clean;

import com.test.entity.SampleRetInfoOject;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class KafkaClean {

    // 1.获取kafka数据
    // 2.判断记录是否重复，重复后处理方案
    // 3.判断记录是否不和规
    // 4.记录每个设备读取的记录数，存入redis(counter和暂时的数据)
    // 5.符合要求整合成json上传到kafka对应topic中


    // 1.解析kafka中读到的数据，做数据清洗处理
    public String parseKafka(String kafkaStr) {
        //  TODO kafkaStr 解析成对象
        // 1.判断记录是否重复，重复后处理方案
        // 2.判断记录是否不和规
        // -- 3.正常数据调用countKafka方法
        // 3.采样数据


        return null;
    }

//    // 2.记录设备counter和数据，存入redis(还需验证)
//    public String countKafka(String kafkaStr) {
//        //  TODO
//        // 1.调用parseKafka方法做数据清洗处理
//        // 2.time时间转换（timeTransferUTC），driection计算(latAndAltTransterDirection)等
//        // 3.合规数据计数，存取
//        // 4.如果到达60条数据，触发到topic存取json数据的事件，调用方法jsonToKafka
//
//        return null;
//    }

    // 3.一批数据转化为json存入topic
    public String jsonToKafka(String kafkaStr) {
        //  TODO
        // 1.从redis，文件，内存等读出一批数据
        // 2.转化成相应的json格式
        // 3.调用kafka producer方法发送json数据

        return null;
    }

    // 4.time转化成utc格式
    public String timeTransferUTC(String kafkaStr) {
        //  TODO
        // 1.time格式转化

        return null;
    }

    // 5.根据经纬度计算direction
    public String latAndAltTransterDirection(String kafkaStr) {
        //  TODO
        // 1.根据经纬度计算direction

        return null;
    }

    // 1.解析kafka读到的数据，做数据清洗处理，采样等
    // 2.记录设备counter和数据，存入redis(还需验证)  TODO 因为使用window可以解决，暂时不用这个方法了
    // 3.一批数据转化为json存入topic
    // 4.time转化成utc格式                           TODO 已完成 GetUTCTimeUtil.java
    // 5.根据经纬度计算direction                     TODO 已完成 AzimuthFromLogLatUtil.java

    // 1.解析kafka中读到的数据，做数据清洗处理
    public List parseKafkaSample(List list) {
        //  TODO kafkaStr 解析成对象
        // 1.判断记录是否重复，重复后处理方案
        // 2.判断记录是否不和规
        // -- 3.正常数据调用countKafka方法
        // 3.采样数据
        // 拿到1分钟的数据，取样 1，11，21，31，41，51

        // 实现java 中 list集合中有1分钟数据,每10间隔条取出一条
        int listSize = list.size();
        List sampleOver = new ArrayList(); // 用list存取样后数据
        // TODO 修改采集步长
        for (int i = 0; i < listSize; i += 2) {
            sampleOver.add(list.get(i));
        }
        // TODO 根据time，locations判断是否有效
        return sampleOver;
    }

    // 3.1分钟的数据转化为json,返回给高德调用
    public JSONObject jsonToObject(List<SampleRetInfoOject> list) {
        // 1.采集出的数据读出
        // 2.转化成相应的json格式，返回
        JSONObject jsonData = null;
        JSONObject device = new JSONObject();
        device.put("device_id", list.get(0).getDevice_id());
        device.put("driver_id", list.get(0).getDriver_id());

        JSONArray jsonArray = new JSONArray();
        JSONObject objData = new JSONObject();

        for (SampleRetInfoOject s : list) {
            jsonData = new JSONObject();
            jsonData.put("event_id_list", s.getEvent_id_list());
            jsonData.put("latitude", s.getLatitude());
            jsonData.put("longitude", s.getLongitude());
            jsonData.put("alt", s.getAlt());
            jsonArray.add(jsonData);
        }
        objData.put("device", device);
        objData.put("data", jsonArray);

        return objData;
    }

    public static void main(String[] args) {
        SampleRetInfoOject test1 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0010,event_0011", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test2 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0020,event_0021", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test3 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0030,event_0031", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test4 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0040,event_0041", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test5 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0050,event_0051", "80", "116.496167", "39.917066", "800");

        SampleRetInfoOject test6 = new SampleRetInfoOject("device_001", "driver_001", "trip_001", "1520490634902",
                "1520490634902", "event_0060,event_0061", "80", "116.496167", "39.917066", "800");

        List list = new ArrayList();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test6);

        KafkaClean test = new KafkaClean();
        List listSample = test.parseKafkaSample(list);
        if (listSample.size()>=3) {
            JSONObject jsonObject = test.jsonToObject(listSample);
            System.out.println(jsonObject.toString());
        }
    }

}