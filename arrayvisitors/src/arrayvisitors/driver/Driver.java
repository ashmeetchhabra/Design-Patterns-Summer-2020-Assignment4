package arrayvisitors.driver;

import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.PopulateMyArrayVisitor;

public class Driver {

	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

	public static void main(String[] args) {

		if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}"))
				|| (args[2].equals("${commonintsout}")) || (args[3].equals("${missingintsout}"))
				|| (args[4].equals("${debug}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}

		try {
			MyLogger.setDebugValue(Integer.parseInt(args[4]));
			// Initializations
			PopulateMyArrayVisitor populateMyArray1 = new PopulateMyArrayVisitor(new FileProcessor(args[0]));
			populateMyArray1.setArr();

			PopulateMyArrayVisitor populateMyArray2 = new PopulateMyArrayVisitor(new FileProcessor(args[1]));
			populateMyArray2.setArr();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
