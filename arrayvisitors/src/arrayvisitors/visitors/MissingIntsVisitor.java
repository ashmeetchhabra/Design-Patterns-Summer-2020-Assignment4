package arrayvisitors.visitors;

import java.util.ArrayList;
import java.util.List;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public class MissingIntsVisitor implements Visitor {

	@Override
	public void visit(MyArrayI myarray) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MyArrayListI myarraylist) {
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

		for (int i = 00; i < 99; i++) {
			if (!existingInts.contains(i))
				missingInts.add(i);
		}
		System.out.print("Existing Ints:");
		for (Integer i : existingInts) {
			System.out.print(i+" ");
			
		}
		
		System.out.println("Missing Ints:");
		for (Integer i : missingInts) {
			System.out.print(i+" ");
			
		}

	}

}
