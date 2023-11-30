package com.example.door.operation;

import java.util.Stack;

public class DoorOperationExecutor {
    private final Stack<DoorOperation> executedOperations = new Stack<>();

    public void execute(DoorOperation doorOperation) {
        doorOperation.execute();
        this.executedOperations.push(doorOperation);
    }

    public Stack<DoorOperation> getExecutedOperations() {
        return executedOperations;
    }
}
