package com.example.demo.controller;

import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Controller
@Order(4)
public class RobotRightController {
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

        if ("RIGHT".equals(command)) {
            robotService.rotateRight();
        }
    }
}
