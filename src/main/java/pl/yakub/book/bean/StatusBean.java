package pl.yakub.book.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StatusBean {

    private final String message;

    public LocalDate getLocalDate(){
        return LocalDate.now();
    }
}


