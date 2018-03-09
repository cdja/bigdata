package com.test.entity;

/**
 * 道路评估实体类
 *
 * @author fanzw
 *
 */
public class TrafficInfo {

    private String description; // 路况综述
    private Evaluation evaluation; // 路况评价

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

}