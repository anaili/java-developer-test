package de.goeuro.internship.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import de.goeuro.internship.model.Location;


public class CSVWriter {

	private File csvFile;
	private BufferedWriter writer;
	
	public CSVWriter() {
		this.csvFile = new File("locations.csv");
		try {
			this.createCSVFile();
			this.writer = new BufferedWriter(new FileWriter(csvFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean generateCSV(List<Location> locations){
		for(Location l : locations){
			StringBuilder lineBuilder = new StringBuilder();
			lineBuilder.append(l.get_id());
			lineBuilder.append(",");
			lineBuilder.append(l.getName());
			lineBuilder.append(",");
			lineBuilder.append(l.getType());
			lineBuilder.append(",");
			lineBuilder.append(l.getGeo_position().getLatitude());
			try {
				writer.write(lineBuilder.toString());
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			finally{
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public void createHeader() throws IOException{
		String header="_id,name,type,latitude";
		createCSVFile();
		try {
			writer.write(header);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createCSVFile() throws IOException{
		if(!csvFile.exists()){
			csvFile.createNewFile();
		}
		if(!(csvFile.canWrite() && csvFile.canRead()))
			throw new IOException("Cannot write to target file");
	}

	
}
