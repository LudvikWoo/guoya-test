# encoding:utf-8
import requests


def get_json(u, i):
    url = " http://business.9daye.com.cn/leader/custom/area"

    form_data = {"account": u,
                 "area_id": i,
                 }
    HEADERS = {
        # User-Agent(UA) 服务器能够识别客户使用的操作系统及版本、CPU 类型、浏览器及版本、浏览器渲染引擎、浏览器语言、浏览器插件等。也就是说伪装成浏览器进行访问
        "User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36",
        # 用于告诉服务器我是从哪个页面链接过来的，服务器基此可以获得一些信息用于处理。如果不加入，服务器可能依旧会判断为非法请求
        "Referer": "http://business.9daye.com.cn/leader/custom?account=u&type=account&search=u&page=1"
    }

    # COOKIES = dict(name="advanced-business", value="o0jelept0arc185ednm1h7ifj5")
    jar = requests.cookies.RequestsCookieJar()
    jar.set("advanced-business", "chcdd5e6jrrdfri0cd39qtvlh4", domain="business.9daye.com.cn")
    res = requests.post(url=url, headers=HEADERS, cookies=jar, data=form_data)
    print res.text


index = 0
for n in ['447634764', '611790438', '789119195', '712467657', '268085802', '960698244', '468621178', '743194483', '350331721', '116883164', '778878592', '619489505', '141396204', '638538662', '218456869', '463262864', '191244601', '312550948', '693523720', '356827855', '216038232', '620358923', '769456567', '370679997', '821397666', '196744556', '854913595', '877818735', '895939126', '171073585', '400007870', '425259259', '370229224', '992627829', '394473850']:
    a = "5667"
    index += 1
    get_json(n, a)
    print n + ',录入了:' + str(index)