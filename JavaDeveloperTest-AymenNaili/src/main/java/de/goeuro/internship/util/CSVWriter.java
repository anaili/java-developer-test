package de.goeuro.internship.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.goeuro.internship.model.Location;

public class CSVWriter {

	private File csvFile;
	private BufferedWriter writer;

	public CSVWriter() {
		this.setCsvFile(new File("locations.csv"));
		try {
			this.createCSVFile();
			this.writer = new BufferedWriter(new FileWriter(getCsvFile()));
			this.createHeader();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public boolean generateCSV(List<Location> locations) {
		try {
			for (Location l : locations) {
				StringBuilder lineBuilder = new StringBuilder();
				lineBuilder.append(l.get_id());
				lineBuilder.append(",");
				lineBuilder.append(l.getName());
				lineBuilder.append(",");
				lineBuilder.append(l.getType());
				lineBuilder.append(",");
				lineBuilder.append(l.getGeo_position().getLatitude());
				writer.write(lineBuilder.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void createHeader() throws IOException {
		String header = "_id,name,type,latitude";
		createCSVFile();
		try {
			writer.write(header);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			writer.close();
		}
	}

	public void createCSVFile() throws IOException {
		if (!getCsvFile().exists()) {
			getCsvFile().createNewFile();
		}
		if (!(getCsvFile().canWrite() && getCsvFile().canRead()))
			throw new IOException("Cannot write to target file");
	}

	public File getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}

}
