package gr.codelearn.javapathjakartaejbadvantageshowcase.resource;

import gr.codelearn.javapathjakartaejbadvantageshowcase.service.ViewCounter;
import gr.codelearn.javapathjakartaejbadvantageshowcase.service.ViewCounterStatefulBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Path("/stateful")
@Slf4j
@SessionScoped
public class StatefulResource implements Serializable {
    @EJB(beanName = "ViewCounterStatefulBean")
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
