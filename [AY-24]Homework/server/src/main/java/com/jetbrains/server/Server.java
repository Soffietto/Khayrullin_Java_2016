package com.jetbrains.server;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JPanel {
    protected JTextField textField;
    protected static JTextArea textArea;
    public final static String CLIENT_NAME = "Server: ";
    private final static String NEWLINE = "\n";
    private static ServerSocket ss;
    private static Socket s;
    private static DataInputStream din;
    private static DataOutputStream dout;
    public static final int PORT = 8080;

    private Server() {
        super(new GridBagLayout());

        JButton jButton = new JButton("Send message");
        jButton.addActionListener(e -> {
            String text = "";
            text = textField.getText();
            try {
                dout.writeUTF(CLIENT_NAME +text + NEWLINE);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            textArea.append(CLIENT_NAME + text + NEWLINE);
            textField.setText("");
            textArea.setCaretPosition(textArea.getDocument().getLength());
        });

        textField = new JTextField();
        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
        add(jButton);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Server());
        frame.setBounds(200, 200, 400, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Server::createAndShowGUI);
        String msgin = "";
        try {
            ss = new ServerSocket(PORT);
            s = ss.accept();

            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while (!msgin.equals("exit")){
                msgin = din.readUTF();
                textArea.setText(textArea.getText().trim() + NEWLINE + msgin);
            }
        }catch (Exception e){

        }
    }
}
