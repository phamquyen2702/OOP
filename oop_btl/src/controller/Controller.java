package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entity.Stocks;
import model.Model;

public class Controller {

    public final static String SOURCE_DATA = "D:\\data.csv";
    public List<Stocks> datas = Model.getInstance().readFile(SOURCE_DATA);
    // Controller

    public int countTang(String day) {
	int sum = 0;
	for (Stocks stock : getStockByDate(day)) {
	    if ((stock.getClose() - stock.getOpen()) > 0) {
		sum++;
	    }
	}
	return sum;
    }

    public int countGiam(String day) {
	int sum = 0;
	for (Stocks stock : getStockByDate(day)) {
	    if ((stock.getClose() - stock.getOpen()) < 0) {
		sum++;
	    }
	}
	return sum;
    }

    public int countGiu(String day) {
	int sum = 0;
	for (Stocks stock : getStockByDate(day)) {
	    if ((stock.getClose() - stock.getOpen()) == 0) {
		sum++;
	    }
	}
	return sum;
    }

    public List<Stocks> getStockByDate(String day) {
	List<Stocks> stocks = new ArrayList<>();
	for (Stocks stock : datas) {
	    if (stock.getDate().equals(day)) {
		stocks.add(stock);
	    }
	}
	return stocks;
    }

    public Stocks getStocks(int index, String day) {
	List<Stocks> list = this.getStockByDate(day);
	Collections.sort(list, new Compara());
	return list.get(index);
    }

    public Double phanTram(Stocks stock) {
	return ((stock.getClose() - stock.getOpen()) * 100 / stock.getOpen());

    }

    public List<Stocks> getStockSortVolume(String day) {
	List<Stocks> list = this.getStockByDate(day);
	Collections.sort(list, new CompaVolume());
	return list;
    }

    public String status(String day) {
	if (this.countTang(day) > this.countGiam(day)) {
	    return "tích cực, với số lượng cổ phiếu tăng giá nhiều hơn số lượng cổ phiếu giảm";
	} else {
	    return "không mấy tích cực khi mà số lượng cổ phiếu tăng giá ít hơn số lượng cổ phiếu giảm";
	}
    }

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
