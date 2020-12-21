package controller;

import java.util.Comparator;

import entity.Stocks;

/**
 * sort by phần trăm cổ phiếu tăng giá
 * 
 * @author Meow
 *
 */
public class Compara implements Comparator<Stocks> {

    @Override
    public int compare(Stocks o1, Stocks o2) {
	return this.tang(o2).compareTo(this.tang(o1));
    }

    private Double tang(Stocks o1) {
	return (o1.getClose() - o1.getOpen()) * 100 / o1.getOpen();
    }

}
