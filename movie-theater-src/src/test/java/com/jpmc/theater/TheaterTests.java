package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(), 37.5);
    }

    @Test
    void testMovieScheduleJSON(){
        Theater theater = new Theater(LocalDateProvider.singleton());
        assertNotNull(theater.getScheduleJSON());
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }

    @Test
    void unknownShowingException(){
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        IllegalStateException thrown = assertThrows(IllegalStateException.class, ()-> theater.reserve(john, 0, 4));
        assertTrue(thrown.getMessage().contains("Not able to find any showing for given sequence"));
    }

    @Test
    void duplicateReservationException(){
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertNotNull(reservation);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, ()-> theater.reserve(john, 2, 4));
        assertTrue(thrown.getMessage().contains("Duplicate Booking"));
    }
}