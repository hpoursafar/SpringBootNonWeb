package com.example.demo.model;

public class Position {
    int x;
    int y;
    int direction; /*NORTH=0,EAST=1,SOUTH=2,WEST=3*/

    public Position() {
        this.x = 0;
        this.y = 0;
        this.direction = 0;
    }
    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public Position(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Position getNextPosition() throws Exception {
        if (this.direction > 3 ||this.direction < 0)
            throw new Exception("Invalid robot direction");

        // new position to validate
        Position newPosition = new Position(this);
        switch (this.direction) {
            case 0:
                newPosition.change(0, 1);
                break;
            case 1:
                newPosition.change(1, 0);
                break;
            case 2:
                newPosition.change(0, -1);
                break;
            case 3:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }

    @Override
    public String toString() {

        return String.format("(%s, %s, %s)",
                getX(),
                getY(),
                getDirection());

    }
}
