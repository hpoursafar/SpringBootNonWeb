package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Order(1)
public class RobotController implements CommandLineRunner {
    @Autowired
    private RobotService robotService;

//    public String commandRobot(String[] arguments) throws Exception{
//        return "Hello World!";
//    }

    @Override
    public void run(String... args) throws Exception {
        String input = new Scanner(System.in).nextLine();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext("/[^A-Z]+/g")){
//            System.out.println(scanner.nextLine());
//        }
        String[] arguments = input.split(" ");
        String command = "";
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
        }
        switch (command) {
            case "PLACE":
                Position position = new Position(x, y, direction);
                if (!robotService.isValidPosition(position)){
                    System.out.println("Invalid position");
                    return;
                }

                robotService.place(position);
                System.out.println("ROBOT IN POSITION");
                return;
            case "MOVE":
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
                    return;

                } catch (Exception e) {
                    System.out.println("ROBOT MISSING");
                    return;
                }
            case "LEFT":
                robotService.rotateLeft();
                return;
            case "RIGHT":
                robotService.rotateRight();
                return;
            case "REPORT":
                System.out.println(robotService.report());
                return;
            default:
                System.out.println("Invalid command");
        }
    }

}
