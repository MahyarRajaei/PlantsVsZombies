package network;

import creatures.*;
import database.Database;
import interpreter.Composer;
import interpreter.Key;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class QueryReceiver {

    ServerSocket serverSocket;
    BufferedReader reader;
    InputStreamReader inputStreamReader;
    Socket socket;

    public QueryReceiver() {
        try {
            serverSocket = new ServerSocket(8085);


            new Thread(() -> {
                while (true) {
                    try {
                        while (true) {
                            socket = serverSocket.accept();
                            inputStreamReader = new InputStreamReader(socket.getInputStream());
                            reader = new BufferedReader(inputStreamReader);
                            query(reader.readLine());
                            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());

                            BufferedWriter writer = new BufferedWriter(out);

                            if (Database.getNewPlants().size() != 0) {
                                for (Plant plant : Database.getNewPlants())
                                    if (plant instanceof OrdinaryShooterPlant)
                                        writer.write(Composer.getAddOrdinaryPlantShooterQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                                    else if (plant instanceof AngryShooterPlant)
                                        writer.write(Composer.getAddAngryPlantShooterQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                                    else if (plant instanceof SunFlower)
                                        writer.write(Composer.getAddPlantSunFlower(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                                    else if (plant instanceof Potato)
                                        writer.write(Composer.getAddPlantPotatoQuery(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getId()));
                                Database.clearNewPlants();
                            } else {
                                writer.write(Key.EMPTY_QUERY.getKey());
                            }

                            writer.newLine();
                            writer.flush();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void query(String query);


}
