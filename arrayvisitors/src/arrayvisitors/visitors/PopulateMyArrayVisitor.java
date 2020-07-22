package arrayvisitors.visitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;
import arrayvisitors.util.Results;

public class PopulateMyArrayVisitor implements Visitor {
	MyArrayI myArrayObj = new MyArray();
	static MyArrayListI myArrayListObj = new MyArrayList();
	List<MyArrayI> arrList = new ArrayList<MyArrayI>();
	FileProcessor fp;

	public PopulateMyArrayVisitor(FileProcessor fp) {
		this.fp = fp;
	}

	Integer value;

	@Override
	public void visit(MyArrayI myarray) {
		myarray.addInts(value);

	}

	@Override
	public void visit(MyArrayListI myarraylist, Results res) {

		arrList = myarraylist.addMyArray(this.myArrayObj);
//		arrayList.addMyArray(array2);
	}

	public MyArrayI setArr(MyArrayI myArrayObj1, Results res) throws NumberFormatException, IOException {
		String line;
		while ((line = fp.poll()) != null) {
			value = Integer.parseInt(line);
			MyLogger.writeMessage("Reading of input1 file", DebugLevel.NONE);
			myArrayObj1.accept(this, res);
		}
		return myArrayObj1;

	}

	public List<MyArrayI> createMyArrayList(MyArrayListI myArrayListObj1, MyArrayI myArrayObj, Results res)
			throws IOException {
		this.myArrayObj = myArrayObj;

		myArrayListObj1.accept(this, res);
		return arrList;
	}

	public void printArrayList() {

	}

}
