package org.maktab.Part2MaktabFinalProject.entity.exceptions;

public class WrongPriceEntered extends RuntimeException{
    public WrongPriceEntered() {
    }

    public WrongPriceEntered(String message) {
        super(message);
    }
}
