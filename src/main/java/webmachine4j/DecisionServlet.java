package webmachine4j;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DecisionServlet extends FrameworkServlet {

	private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
	private static ResourceBundle LOCAL_STRINGS = ResourceBundle
			.getBundle(LSTRING_FILE);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	protected void methodNotAllowed(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_METHOD_NOT_ALLOWED;
	}
	
	protected void notAcceptable(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_NOT_ACCEPTABLE;
	}

	protected void ifMatch(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_PRECONDITION_FAILED;
	}

	protected void ifUnmodifiedSince(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_PRECONDITION_FAILED;
	}

	protected void ifNoneMatch(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_PRECONDITION_FAILED;
	}

	protected void notModified(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_NOT_MODIFIED;
	}

	protected void preconditionFailed(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_PRECONDITION_FAILED;
	}

	protected void isPostToMissingResource(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}



	protected void doMethod(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void putResource(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

}
