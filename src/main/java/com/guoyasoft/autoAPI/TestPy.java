package com.guoyasoft.autoAPI;

import java.net.HttpURLConnection;

import com.guoyasoft.topic.interfaces.HttpClient;

public class TestPy {
	public void m1() {
		try {
			String[] array = { "447634764", "611790438", "789119195",
					"712467657", "268085802", "960698244", "468621178",
					"743194483", "350331721", "116883164", "778878592",
					"619489505", "141396204", "638538662", "218456869",
					"463262864", "191244601", "312550948", "693523720",
					"356827855", "216038232", "620358923", "769456567",
					"370679997", "821397666", "196744556", "854913595",
					"877818735", "895939126", "171073585", "400007870",
					"425259259", "370229224", "992627829", "394473850" };
			String url = " http://business.9daye.com.cn/leader/custom/area";
			for (int i = 0; i < array.length; i++) {
				String u = array[i];
				HttpURLConnection connection = HttpClient
						.getHttpUrlConnection(url);
				connection
						.setRequestProperty(
								"User-Agent",
								"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36");
				connection
						.setRequestProperty(
								"Referer",
								"http://business.9daye.com.cn/leader/custom?account=u&type=account&search=u&page=1");
				String body = "form_data = {\"account\": " + u
						+ ", \"area_id\":" + i + " }";
				String response = HttpClient.post(3000, connection, body,
						"UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
