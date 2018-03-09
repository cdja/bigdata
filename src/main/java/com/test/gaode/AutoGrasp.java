package com.test.gaode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.util.OKHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.entity.RoadInfo;
import com.test.entity.GaoDeAutoGraspResponse;
import com.test.entity.AutoGraspRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 抓路服务
 *
 * @author cp
 *
 */
public class AutoGrasp {

	// 日志处理
	private static final Logger logger = LoggerFactory.getLogger(AutoGrasp.class);

	// TODO 之后提取到配置文件中
	// 高德应用API调用key
	private static String gaodeKeyID = "327ea05dbf7a2b5408e93d06cc4fdea5";

	// 抓路服务地址
	private static String autograsp_url = "http://restapi.amap.com/v3/autograsp?parameters";

	/*
	 * static { Properties properties = new Properties(); try { gaodeAppID =
	 * properties.getProperty("appkey"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	/**
	 * 输入地址抓路服务的信息
	 *
	 * @param requestParams
	 * @param url
	 *
	 * @return 返回的类gaoDeAutoGrasp
	 */
	public GaoDeAutoGraspResponse autoGrasp(AutoGraspRequest requestParams, String url) {
		GaoDeAutoGraspResponse gaoDeAutoGraspResponse = null;
		RoadInfo roadInfo = null;
		List<RoadInfo> roadInfos = null;
		// 参数校验
		if (!requestParams.getKey().isEmpty() && !requestParams.getCarid().isEmpty() && !requestParams.getDirection().isEmpty()
				&& !requestParams.getLocations().isEmpty() && !requestParams.getSpeed().isEmpty() && !requestParams.getTime().isEmpty()) {
			try {
				gaoDeAutoGraspResponse = new GaoDeAutoGraspResponse();

				String params = "key=" + requestParams.getKey() +"&carid=" + requestParams.getCarid() +
						"&locations=" + requestParams.getLocations() + "&time=" + requestParams.getTime() +
						"&direction=" + requestParams.getDirection() +
						"&speed=" + requestParams.getSpeed();

				logger.info("高德地图params:" + params);
				String result = OKHttpUtil.httpPost(url.replace("parameters", ""), params);

				logger.info("高德地图返回结果:" + result);
				JSONObject jsonObject = JSONObject.parseObject(result);

				// 解析json
				gaoDeAutoGraspResponse.setStatus(jsonObject.getString("status"));
				gaoDeAutoGraspResponse.setInfo(jsonObject.getString("info"));
				gaoDeAutoGraspResponse.setCount(jsonObject.getString("count"));
				roadInfos = new ArrayList<RoadInfo>();
				JSONArray jsonArray = jsonObject.getJSONArray("roads");
				// 遍历解析出来的结果
				if (jsonArray != null && jsonArray.size() > 0) {
					for (int i=0; i<jsonArray.size();i++) {
						JSONObject jo = (JSONObject) jsonArray.get(i);
						roadInfo = new RoadInfo();
						roadInfo.setCrosspoint(jo.getString("crosspoint"));
						roadInfo.setRoadname(jo.getString("roadname"));
						roadInfo.setPloyline(jo.getString("ployline"));
						roadInfo.setRoadlevel(jo.getString("roadlevel"));
						roadInfo.setMaxspeed(jo.getString("maxspeed"));
						roadInfo.setIntersection(jo.getString("intersection"));
						roadInfo.setIntersectiondistance(jo.getString("intersectiondistance"));
						roadInfos.add(roadInfo);
					}
					gaoDeAutoGraspResponse.setGaoDeAutoGrasp(roadInfos);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return gaoDeAutoGraspResponse;
	}

	public static void main(String[] args) {
		AutoGraspRequest requestParams = new AutoGraspRequest();
		// 参数设置
		// key=您的key&carid=abcd123456&locations=116.496167,39.917066|116.496149,39.917205|116.496149,39.917326&time=1434077500,1434077501,1434077510&direction=1,1,2&speed=1,1,2
		requestParams.setKey(gaodeKeyID);
		requestParams.setCarid("abcd123456");
		requestParams.setLocations("116.496167,39.917066|116.496149,39.917205|116.496149,39.917326");
		requestParams.setTime("1434077500,1434077501,1434077510");
		requestParams.setDirection("1,1,2");
		requestParams.setSpeed("1,1,2");

		AutoGrasp autoGrasp = new AutoGrasp();
		GaoDeAutoGraspResponse result = autoGrasp.autoGrasp(requestParams, autograsp_url);
		System.out.println(JSON.toJSONString(result));
	}
}
