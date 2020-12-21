package generate;

import java.util.Collections;
import java.util.List;

import constant.Constant;
import controller.CompaClose;
import controller.CompaHigh;
import controller.CompaLow;
import controller.CompaOpen;
import controller.Controller;
import entity.Sentence;
import entity.Stocks;

/**
 * generate sentence
 * 
 * @author Meow
 *
 */
public class Generation extends GenerateUtil {

    Controller ctr = new Controller();

    public Sentence generateSentence(String day) {
	Sentence sentence = new Sentence();
	String content = "Biến động của thị trường cổ phiếu trong ngày " + day + " như sau:";
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence1(String day) {
	Sentence sentence = new Sentence();
	String content = Constant.THI_TRUONG + this.gen(ctr.countTang(day), Constant.TANG) + Constant.DELIMITER
		+ this.gen(ctr.countGiam(day), Constant.GIAM) + Constant.AND
		+ this.gen(ctr.countGiu(day), Constant.GIU);
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence2(String day) {
	Sentence sentence = new Sentence();
	String content = this.gen(Constant.TOP_10_COPHIEU, Constant.TANG_PHAN_TRAM, Constant.NHIEU_NHAT);
	for (int i = 0; i < 10; i++) {
	    Stocks stock = ctr.getStocks(i, day);
	    content += this.gen(stock.getCode(), Constant.TANG_PHAN_TRAM, ctr.phanTram(stock)) + Constant.PHAN_TRAM;
	    if (i == 3 || i == 8) {
		content += "\n";
	    }
	}
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence3(String day) {
	Sentence sentence = new Sentence();
	Stocks stock = ctr.getStockSortVolume(day).get(0);
	String content = "Cổ phiếu " + stock.getCode() + " đạt khối lượng lớn nhất là " + stock.getVolume() + ".";
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence4(String day) {
	Sentence sentence = new Sentence();
	Stocks stock = ctr.getStockSortVolume(day).get(ctr.getStockByDate(day).size() - 1);
	String content = "Cổ phiếu " + stock.getCode() + " đạt khối lượng nhỏ nhất là " + stock.getVolume() + ".";
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence5(String day) {
	Sentence sentence = new Sentence();
	Stocks stock = ctr.getStockSortVolume(day).get(0);
	String content = " Biến động giá của cổ phiếu " + stock.getCode() + " từ " + stock.getLow() + " đến "
		+ stock.getHigh() + ".";
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence6(String day) {
	Sentence sentence = new Sentence();
	String content = "Từ kết quả trên chúng ta có nhận xét chung về tình hình biến động của cố phiếu trong ngày đang tiến triền một cách \n"
		+ ctr.status(day) + ".";
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence11(String day) {
	Sentence sentence = new Sentence();
	String content = this.gen(Constant.TOP_10_COPHIEU, Constant.GIAM_PHAN_TRAM, Constant.NHIEU_NHAT);
	for (int i = 0; i < 10; i++) {
	    Stocks stock = ctr.getStocks(ctr.getStockByDate(day).size() - 1 - i, day);
	    content += this.gen(stock.getCode(), Constant.GIAM_PHAN_TRAM, ctr.phanTram(stock) * (-1))
		    + Constant.PHAN_TRAM;
	    if (i == 3 || i == 8) {
		content += "\n";
	    }
	}
	sentence.setContent(content);
	return sentence;
    }
    // Generate Tag2

    public Sentence generateSentence7(String code, String start, String stop) {
	Sentence sentence = new Sentence();
	String content = "Biến động của cổ phiếu " + code + " từ ngày " + start + " đến ngày " + stop + "như sau:";
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence8(String code, String start, String stop) {
	Sentence sentence = new Sentence();
	List<Stocks> list = ctr.getStock(code, start, stop);
	Collections.sort(list, new CompaOpen());
	String content = "Cổ phiếu " + code + " có giá mở dao động từ " + list.get(0).getOpen() + " đến "
		+ list.get(list.size() - 1).getOpen() + ".";
	content += " Trong đó thì giá mở cửa cao nhất vào ngày " + list.get(list.size() - 1).getDate()
		+ " và thấp nhất vào ngày " + list.get(0).getDate();
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence9(String code, String start, String stop) {
	Sentence sentence = new Sentence();
	List<Stocks> list = ctr.getStock(code, start, stop);
	Collections.sort(list, new CompaClose());
	String content = "Cổ phiếu " + code + " có giá đóng cửa dao động từ " + list.get(0).getClose() + " đến "
		+ list.get(list.size() - 1).getClose() + ".";
	content += " Trong đó thì giá đóng cửa cao nhất vào ngày " + list.get(list.size() - 1).getDate()
		+ " và thấp nhất vào ngày " + list.get(0).getDate();
	sentence.setContent(content);
	return sentence;
    }

    public Sentence generateSentence10(String code, String start, String stop) {
	Sentence sentence = new Sentence();
	List<Stocks> listLow = ctr.getStock(code, start, stop);
	Collections.sort(listLow, new CompaLow());
	List<Stocks> listHigh = ctr.getStock(code, start, stop);
	Collections.sort(listHigh, new CompaHigh());
	String content = "Trong khoảng thời gian này thì cổ phiếu " + code + " có biến động giá từ "
		+ listLow.get(0).getLow() + " đến " + listHigh.get(listHigh.size() - 1).getHigh() + ".";
	sentence.setContent(content);
	return sentence;
    }

}
