package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RobotMoveController {

    @Autowired
    private RobotService robotService;

    public void run(String input) throws Exception {
        String[] arguments = input.split(" ");
        String command ;
        try {
            command = arguments[0];
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid command");
        }
        if ("PLACE".equals(command) && arguments.length < 2) {
            throw new Exception("Invalid command");
        }

        if ("MOVE".equals(command)) {
            try {
                Position newPosition = robotService.getNextPosition();
                if(newPosition == null){
                    System.out.println("NULL POSITION");
                    return;
                }
                if (!robotService.isValidPosition(newPosition)){
                    System.out.println("Invalid position");
                } else {
                    robotService.move(newPosition);
                    System.out.println("ROBOT MOVED");
                }

            } catch (Exception e) {
                System.out.println("ROBOT MISSING");
            }
        }
    }
}
