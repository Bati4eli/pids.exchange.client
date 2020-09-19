package ru.bati4eli.pids.exchange.client.log

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//@Singleton
class MyLog {

    public static final log = new MyLog()

    private MyLog() {}

    void warn(Object msg) {
        def state = "[WARN]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    void error(Object msg) {
        def state = "[ERROR]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    void debug(Object msg) {
        def state = "[DEBUG]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    void info(Object msg) {
        def state = "[INFO]"
        print "${printDate()}\t$state\t${printObj(msg)}"
    }

    private static String printDate() {
        "${LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}"
    }

    private static String printObj(Object obj) {
        "${obj?.toString()}\n"
    }
}
