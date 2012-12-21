package webmachine4j;

import java.io.Serializable;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Methods[] allowedMethods(HttpServletRequest request) {
		return new Methods[] { Methods.GET, Methods.HEAD };
	}

	protected boolean allowMissingPost(HttpServletRequest request) {
		return false;
	}

	protected Tuple<Charset, String>[] charsetsProvided(
			HttpServletRequest request) {
		return null;
	}

	protected Tuple<String, String>[] contentTypesAccepted(
			HttpServletRequest request) {
		return null;
	}

	@SuppressWarnings("unchecked")
	protected Tuple<String, String>[] contentTypesProvided(
			HttpServletRequest request) {
		return new Tuple[] { new Tuple<String, String>("text/html", "toHtml") };
	}

	protected String createPath(HttpServletRequest request) {
		return null;
	}

	protected boolean deleteCompleted(HttpServletRequest request,
			HttpServletResponse response) {
		return true;
	}

	protected boolean deleteResource(HttpServletRequest request,
			HttpServletResponse response) {
		return false;
	}

	protected Tuple<String, String> encodingsProvided(HttpServletRequest request,
			HttpServletResponse response) {
		//Include identity encoding
		return null;
	}

	protected void expires(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void finishRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void forbidden(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_FORBIDDEN;
	}

	protected void generateEtag(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void isAuthorized(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_UNAUTHORIZED;
	}

	protected void isConflict(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_CONFLICT;
	}

	protected void knownContentType(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE;
	}

	protected void knownMethods(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_NOT_IMPLEMENTED;
	}

	protected void languageChosen(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void languagesProvided(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void lastModified(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void malformedRequest(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_BAD_REQUEST;
	}

	protected void movedPermanently(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_MOVED_PERMANENTLY;
	}

	protected void movedTemporarily(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_MOVED_TEMPORARILY;
	}

	protected void multipleChoices(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_OK;
	}

	protected void options(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_OK;
	}

	protected void postIsCreate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void previouslyExisted(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void processPost(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	protected void resourceExists(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_NOT_FOUND;
	}

	protected void serviceAvailable(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_SERVICE_UNAVAILABLE;
	}

	protected void uriTooLong(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_REQUEST_URI_TOO_LONG;
	}

	protected void validContentHeaders(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_NOT_IMPLEMENTED;
	}

	protected void validEntityLength(HttpServletRequest request,
			HttpServletResponse response) {
		int errorCode = HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE;
	}

	protected void variances(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
	}
}
