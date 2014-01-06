package com.tmg.fuse.poc;

import javax.xml.ws.Endpoint;

/**
 * A bean to start and stop the real webservice.
 * <p/>
 * This implementation uses pure JAX-WS (no CXF, no Camel).
 *
 * @version 
 */
public class RealCRMWebServiceBean {

    // should be the same address as we have in our route
    private String url;

    private AccountEndpointService service = new AccountEndpointService();
    private Endpoint endpoint;

    public void start() throws Exception {
        System.out.println("Starting real web service...");
        endpoint = Endpoint.publish(url, service);
        System.out.println("Started real web service at: " + url);
    }

    public void stop() throws Exception {
        if (endpoint != null) {
            System.out.println("Stopping real webservice...");
            endpoint.stop();
            System.out.println("Stopped real webservice.");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}