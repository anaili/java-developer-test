package de.goeuro.internship.app;

import java.awt.Desktop;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import de.goeuro.internship.model.Location;
import de.goeuro.internship.util.CSVWriter;
import de.goeuro.internship.util.LocationFinder;

public class App {

	public static void main(String[] args) {
		System.out.println("GoEuro - Java Developer Test");
		if(args.length != 1){
			System.out.println("Invalid argument");
			System.exit(1);
		}
		String input = args[0];
		System.out.println("Looking for : "+input);
		List<Location> locations = new LocationFinder().findLocations(input);
		if(locations.isEmpty()){
			System.out.println("No locations found");
			System.exit(0);
		}
		System.out.println("Found "+locations.size()+" locations");
		System.out.print("Generating CSV File ... ");
		CSVWriter csvWriter = new CSVWriter();
		csvWriter.generateCSV(locations);
		System.out.println("OK");
		while(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")){
			System.out.print("Do you want to open the file (Y/N): ");
			input = new Scanner(System.in).nextLine();
			if(input.equalsIgnoreCase("y")){
				try {
					Desktop.getDesktop().edit(csvWriter.getCsvFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
			else{
				System.exit(0);
			}
		}
		
	}

}
