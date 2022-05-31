package com.jpmc.theater;

import java.time.LocalDate;

public class LocalDateProvider {
    private static volatile LocalDateProvider instance = null;
    private LocalDateProvider(){}
    /**
     * @return make sure to return singleton instance
     */
    public static LocalDateProvider singleton() {//Can work in Multithreaded
        if (instance == null) {
            synchronized (LocalDateProvider.class){
                if(instance == null){
                    instance = new LocalDateProvider();
                }
            }
        }
        return instance;
    }

    public LocalDate currentDate() {
            return LocalDate.now();
    }
}