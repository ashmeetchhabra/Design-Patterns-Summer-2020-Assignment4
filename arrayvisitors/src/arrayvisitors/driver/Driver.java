package arrayvisitors.driver;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
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
			MyArrayI myArrayObj1 = new MyArray();
			MyArrayI myArrayObj2 = new MyArray();
			MyArrayListI myArrayListObj1 = new MyArrayList();
			PopulateMyArrayVisitor populateMyArray1 = new PopulateMyArrayVisitor(new FileProcessor(args[0]));
			PopulateMyArrayVisitor populateMyArray2 = new PopulateMyArrayVisitor(new FileProcessor(args[1]));
			Visitor commonIntsVisitor = new CommonIntsVisitor();
			Visitor missingIntsVisitor = new MissingIntsVisitor();
			Results commonintsout = new Results(args[2]);
			Results missingintsout = new Results(args[3]);

			MyLogger.setDebugValue(Integer.parseInt(args[4]));

			// Initializations
			MyLogger.writeMessage("In Driver", DebugLevel.DRIVER);
			populateMyArray1.setArr(myArrayObj1, null);
			myArrayObj1.displayElements();
			populateMyArray1.createMyArrayList(myArrayListObj1, myArrayObj1, null);

			populateMyArray2.setArr(myArrayObj2, null);
			myArrayObj2.displayElements();
			populateMyArray2.createMyArrayList(myArrayListObj1, myArrayObj2, null);
			myArrayListObj1.displayMyArrayList();

//			Calling CommonIntsVisitor
			myArrayListObj1.accept(commonIntsVisitor, commonintsout);
			myArrayListObj1.accept(missingIntsVisitor, missingintsout);
			commonintsout.closeFile();
			missingintsout.closeFile();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
