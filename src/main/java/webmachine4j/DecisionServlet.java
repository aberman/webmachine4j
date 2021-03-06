package webmachine4j;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class DecisionServlet extends FrameworkServlet {

    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final List<String> KNOWN_METHODS = Arrays.asList(new String[]{
            "HEAD", "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"
    });
    private static ResourceBundle LOCAL_STRINGS = ResourceBundle
            .getBundle(LSTRING_FILE);
    private Map<String, String> handlerMap = new HashMap<String, String>();

    @Override
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) {
        String method = request.getMethod();
        WebmachineResource resource = null;

        try {
            isServiceAvailable(resource, request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void isServiceAvailable(WebmachineResource resource,
                                    HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.serviceAvailable())
            isKnownMethod(resource, request, response);

        sendServiceUnavailable(request, response);
    }

    private void isKnownMethod(WebmachineResource resource,
                               HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (KNOWN_METHODS.contains(request.getMethod()))
            isURITooLong(resource, request, response);

        sendNotImplemented(request, response);
    }

    private void isURITooLong(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.uriTooLong())
            isMethodAllowed(resource, request, response);

        sendRequestURITooLong(request, response);
    }

    private void isMethodAllowed(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.getAllowedMethods().contains(request.getMethod()))
            isRequestMalformed(resource, request, response);

        sendMethodNotAllowed(request, response);
    }

    private void isRequestMalformed(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!resource.malformedRequest())
            isAuthorized(resource, request, response);

        sendBadRequest(request, response);
    }

    private void isAuthorized(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.isAuthorized())
            isForbidden(resource, request, response);

        sendUnauthorized(request, response, null);
    }

    private void isForbidden(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!resource.forbidden())
            hasValidContentHeaders(resource, request, response);

        sendForbidden(request, response);
    }

    private void hasValidContentHeaders(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.validContentHeaders())
            hasKnownContentType(resource, request, response);

        sendNotImplemented(request, response);
    }

    private void hasKnownContentType(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.knownContentType())
            isRequestEntityTooLarge(resource, request, response);

        sendUnsupportedMediaType(request, response);
    }

    private void isRequestEntityTooLarge(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (resource.validEntityLength())
            isOptionsMethod(resource, request, response);

        sendRequestEntityTooLarge(request, response);
    }

    private void isOptionsMethod(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (false)
            doesAcceptExist(resource, request, response);

        //set allow header to allowed methods
        sendOK(request, response);
    }

    private void doesAcceptExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isAcceptableMediaTypeAvailable(resource, request, response);
        else
            doesAcceptLanguageExist(resource, request, response);
    }

    private void isAcceptableMediaTypeAvailable(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesAcceptLanguageExist(resource, request, response);
        else
            sendNotAcceptable(request, response);
    }

    private void doesAcceptLanguageExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isAcceptableLanguageAvailable(resource, request, response);
        else
            doesAcceptCharsetExist(resource, request, response);
    }

    private void isAcceptableLanguageAvailable(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesAcceptCharsetExist(resource, request, response);
        else
            sendNotAcceptable(request, response);
    }

    private void doesAcceptCharsetExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isAcceptableCharsetAvailable(resource, request, response);
        else
            doesAcceptEncodingExist(resource, request, response);
    }

    private void isAcceptableCharsetAvailable(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesAcceptEncodingExist(resource, request, response);
        else
            sendNotAcceptable(request, response);
    }

    private void doesAcceptEncodingExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isAcceptableEncodingAvailable(resource, request, response);
        else
            sendNotAcceptable(request, response);
    }

    private void isAcceptableEncodingAvailable(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesResourceExist(resource, request, response);
        else
            sendNotAcceptable(request, response);
    }

    private void doesResourceExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            hasIfMatch(resource, request, response);
        else
            hasIfMatchStar_H7(resource, request, response);
    }

    private void hasIfMatchStar_H7(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendPreconditionFailed(request, response);
        else
            isPutMethod_I7(resource, request, response);
    }

    private void hasIfMatch(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            hasIfMatchStarExist_G9(resource, request, response);
        else
            hasIfUnmodifiedSince(resource, request, response);
    }

    private void hasIfMatchStarExist_G9(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            hasIfUnmodifiedSince(resource, request, response);
        else
            hasEtagInIfMatch(resource, request, response);
    }

    private void hasEtagInIfMatch(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            hasIfUnmodifiedSince(resource, request, response);
        else
            sendPreconditionFailed(request, response);
    }

    private void hasIfUnmodifiedSince(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isIfUnmodifiedSinceValid(resource, request, response);
        else
            hasIfNoneMatch(resource, request, response);
    }

    private void isIfUnmodifiedSinceValid(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isLastModifiedGreaterThanIfUnmodifiedSince(resource, request, response);
        else
            hasIfNoneMatch(resource, request, response);
    }

    private void isLastModifiedGreaterThanIfUnmodifiedSince(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendPreconditionFailed(request, response);
        else
            hasIfNoneMatch(resource, request, response);
    }

    private void hasIfNoneMatch(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            hasIfNoneMatchStar(resource, request, response);
        else
            hasIfModifiedSince(resource, request, response);
    }

    private void hasIfNoneMatchStar(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isGetOrHeadMethod(resource, request, response);
        else
            hasEtagInIfNoneMatch(resource, request, response);
    }

    private void isGetOrHeadMethod(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendNotModified(request, response);
        else
            sendPreconditionFailed(request, response);
    }

    private void hasEtagInIfNoneMatch(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isGetOrHeadMethod(resource, request, response);
        else
            hasIfModifiedSince(resource, request, response);
    }

    private void hasIfModifiedSince(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isIfModifiedSinceValid(resource, request, response);
        else
            isDeleteMethod(resource, request, response);
    }

    private void isIfModifiedSinceValid(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isIfModifiedSinceGreaterThanNow(resource, request, response);
        else
            isDeleteMethod(resource, request, response);
    }

    private void isIfModifiedSinceGreaterThanNow(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isDeleteMethod(resource, request, response);
        else
            isLastModifiedGreaterThanIfModifiedSince(resource, request, response);
    }

    private void isLastModifiedGreaterThanIfModifiedSince(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isDeleteMethod(resource, request, response);
        else
            sendNotModified(request, response);
    }

    private void isDeleteMethod(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isDeleteEnacted(resource, request, response);
        else
            isPostMethod_N16(resource, request, response);
    }

    private void isPostMethod_N16(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isRedirect(resource, request, response);
        else
            isPutMethod_O16(resource, request, response);
    }

    private void isPutMethod_O16(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesConflictExist_O14(resource, request, response);
        else
            areThereMultipleRepresentations(resource, request, response);
    }

    private void doesConflictExist_O14(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendConflict(request, response);
        else
            isNewResource(resource, request, response);
    }

    private void isDeleteEnacted(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        if (true)
            doesResponseIncludeAnEntity(resource, request, response);
        else
            sendAccepted(request, response);
    }

    private void isPutMethod_I7(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesServerDesireDifferentURI(resource, request, response);
        else
            didResourcePreviouslyExist(resource, request, response);
    }

    private void doesServerDesireDifferentURI(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendMovedPermanently(request, response, null);
        else
            doesConflictExist(resource, request, response);
    }

    private void didResourcePreviouslyExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            didResourceMovePermanently(resource, request, response);
        else
            isPostMethod_L7(resource, request, response);
    }

    private void isPostMethod_L7(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesServerPermitPostToMissingResource_M7(resource, request, response);
        else
            sendNotFound(request, response);
    }

    private void doesServerPermitPostToMissingResource_M7(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isRedirect(resource, request, response);
        else
            sendNotFound(request, response);
    }

    private void didResourceMovePermanently(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendMovedPermanently(request, response, null);
        else
            didResourceMoveTemporarily(resource, request, response);
    }

    private void didResourceMoveTemporarily(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendMovedTemporarily(request, response, null);
        else
            isPostMethodM5(resource, request, response);
    }

    private void isPostMethodM5(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            doesServerPermitPostToMissingResource(resource, request, response);
        else
            sendGone(request, response);
    }

    private void doesServerPermitPostToMissingResource(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendSeeOther(request, response);
        else
            isNewResource(resource, request, response);
    }

    private void isRedirect(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            isRedirect(resource, request, response);
        else
            sendGone(request, response);
    }

    private void doesConflictExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (true)
            sendConflict(request, response);
        else
            isNewResource(resource, request, response);
    }

    private void isNewResource(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        if (true)
            sendCreated(request, response);
        else
            doesResponseIncludeAnEntity(resource, request, response);
    }

    private void doesResponseIncludeAnEntity(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        if (true)
            areThereMultipleRepresentations(resource, request, response);
        else
            sendNoContent(request, response);
    }

    private void areThereMultipleRepresentations(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        if (true)
            sendMultipleChoices(request, response);
        else
            sendOK(request, response);
    }

    private void sendServiceUnavailable(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    private void sendNotImplemented(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
    }

    private void sendRequestURITooLong(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_REQUEST_URI_TOO_LONG);
    }

    private void sendMethodNotAllowed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("allow", StringUtils.join(KNOWN_METHODS, ", "));
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private void sendBadRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }

    private void sendUnauthorized(HttpServletRequest request, HttpServletResponse response, String header) throws IOException {
        response.setHeader("www-authenticate", header);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private void sendForbidden(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    private void sendUnsupportedMediaType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
    }

    private void sendRequestEntityTooLarge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
    }

    private void sendOK(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void sendNotAcceptable(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
    }

    private void sendPreconditionFailed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
    }

    private void sendMovedPermanently(HttpServletRequest request, HttpServletResponse response, String location) {
        response.setHeader("location", location);
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    }

    private void sendMovedTemporarily(HttpServletRequest request, HttpServletResponse response, String location) {
        response.setHeader("location", location);
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
    }

    private void sendGone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_GONE);
    }

    private void sendConflict(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_CONFLICT);
    }

    private void sendCreated(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    private void sendSeeOther(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_SEE_OTHER);
    }

    private void sendNotFound(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    private void sendNoContent(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    private void sendAccepted(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    private void sendMultipleChoices(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_MULTIPLE_CHOICES);
    }

    private void sendNotModified(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
    }

}
