package gr.codelearn.javapathjakartaejbadvantageshowcase.service;


import jakarta.ejb.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
public class TimerServiceBean {
    private Integer timerCounter = 0;

    @Schedule(
            hour = "*", minute = "*", second = "*/30", info = "This is an automatic timer"
    )
    public void automaticTimer(Timer timer){
        timerCounter++;
        log.info("Timer counter is: {}",timerCounter );
        log.info("Next timeout: " + timer.getNextTimeout());

        if (timerCounter > 2 ){
            timer.cancel();
        }
    }
}
