package com.example.door.operation;

import com.example.door.Door;

public class DoorOpenOperation implements DoorOperation {
    private final Door door;

    public DoorOpenOperation(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        this.door.open();
    }
}
