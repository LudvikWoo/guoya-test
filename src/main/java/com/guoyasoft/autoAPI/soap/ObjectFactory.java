
package com.guoyasoft.autoAPI.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.guoyasoft.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckUser_QNAME = new QName("http://soap.guoyasoft.com/", "checkUser");
    private final static QName _CheckUserResponse_QNAME = new QName("http://soap.guoyasoft.com/", "checkUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.guoyasoft.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckUser }
     * 
     */
    public CheckUser createCheckUser() {
        return new CheckUser();
    }

    /**
     * Create an instance of {@link CheckUserResponse }
     * 
     */
    public CheckUserResponse createCheckUserResponse() {
        return new CheckUserResponse();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.guoyasoft.com/", name = "checkUser")
    public JAXBElement<CheckUser> createCheckUser(CheckUser value) {
        return new JAXBElement<CheckUser>(_CheckUser_QNAME, CheckUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.guoyasoft.com/", name = "checkUserResponse")
    public JAXBElement<CheckUserResponse> createCheckUserResponse(CheckUserResponse value) {
        return new JAXBElement<CheckUserResponse>(_CheckUserResponse_QNAME, CheckUserResponse.class, null, value);
    }

}
