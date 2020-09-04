package com.service.logging;

import com.service.language.Messages;

public class Log {
    public static void LogDuplicatedUrl(String url)
    {
        System.out.println(Messages.DUPLICATED_URL_MSG.replace("{?}", url));
    }

    public static void log(String msg)
    {
        System.out.println(msg);
    }
}
