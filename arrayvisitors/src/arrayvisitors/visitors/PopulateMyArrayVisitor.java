package arrayvisitors.visitors;

import java.io.IOException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.DynamicArray;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

public class PopulateMyArrayVisitor implements Visitor {
	
//	DynamicArray array = new DynamicArray();
	MyArrayI array = new MyArray();
	FileProcessor fp;
	
	public PopulateMyArrayVisitor(FileProcessor fp){
		this.fp=fp;
	}
	
	Integer value;

	@Override
	public void visit(MyArrayI myarray) {
		myarray.addInts(value);
		
	}

	@Override
	public void visit(MyArrayListI myarraylist) {
		// TODO Auto-generated method stub
		
	}
	
	public void setArr() throws NumberFormatException, IOException {
		String line ;
		while ((line =fp.poll()) != null) {
			
			value = Integer.parseInt(line);
			System.out.println("Value is::"+value);
			MyLogger.writeMessage("Reading of input1 file", DebugLevel.NONE);
			
			
//			populateMyArray.visit(array1);
//			array1.addInts(value);
			array.accept(this);
			array.displayElements();
		}

	}

}
