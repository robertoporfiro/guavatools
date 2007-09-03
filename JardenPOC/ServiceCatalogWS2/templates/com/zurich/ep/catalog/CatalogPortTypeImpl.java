package com.zurich.ep.catalog;

import javax.jws.WebService;
import weblogic.jws.*;

/**
 * CatalogPortTypeImpl class implements web service endpoint interface CatalogPortType */

@WebService(
  serviceName="CatalogService",
  targetNamespace="http://www.zurich.com/ep/catalog",
  endpointInterface="com.zurich.ep.catalog.CatalogPortType")
@WLHttpTransport(contextPath="ServiceCatalogWS2",serviceUri="ServiceCatalogWSImpl",portName="ServiceCatalogWSSoapPort")
public class CatalogPortTypeImpl implements CatalogPortType {
 
  public CatalogPortTypeImpl() {
  
  }

  public com.zurich.ep.catalog.PackageBeans getPackageHierarchy(java.lang.String packageName) 
     
  {
    //replace with your impl here
     return null;     
  }

  public com.zurich.ep.catalog.PackageBeans getMemberPackages(java.lang.String packageName) 
     
  {
    //replace with your impl here
     return null;     
  }

  public com.zurich.ep.catalog.ServiceBean getService(java.lang.String serviceName) 
     
  {
    //replace with your impl here
     return null;     
  }

  public com.zurich.ep.catalog.ServiceBeans getMemberServices(java.lang.String packageName) 
     
  {
    //replace with your impl here
     return null;     
  }

  public java.lang.String reloadCatalog() 
     
  {
    //replace with your impl here
     return null;     
  }
}  