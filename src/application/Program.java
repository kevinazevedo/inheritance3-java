package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = scan.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or Company (i/c)? ");
			char resp = scan.next().charAt(0);
			System.out.print("Name: ");
			scan.nextLine();
			String name = scan.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = scan.nextDouble();	
			
			if (resp=='i' || resp=='I') {			
				System.out.print("Health expenditures: ");
				Double healthExpenditures = scan.nextDouble();				
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else if (resp=='c' || resp=='C') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = scan.nextInt();				
				list.add(new Company(name, anualIncome, numberOfEmployees));			
			}		
		}
		
		System.out.println("\nTAXES PAID:");
		double sum = 0.0;
		
		for (TaxPayer tp : list) {
			System.out.println(tp.getName()+ ": $ " + String.format("%.2f", tp.tax()));
			sum += tp.tax();
		}
				
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", sum));
			
		scan.close();
	}
}