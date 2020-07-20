package arrayvisitors.adt;

import arrayvisitors.util.DynamicArray;
import arrayvisitors.visitors.Visitor;

public class MyArray implements MyArrayI {
	DynamicArray array = new DynamicArray();

	@Override
	public int getInt(int index) {
		return array.getElement(index);
	}

	@Override
	public void addInts(int value) {	
		array.addElement(value);
	}

	@Override
	public int length() {
		return array.size();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	@Override
	public void displayElements() {
		array.printElements();
	}
	

}
