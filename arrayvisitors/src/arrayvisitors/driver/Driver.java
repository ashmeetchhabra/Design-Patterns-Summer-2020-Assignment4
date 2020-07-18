package arrayvisitors.driver;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;


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
			FileProcessor fp;
			Integer line;
			
//			Processing input.txt file
			fp = new FileProcessor(args[0]);
			Visitor populateMyArray = new PopulateMyArrayVisitor();
			MyArrayI array1 = new MyArray();
//			int l = Integer.parseInt(fp.poll());
			
			while ((line = Integer.parseInt(fp.poll())) != null) {
				MyLogger.writeMessage("Reading of input1 file", DebugLevel.DRIVER);
				array1.addInts(line);
				array1.accept(populateMyArray);
			}
			
		}catch(Exception e) {
			
		}

	}

}
