package com.web.service.impl;

import org.apache.karaf.features.Feature;
import org.apache.karaf.features.FeaturesService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.web.service.FeaturesRestService;
/**
* Implementation of the Features REST service.
*/
public class FeaturesRestServiceImpl implements FeaturesRestService {
  private FeaturesService featuresService;
  public FeaturesService getFeaturesService() {
    return this.featuresService;
  }
  public void setFeaturesService(FeaturesService featuresService) {
    this.featuresService = featuresService;
  }
  
  public Collection getFeatures() throws Exception {
    List featuresWrapper = new ArrayList();
    Feature[] features = featuresService.listFeatures();
    for (int i = 0; i < features.length; i++) {
      System.out.println("Name: "+features[i].getName());
      //FeatureWrapper wrapper = new FeatureWrapper(features[i].getName(), features[i].getVersion());
      //featuresWrapper.add(wrapper);
    }
    return featuresWrapper;
  }
}
