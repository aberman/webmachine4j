package webmachine4j;

import java.io.Serializable;

public class Tuple<X, Y> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private X x;
	private Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public final X getX() {
		return x;
	}

	public final Y getY() {
		return y;
	}

}
