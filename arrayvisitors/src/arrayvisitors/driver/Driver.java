package arrayvisitors.driver;

import java.util.ArrayList;
import java.util.List;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.Element;
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
			Results res = new Results();
			

			MyArrayI array1, array2;
			MyLogger.setDebugValue(Integer.parseInt(args[4]));
			List<MyArrayI> arrList = new ArrayList<MyArrayI>();
			
			// Initializations
			PopulateMyArrayVisitor populateMyArray1 = new PopulateMyArrayVisitor(new FileProcessor(args[0]));
			array1 = populateMyArray1.setArr(myArrayObj1);
			myArrayObj1.displayElements();
			arrList = populateMyArray1.createMyArrayList(myArrayListObj1,array1);
			
			

			PopulateMyArrayVisitor populateMyArray2 = new PopulateMyArrayVisitor(new FileProcessor(args[1]));
			array2 = populateMyArray2.setArr(myArrayObj2);
			myArrayObj2.displayElements();
			arrList = populateMyArray2.createMyArrayList(myArrayListObj1,array2);
			System.out.println("DISPLAYING MYARRAYLIST");
			myArrayListObj1.displayMyArrayList();
			
//			Calling CommonIntsVisitor
			Visitor commonIntsVisitor = new CommonIntsVisitor();
			Visitor missingIntsVisitor = new MissingIntsVisitor();
			
			myArrayListObj1.accept(commonIntsVisitor);
			myArrayListObj1.accept(missingIntsVisitor);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
