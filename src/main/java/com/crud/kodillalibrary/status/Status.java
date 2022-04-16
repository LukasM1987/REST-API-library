package com.crud.kodillalibrary.status;

public enum Status {

    AVAILABLE ("Available"),
    BORROWED ("Borrowed"),
    DAMAGED ("Damaged"),
    LOST ("Lost");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
