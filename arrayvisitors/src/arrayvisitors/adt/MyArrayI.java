package arrayvisitors.adt;

import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

public interface MyArrayI extends Element {
	
	public int getInt(int index);
	public void addInts(int value);
	public int length();
	public void accept(Visitor visitor);
	public void displayElements();
	

}
