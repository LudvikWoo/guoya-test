package com.guoyasoft.autoUI;

public class AutoBasic {
	public static void sleep(int time) {
		// 先线程休眠3秒，然后才关闭
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
