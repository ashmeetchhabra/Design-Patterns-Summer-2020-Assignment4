package arrayvisitors.adt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import arrayvisitors.util.Results;
import arrayvisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI {
	List<MyArrayI> myArrayList = new ArrayList<MyArrayI>();
	

	@Override
	public void accept(Visitor visitor, Results res) throws IOException { 
		visitor.visit(this,res);
		
	}

	@Override
	public List<MyArrayI> addMyArray(MyArrayI array) {
		myArrayList.add(array);
		return myArrayList;
	}

	@Override
	public MyArrayI getMyArray(int index) {
		return myArrayList.get(index);
	}

	@Override
	public int length() {
		return myArrayList.size();
	}

	@Override
	public void displayMyArrayList() {
		for (MyArrayI myArray : myArrayList) {
			System.out.println("InArrayList");
			myArray.displayElements();
			
		}
		
	}

	@Override
	public List<MyArrayI> getArrayList() {
		return myArrayList;
	}

}
