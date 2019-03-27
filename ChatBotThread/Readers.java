package ru.mera.korsakovkirill.postman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Readers extends MyThreads {

    private static String line;
    private static final Person bot = new Person("Bot", "Алёша");
    private static BufferedReader bufferedReader = null;

    @Override
    public void run() {
        readFullHistory();
        long dateLastMessageLong;
        long timeDifferenceLong;

        while(true) {
            synchronized (this) {
                if (indicator) {
                    if (bodyLastMessage() != null) {
                        String conMessBot = getMessBot(bodyLastMessage());
                        receiveDateLong = System.currentTimeMillis();
                        dateLastMessageLong = dateLastMessageLongRead();
                        timeDifferenceLong = receiveDateLong - dateLastMessageLong;
                        if (timeDifferenceLong >= 10800000 && dateLastMessageLong != 0) {
                            System.out.println(conMessBot + " - Что-то давно тебя не было видно!");
                        } else {
                            System.out.println(conMessBot);
                        }
                        indicator = false;
                    }
                }
                notify();
            }
        }
    }
    private static String getMessBot(String str){
        receiveDate = new Date();
        date = simpleDateFormat.format(receiveDate);
        return date + " " + bot + reverseCaseAndReplace(str);
    }

    private static String reverseCaseAndReplace(String lastLine) {
        String tab = " ";
        lastLine = lastLine.replace("!", ".").replace("?", ".").replaceAll(tab, "").replaceAll(tab, "");
        char[] chars = lastLine.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    private static void readFullHistory() {
        File filePath = new File(pathMessage);
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String bodyLastMessage(){
        File filePath = new File(pathMessage);
        String[] message = new String[5];
        String lastLine;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while (null != (line = bufferedReader.readLine())) {
                lastLine = line;
                message = lastLine.split(" ",5);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch(NullPointerException | IOException ex){
                ex.printStackTrace();
            }
        }
        lastLine = message[4];
        return lastLine;
    }

    private static long dateLastMessageLongRead(){
        File filePath = new File(pathDate);
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while (null != (line = bufferedReader.readLine())) {
                return Long.parseLong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch(NullPointerException | IOException ex){
                ex.printStackTrace();
            }
        }
        return 0;
    }
}
