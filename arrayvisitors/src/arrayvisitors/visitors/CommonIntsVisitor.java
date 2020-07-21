package arrayvisitors.visitors;

import java.util.ArrayList;
import java.util.List;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public class CommonIntsVisitor implements Visitor {

	@Override
	public void visit(MyArrayI myarray) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MyArrayListI myarraylist) {
		// Logic for getting same values from 2 ArrayObjs in ArrayList

		List<Integer> commonIntsList = new ArrayList<Integer>(); 
		List<MyArrayI> list = myarraylist.getArrayList();
		
		MyArrayI arrayObj1 = new MyArray();
		MyArrayI arrayObj2 = new MyArray();
		
		arrayObj1 =list.get(0);
		arrayObj2 =list.get(1);
		
		System.out.println("Common ints::");
		for (int i = 0; i < arrayObj1.length(); i++) {
			for (int j = 0; j < arrayObj2.length(); j++) {
				if(arrayObj1.getInt(i)==arrayObj2.getInt(j))
				{
					if(!commonIntsList.contains(arrayObj1.getInt(i)))
					{
						System.out.print(arrayObj1.getInt(i)+" ");
						
						commonIntsList.add(arrayObj1.getInt(i));
					}
					
					
				}
			}
//			System.out.println();
			
		}
	}

}
