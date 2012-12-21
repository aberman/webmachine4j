package webmachine4j;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FrameworkServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * Overridden method that simply returns <code>null</code> when no
	 * ServletConfig set yet.
	 * 
	 * @see #getServletConfig()
	 */
	@Override
	public final String getServletName() {
		return (getServletConfig() != null ? getServletConfig()
				.getServletName() : null);
	}

	/**
	 * Overridden method that simply returns <code>null</code> when no
	 * ServletConfig set yet.
	 * 
	 * @see #getServletConfig()
	 */
	@Override
	public final ServletContext getServletContext() {
		return (getServletConfig() != null ? getServletConfig()
				.getServletContext() : null);
	}

	/**
	 * Override the parent class implementation in order to intercept PATCH
	 * requests.
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected abstract void processRequest(HttpServletRequest request,
			HttpServletResponse response);
}
