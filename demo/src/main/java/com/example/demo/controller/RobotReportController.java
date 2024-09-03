package com.example.demo.controller;

import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Order(2)
public class RobotReportController implements CommandLineRunner {
    @Autowired
    private RobotService robotService;
    @Override
    public void run(String... args) throws Exception {
        String input = new Scanner(System.in).nextLine();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext("/[^A-Z]+/g")){
//            System.out.println(scanner.nextLine());
//        }
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
        }
        System.out.println(robotService.report());
        return;
    }
}
