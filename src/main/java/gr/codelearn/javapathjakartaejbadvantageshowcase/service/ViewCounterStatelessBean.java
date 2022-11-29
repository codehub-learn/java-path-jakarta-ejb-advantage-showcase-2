package gr.codelearn.javapathjakartaejbadvantageshowcase.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
public class ViewCounterStatelessBean implements ViewCounter{
    private Integer numberOfViews;

    @PostConstruct
    public void init(){
        numberOfViews = 0;
        log.info("Created class {}", getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy(){
        log.info("Destroying class {}", getClass().getSimpleName());
    }

    @Override
    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    @Override
    public void incrementNumberOfViews() {
        numberOfViews++;
        log.info("Views | {} | incremented to total of {}",getClass().getSimpleName(), numberOfViews);
    }
}
