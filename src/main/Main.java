package main;

import gui.Menu;
import gui.Setting;

public class Main {

    public static void main(String[] args) {

//        GameHandler.startOfflineGame();
        Menu menu = new Menu() {
            @Override
            public void offline() {
                GameHandler.startOfflineGame();
                dispose();
                setVisible(false);
            }

            @Override
            public void onlineClient() {
                GameHandler.startClientOnline();
                dispose();
                setVisible(false);
            }

            @Override
            public void onlineServer() {
                GameHandler.startServerOnline();
                dispose();
                setVisible(false);
            }

            @Override
            public void setting() {
                Setting setting = new Setting();
                setting.setVisible(true);
//                dispose();
//                setVisible(false);
            }
        };
        menu.setVisible(true);


    }

}