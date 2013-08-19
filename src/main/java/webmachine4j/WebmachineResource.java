package webmachine4j;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrewberman
 * Date: 8/13/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public interface WebmachineResource {
    boolean serviceAvailable();

    boolean uriTooLong();

    List<String> getAllowedMethods();

    boolean malformedRequest();

    boolean isAuthorized();

    boolean forbidden();

    boolean validContentHeaders();

    boolean knownContentType();

    boolean validEntityLength();
}
