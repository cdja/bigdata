package com.test.entity;

/**
 * 道路评估实体类
 *
 * @author fanzw
 *
 */
public class Evaluation {

    private String expedite; // 畅通所占百分比
    private String congested; // 缓行所占百分比
    private String blocked; // 拥堵所占百分比
    private String unknown; // 未知路段所占百分比
    private String status; // 路况
    private String description; // 道路描述

    public String getExpedite() {
        return expedite;
    }

    public void setExpedite(String expedite) {
        this.expedite = expedite;
    }

    public String getCongested() {
        return congested;
    }

    public void setCongested(String congested) {
        this.congested = congested;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public String getUnknown() {
        return unknown;
    }

    public void setUnknown(String unknown) {
        this.unknown = unknown;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}