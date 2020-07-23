package arrayvisitors.adt;

import java.io.IOException;

import arrayvisitors.util.DynamicArray;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.util.MyLogger.DebugLevel;
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
	public void accept(Visitor visitor,Results res) {
		visitor.visit(this);

	}

	@Override
	public void displayElements() throws IOException {
		MyLogger.writeMessage("Displaying Elements", DebugLevel.MYARRAY);
		array.printElements();
	}
	

}
