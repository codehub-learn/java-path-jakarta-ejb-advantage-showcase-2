package gr.codelearn.javapathjakartaejbadvantageshowcase.resource;

import gr.codelearn.javapathjakartaejbadvantageshowcase.service.ViewCounter;
import gr.codelearn.javapathjakartaejbadvantageshowcase.service.ViewCounterStatelessBean;
import gr.codelearn.javapathjakartaejbadvantageshowcase.util.JNDILookup;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/stateless")
public class StatelessResource {

    @EJB
    ViewCounter viewCounter;

    @GET
    @Produces("text/plain")
    @Path("/views")
    public String getTotalNumberOfViews(){
        return "Total views: " + viewCounter.getNumberOfViews();
    }

    @GET
    @Produces("text/plain")
    @Path("/increment")
    public String incrementViews(){
        viewCounter.incrementNumberOfViews();
        return "Views incremented!";
    }

   /* @GET
    @Produces("text/plain")
    @Path("/views-context")
    public String getTotalNumberOfViewsContext(){
        ViewCounter viewsCounterContext = (ViewCounter) JNDILookup.beanInvocation(
                ViewCounterStatelessBean.class.getSimpleName(),ViewCounter.class.getName()
        );
        viewsCounterContext.incrementNumberOfViews();
        return "Total views with context: " + viewsCounterContext.getNumberOfViews();
    }*/
}
