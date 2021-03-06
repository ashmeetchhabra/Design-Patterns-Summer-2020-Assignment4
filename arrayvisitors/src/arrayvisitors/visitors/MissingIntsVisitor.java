package arrayvisitors.visitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.util.MyLogger.DebugLevel;

public class MissingIntsVisitor implements Visitor {

	@Override
	public void visit(MyArrayI myarray) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MyArrayListI myarraylist,Results res) throws IOException {
		MyLogger.writeMessage("In visit() of MissingIntsVisitor", DebugLevel.MISSINGINTSVISTOR);
		List<MyArrayI> list = new ArrayList<MyArrayI>();
		System.out.println();
//		System.out.println("Missing Ints::");

		List<Integer> existingInts = new ArrayList<Integer>();
		List<Integer> missingInts = new ArrayList<Integer>();

		list = myarraylist.getArrayList();

		for (MyArrayI myArrayElement : list) {
			for (int i = 0; i < myArrayElement.length(); i++) {
				if (!existingInts.contains(myArrayElement.getInt(i)))
					existingInts.add(myArrayElement.getInt(i));
			}
		}

		for (int i = 00; i <=99; i++) {
			if (!existingInts.contains(i))
				missingInts.add(i);
		}

		
		System.out.println("Missing Ints:");
		res.writeToFile("Missing Ints:"+"\n");
		for (Integer i : missingInts) {
			if(i<10)
				res.writeToFile("0"+i+"\n");
			else
				res.writeToFile(i+"\n");
			System.out.print(i+" ");
			
		}

	}

}
