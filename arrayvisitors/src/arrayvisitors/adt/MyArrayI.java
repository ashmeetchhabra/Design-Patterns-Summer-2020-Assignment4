package arrayvisitors.adt;

import java.io.IOException;

import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

public interface MyArrayI extends Element {
	
	public int getInt(int index);
	public void addInts(int value);
	public int length();
	public void displayElements() throws IOException;
	

}
