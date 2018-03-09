package com.test.gaode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.entity.Evaluation;
import com.test.entity.GaoDeTrafficInfoResponse;
import com.test.entity.RectangleTrafficInfoRequest;
import com.test.entity.TrafficInfo;
import com.test.util.OKHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 矩形区域交通态势
 *
 * @author cp
 *
 */
public class RectangleTrafficInfo {

	// 日志处理
	private static final Logger logger = LoggerFactory.getLogger(RectangleTrafficInfo.class);

	// TODO 之后提取到配置文件中
	// 高德应用API调用key
	private static String gaodeKeyID = "327ea05dbf7a2b5408e93d06cc4fdea5";

	// 矩形区域交通态势地址
	private static String rectangleTrafficInfo_url = "http://restapi.amap.com/v3/traffic/status/rectangle?parameters";

	/*
	 * static { Properties properties = new Properties(); try { gaodeAppID =
	 * properties.getProperty("appkey"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	/**
	 * 输入矩形区域交通态势的信息
	 *
	 * @param requestParams
	 * @param url
	 *
	 * @return 返回的类rectangleTrafficInfo
	 */
	public GaoDeTrafficInfoResponse rectangleTrafficInfo(RectangleTrafficInfoRequest requestParams, String url) {
		GaoDeTrafficInfoResponse gaoDeTrafficInfoResponse = null;
		Evaluation evaluation = null;
		TrafficInfo trafficInfo = null;
		// 参数校验
		if (!requestParams.getKey().isEmpty() && !requestParams.getRectangle().isEmpty()) {
			try {
				gaoDeTrafficInfoResponse = new GaoDeTrafficInfoResponse();
				String params = "key=" + requestParams.getKey() +"&rectangle=" + requestParams.getRectangle();

				logger.info("高德地图params:" + params);
				String result = OKHttpUtil.httpPost(url.replace("parameters", ""), params);

				logger.info("高德地图返回结果:" + result);
				JSONObject jsonObject = JSONObject.parseObject(result);

				// 解析json
				gaoDeTrafficInfoResponse.setStatus(jsonObject.getString("status"));
				gaoDeTrafficInfoResponse.setInfo(jsonObject.getString("info"));
				gaoDeTrafficInfoResponse.setInfoCode(jsonObject.getString("infocode"));

				JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.getString("trafficinfo"));

				trafficInfo = new TrafficInfo();
				trafficInfo.setDescription(jsonObject1.get("description").toString());
				JSONObject jsonArray = (JSONObject)jsonObject1.get("evaluation");

				// 遍历解析出来的结果
				if (jsonArray != null && jsonArray.size() > 0) {
					evaluation = new Evaluation();
					evaluation.setExpedite(jsonArray.getString("expedite"));
					evaluation.setCongested(jsonArray.getString("congested"));
					evaluation.setBlocked(jsonArray.getString("blocked"));
					evaluation.setUnknown(jsonArray.getString("unknown"));
					evaluation.setStatus(jsonArray.getString("status"));
					evaluation.setDescription(jsonArray.getString("description"));

					trafficInfo.setEvaluation(evaluation);
					gaoDeTrafficInfoResponse.setTrafficInfo(trafficInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return gaoDeTrafficInfoResponse;
	}

	public static void main(String[] args) {
		RectangleTrafficInfoRequest requestParams = new RectangleTrafficInfoRequest();
		// 参数设置
		// key=您的key&rectangle=116.351147,39.966309;116.357134,39.968727
		requestParams.setKey(gaodeKeyID);
		requestParams.setRectangle("116.351147,39.966309;116.357134,39.968727");

		RectangleTrafficInfo autoGrasp = new RectangleTrafficInfo();
		GaoDeTrafficInfoResponse result = autoGrasp.rectangleTrafficInfo(requestParams, rectangleTrafficInfo_url);
		System.out.println(JSON.toJSONString(result));
	}
}
