package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Robot {
    private Position position;
    private boolean isPlaced = false;

    public Robot() {
    }

    public boolean setPosition(Position position) {
        if (position == null)
            return false;
        isPlaced = true;
        this.position = position;
        return true;
    }


    public void move() throws Exception {
        if(isPlaced) {
            move(position.getNextPosition());
        }
    }


    public void move(Position newPosition) {
        if(isPlaced) {
            if (newPosition == null)
                return;

            this.position = newPosition;
        }
    }


    public Position getPosition() {
        if(isPlaced) {
            return this.position;
        }
        return null;
    }

    public int rotate(int step) {

        int newIndex = (this.position.direction + step) < 0 ?
                4 - 1 :
                (this.position.direction + step) % 4;

        return newIndex;
    }


    public void rotateLeft() {
        if(isPlaced) {
            if (this.position.direction > 3 ||this.position.direction < 0)
                return;

            this.position.direction = rotate(-1);
            return;
        }
    }


    public void rotateRight() {
        if(isPlaced) {
            if (this.position.direction > 3 ||this.position.direction < 0)
                return;

            this.position.direction = rotate(1);
            return;
        }
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
