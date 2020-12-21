package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entity.Stocks;
import model.Model;

/**
 * controller
 * 
 * @author Meow
 *
 */
public class Controller {

    /**
     * storage data
     */
    public final static String SOURCE_DATA = "D:\\data.csv";

    /**
     * return list Stock
     */
    public List<Stocks> datas = Model.getInstance().readFile(SOURCE_DATA);

    /**
     * count số cổ phiếu tăng trong một ngày
     * 
     * @param day
     * @return
     */
    public int countTang(String day) {
	int sum = 0;
	for (Stocks stock : getStockByDate(day)) {
	    if ((stock.getClose() - stock.getOpen()) > 0) {
		sum++;
	    }
	}
	return sum;
    }

    /**
     * count số cổ phiếu giảm trong một ngày
     * 
     * @param day
     * @return
     */
    public int countGiam(String day) {
	int sum = 0;
	for (Stocks stock : getStockByDate(day)) {
	    if ((stock.getClose() - stock.getOpen()) < 0) {
		sum++;
	    }
	}
	return sum;
    }

    /**
     * count số cổ phiếu giữ giá
     * 
     * @param day
     * @return
     */
    public int countGiu(String day) {
	int sum = 0;
	for (Stocks stock : getStockByDate(day)) {
	    if ((stock.getClose() - stock.getOpen()) == 0) {
		sum++;
	    }
	}
	return sum;
    }

    /**
     * get list Stock by Date
     * 
     * @param day
     * @return list
     */
    public List<Stocks> getStockByDate(String day) {
	List<Stocks> stocks = new ArrayList<>();
	for (Stocks stock : datas) {
	    if (stock.getDate().equals(day)) {
		stocks.add(stock);
	    }
	}
	return stocks;
    }

    /**
     * get Stock by day
     * 
     * @param index
     * @param day
     * @return list
     */
    public Stocks getStocks(int index, String day) {
	List<Stocks> list = this.getStockByDate(day);
	Collections.sort(list, new Compara());
	return list.get(index);
    }

    /**
     * tính phần trăm
     * 
     * @param stock
     * @return
     */
    public Double phanTram(Stocks stock) {
	return ((stock.getClose() - stock.getOpen()) * 100 / stock.getOpen());

    }

    /**
     * get list stock by day and sort by volumn
     * 
     * @param day
     * @return list
     */
    public List<Stocks> getStockSortVolume(String day) {
	List<Stocks> list = this.getStockByDate(day);
	Collections.sort(list, new CompaVolume());
	return list;
    }

    /**
     * 
     * @param day
     * @return
     */
    public String status(String day) {
	if (this.countTang(day) > this.countGiam(day)) {
	    return "tích cực, với số lượng cổ phiếu tăng giá nhiều hơn số lượng cổ phiếu giảm";
	} else {
	    return "không mấy tích cực khi mà số lượng cổ phiếu tăng giá ít hơn số lượng cổ phiếu giảm";
	}
    }

    /**
     * 
     * @param code
     * @param start
     * @param stop
     * @return stock
     */
    public List<Stocks> getStock(String code, String start, String stop) {
	List<Stocks> stocks = new ArrayList<>();
	for (Stocks stock : datas) {
	    if (stock.getCode().equals(code) && Integer.parseInt(stock.getDate()) >= Integer.parseInt(start)
		    && Integer.parseInt(stock.getDate()) <= Integer.parseInt(stop)) {
		stocks.add(stock);
	    }
	}
	return stocks;

    }
}
