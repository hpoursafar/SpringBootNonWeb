package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Order(2)
public class RobotMoveController implements CommandLineRunner {

    @Autowired
    private RobotService robotService;


    @Override
    public void run(String... args) throws Exception {
        String input = new Scanner(System.in).nextLine();
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        if (!scanner.hasNext("/[^A-Z]+/g")){
////            System.out.println(scanner.nextLine());
//            return;
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
