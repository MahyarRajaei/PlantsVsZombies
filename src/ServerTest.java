import gui.Menu;
import main.GameHandler;

public class ServerTest {

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
                    dispose();
                    setVisible(false);
                }
            };
            menu.setVisible(true);


        }


}
