package ru.mera.korsakovkirill.postman;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Writers extends MyThreads{

    private static String fullStr;
    private static FileWriter fileWriter = null;
    private static boolean exitValue = true;
    private final Person user = new Person("Kirill", "Korsakov");

    @Override
    public void run() {

        Readers readers = new Readers();
        readers.start();

        String messageUser;
        String fullMessageUser;
        Scanner scn = new Scanner(System.in);
        long receiveDateLastMessLong;

        while (exitValue) {
            synchronized (readers){
                messageUser = scn.nextLine();
                receiveDate = new Date();
                outPutMessage(messageUser);
                if (exitValue) {
                    date = simpleDateFormat.format(receiveDate);
                    fullMessageUser = date + " " + user + messageUser;
                    writeHistory(fullMessageUser);
                    indicator = true;
                    try {
                        readers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                receiveDateLastMessLong = System.currentTimeMillis();
                dateLastMessageLongWrite(receiveDateLastMessLong);
            }
        }
    }

    private static void dateLastMessageLongWrite(Long dateStr) {
        fullStr = Long.toString(dateStr);
        try {
            fileWriter = new FileWriter(pathDate);
            fileWriter.write(fullStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeHistory(String str) {
        String lineSeparator = System.getProperty("line.separator");
        fullStr = lineSeparator + str;
        try {
            fileWriter = new FileWriter(pathMessage, true);
            fileWriter.write(fullStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void outPutMessage(String messageUser){
        if(messageUser.equals("!выход")|| messageUser.equals("!exit")){
            exitValue = false;
            System.out.println("Очень жаль, что ты уходишь... Возвращайся скорее!");
        }
    }
}
