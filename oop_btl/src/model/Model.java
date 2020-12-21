package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Stocks;

/**
 * get data
 * 
 * @author Meow
 *
 */
public class Model {

    private final static String DELIMITER = ",";

    private static Model data = null;

    public static Model getInstance() {
	if (data == null) {
	    data = new Model();
	}
	return data;
    }

    /**
     * conver String-> object
     * 
     * @param line
     * @return
     */
    private Stocks converStocks(String line) {
	Stocks stock = new Stocks();
	String[] data = line.split(DELIMITER);
	stock.setCode(data[0]);
	stock.setDate(data[1]);
	stock.setOpen(Double.parseDouble(data[2]));
	stock.setHigh(Double.parseDouble(data[3]));
	stock.setLow(Double.parseDouble(data[4]));
	stock.setClose(Double.parseDouble(data[5]));
	stock.setVolume(Double.parseDouble(data[6]));

	return stock;
    }

    /**
     * readFile
     * 
     * @param path
     * @return list
     */
    public List<Stocks> readFile(String path) {
	BufferedReader fileReader = null;
	List<Stocks> stocks = new ArrayList<>();

	try {
	    String line = "";

	    fileReader = new BufferedReader(new FileReader(path));

	    while ((line = fileReader.readLine()) != null) {
		stocks.add(this.converStocks(line));

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		fileReader.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return stocks;
    }
}
