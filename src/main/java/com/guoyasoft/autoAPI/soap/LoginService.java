package com.guoyasoft.autoAPI.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-20T11:51:53.680+08:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "LoginService",
                  wsdlLocation = "http://127.0.0.1:8080/guoya-medium/LoginPort?wsdl",
                  targetNamespace = "http://soap.guoyasoft.com/")
public class LoginService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap.guoyasoft.com/", "LoginService");
    public final static QName LoginPort = new QName("http://soap.guoyasoft.com/", "LoginPort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:8080/guoya-medium/LoginPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(LoginService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:8080/guoya-medium/LoginPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public LoginService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LoginService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoginService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public LoginService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public LoginService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public LoginService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns LoginDelegate
     */
    @WebEndpoint(name = "LoginPort")
    public LoginDelegate getLoginPort() {
        return super.getPort(LoginPort, LoginDelegate.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoginDelegate
     */
    @WebEndpoint(name = "LoginPort")
    public LoginDelegate getLoginPort(WebServiceFeature... features) {
        return super.getPort(LoginPort, LoginDelegate.class, features);
    }

}