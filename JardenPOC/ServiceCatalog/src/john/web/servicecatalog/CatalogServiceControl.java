package john.web.servicecatalog;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"http://10.160.2.94:7021/ServiceCatalogWS2/ServiceCatalogWSImpl"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/web/servicecatalog/CatalogService.wsdl", service = "CatalogService")
@ControlExtension
public interface CatalogServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public com.zurich.ep.catalog.PackageBean[] getMemberPackages(java.lang.String packageName_arg);

    public com.zurich.ep.catalog.ServiceBean[] getMemberServices(java.lang.String packageName_arg);

    public com.zurich.ep.catalog.PackageBean[] getPackageHierarchy(java.lang.String packageName_arg);

    public com.zurich.ep.catalog.ServiceBean getService(java.lang.String serviceName_arg);

    public java.lang.String reloadCatalog();

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}