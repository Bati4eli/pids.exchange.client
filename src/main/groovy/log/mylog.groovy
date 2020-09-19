package log

import java.time.LocalDateTime

public class mylog {

    static void warn(Object msg) {
        def state = "[WARN]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    static void error(Object msg) {
        def state = "[ERROR]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    static void debug(Object msg) {
        def state = "[DEBUG]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    static void info(Object msg) {
        def state = "[INFO]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    private static String printDate() {
        "${LocalDateTime.now()}"
    }

    private static String printObj(Object obj) {
        "${obj?.toString()}\n"
    }


}
