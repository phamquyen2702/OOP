package controller;

import java.util.Comparator;

import entity.Stocks;

/**
 * sort by low
 * 
 * @author Meow
 *
 */
public class CompaLow implements Comparator<Stocks> {

    @Override
    public int compare(Stocks o1, Stocks o2) {
	return o1.getOpen().compareTo(o2.getOpen());
    }

}
