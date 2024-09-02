package com.example.demo.service;

import com.example.demo.model.Position;
import com.example.demo.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RobotService.class);
    private static final int rows =5;
    private static final int columns=5;


    @Autowired
    private Robot robot;

//	public boolean isValidPosition(Position position) {
//		if(robot.isPlaced())
//			return squareTable.isValidPosition(position);
//		else
//			return true;
//	}

    public boolean isValidPosition(Position position) {
        if(robot.isPlaced())
            return !(
                    position.getX() > this.columns || position.getX() < 0 ||
                            position.getY() > this.rows || position.getY() < 0
            );
        else
            return false;
    }

    public String place(Position position) {
        robot.setPosition(position);
        return String.valueOf(robot.getPosition().toString());
    }

    public void move(Position position) {
        robot.move(position);
    }

    public void rotateLeft() {
        robot.rotateLeft();
    }

    public void rotateRight() {
        robot.rotateRight();
    }

    public String report() {
        if(robot == null || robot.getPosition() == null || !robot.isPlaced())
            return "ROBOT MISSING";
        return String.valueOf(robot.getPosition());
    }

    public Position getNextPosition() {
        if(robot.isPlaced())
        {
            try {
                return robot.getPosition().getNextPosition();
            } catch (Exception e) {
                LOGGER.debug("Invalid next position");
                return null;
            }
        }
        return null;

    }
}
