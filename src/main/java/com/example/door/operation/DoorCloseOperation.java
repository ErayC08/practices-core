package com.example.door.operation;

import com.example.door.Door;

public class DoorCloseOperation implements DoorOperation {
    private final Door door;

    public DoorCloseOperation(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        this.door.close();
    }
}
