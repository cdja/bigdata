package com.test.entity;

/**
 * 采样后的数据参数实体类
 *
 * @author fanzw
 *
 */
public class SampleRetInfoOject {

    private String device_id; // 车载adas设备id
    private String driver_id; // 驾驶员id
    private String trip_id; // 行程ID
    private String timestamp; // 时间戳（在端上采集数据的时间戳）
    private String server_time; // 服务端时间戳
    private String event_id_list; // 事件类型编码
    private String speed; // GPS速度
    private String longitude; // 经度
    private String latitude; // 纬度
    private String alt; // 海拔
    private String x_axis_acceleration; // X轴加速度
    private String y_axis_acceleration; // Y轴加速度
    private String z_axis_acceleration; // Z轴加速度
    private String x_axis_angular_velocity; // X轴角速度
    private String y_axis_angular_velocity; // Y轴角速度
    private String z_axis_angular_velocity; // Z轴角速度
    private String front_vehicle_num; // 前方被识别的车辆目标数
    private String key_target_id; // 关键目标ID
    private String key_target_code; // 关键目标类型编码
    private String key_target_relative_distance; // 关键目标相对距离
    private String key_target_absolute_speed; // 关键目标绝对速度
    private String key_target_relative_speed; // 关键目标相对速度
    private String target_collision_time; // 目标碰撞时间（秒）
    private String total_lanes_num; // 总车道数
    private String target_lane_info_code; // 目标车道信息编码（虚实、黄白、单双）
    private String vehicle_center_to_leftLane; // 车辆中心距离左车道距离
    private String vehicle_center_to_rightLane; // 车辆中心距离右车道距离
    private String vehicle_relative_rightLane_speed; // 车辆相对右车道的偏离速度

    public SampleRetInfoOject(){}

    public SampleRetInfoOject(String device_id, String driver_id, String trip_id, String timestamp, String server_time,
                              String event_id_list, String speed, String longitude, String latitude, String alt){
        this.device_id = device_id;
        this.driver_id = driver_id;
        this.trip_id = trip_id;
        this.timestamp = timestamp;
        this.server_time = server_time;
        this.event_id_list = event_id_list;
        this.speed = speed;
        this.longitude = longitude;
        this.latitude = latitude;
        this.alt = alt;
    }

