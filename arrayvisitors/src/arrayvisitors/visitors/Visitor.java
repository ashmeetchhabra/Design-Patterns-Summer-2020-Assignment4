package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public interface Visitor {
	public void visit(MyArrayI myarray);
	public void visit(MyArrayListI myarraylist);

}
