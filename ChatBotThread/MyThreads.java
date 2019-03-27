package ru.mera.korsakovkirill.postman;

import java.text.SimpleDateFormat;
import java.util.Date;

class MyThreads extends Thread {
    volatile static boolean indicator;
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm ");
    static Date receiveDate;
    static long receiveDateLong;
    static String date;
    static String pathMessage = "C:\\Users\\Kirill\\IdeaProjects\\ChatThread\\HistoryThread.txt";
    static String pathDate = "C:\\Users\\Kirill\\IdeaProjects\\ChatThread\\DateLastMessageThread.txt";
}
