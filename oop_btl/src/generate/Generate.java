package generate;

public class Generate {

    Generation generation = new Generation();

    public String showSentence(String code, String start, String stop) {
	StringBuffer buffer = new StringBuffer();
	buffer.append(generation.generateSentence7(code, start, stop).toString());
	buffer.append("\n");
	buffer.append(generation.generateSentence8(code, start, stop).toString());
	buffer.append("\n");
	buffer.append(generation.generateSentence9(code, start, stop).toString());
	buffer.append("\n");
	buffer.append(generation.generateSentence10(code, start, stop).toString());
	return buffer.toString();
    }

    public String showSentence(String day) {

	StringBuffer buffer = new StringBuffer();
	buffer.append(generation.generateSentence(day).toString());
	buffer.append("\n");
	buffer.append(generation.generateSentence1(day).toString());
	buffer.append("\n");
	buffer.append(generation.generateSentence11(day).toString());
	buffer.append("\n");
	buffer.append(generation.generateSentence2(day)).toString();
	buffer.append("\n");
	buffer.append(generation.generateSentence3(day)).toString();
	buffer.append(generation.generateSentence4(day)).toString();
	buffer.append(generation.generateSentence5(day)).toString();
	buffer.append("\n");
	buffer.append(generation.generateSentence6(day)).toString();
	return buffer.toString();
    }

}
