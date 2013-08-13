package webmachine4j;

import webmachine4j.util.Tuple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.nio.charset.Charset;

public abstract class AbstractWebmachineResource implements Serializable, WebmachineResource {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#allowedMethods(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public Methods[] allowedMethods(HttpServletRequest request) {
        return new Methods[]{Methods.GET, Methods.HEAD};
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#allowMissingPost(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public boolean allowMissingPost(HttpServletRequest request) {
        return false;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#charsetsProvided(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public Tuple<Charset, String>[] charsetsProvided(
            HttpServletRequest request) {
        return null;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#contentTypesAccepted(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public Tuple<String, String>[] contentTypesAccepted(
            HttpServletRequest request) {
        return null;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#contentTypesProvided(javax.servlet.http.HttpServletRequest)
     */
    @Override
    @SuppressWarnings("unchecked")
    public Tuple<String, String>[] contentTypesProvided(
            HttpServletRequest request) {
        return new Tuple[]{new Tuple<String, String>("text/html", "toHtml")};
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#createPath(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String createPath(HttpServletRequest request) {
        return null;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#deleteCompleted(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public boolean deleteCompleted(HttpServletRequest request,
                                   HttpServletResponse response) {
        return true;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#deleteResource(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public boolean deleteResource(HttpServletRequest request,
                                  HttpServletResponse response) {
        return false;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#encodingsProvided(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Tuple<String, String> encodingsProvided(HttpServletRequest request,
                                                   HttpServletResponse response) {
        //Include identity encoding
        return null;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#expires(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void expires(HttpServletRequest request,
                        HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#finishRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void finishRequest(HttpServletRequest request,
                              HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#forbidden(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void forbidden(HttpServletRequest request,
                          HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_FORBIDDEN;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#generateEtag(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void generateEtag(HttpServletRequest request,
                             HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#isAuthorized(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void isAuthorized(HttpServletRequest request,
                             HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_UNAUTHORIZED;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#isConflict(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void isConflict(HttpServletRequest request,
                           HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_CONFLICT;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#knownContentType(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void knownContentType(HttpServletRequest request,
                                 HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#knownMethods(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void knownMethods(HttpServletRequest request,
                             HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_NOT_IMPLEMENTED;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#languageChosen(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void languageChosen(HttpServletRequest request,
                               HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#languagesProvided(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void languagesProvided(HttpServletRequest request,
                                  HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#lastModified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void lastModified(HttpServletRequest request,
                             HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#malformedRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void malformedRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_BAD_REQUEST;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#movedPermanently(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void movedPermanently(HttpServletRequest request,
                                 HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_MOVED_PERMANENTLY;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#movedTemporarily(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void movedTemporarily(HttpServletRequest request,
                                 HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_MOVED_TEMPORARILY;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#multipleChoices(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void multipleChoices(HttpServletRequest request,
                                HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_OK;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#options(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void options(HttpServletRequest request,
                        HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_OK;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#postIsCreate(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void postIsCreate(HttpServletRequest request,
                             HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#previouslyExisted(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void previouslyExisted(HttpServletRequest request,
                                  HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#processPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void processPost(HttpServletRequest request,
                            HttpServletResponse response) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#resourceExists(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void resourceExists(HttpServletRequest request,
                               HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_NOT_FOUND;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#serviceAvailable(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void serviceAvailable(HttpServletRequest request,
                                 HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_SERVICE_UNAVAILABLE;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#uriTooLong(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void uriTooLong(HttpServletRequest request,
                           HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_REQUEST_URI_TOO_LONG;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#validContentHeaders(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void validContentHeaders(HttpServletRequest request,
                                    HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_NOT_IMPLEMENTED;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#validEntityLength(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void validEntityLength(HttpServletRequest request,
                                  HttpServletResponse response) {
        int errorCode = HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE;
    }

    /* (non-Javadoc)
     * @see webmachine4j.WebmachineResource#variances(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void variances(HttpServletRequest request,
                          HttpServletResponse response) {
        // TODO Auto-generated method stub
    }
}
