package controller;

import java.util.Comparator;

import entity.Stocks;

/**
 * sort by volumn
 * 
 * @author Meow
 *
 */
public class CompaVolume implements Comparator<Stocks> {

    @Override
    public int compare(Stocks o1, Stocks o2) {
	return o2.getVolume().compareTo(o1.getVolume());
    }

}
