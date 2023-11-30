package com.example.door;

public class Door {
    private DoorState state = DoorState.CLOSED;

    public boolean isOpen() {
        return state == DoorState.OPEN;
    }

    public void open() {
        if (this.state == DoorState.CLOSED) {
            this.state = DoorState.OPEN;
        }
    }

    public void close() {
        if (this.state == DoorState.OPEN) {
            this.state = DoorState.CLOSED;
        }
    }
}
