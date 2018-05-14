package com.guoyasoft.autoAPI;

import java.net.HttpURLConnection;

import javax.swing.RepaintManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guoyasoft.topic.interfaces.HttpClient;

public class PangZi {
	

	public void ali(){
		String[] accounts={"447634764", "611790438", "789119195", "712467657", "268085802", "960698244", "468621178", "743194483", "350331721", "116883164", "778878592", "619489505", "141396204", "638538662", "218456869", "463262864", "191244601", "312550948", "693523720", "356827855", "216038232", "620358923", "769456567", "370679997", "821397666", "196744556", "854913595", "877818735", "895939126", "171073585", "400007870", "425259259", "370229224", "992627829", "394473850"};
		String areaId="5667";
		for(int i=0;i<accounts.length;i++){
			String account=accounts[i];
			try {
				sendPost(account, areaId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(account+",录入了:"+i);
		}
	}
	
	@Test(dataProvider="accounts")
	public void sendPost(String account,String areaId) throws Exception{
		String url="http://business.9daye.com.cn/leader/custom/area";
		String formJson="{\"account\": "+account+", \"area_id\": "+areaId+"}";
		
		HttpURLConnection conn=HttpClient.getHttpUrlConnection(url);
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36");
		conn.setRequestProperty("Referer", "http://business.9daye.com.cn/leader/custom?account=u&type=account&search=u&page=1");
		
		conn.setRequestProperty("Cookie", "advanced-business=chcdd5e6jrrdfri0cd39qtvlh4"); 
		
		String response=HttpClient.post(6000, conn, formJson, "UTF-8");
		System.out.println(response);
	}
	
	@DataProvider(name="accounts")
	public Object[][] getAccounts(){
			String[] strs={"447634764", "611790438", "789119195", "712467657", "268085802", "960698244", "468621178", "743194483", "350331721", "116883164", "778878592", "619489505", "141396204", "638538662", "218456869", "463262864", "191244601", "312550948", "693523720", "356827855", "216038232", "620358923", "769456567", "370679997", "821397666", "196744556", "854913595", "877818735", "895939126", "171073585", "400007870", "425259259", "370229224", "992627829", "394473850"};
			Object[][] objs=new Object[strs.length][2];
			for(int i=0;i<strs.length;i++){
				objs[i][0]=strs[i];
				objs[i][1]="5667";
			}
			return objs;
	}
	
}
