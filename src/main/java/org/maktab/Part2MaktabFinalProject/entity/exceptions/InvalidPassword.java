package org.maktab.Part2MaktabFinalProject.entity.exceptions;

    public class InvalidPassword extends RuntimeException{
        public InvalidPassword() {
        }

        public InvalidPassword(String message) {
            super(message);
        }
}
