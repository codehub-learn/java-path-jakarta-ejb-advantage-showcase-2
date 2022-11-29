package gr.codelearn.javapathjakartaejbadvantageshowcase.service;

import jakarta.ejb.Remote;

@Remote
public interface ViewCounter {
    Integer getNumberOfViews();
    void incrementNumberOfViews();
}
