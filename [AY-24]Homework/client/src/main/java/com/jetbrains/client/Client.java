package com.jetbrains.client;

import com.jetbrains.server.Server;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JPanel {
    private JTextField textField;
    private static JTextArea textArea;
    public final static String CLIENT_NAME = "Client: ";
    private final static String NEWLINE = "\n";
    private static final String ADDRESS = "127.0.0.1";
    private static Socket s;
    private static DataOutputStream dout;
    private static DataInputStream din;


    public Client() {

        super(new GridBagLayout());

        JButton jButton = new JButton("Send message");
        jButton.addActionListener(e -> {
            String text = "";
            text = textField.getText();
            try {
                dout.writeUTF(CLIENT_NAME + text + NEWLINE);
            } catch (Exception e1) {
                //Unhandled exception
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
        JFrame frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Client());
        frame.setBounds(200, 200, 400, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Client::createAndShowGUI);

        try {
            s = new Socket(ADDRESS, Server.PORT);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msgin = "";
            while (!msgin.equals("exit")) {
                msgin = din.readUTF();
                textArea.setText(textArea.getText().trim() + NEWLINE + msgin);
            }
        } catch (Exception e) {
            //Unhandled Exception
        }
    }
}
