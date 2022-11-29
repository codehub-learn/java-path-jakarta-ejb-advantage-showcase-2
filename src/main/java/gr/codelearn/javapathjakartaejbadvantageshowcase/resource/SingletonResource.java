package gr.codelearn.javapathjakartaejbadvantageshowcase.resource;

import gr.codelearn.javapathjakartaejbadvantageshowcase.service.ViewCounter;
import gr.codelearn.javapathjakartaejbadvantageshowcase.service.ViewCounterSingletonBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/singleton")
public class SingletonResource {
    @EJB(beanName = "ViewCounterSingletonBean")
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
}
