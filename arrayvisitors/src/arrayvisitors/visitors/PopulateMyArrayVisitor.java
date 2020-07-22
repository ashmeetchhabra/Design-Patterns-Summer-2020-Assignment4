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

	/**
	 * @param fp, Fileprocessor object
	 */
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
	}

	/**
	 * This method reads the input file and call accept() on MyArray 
	 * @param myArrayObj1
	 * @param res
	 * @return MyArrayI
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public MyArrayI setArray(MyArrayI myArrayObj1, Results res) throws NumberFormatException, IOException {
		boolean isInputFileEmpty=true;
		MyLogger.writeMessage("setArray() method in PopulateMyArrayVisitor", DebugLevel.POPULATEMYARRAYVISITOR);

		String line;
		while ((line = fp.poll()) != null) {
			isInputFileEmpty=false;
			value = Integer.parseInt(line);
			MyLogger.writeMessage("Reading of input1 file", DebugLevel.NONE);
			myArrayObj1.accept(this, res);
		}
		
		if(isInputFileEmpty==true)
			throw new RuntimeException("Empty Input file");
		return myArrayObj1;

	}

	/**
	 * This method accepts 2 array objects and call accept() on MyArrayListObj
	 * @param myArrayListObj1
	 * @param myArrayObj
	 * @param res
	 * @return
	 * @throws IOException
	 */
	public List<MyArrayI> createMyArrayList(MyArrayListI myArrayListObj1, MyArrayI myArrayObj, Results res)
			throws IOException {
		this.myArrayObj = myArrayObj;

		myArrayListObj1.accept(this, res);
		return arrList;
	}

	public void printArrayList() {

	}

}
