package webmachine4j;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.StringUtils;
import webmachine4j.util.Tuple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class DecisionServlet extends FrameworkServlet {

    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static ResourceBundle LOCAL_STRINGS = ResourceBundle
            .getBundle(LSTRING_FILE);
    private Map<String, String> handlerMap = new HashMap<String, String>();

    @Override
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) {
        String method = request.getMethod();
        WebmachineResource resource = null;

        isServiceAvailable(resource, request, response);
        isKnownMethod(resource, request, response);
        isURITooLong(resource, request, response);
        isMethodAllowed(resource, request, response);
        isRequestMalformed(resource, request, response);
        isAuthorized(resource, request, response);
        isForbidden(resource, request, response);
        hasUnknownContentHeader(resource, request, response);
        hasUnknownContentType(resource, request, response);
        isRequestEntityTooLarge(resource, request, response);

        if (method.equals(Methods.OPTIONS)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        doesAcceptExist(resource, request, response);
        doesAcceptLanguageExist(resourse, request, response);
        doesAcceptCharsetExist(resourse, request, response);
        doesAcceptEncodingExist(resourse, request, response);

        if (doesResourceExist(resource, request, response)) {

        } else {
            doesIfMatchExist(resource, request, response);
            if (method.equals(Methods.PUT)) {
                if (doesServerDesireDifferentURI(request, response)) {
                    movedPermanently(request, response);
                } else {

                }
            } else {

            }
        }
    }

    private void doesAcceptExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        //Throw an exception if it exists and is not valid, otherwise continue
        String acceptHeader = StringUtils.trimToNull(request.getHeader("Accept"));
        if (acceptHeader != null) {
            List<String> contentTypesProvided = CollectionUtils.collect(resource.contentTypesProvided(), new Transformer() {
                @Override
                public Object transform(Object input) {
                    ((Tuple<String, Method>) input).getX();
                }
            };

            //TODO: Need a proper parser for this
            String[] acceptValues = StringUtils.split(acceptHeader, ",");
            if (!contentTypesProvided.containsAll(acceptValues))
                notAcceptable(request, response);
        }
    }

    private void doesAcceptLanguageExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        //Throw an exception if it exists and is not valid, otherwise continue
        String acceptLanguageHeader = StringUtils.trimToNull(request.getHeader("Accept-Language"));
        if (acceptLanguageHeader != null) {
            List<String> languagesProvided = resource.getLanguagesProvided();

            //If empty, skip
            if (!languagesProvided.isEmpty()) {
                //TODO: Need a proper parser for this
                String[] acceptLanguageValues = StringUtils.split(acceptHeader, ",");
                if (!languagesProvided.contains(acceptLanguageValues))
                    notAcceptable(request, response);
            }
        }
    }

    private void doesAcceptCharsetExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        //Throw an exception if it exists and is not valid, otherwise continue
        String acceptCharsetHeader = StringUtils.trimToNull(request.getHeader("Accept-Charset"));
        if (acceptCharsetHeader != null) {
            List<String> charsetsProvided = resource.getCharsetsProvided();

            //If empty, skip
            if (!charsetsProvided.isEmpty()) {
                //TODO: Need a proper parser for this
                String[] acceptCharsetValues = StringUtils.split(acceptCharsetHeader, ",");
                if (!charsetsProvided.contains(acceptCharsetValues))
                    notAcceptable(request, response);
            }
        }
    }

    private void doesResourceExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        if (!resource.resourceExists())
            notFound(request, response);
    }

    private void doesAcceptEncodingExist(WebmachineResource resource, HttpServletRequest request, HttpServletResponse response) {
        //Throw an exception if it exists and is not valid, otherwise continue
//        String acceptEncodingHeader = StringUtils.trimToNull(request.getHeader("Accept-Encoding"));
//        if (acceptEncodingHeader != null) {
//            List<String> encodingsProvided = resource.getEncodingsProvided();
//
//            //If empty, skip
//            if (!charsetsProvided.isEmpty()) {
//                //TODO: Need a proper parser for this
//                String[] acceptCharsetValues = StringUtils.split(acceptCharsetHeader, ",");
//                if (!charsetsProvided.contains(acceptCharsetValues))
//                    notAcceptable(request, response);
//            }
//        }
    }

    private void isServiceAvailable(WebmachineResource resource,
                                    HttpServletRequest request, HttpServletResponse response) {
    }

    private void isKnownMethod(WebmachineResource resource,
                               HttpServletRequest request, HttpServletResponse response) {
    }

    private void sendResponse(HttpServletResponse response, int httpStatus,
                              String message) {

    }

    protected void methodNotAllowed() {
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
