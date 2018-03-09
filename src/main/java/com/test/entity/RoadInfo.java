package com.test.entity;

/**
 * 道路信息实体类
 *
 * @author fanzw
 *
 */
public class RoadInfo {

	// 交叉点坐标
	private String crosspoint;
	// 道路名称
	private String roadname;
	// 道路经纬度坐标
	private String ployline;
	// 道路等级
	private String roadlevel;
	// 道路最高限速
	private String maxspeed;
	// 临近路口
	private String intersection;
	// 距离临近路口距离
	private String intersectiondistance;


	public String getCrosspoint() {
		return crosspoint;
	}

	public void setCrosspoint(String crosspoint) {
		this.crosspoint = crosspoint;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getPloyline() {
		return ployline;
	}

	public void setPloyline(String ployline) {
		this.ployline = ployline;
	}

	public String getRoadlevel() {
		return roadlevel;
	}

	public void setRoadlevel(String roadlevel) {
		this.roadlevel = roadlevel;
	}

	public String getMaxspeed() {
		return maxspeed;
	}

	public void setMaxspeed(String maxspeed) {
		this.maxspeed = maxspeed;
	}

	public String getIntersection() {
		return intersection;
	}

	public void setIntersection(String intersection) {
		this.intersection = intersection;
	}

	public String getIntersectiondistance() {
		return intersectiondistance;
	}

	public void setIntersectiondistance(String intersectiondistance) {
		this.intersectiondistance = intersectiondistance;
	}

}