package com.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;
/**
* REST service to manipulate Karaf features
*/
@Path("/")
public interface FeaturesRestService {
  /**
  * Returns an explicit collection of all features in XML format in response to HTTP GET requests.
  * @return the collection of features
  */
  @GET
  @Path("/clientes")
  @Produces("application/xml")
  public Collection getFeatures() throws Exception;
}