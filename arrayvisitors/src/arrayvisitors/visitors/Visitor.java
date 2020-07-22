package arrayvisitors.visitors;

import java.io.IOException;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

public interface Visitor {
	public void visit(MyArrayI myarray);
	public void visit(MyArrayListI myarraylist,Results res) throws IOException;

}
