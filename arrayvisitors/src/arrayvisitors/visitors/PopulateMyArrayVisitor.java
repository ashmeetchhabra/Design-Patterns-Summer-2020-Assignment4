package arrayvisitors.visitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.DynamicArray;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

public class PopulateMyArrayVisitor implements Visitor {
	MyArrayI myArrayObj = new MyArray();
//	MyArrayI array1 = new MyArray();
//	MyArrayI array2 = new MyArray();
	static MyArrayListI myArrayListObj = new MyArrayList();
	List<MyArrayI> arrList = new ArrayList<MyArrayI>();
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
		
		arrList=myarraylist.addMyArray(this.myArrayObj);
//		arrayList.addMyArray(array2);
	}
	
	public MyArrayI setArr(MyArrayI myArrayObj1) throws NumberFormatException, IOException {
		String line ;
		while ((line =fp.poll()) != null) {
			
			value = Integer.parseInt(line);
//			System.out.println("Value is::"+value);
			MyLogger.writeMessage("Reading of input1 file", DebugLevel.NONE);
			myArrayObj1.accept(this);
//			myArrayObj1.displayElements();
		}
		return myArrayObj1;

	}
	
	public List<MyArrayI> createMyArrayList(MyArrayListI myArrayListObj1,MyArrayI myArrayObj) {
		this.myArrayObj=myArrayObj;
		
//		this.arrayList=myArrayList;
		myArrayListObj1.accept(this);
//		System.out.println("DISPLAYING MYARRAYLIST");
//		myArrayListObj1.displayMyArrayList();
		
		
//		this.array1=array1;
//		this.array2=array2;
		return arrList;
	}
	
	public void printArrayList()
	{
		
	}

}
