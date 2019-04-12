package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class Server {
    private static ArrayList<PrintWriter> streams;
    private static PrintWriter writer;
    private static Statement statementBD;
    private static Connection connectionBD;
    private static Socket socket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer()  {
        streams = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(8087);
            while (true){
                socket = serverSocket.accept();
                System.out.println("Пользователь подключён!");

                Thread threadListener = new Thread(new Listener(socket));
                threadListener.start();

                writer = new PrintWriter(socket.getOutputStream());
                streams.add(writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Listener implements Runnable{

        BufferedReader reader;
        int numberDialog;

        Listener(Socket socket){
            InputStreamReader inputStreamReader;
            try {
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(inputStreamReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            String message;

            try {
                setBD();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try{
                while((message = reader.readLine()) != null){
                    if(message.equals("KirillWild") || message.equals("WildKirill")){
                        numberDialog = 1;
                        sendHistory(numberDialog);
                        while ((message = reader.readLine()) != null) {
                            if (!message.equals("KirillWild") && !message.equals("WildKirill")) {
                                if(message.equals("KirillQwerty") || message.equals("QwertyKirill") || message.equals("WildQwerty") || message.equals("QwertyWild")){
                                    System.out.println(message);
                                    break;
                                } else {
                                    send(message);
                                }
                            } else {
                                break;
                            }
                        }

                    } else if (message.equals("KirillQwerty") || message.equals("QwertyKirill")){
                        numberDialog = 2;
                        sendHistory(numberDialog);
                        while ((message = reader.readLine()) != null){
                            if(!message.equals("KirillQwerty") && !message.equals("QwertyKirill")){
                                if(message.equals("KirillWild") || message.equals("WildKirill") || message.equals("WildQwerty") || message.equals("QwertyWild") ) {
                                    System.out.println(message);
                                    break;
                                } else {
                                    send(message);
                                }
                            }else {
                                break;
                            }
                        }
                    } else if(message.equals("WildQwerty") || message.equals("QwertyWild")){
                        numberDialog = 3;
                        sendHistory(numberDialog);
                        while ((message = reader.readLine()) != null){
                            if(!message.equals("WildQwerty") && !message.equals("QwertyWild")){
                                if(message.equals("KirillWild") || message.equals("WildKirill") || message.equals("KirillQwerty")|| message.equals("QwertyKirill")) {
                                    System.out.println(message);
                                    break;
                                } else {
                                    send(message);
                                }
                            }else {
                                break;
                            }
                        }
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        private void send(String message) throws  SQLException{

            String[] splitMessage = message.split(":",3);
            String recipient = splitMessage[0];
            String login = splitMessage[1];
            String mesBody = splitMessage[2];

            String receiverMessage = recipient + ":" + login + ": " + mesBody;

            saveBD(login, mesBody, recipient, numberDialog);

            for (PrintWriter stream : streams) {
                try {
                    PrintWriter writer = stream;
                    writer.println(receiverMessage);
                    writer.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        private void sendHistory (int numberDialog) throws SQLException {
            String SQL = null;
            switch(numberDialog){
                case 1:
                    SQL = "SELECT `recipient`, `login`,`message`  FROM  `historykirillwild`";
                    break;
                case 2:
                    SQL = "SELECT `recipient`, `login`, `message` FROM `historykirillqwerty`";
                    break;
                case 3:
                    SQL = "SELECT `recipient`, `login`,`message`  FROM  `historyqwertywild`";
                    System.out.println("послал историю");
                    break;
            }

            ResultSet resultSet = statementBD.executeQuery(SQL);

            while (resultSet.next()) {
                writer.println(resultSet.getString("recipient")+ ":" + resultSet.getString("login") + ": " + resultSet.getString("message"));
                writer.flush();
            }

        }

        private void saveBD(String login, String mesBody, String recipient, int numberDialog) throws SQLException {

            String SQL = null;
            switch(numberDialog){
                case 1:
                    SQL = "INSERT INTO `messenger`.`historykirillwild` (`login`,`recipient`, `message` ) VALUES ('"+login+"', '"+recipient+"','"+mesBody+"');";
                    break;
                case 2:
                    SQL = "INSERT INTO `messenger`.`historykirillqwerty` (`login`,`recipient`, `message` ) VALUES ('"+login+"', '"+recipient+"','"+mesBody+"');";
                    break;
                case 3:
                    SQL = "INSERT INTO `messenger`.`historyqwertywild` (`login`,`recipient`, `message` ) VALUES ('"+login+"', '"+recipient+"','"+mesBody+"');";
                    break;
            }
            statementBD.executeUpdate(SQL);
        }

        private void setBD() throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            String url = "jdbc:mysql://localhost/messenger?serverTimezone=Europe/Moscow&useSSL=false";
            String login = "Korsakov";
            String pass = "Korsakov";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance(); // загрузка драйвера
            connectionBD = DriverManager.getConnection(url,login,pass);
            statementBD = connectionBD.createStatement();
        }
    }

}