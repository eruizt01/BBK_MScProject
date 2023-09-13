/*

package mscproject.cartelapp;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AppErrorController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppErrorController.class);

    private final ErrorAttributes errorAttributes;

    private static final String ERROR_PATH = "/error";

    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        Map<String, Object> errorDetails = getErrorAttributes(request, false);
        LOGGER.error("Error occurred: {}", errorDetails);
        return new ModelAndView("errors/error", customizeErrorAttributes(errorDetails));
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = customizeErrorAttributes(getErrorAttributes(request, getTraceParameter(request)));
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        return parameter != null && !"false".equals(parameter.toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        WebRequest webRequest = new ServletWebRequest(request);
        ErrorAttributeOptions options = includeStackTrace ? ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE) : ErrorAttributeOptions.defaults();
        return this.errorAttributes.getErrorAttributes(webRequest, options);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception ex) {
                LOGGER.error("Invalid HTTP status code: {}", statusCode, ex);
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private Map<String, Object> customizeErrorAttributes(Map<String, Object> originalErrorAttributes) {
        Map<String, Object> customizedAttributes = new HashMap<>();
        customizedAttributes.put("message", originalErrorAttributes.getOrDefault("message", "No message available"));
        customizedAttributes.put("status", originalErrorAttributes.getOrDefault("status", "Unknown"));
        customizedAttributes.put("exception", originalErrorAttributes.getOrDefault("exception", "N/A"));
        customizedAttributes.put("trace", originalErrorAttributes.getOrDefault("trace", "N/A"));
        customizedAttributes.put("errors", originalErrorAttributes.getOrDefault("errors", "N/A"));
        return customizedAttributes;
    }
}

*/
