package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {
	@Test
    void makeSureSingleInstance() {
        LocalDateProvider localDateProvider = LocalDateProvider.singleton();
        for(int i=0; i<10; i++){
            assertTrue(LocalDateProvider.singleton() == localDateProvider);
        }
    }
}