    public SampleRetInfoOject(String device_id, String driver_id, String trip_id, String timestamp, String server_time,
                              String event_id_list, String speed, String longitude, String latitude, String alt,
                              String x_axis_acceleration, String y_axis_acceleration, String z_axis_acceleration,
                              String x_axis_angular_velocity, String y_axis_angular_velocity, String z_axis_angular_velocity,
                              String front_vehicle_num, String key_target_id, String key_target_code, String key_target_relative_distance,
                              String key_target_absolute_speed, String key_target_relative_speed, String target_collision_time,
                              String total_lanes_num, String target_lane_info_code, String vehicle_center_to_leftLane,
                              String vehicle_center_to_rightLane, String vehicle_relative_rightLane_speed) {
        this.device_id = device_id;
        this.driver_id = driver_id;
        this.trip_id = trip_id;
        this.timestamp = timestamp;
        this.server_time = server_time;
        this.event_id_list = event_id_list;
        this.speed = speed;
        this.longitude = longitude;
        this.latitude = latitude;
        this.alt = alt;
        this.x_axis_acceleration = x_axis_acceleration;
        this.y_axis_acceleration = y_axis_acceleration;
        this.z_axis_acceleration = z_axis_acceleration;
        this.x_axis_angular_velocity = x_axis_angular_velocity;
        this.y_axis_angular_velocity = y_axis_angular_velocity;
        this.z_axis_angular_velocity = z_axis_angular_velocity;
        this.front_vehicle_num = front_vehicle_num;
        this.key_target_id = key_target_id;
        this.key_target_code = key_target_code;
        this.key_target_relative_distance = key_target_relative_distance;
        this.key_target_absolute_speed = key_target_absolute_speed;
        this.key_target_relative_speed = key_target_relative_speed;
        this.target_collision_time = target_collision_time;
        this.total_lanes_num = total_lanes_num;
        this.target_lane_info_code = target_lane_info_code;
        this.vehicle_center_to_leftLane = vehicle_center_to_leftLane;
        this.vehicle_center_to_rightLane = vehicle_center_to_rightLane;
        this.vehicle_relative_rightLane_speed = vehicle_relative_rightLane_speed;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getServer_time() {
        return server_time;
    }

    public void setServer_time(String server_time) {
        this.server_time = server_time;
    }

    public String getEvent_id_list() {
        return event_id_list;
    }

    public void setEvent_id_list(String event_id_list) {
        this.event_id_list = event_id_list;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getX_axis_acceleration() {
        return x_axis_acceleration;
    }

    public void setX_axis_acceleration(String x_axis_acceleration) {
        this.x_axis_acceleration = x_axis_acceleration;
    }

    public String getY_axis_acceleration() {
        return y_axis_acceleration;
    }

    public void setY_axis_acceleration(String y_axis_acceleration) {
        this.y_axis_acceleration = y_axis_acceleration;
    }

    public String getZ_axis_acceleration() {
        return z_axis_acceleration;
    }

    public void setZ_axis_acceleration(String z_axis_acceleration) {
        this.z_axis_acceleration = z_axis_acceleration;
    }

    public String getX_axis_angular_velocity() {
        return x_axis_angular_velocity;
    }

    public void setX_axis_angular_velocity(String x_axis_angular_velocity) {
        this.x_axis_angular_velocity = x_axis_angular_velocity;
    }

    public String getY_axis_angular_velocity() {
        return y_axis_angular_velocity;
    }

    public void setY_axis_angular_velocity(String y_axis_angular_velocity) {
        this.y_axis_angular_velocity = y_axis_angular_velocity;
    }

    public String getZ_axis_angular_velocity() {
        return z_axis_angular_velocity;
    }

    public void setZ_axis_angular_velocity(String z_axis_angular_velocity) {
        this.z_axis_angular_velocity = z_axis_angular_velocity;
    }

    public String getFront_vehicle_num() {
        return front_vehicle_num;
    }

    public void setFront_vehicle_num(String front_vehicle_num) {
        this.front_vehicle_num = front_vehicle_num;
    }

    public String getKey_target_id() {
        return key_target_id;
    }

    public void setKey_target_id(String key_target_id) {
        this.key_target_id = key_target_id;
    }

    public String getKey_target_code() {
        return key_target_code;
    }

    public void setKey_target_code(String key_target_code) {
        this.key_target_code = key_target_code;
    }

    public String getKey_target_relative_distance() {
        return key_target_relative_distance;
    }

    public void setKey_target_relative_distance(String key_target_relative_distance) {
        this.key_target_relative_distance = key_target_relative_distance;
    }

    public String getKey_target_absolute_speed() {
        return key_target_absolute_speed;
    }

    public void setKey_target_absolute_speed(String key_target_absolute_speed) {
        this.key_target_absolute_speed = key_target_absolute_speed;
    }

    public String getKey_target_relative_speed() {
        return key_target_relative_speed;
    }

    public void setKey_target_relative_speed(String key_target_relative_speed) {
        this.key_target_relative_speed = key_target_relative_speed;
    }

    public String getTarget_collision_time() {
        return target_collision_time;
    }

    public void setTarget_collision_time(String target_collision_time) {
        this.target_collision_time = target_collision_time;
    }

    public String getTotal_lanes_num() {
        return total_lanes_num;
    }

    public void setTotal_lanes_num(String total_lanes_num) {
        this.total_lanes_num = total_lanes_num;
    }

    public String getTarget_lane_info_code() {
        return target_lane_info_code;
    }

    public void setTarget_lane_info_code(String target_lane_info_code) {
        this.target_lane_info_code = target_lane_info_code;
    }

    public String getVehicle_center_to_leftLane() {
        return vehicle_center_to_leftLane;
    }

    public void setVehicle_center_to_leftLane(String vehicle_center_to_leftLane) {
        this.vehicle_center_to_leftLane = vehicle_center_to_leftLane;
    }

    public String getVehicle_center_to_rightLane() {
        return vehicle_center_to_rightLane;
    }

    public void setVehicle_center_to_rightLane(String vehicle_center_to_rightLane) {
        this.vehicle_center_to_rightLane = vehicle_center_to_rightLane;
    }

    public String getVehicle_relative_rightLane_speed() {
        return vehicle_relative_rightLane_speed;
    }

    public void setVehicle_relative_rightLane_speed(String vehicle_relative_rightLane_speed) {
        this.vehicle_relative_rightLane_speed = vehicle_relative_rightLane_speed;
    }

}