package network;

import interpreter.Parser;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class QuerySender {

    private static Socket socket;
    private static PrintWriter printWriter;
    private static BufferedWriter writer;


    public static void send(String query) {

        try {
            socket = new Socket("127.0.0.1", 8085);

            printWriter = new PrintWriter(socket.getOutputStream());
            writer = new BufferedWriter(printWriter);
            writer.write(query);
            writer.newLine();
            writer.flush();

            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader);
//            System.out.println(reader.readLine());
            Parser.runQuery(reader.readLine());

        } catch (IOException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Server isn't exist");
            System.exit(0);
        }
    }

}
