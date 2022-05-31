package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {

    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 30)));
        assertEquals(10, showing.getPrice());
    }

    @Test
    void movieShowingFirstDayWithDollar3Discount(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 2);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 30)));
        assertEquals(9.5d, showing.getPrice());
    }

    @Test
    void movieShowingSecondDayWithDollar2Discount(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 2);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 30)));
        assertEquals(10.5d, showing.getPrice());
    }

    @Test
    void movieShowingSeventhDayWithDollar1Discount(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 2);
        Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 30)));
        assertEquals(11.5d, showing.getPrice());
    }

    @Test
    void movieShowingBetweenSpecialHours(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 2);
        Showing showing = new Showing(spiderMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 30)));
        assertEquals(9.375, showing.getPrice());
    }

    @Test
    void movieShowingWithMultipleDiscountApplicable(){
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        assertEquals(9.375, showing.getPrice());
    }
}