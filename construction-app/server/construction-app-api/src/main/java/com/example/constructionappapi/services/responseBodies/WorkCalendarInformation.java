package com.example.constructionappapi.services.responseBodies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkCalendarInformation {
    private long customerId;
    private String customerName;
    private String workName;
    private LocalDate date;
}
