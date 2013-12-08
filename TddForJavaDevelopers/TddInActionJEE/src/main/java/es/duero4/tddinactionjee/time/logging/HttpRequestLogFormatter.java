package es.duero4.tddinactionjee.time.logging;

import es.duero4.tddinactionjee.time.abstraction.SystemTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ramon
 */
public class HttpRequestLogFormatter {
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z");

    public String format(HttpServletRequest request, int httpStatusCode, int contentLength) {
        StringBuffer line = new StringBuffer();
        line.append(request.getRemoteAddr());
        line.append(" - ");
        line.append(request.getRemoteUser());
        line.append(" [");
        // 1 - Obtain current date and time from SystemTime
        line.append(dateFormat.format(SystemTime.asDate()));
        
        line.append("] \"").append(request.getMethod());
        line.append(" ").append(request.getRequestURI());
        line.append(" ").append(request.getProtocol());
        line.append("\" ").append(httpStatusCode);
        line.append(" ").append(contentLength);
        return line.toString();
    }
    
}
