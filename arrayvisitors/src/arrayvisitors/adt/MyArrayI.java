package arrayvisitors.adt;

import arrayvisitors.visitors.Visitor;

public interface MyArrayI {
	
	public int getInts(int index);
	public void addInts(int value);
	public int length();
	public void accept(Visitor visitor);

}
