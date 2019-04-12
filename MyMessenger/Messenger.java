package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Messenger {
    private static JTextArea chatKW,chatKQ,chatWK,chatWQ,chatQK,chatQW;
    private static ArrayList<JTextArea> chatListArea;
    private static ArrayList<String> loginList;
    private static JTextArea inputText;
    private static JFrame frame;
    private static PrintWriter writer;
    private static BufferedReader reader;
    private static String login = null;
    private static String selectedUser;
    private static ArrayList<String> listUser;
    private static int selected;
    private static boolean KW,KQ,WK,WQ,QK,QW;
    private static String KIRILL = "Kirill";
    private static String WILD = "Wild";
    private static String QWERTY = "Qwerty";
    private static JScrollPane scrollChat = null;

    public static void main(String[] args) {
        runClient();
    }

    private static void runClient(){
        JPanel panel1 = new JPanel();
        chatListArea = new ArrayList<>();
        chatKW = new JTextArea();
        chatKQ = new JTextArea();
        chatWK = new JTextArea();
        chatWQ = new JTextArea();
        chatQK = new JTextArea();
        chatQW = new JTextArea();
        chatListArea.add(chatKW);
        chatListArea.add(chatKQ);
        chatListArea.add(chatWK);
        chatListArea.add(chatWQ);
        chatListArea.add(chatQK);
        chatListArea.add(chatQW);

        inputText = new JTextArea();
        inputText.setEditable(false);
        JButton sendMessage = new JButton();

        loginList = new ArrayList<>();
        do{
            login = JOptionPane.showInputDialog("Введите ваш никнейм");
//            writer.println("/l"+login);
//            loginList.add(login);
        }while(!login.equals(KIRILL)&&!login.equals(WILD)&&!login.equals(QWERTY));


        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel2.setPreferredSize(new Dimension(350, 300));
        panel1.add(panel2, BorderLayout.WEST);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        
        scrollChat = new JScrollPane();
        scrollChat.setPreferredSize(new Dimension(2, 300));
        panel2.add(scrollChat, BorderLayout.NORTH);
        scrollChat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));

        for (JTextArea jTextArea : chatListArea) {
            jTextArea.setEditable(false);
            jTextArea.setWrapStyleWord(true);
            jTextArea.setVisible(true);
        }

        final JScrollPane scrollInputText = new JScrollPane();
        scrollInputText.setPreferredSize(new Dimension(0, 80));
        panel2.add(scrollInputText, BorderLayout.SOUTH);
        scrollInputText.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), null));
        scrollInputText.setViewportView(inputText);

        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        panel3.setPreferredSize(new Dimension(140, 0));
        panel1.add(panel3, BorderLayout.EAST);
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));

        listUser = new ArrayList<>();
        listUser.add(KIRILL);
        listUser.add(WILD);
        listUser.add(QWERTY);
        for (int i = 0; i < listUser.size(); i++) {
            if(login.equals(listUser.get(i))){
                listUser.remove(i);
            }
        }

        final JList<Object> list = new JList<>(listUser.toArray());

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( e.getClickCount() == 1 ) {
                    // Получение элемента
                    inputText.setEditable(true);
                    selected = list.locationToIndex(e.getPoint());
                    list.setSelectionBackground(Color.CYAN);
                    String txt = "";
                    selectedUser = listUser.get(selected);
                    txt += selectedUser + "\n";

                    KW = ((login.equals(KIRILL)) && (selectedUser.equals(WILD)));
                    KQ = ((login.equals(KIRILL)) && (selectedUser.equals(QWERTY)));
                    WK = ((login.equals(WILD)) && (selectedUser.equals(KIRILL)));
                    WQ = ((login.equals(WILD)) && (selectedUser.equals(QWERTY)));
                    QK = ((login.equals(QWERTY)) && (selectedUser.equals(KIRILL)));
                    QW = ((login.equals(QWERTY)) && (selectedUser.equals(WILD)));

                    if(KW){
                        System.out.println("kw -" + KW);
                        chatKW.selectAll();
                        chatKW.replaceSelection("");
                        chatKW.setBackground(Color.GREEN);
                        scrollChat.setViewportView(chatKW);
                    } else if(KQ) {
                        System.out.println("KQ -" + KQ);
                        chatKQ.selectAll();
                        chatKQ.replaceSelection("");
                        chatKQ.setBackground(Color.gray);
                        scrollChat.setViewportView(chatKQ);
                    } else if(WK){
                        chatWK.selectAll();
                        chatWK.replaceSelection("");
                        chatWK.setBackground(Color.cyan);
                        scrollChat.setViewportView(chatWK);
                    } else if(WQ){
                        chatWQ.selectAll();
                        chatWQ.replaceSelection("");
                        chatWQ.setBackground(Color.orange);
                        scrollChat.setViewportView(chatWQ);
                    } else if(QK){
                        chatQK.selectAll();
                        chatQK.replaceSelection("");
                        chatQK.setBackground(Color.GREEN);
                        scrollChat.setViewportView(chatQK);
                    } else if(QW){
                        chatQW.selectAll();
                        chatQW.replaceSelection("");
                        chatQW.setBackground(Color.GREEN);
                        scrollChat.setViewportView(chatQW);
                    }

                    String message = login + selectedUser;
                    writer.println(message);
                    writer.flush();

                    frame.setTitle(txt);
                    list.clearSelection();

                }
            }
        });

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scrollListUser = new JScrollPane(list);
        scrollListUser.setPreferredSize(new Dimension(10, 300));
        panel3.add(scrollListUser, BorderLayout.NORTH);

        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout(0, 0));
        panel4.setMinimumSize(new Dimension(0, 0));
        panel4.setPreferredSize(new Dimension(0, 90));
        panel3.add(panel4, BorderLayout.SOUTH);

        sendMessage.setText("Отправить");
        panel4.add(sendMessage, BorderLayout.CENTER);
        sendMessage.addActionListener(new Send());

        setNet();

        Thread threadListener = new Thread( new Listener());
        threadListener.start();

        writer.println(login);
        writer.flush();

        frame = new JFrame("Messenger");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(550, 450);
        frame.setVisible(true);
    }


    private static class Listener implements Runnable{
        @Override
        public void run() {
            String message;
            try{
                while((message = reader.readLine()) != null) {

                    if (!message.equals(login) || message.equals(selectedUser + login) || message.equals(login + selectedUser)) {
                        String rlogin;
                        String rRecipient = null;
                        String mesBody;
                        //преобразование строки во время чтения истории
//                            if (message.startsWith("/h")) {
//                                message = message.substring(2);
//                            }
                        String[] splitMessage = message.split(":", 3);
                        rRecipient = splitMessage[0];
                        rlogin = splitMessage[1];
                        mesBody = splitMessage[2];

                        if ((login.equals(KIRILL)&& selectedUser.equals(WILD)) || ((login.equals(WILD)&& selectedUser.equals(KIRILL)))) {
                            chatKW.append(rlogin + ": " + mesBody + "\n");
                            chatWK.append(rlogin + ": " + mesBody + "\n");
                        } else if ((login.equals(KIRILL)&& selectedUser.equals(QWERTY)) || (login.equals(QWERTY)&& selectedUser.equals(KIRILL))) {
                            chatKQ.append(rlogin + ": " + mesBody + "\n");
                            chatQK.append(rlogin + ": " + mesBody + "\n");
                        } else if ((login.equals(WILD)&& selectedUser.equals(QWERTY)) || (login.equals(QWERTY)&& selectedUser.equals(WILD))) {
                            chatWQ.append(rlogin + ": " + mesBody + "\n");
                            chatQW.append(rlogin + ": " + mesBody + "\n");
                        }
                    }
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private static class Send implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = listUser.get(selected) + ":" + login + ":" + inputText.getText();
            writer.println(message);
            writer.flush();

            inputText.setText("");
            inputText.requestFocus();

            for (String arrayList : loginList) {
                System.out.println(arrayList);
            }
        }
    }

    private static void setNet() {
        Socket socket = null;
        try{
            socket = new Socket("127.0.0.1",8087);
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(inputStreamReader);
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
