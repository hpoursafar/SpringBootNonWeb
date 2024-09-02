package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String input = new Scanner(System.in).next();
//		System.out.println(input);
//		String[] arguments = input.split(":");
//		String command = "";
//		try {
//			command = arguments[0];
//		} catch (IllegalArgumentException e) {
//			throw new Exception("Invalid command");
//		}
//		if ("PLACE".equals(command) && args.length < 2) {
//			throw new Exception("Invalid command");
//		}
//
//		String[] params;
//		int x = 0;
//		int y = 0;
//		int direction = 0;
//		if ("PLACE".equals(command)) {
//			params = args[1].split(",");
//			try {
//				x = Integer.parseInt(params[0]);
//				y = Integer.parseInt(params[1]);
//				direction = Integer.parseInt(params[2]);
//			} catch (Exception e) {
//				throw new Exception("Invalid command");
//			}
//		}
//		switch (command) {
//			case "PLACE":
//				Position position = new Position(x, y, direction);
//				if (!robotService.isValidPosition(position))
//					System.out.println("Invalid position");
//				robotService.place(position);
//				System.out.println("ROBOT IN POSITION");
//			case "MOVE":
//				try {
//					Position newPosition = robotService.getNextPosition();
//					if(newPosition == null)
//						System.out.println("NULL POSITION");
//					if(!robotService.isValidPosition(newPosition))
//						System.out.println("Invalid position");
//					else {
//						robotService.move(newPosition);
//						System.out.println("ROBOT MOVED");
//					}
//
//				} catch (Exception e) {
//					System.out.println("ROBOT MISSING");
//				}
//			case "LEFT":
//				robotService.rotateLeft();
//			case "RIGHT":
//				robotService.rotateRight();
//			case "REPORT":
//				System.out.println(robotService.report());
//			default:
//				System.out.println("Invalid command");
//		}
//	}
}
