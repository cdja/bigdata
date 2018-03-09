package com.test.entity;

/**
 * 抓路服务请求参数实体类
 *
 * @author fanzw
 *
 */
public class AutoGraspRequest {

    private String key; // 用户唯一标识
    private String carid; // 车辆唯一标识
    private String locations; // 经纬度
    private String time; // gps时间
    private String direction; // 行驶方向
    private String speed; // 行驶速度

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "AutoGraspRequest{" +
                "key='" + key + '\'' +
                ", carid='" + carid + '\'' +
                ", locations='" + locations + '\'' +
                ", time='" + time + '\'' +
                ", direction='" + direction + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }

}