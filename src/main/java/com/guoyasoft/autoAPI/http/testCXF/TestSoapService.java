package com.guoyasoft.autoAPI.http.testCXF;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-07-29T11:31:43.678+08:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "TestSoapService",
                  wsdlLocation = "http://127.0.0.1:8080/guoya-test/TestSoapPort?wsdl",
                  targetNamespace = "http://soap.topic.guoyasoft.com/")
public class TestSoapService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.topic.guoyasoft.com/", "TestSoapService");
    public final static QName TestSoapPort = new QName("http://soap.topic.guoyasoft.com/", "TestSoapPort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:8080/guoya-test/TestSoapPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TestSoapService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:8080/guoya-test/TestSoapPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TestSoapService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TestSoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestSoapService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TestSoapService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TestSoapService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TestSoapService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TestSoapDelegate
     */
    @WebEndpoint(name = "TestSoapPort")
    public TestSoapDelegate getTestSoapPort() {
        return super.getPort(TestSoapPort, TestSoapDelegate.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestSoapDelegate
     */
    @WebEndpoint(name = "TestSoapPort")
    public TestSoapDelegate getTestSoapPort(WebServiceFeature... features) {
        return super.getPort(TestSoapPort, TestSoapDelegate.class, features);
    }

}
