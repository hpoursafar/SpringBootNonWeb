package com.example.demo.controller;

import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;


@Controller
@Order(5)
public class RobotReportController {
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

        if ("REPORT".equals(command)) {
            String report = robotService.report();
            String direction = report.substring(5,9).replace(", ","").replace(")","");
            switch (Integer.parseInt(direction)) {
                case 0:
                    direction = "NORTH";
                    break;
                case 1:
                    direction = "EAST";
                    break;
                case 2:
                    direction = "SOUTH";
                    break;
                case 3:
                    direction = "WEST";
                    break;
                default:
                    System.out.println("Invalid pos");
            }
            report = report.replace(report.substring(5,9),", "+direction+" )");
            System.out.println(report);
//            System.out.println(robotService.report());
        }
    }
}
