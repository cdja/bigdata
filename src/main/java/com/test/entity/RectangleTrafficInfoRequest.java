package com.test.entity;

/**
 * 矩形区域交通态势请求参数实体类
 *
 * @author fanzw
 *
 */
public class RectangleTrafficInfoRequest {

    private String key; // 请求服务权限标识	必填
    private String level; // 道路等级	可选
    private String extensions; // 返回结果控制	可选
    private String sig; // 数字签名	可选
    private String output; // 返回数据格式类型	可选
    private String callback; // 回调函数	可选
    private String rectangle; // 代表此为矩形区域查询	必填

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExtensions() {
        return extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getRectangle() {
        return rectangle;
    }

    public void setRectangle(String rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public String toString() {
        return "RectangleTrafficInfoRequest{" +
                "key='" + key + '\'' +
                ", level='" + level + '\'' +
                ", extensions='" + extensions + '\'' +
                ", sig='" + sig + '\'' +
                ", output='" + output + '\'' +
                ", callback='" + callback + '\'' +
                ", rectangle='" + rectangle + '\'' +
                '}';
    }
}