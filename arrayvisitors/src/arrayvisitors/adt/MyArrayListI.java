package arrayvisitors.adt;

import java.util.List;

import arrayvisitors.visitors.Element;

public interface MyArrayListI extends Element {
	
	public List<MyArrayI> addMyArray(MyArrayI array);
	public MyArrayI getMyArray(int index);
	public int length();
	public void displayMyArrayList();
	public List<MyArrayI> getArrayList();


	
	

}
