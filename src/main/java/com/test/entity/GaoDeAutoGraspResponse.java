package com.test.entity;

import java.util.List;

/**
 * 抓路服务实体类
 *
 * @author fanzw
 *
 */
public class GaoDeAutoGraspResponse {

	private String status;// 结果状态0,表示失败,1:表示成功
	private String count;// 返回结果的数目
	private String info;// 返回状态说明
	private String infoCode; // 返回信息码
	private List<RoadInfo> gaoDeAutoGrasp;// 抓路服务列表

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
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

	public List<RoadInfo> getGaoDeAutoGrasp() {
		return gaoDeAutoGrasp;
	}

	public void setGaoDeAutoGrasp(List<RoadInfo> gaoDeAutoGrasp) {
		this.gaoDeAutoGrasp = gaoDeAutoGrasp;
	}

}
