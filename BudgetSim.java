package com.budgetsim;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BudgetSim {
	private double balance;
	private ArrayList<Double> expenses;
	private Scanner scanner;
	LocalDate startDate;
	DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	String date;
	
	
	public BudgetSim() {
		scanner = new Scanner(System.in);
		expenses = new ArrayList<>();
		System.out.println("Set starting date to today? (1 for yes, 2 for no)");
		int choice = scanner.nextInt();
		boolean answering = true;
		while (answering) {
			switch (choice) {
				case 1:
					answering = false;
					startDate = LocalDate.now();
					break;
				case 2:
					System.out.println("Enter the year: ");
					int year = scanner.nextInt();
					System.out.println("Enter the month: ");
					int month = scanner.nextInt();
					System.out.println("Enter the day: ");
					int day = scanner.nextInt();
					startDate = LocalDate.of(year, month, day);
					answering = false;
					break;
			}
		}
		date = startDate.format(dFormat);
		
	}
	
	public void run() {
		boolean running = true;
		while (running) {
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					checkBalance();
			}
		}
	}
	private void checkBalance() {
		date = startDate.format(dFormat);
		System.out.println(date + " $" + balance);
		startDate = startDate.plusDays(1);
	}
	
	public static void main(String[] args) {
		BudgetSim simulator = new BudgetSim();
		simulator.run();
	}
}
	