package org.maktab.Part2MaktabFinalProject.entity.exceptions;

public class FileIsTooBig extends RuntimeException {
    public FileIsTooBig() {
    }

    public FileIsTooBig(String message) {
        super(message);
    }
}
