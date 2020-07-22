package arrayvisitors.visitors;

import java.io.IOException;

import arrayvisitors.util.Results;

public interface Element {
	public void accept(Visitor visitor, Results res) throws IOException;

}
