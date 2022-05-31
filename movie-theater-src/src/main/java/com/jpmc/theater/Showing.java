package com.jpmc.theater;

import java.time.LocalDateTime;
import java.util.Objects;

public class Showing {

    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {//Possible discount not applied here
        return movie.getPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    /*public double calculateFee(int audienceCount) {

        return calculateTicketPrice() * audienceCount;
    }*/

    public double getPrice() {
        return movie.getPrice() - getDiscount();
    }

    private double getDiscount() {
        double specialDiscount = 0d, finalDiscount = 0d;
        if (Movie.getMovieCodeSpecial() == movie.getSpecialCode()) {
            specialDiscount = movie.getPrice() * 0.2;  // 20% discount for special movie
        }
        finalDiscount = specialDiscount;

        double sequenceDiscount = 0;
        switch(sequenceOfTheDay){
            case 1 :{
                sequenceDiscount = 3; // $3 discount for 1st show
                break;
            }
            case 2 :{
                sequenceDiscount = 2; // $2 discount for 2nd show
                break;
            }

            case 7:{
                sequenceDiscount = 1; // $1 discount for 7th show
            }
        }
        finalDiscount = Math.max(finalDiscount, sequenceDiscount);

        double showStartTimeDiscount = 0d;
        if(showStartTime.getHour() >=11 && showStartTime.getHour()<=16){
            showStartTimeDiscount = movie.getPrice() * 0.25;
        }
        finalDiscount = Math.max(finalDiscount, showStartTimeDiscount);

        // biggest discount wins
        return finalDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showing showing = (Showing) o;
        return sequenceOfTheDay == showing.sequenceOfTheDay && Objects.equals(movie, showing.movie) && Objects.equals(showStartTime, showing.showStartTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, sequenceOfTheDay, showStartTime);
    }
}