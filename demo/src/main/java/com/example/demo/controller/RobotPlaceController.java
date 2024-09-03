package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Controller
@Order(1)
public class RobotPlaceController {
    @Autowired
    private RobotService robotService;

    public void run(String input) throws Exception{
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

        String[] params;
        int x = 0;
        int y = 0;
        int direction = 0;
        if ("PLACE".equals(command)) {
            params = arguments[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                direction = Integer.parseInt(params[2]);
            } catch (Exception e) {
                throw new Exception("Invalid command");
            }
            Position position = new Position(x, y, direction);
            if (!robotService.isValidPosition(position)){
                System.out.println("Invalid position");
                return;
            }

            robotService.place(position);
            System.out.println("ROBOT IN POSITION");
        }
    }

}
