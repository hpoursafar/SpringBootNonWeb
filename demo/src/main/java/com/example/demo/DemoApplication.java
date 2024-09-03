package com.example.demo;

import com.example.demo.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication  {
	@Autowired
	private RobotMoveController robotMoveController;
	@Autowired
	private RobotLeftController robotLeftController;
	@Autowired
	private RobotRightController robotRightController;
	@Autowired
	private RobotReportController robotReportController;
	@Autowired
	private RobotPlaceController robotPlaceController;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public String place() throws  Exception{
		Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
			String input = scanner.nextLine();
            if (input.equals("EXIT"))
                return null;
			if (input.contains("PLACE")) {
				robotPlaceController.run(input);
			}
			if (input.equals("MOVE"))
				robotMoveController.run(input);
			if (input.equals("LEFT"))
				robotLeftController.run(input);
			if (input.equals("RIGHT"))
				robotRightController.run(input);
			if (input.equals("REPORT"))
				robotReportController.run(input);
        }
		return null;
	}
}
