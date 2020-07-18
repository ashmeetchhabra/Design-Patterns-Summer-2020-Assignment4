package arrayvisitors.adt;

import arrayvisitors.visitors.Visitor;

public class MyArray implements MyArrayI {
	

	@Override
	public int getInts(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addInts(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
