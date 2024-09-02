package com.example.demo.service;

import com.example.demo.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@Service
//@Order(1)
public class Runner
//        implements CommandLineRunner

{

    @Autowired
    private RobotService robotService;
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

//    @Override
    public void run(String... args) throws Exception {
//        logger.info("EXECUTING : Command Line Runner");
        System.out.println("Hellllo");
//        String input = new Scanner(System.in).next();
//        System.out.println(input);
//        String[] arguments = input.split(":");
//        String command = "";
//        try {
//            command = arguments[0];
//        } catch (IllegalArgumentException e) {
//            throw new Exception("Invalid command");
//        }
//        if ("PLACE".equals(command) && args.length < 2) {
//            throw new Exception("Invalid command");
//        }
//
//        String[] params;
//        int x = 0;
//        int y = 0;
//        int direction = 0;
//        if ("PLACE".equals(command)) {
//            params = args[1].split(",");
//            try {
//                x = Integer.parseInt(params[0]);
//                y = Integer.parseInt(params[1]);
//                direction = Integer.parseInt(params[2]);
//            } catch (Exception e) {
//                throw new Exception("Invalid command");
//            }
//        }
//        switch (command) {
//            case "PLACE":
//                Position position = new Position(x, y, direction);
//                if (!robotService.isValidPosition(position))
//                    System.out.println("Invalid position");
//                robotService.place(position);
//                System.out.println("ROBOT IN POSITION");
//            case "MOVE":
//                try {
//                    Position newPosition = robotService.getNextPosition();
//                    if(newPosition == null)
//                        System.out.println("NULL POSITION");
//                    if(!robotService.isValidPosition(newPosition))
//                        System.out.println("Invalid position");
//                    else {
//                        robotService.move(newPosition);
//                        System.out.println("ROBOT MOVED");
//                    }
//
//                } catch (Exception e) {
//                    System.out.println("ROBOT MISSING");
//                }
//            case "LEFT":
//                robotService.rotateLeft();
//            case "RIGHT":
//                robotService.rotateRight();
//            case "REPORT":
//                System.out.println(robotService.report());
//            default:
//                System.out.println("Invalid command");
//        }
    }
}
