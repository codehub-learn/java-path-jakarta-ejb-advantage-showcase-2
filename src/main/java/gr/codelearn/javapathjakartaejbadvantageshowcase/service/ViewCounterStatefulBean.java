package gr.codelearn.javapathjakartaejbadvantageshowcase.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateful
public class ViewCounterStatefulBean implements ViewCounter{
    private Integer numberOfViews;

    @PostConstruct
    public void init(){
        numberOfViews = 0;
        log.info("Created class {}", getClass().getSimpleName());
    }

    @PostActivate
    public void postActivate(){
        log.info("Post activate class {}", getClass().getSimpleName());
    }

    @PrePassivate
    public void prePassivate(){
        log.info("Pre passivate class {}", getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy(){
        log.info("Destroy class {}", getClass().getSimpleName());
    }

    @Override
    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    @Override
//    @Remove
    public void incrementNumberOfViews() {
        numberOfViews++;
        log.info("Views | {} | incremented to total of {}",getClass().getSimpleName(), numberOfViews);
    }

}
