package com.test.clean;

import com.test.entity.SampleRetInfoOject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SampledData {

    // 解析kafka中读到的数据，做数据清洗处理
    public List sampleKafkaData(List list) {
        //  TODO kafkaStr 解析成对象
        // 1.判断记录是否重复，重复后处理方案
        // 2.判断记录是否不和规
        // 3.采样数据
        // 拿到1分钟的数据，取样 1，11，21，31，41，51

        // 实现java 中 list集合中有1分钟数据,每10间隔条取出一条
        int listSize = list.size();
        List sampleOver = new ArrayList(); // 用list存取样后数据
        // TODO 修改采集步长
        for (int i = 0; i < listSize; i += 2) {
            sampleOver.add(list.get(i));
        }
        // TODO 根据device_id，time，locations判断是否有效
        // 数据相同，调用无效；车停止数据量不足

        return sampleOver;
    }

    // 1分钟的数据转化为json,返回给高德调用
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

        SampledData sampledData = new SampledData();
        List listSample = sampledData.sampleKafkaData(list);
        if (listSample.size() >= 3) {
            JSONObject jsonObject = sampledData.jsonToObject(listSample);
            System.out.println(jsonObject.toString());
        }
    }

}