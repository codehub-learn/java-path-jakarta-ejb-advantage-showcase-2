package gr.codelearn.javapathjakartaejbadvantageshowcase.service;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Startup
@Slf4j
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ViewCounterSingletonBean implements  ViewCounter{
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
    @Lock(LockType.READ)
    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    @Override
    @Lock(LockType.WRITE)
    public void incrementNumberOfViews() {
        numberOfViews++;
        log.info("Views | {} | incremented to total of {}",getClass().getSimpleName(), numberOfViews);
    }
}
