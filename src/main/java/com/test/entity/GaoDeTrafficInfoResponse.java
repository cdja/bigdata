package com.test.entity;

import java.util.List;

/**
 * 交通信息实体类
 *
 * @author fanzw
 *
 */
public class GaoDeTrafficInfoResponse {

    private String status;// 结果状态0,表示失败,1:表示成功
    private String info;// 返回状态说明
    private String infoCode; // 返回信息码
    private TrafficInfo trafficInfo;// 交通态势信息

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infocode) {
        this.infoCode = infoCode;
    }

    public TrafficInfo getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(TrafficInfo trafficInfo) {
        this.trafficInfo = trafficInfo;
    }

    @Override
    public String toString() {
        return "GaoDeTrafficInfoResponse{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", infoCode='" + infoCode + '\'' +
                ", trafficInfo=" + trafficInfo +
                '}';
    }
}