package generate;

public class GenerateUtil {

    public String gen(int count, String status) {
	return count + status;
    }

    public String gen(String maCophieu, String status, Double soPhantram) {
	return maCophieu + status + soPhantram;
    }

    public String gen(String prefix, String status, String subfix) {
	return prefix + status + subfix;
    }

}
