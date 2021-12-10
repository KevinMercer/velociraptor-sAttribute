package net.attribute.velociraptor.util;

/**
 * @author warren
 * @function locate the line
 * @createDate 2021/12/1 9:53
 * @updateDate 2021/12/1 9:53
 * @updateAuthor
 * @describe return a string to locate the line
 */
@SuppressWarnings("unused")
public class LineNumberUtil {
    public static String exceptionThrowLineNumber() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return "Exception throw at " + stackTraceElement.getFileName() + " " + stackTraceElement.getMethodName() + " line " + stackTraceElement.getLineNumber();
    }

    public static String showLogLine(Object object) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return "print at " + stackTraceElement.getFileName() + " " + stackTraceElement.getMethodName() + " line " + stackTraceElement.getLineNumber();
    }
}
