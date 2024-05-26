package com.vkr.inventory.exeption;

public class UsernameOrIdNotFound extends Exception {

    private static final long serialVersionUID = 1668398822129870029L;

    public UsernameOrIdNotFound() {
        super("not found");
    }

    public UsernameOrIdNotFound(String message) {
        super(message);
    }
}