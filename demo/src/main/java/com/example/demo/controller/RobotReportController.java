package com.example.demo.controller;

import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Order(5)
public class RobotReportController implements CommandLineRunner {
    @Autowired
    private RobotService robotService;
    @Override
    public void run(String... args) throws Exception {
        String input = new Scanner(System.in).nextLine();
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
        if ("REPORT".equals(command)) {
            System.out.println(robotService.report());
            return;
        }
        return;
    }
}
