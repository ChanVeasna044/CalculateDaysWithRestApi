package com.veasna.calculate.api;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


@RestController
@RequestMapping("/api/v1")
public class CalculateDaysController {

    @GetMapping("/dateDifference")
    public String calculateDateDifference(
            @RequestParam("date1") String dateStr1,
            @RequestParam("date2") String dateStr2
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date1 = LocalDate.parse(dateStr1, formatter);
            LocalDate date2 = LocalDate.parse(dateStr2, formatter);
            long daysDifference = ChronoUnit.DAYS.between(date1, date2);
            return "Difference in days: " + daysDifference + " days";
        } catch (Exception e) {
            return "Invalid date format. Please use dd-MM-yyyy format.";
        }
    }

}
