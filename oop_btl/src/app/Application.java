package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entity.Tag;
import exception.NotFoundSouceException;
import generate.Generate;

/**
 * class hiển thị menu
 * 
 * @author Meow
 *
 */
public class Application {

    private static Map<String, Tag> mapTags = null;

    static {
	mapTags = new HashMap<String, Tag>();
	mapTags.put("TAG1", new Tag(1, "Biến động toàn thị trường cổ phiếu trong một ngày cụ thể."));
	mapTags.put("TAG2", new Tag(2, "Biến động của một loại cổ phiếu trong một khoảng thời gian."));
    }

    private static Scanner sc;

    public static void choose() throws NotFoundSouceException {
	sc = new Scanner(System.in);
	int choose;
	Generate gen = new Generate();
	do {
	    choose = sc.nextInt();
	    switch (choose) {
	    case 1:
		System.out.print("Nhập ngày cụ thể biến động( định dạng YYYYMMDD, vd: 20201111 ):");
		String day = sc.next();
		// Generate sentence
		try {
		    System.out.println("----------------------------------------------------- ");
		    System.out.println(gen.showSentence(day));
		    System.out.println("----------------------------------------------------- ");
		} catch (Exception e) {
		    System.out.println("Dữ liệu đầu vào không hợp lệ: ");
		} finally {
		    System.out.print("Chọn chủ đề tiếp theo: ");
		    choose();

		}

		break;
	    case 2:
		System.out.print("Nhập một mã cổ phiếu bất kì( đúng định dạng mã cổ phiếu, vd: ICN):");
		String stock = sc.next();
		System.out.println("");
		System.out.print("Nhập ngày bắt đầu( định dạng YYYYMMDD ) :");
		String start = sc.next();
		System.out.println("");
		System.out.print("Nhập ngày kết thúc( định dạng YYYYMMDD ) :");
		String stop = sc.next();
		System.out.println("");
		try {
		    System.out.println("----------------------------------------------------- ");
		    System.out.println(gen.showSentence(stock, start, stop));
		    System.out.println("----------------------------------------------------- ");
		} catch (Exception e) {
		    System.out.println("Dữ liệu đầu vào không hợp lệ: ");
		} finally {
		    System.out.print("Chọn chủ đề tiếp theo: ");
		    choose();
		    System.out.println("----------------------------------------------------- ");
		}

		break;
	    default:
		System.out.print("Chủ đề bạn chọn không tồn tại, vui lòng chọn lại chủ đề đúng hướng dẫn: ");
	    }
	} while (choose < 1 || choose > 3);
    }

    public static void main(String[] args) throws NotFoundSouceException {
	System.out.println("___CHƯƠNG TRÌNH SINH THÔNG TIN DỮ LIỆU CHỨNG KHOÁN___");
	System.out.println("---------------");
	System.out.println("Các chủ đề sinh dữ liệu:");
	System.out.println("----------------");
	for (String key : mapTags.keySet()) {
	    System.out.println(mapTags.get(key).toString());
	}
	System.out.println("----------------");
	System.out.print("Lựa chọn 1 trong 2 chủ đề sau( chọn 1 -> 2): ");
	choose();
    }
}
