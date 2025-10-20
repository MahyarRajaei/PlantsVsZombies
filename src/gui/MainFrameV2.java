package gui;

import creatures.*;
import database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

public class MainFrameV2 extends javax.swing.JFrame {


    private int rowCount = 5;
    private int plantsCountInRow = 9;

    private boolean isFrameForZombie = false;


    private final int endX;

    private final int row1Y;
    private final int row2Y;
    private final int row3Y;
    private final int row4Y;
    private final int row5Y;

    private enum ITEMS {
        NO_SELECTION(-1, -1),
        SUN_FLOWER(3000, 50),
        PLANT_1(5000, 100),
        PLANT_2(8000, 200),
        PLANT_POTATO(4000, 50),
        ZOMBIE_1(10000, 50),
        ZOMBIE_2(15000, 150);

        private int cooldown;
        private int price;

        ITEMS(int cooldown, int price) {
            this.cooldown = cooldown;
            this.price = price;
        }


        public int getCooldown() {
            return this.cooldown;
        }

        public int getPrice() {
            return this.price;
        }
    }

    //    int item = 0;
    ITEMS item = ITEMS.NO_SELECTION;


    private BufferStrategy bufferStrategy;

    public MainFrameV2(int FPS, boolean isFrameForZombie) {

        this.isFrameForZombie = isFrameForZombie;

        initComponents();
        setResizable(false);

        panel.setLayout(null);
        panel.setSize(getWidth(), getHeight());

        endX = endLabel.getX() + endLabel.getWidth();
//        System.out.println(endX);
        row1Y = separator1.getY();
        row2Y = separator2.getY();
        row3Y = separator3.getY();
        row4Y = separator4.getY();
        row5Y = separator5.getY();

        separator1.setVisible(false);
        separator2.setVisible(false);
        separator3.setVisible(false);
        separator4.setVisible(false);
        separator5.setVisible(false);


        zombiePosition1.setVisible(false);
//            zombiePosition2.setVisible(false);
        zombiePosition3.setVisible(false);
        zombiePosition4.setVisible(false);
        zombiePosition5.setVisible(false);
        zombiePosition6.setVisible(false);
//        jLabel4.setVisible(false);
//        jLabel5.setVisible(false);


        initPlantsStation();

        if (isFrameForZombie) {
            initZombieStartStation();
            sunFlowerItem.setVisible(false);
            potatoItem.setVisible(false);
            plant1Item.setVisible(false);
            plant2Item.setVisible(false);
//            starsCount.setVisible(false);
//            jLabel1.setVisible(false);
        } else {

            zombiePosition1.setVisible(false);
//            zombiePosition2.setVisible(false);
            zombiePosition3.setVisible(false);
            zombiePosition4.setVisible(false);
            zombiePosition5.setVisible(false);
            zombiePosition6.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
        }


        new Thread(() -> {
            while (true) {
                try {
                    repaint();
                    Thread.sleep(1000 / FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new Thread(() -> {
//
//            for (int i = 0; i < 1000; i++){
//                starsCount.setText(i + "");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//
//                System.out.println(i);
//            }
//
//        }).start();

    }

//    public void isFrameForZombie(boolean frameState) {
//
//        if (!frameState) {
//            zombiePosition1.setVisible(false);
////            zombiePosition2.setVisible(false);
//            zombiePosition3.setVisible(false);
//            zombiePosition4.setVisible(false);
//            zombiePosition5.setVisible(false);
//            zombiePosition6.setVisible(false);
//            jLabel4.setVisible(false);
//            jLabel5.setVisible(false);
//        } else {
//            sunFlowerItem.setVisible(false);
//            potatoItem.setVisible(false);
//            plant1Item.setVisible(false);
//            plant2Item.setVisible(false);
//            starsCount.setVisible(false);
//            jLabel1.setVisible(false);
//        }
//
//    }


    public int getRow1Coordinate() {
        return row1Y;
    }

    public int getRow2Coordinate() {
        return row2Y;
    }

    public int getRow3Coordinate() {
        return row3Y;
    }

    public int getRow4Coordinate() {
        return row4Y;
    }


    public int getRow5Coordinate() {
        return row5Y;
    }


    private void initZombieStartStation() {


        for (int i = 0; i < 5; i++) {

            int y = 0;
            if (i == 0) {
                y = row1Y;
            } else if (i == 1) {
                y = row2Y;
            } else if (i == 2) {
                y = row3Y;
            } else if (i == 3) {
                y = row4Y;
            } else if (i == 4) {
                y = row5Y;
            }

            JLabel zombieP = new JLabel();
            zombieP.setSize(80, 100);
            zombieP.setLocation(getWidth() - zombieP.getWidth() - 50, y - 10);
            zombieP.setIcon(new javax.swing.ImageIcon("./res/zombieStartStation.png"));
            zombieP.setText("" + i);
            zombieP.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if (item == ITEMS.ZOMBIE_1 && Database.getDollar() >= ITEMS.ZOMBIE_1.getPrice()) {
                        Database.setDollar(Database.getDollar() - ITEMS.ZOMBIE_1.getPrice());
                        OrdinaryZombie ordinaryZombie = new OrdinaryZombie(e.getComponent().getX(), e.getComponent().getY());
                        ordinaryZombie.run();
                        Database.addZombie(ordinaryZombie);
                        jLabel4.setBorder(null);
                        item = ITEMS.NO_SELECTION;
                    }
                }
            });
            panel.add(zombieP);


        }

    }


    private void initPlantsStation() {


        int distance = 90;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < plantsCountInRow; j++) {
                JLabel label = new JLabel();
                label.setSize(80, 80);
                label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                label.setText("" + i + j);
                int y = 0;
                if (i == 0) {
                    y = row1Y;
                } else if (i == 1) {
                    y = row2Y;
                } else if (i == 2) {
                    y = row3Y;
                } else if (i == 3) {
                    y = row4Y;
                } else if (i == 4) {
                    y = row5Y;
                }

//                System.out.println("i:" + i + "   " + "y:" + y);
                label.setLocation(endX + j * distance, y);
                label.setIcon(new javax.swing.ImageIcon("./res/grass.jpg"));
                label.setName("" + i + j);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        switch (item) {
                            case SUN_FLOWER:
                                SunFlower sunFlower = new SunFlower(e.getComponent().getX(), e.getComponent().getY());
                                Database.setStars(Database.getStars() - ITEMS.SUN_FLOWER.getPrice());
                                Database.addPlant(sunFlower);
                                new Thread(() -> {

                                    try {
                                        sunFlowerItem.setEnabled(false);
                                        Thread.sleep(ITEMS.SUN_FLOWER.getCooldown());
                                        sunFlowerItem.setEnabled(true);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                }).start();
                                sunFlowerItem.setEnabled(true);
                                sunFlowerItem.setBorder(null);
                                break;
                            case PLANT_POTATO:
                                Potato potato = new Potato(e.getComponent().getX(), e.getComponent().getY() + 20);
                                Database.setStars(Database.getStars() - ITEMS.PLANT_POTATO.getPrice());
                                new Thread(() -> {

                                    try {
                                        potatoItem.setEnabled(false);
                                        Thread.sleep(ITEMS.PLANT_POTATO.getCooldown());
                                        potatoItem.setEnabled(true);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                }).start();
                                Database.addPlant(potato);
                                potatoItem.setEnabled(true);
                                potatoItem.setBorder(null);
                                break;
                            case PLANT_1:
                                OrdinaryShooterPlant plant = new OrdinaryShooterPlant(e.getComponent().getX(), e.getComponent().getY() + 20);
                                Database.setStars(Database.getStars() - ITEMS.PLANT_1.getPrice());
                                new Thread(() -> {

                                    try {
                                        plant1Item.setEnabled(false);
                                        Thread.sleep(ITEMS.PLANT_1.getCooldown());
                                        plant1Item.setEnabled(true);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                }).start();
                                Database.addPlant(plant);
                                plant1Item.setEnabled(true);
                                plant1Item.setBorder(null);
                                break;
                            case PLANT_2:
                                AngryShooterPlant angryShooterPlant = new AngryShooterPlant(e.getComponent().getX(), e.getComponent().getY() + 20);
                                Database.setStars(Database.getStars() - ITEMS.PLANT_2.getPrice());
                                new Thread(() -> {

                                    try {
                                        plant2Item.setEnabled(false);
                                        Thread.sleep(ITEMS.PLANT_2.getCooldown());
                                        plant2Item.setEnabled(true);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                }).start();
                                Database.addPlant(angryShooterPlant);
                                plant2Item.setEnabled(true);
                                plant2Item.setBorder(null);
                                break;
//                            case ZOMBIE_1:
//                                break;
//                            case ZOMBIE_2:
//                                break;
                            case NO_SELECTION:
                                break;
                        }

                        item = ITEMS.NO_SELECTION;
                    }

                });
                label.setVisible(true);

                panel.add(label);
            }
        }


    }


    @Override
    public void paint(Graphics g) {

        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        System.out.println(Database.getStars());
//        StringBuilder stringBuilder = new StringBuilder(Database.getStars());
//        jLabel1.setText(String.valueOf(Database.getStars()));
//        star.setText("123");
//        jLabel1.repaint();

//        BufferStrategy bufferStrategy = getBufferStrategy();
//        if (bufferStrategy == null) {
//            createBufferStrategy(3);
//            return;
//        }
//
//        g = bufferStrategy.getDrawGraphics();

//        if (isFrameForZombie)


        if (isFrameForZombie)
            starsCount.setText(Database.getDollar() + "");
        else
            starsCount.setText(Database.getStars() + "");


//        else

//            starsCount.setText(Database.getStars() + "");


        for (Plant p : Database.getPlants()) {

            AnimationContainer animation = p.getAnimationContainer();
            int x = animation.getX();
            int y = animation.getY();

            if (x >= getWidth() || y >= getHeight()) {
                Database.removePlant(p.hashCode());
                continue;
            }

            Image frame = animation.getCurrentFrame();

//            new BufferedImage(frame.getWidth(null),frame.getHeight(null), BufferedImage.TYPE_INT_RGB).getGraphics().drawImage(frame, x, y, null);

            g.drawImage(frame, x, y, null);
//            bufferStrategy.getDrawGraphics().drawImage(frame, x, y, null);
//            bufferStrategy.dispose();
//            bufferStrategy.show();
        }


        for (Zombie z : Database.getZombies()) {

            AnimationContainer animation = z.getAnimationContainer();
            int x = animation.getX();
            int y = animation.getY();


            if (x <= endX) {
                Database.removeZombie(z.hashCode());
                setVisible(false);
                dispose();
                if (isFrameForZombie)
                    JOptionPane.showMessageDialog(null, "YOU WIN");
                else
                    JOptionPane.showMessageDialog(null, "YOU LOSE");
                System.exit(0);
                continue;
            }

            Image frame = animation.getCurrentFrame();
//            new BufferedImage(frame.getWidth(null),frame.getHeight(null), BufferedImage.TYPE_INT_RGB).getGraphics().drawImage(frame, x, y, null);
            g.drawImage(frame, x, y, null);
//            bufferStrategy.getDrawGraphics().drawImage(frame, x, y, null);
//            bufferStrategy.dispose();
//            bufferStrategy.show();
        }


        collisionDetection();
    }


    public void collisionDetection() {

        for (Zombie zombie : Database.getZombies()) {

            Rectangle zombieArea = new Rectangle(zombie.getAnimationContainer().getX(), zombie.getAnimationContainer().getY(), zombie.getAnimationContainer().getCurrentFrame().getWidth(), zombie.getAnimationContainer().getCurrentFrame().getHeight());
            for (Plant plant : Database.getPlants()) {

                Rectangle plantArea = new Rectangle(plant.getAnimationContainer().getX(), plant.getAnimationContainer().getY(), plant.getAnimationContainer().getCurrentFrame().getWidth(), plant.getAnimationContainer().getCurrentFrame().getHeight());

                if (zombieArea.intersects(plantArea) && plant.getAnimationContainer().getY() >= zombie.getAnimationContainer().getY()) {
                    if (plant instanceof Damaging) {
//                        System.out.print(zombie.getPower() + " --- ");
                        zombie.setPower(zombie.getPower() - ((Damaging) plant).getDamagePower());
//                        zombie.stop();
//                        zombie.hit();
                        if (zombie.getPower() <= 0)
                            Database.removeZombie(zombie.getId());
                        plant.setPower(0);
                        Database.removePlant(plant.getId());
                    }


                    if (plant instanceof Shooter && plant.getAnimationContainer().getY() >= zombie.getAnimationContainer().getY()) {


                        zombie.stop();
                        zombie.hit(plant);
                        if (plant.getPower() <= 0) {
                            Database.removePlant(plant.getId());
                            zombie.run();
                        }
//                        zombie.run();
                    }

                }

            }


        }

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sunFlowerItem = new javax.swing.JLabel();
        plant1Item = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        separator2 = new javax.swing.JSeparator();
        separator3 = new javax.swing.JSeparator();
        separator4 = new javax.swing.JSeparator();
        separator5 = new javax.swing.JSeparator();
        endLabel = new javax.swing.JLabel();
        endLabel1 = new javax.swing.JLabel();
        endLabel2 = new javax.swing.JLabel();
        endLabel3 = new javax.swing.JLabel();
        endLabel4 = new javax.swing.JLabel();
        zombiePosition1 = new javax.swing.JLabel();
        zombiePosition3 = new javax.swing.JLabel();
        zombiePosition4 = new javax.swing.JLabel();
        zombiePosition5 = new javax.swing.JLabel();
        zombiePosition6 = new javax.swing.JLabel();
        starsCount = new javax.swing.JLabel();
        plant2Item = new javax.swing.JLabel();
        potatoItem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(35, 155, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        if (isFrameForZombie)
            jLabel1.setIcon(new javax.swing.ImageIcon("./res/dollar.png")); // NOI18N
        else
            jLabel1.setIcon(new javax.swing.ImageIcon("./res/sun/15.png")); // NOI18N


        sunFlowerItem.setIcon(new javax.swing.ImageIcon("./res/sunFlowerCard.png")); // NOI18N
        sunFlowerItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (sunFlowerItem.isEnabled() && Database.getStars() >= ITEMS.NO_SELECTION.getPrice()) {
                    item = ITEMS.SUN_FLOWER;
                    sunFlowerItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 55)));
                    plant2Item.setBorder(null);
                    plant1Item.setBorder(null);
                    potatoItem.setBorder(null);
                }
            }
        });

        plant1Item.setIcon(new javax.swing.ImageIcon("./res/flowerAttackerCard.png")); // NOI18N
        plant1Item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (plant1Item.isEnabled() && Database.getStars() >= ITEMS.PLANT_1.getPrice()) {
                    item = ITEMS.PLANT_1;
                    plant1Item.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 55)));
                    potatoItem.setBorder(null);
                    plant2Item.setBorder(null);
                    sunFlowerItem.setBorder(null);
                }
            }
        });

//        jLabel4.setText("zombie1");
        jLabel4.setIcon(new javax.swing.ImageIcon("./res/zombieHead.png")); // NOI18N

        jLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jLabel4.isEnabled() && Database.getDollar() >= ITEMS.ZOMBIE_1.getPrice()) {
                    item = ITEMS.ZOMBIE_1;
                    jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 55)));
                    jLabel5.setBorder(null);
                }
            }
        });

//        jLabel5.setText("zombie2");
        jLabel5.setIcon(new javax.swing.ImageIcon("./res/zombieHead.png")); // NOI18N
        jLabel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                if (jLabel5.isEnabled() && Database.getDollar() >= ITEMS.ZOMBIE_2.getPrice()) {
                item = ITEMS.ZOMBIE_2;
                jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 55)));
                jLabel4.setBorder(null);
//                }
            }
        });

        endLabel.setBackground(new java.awt.Color(255, 51, 51));
        endLabel.setIcon(new javax.swing.ImageIcon("./res/mower.png")); // NOI18N
        endLabel.setText("end");
        endLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createCompoundBorder()));

        endLabel1.setBackground(new java.awt.Color(255, 51, 51));
        endLabel1.setIcon(new javax.swing.ImageIcon("./res/mower.png")); // NOI18N
        endLabel1.setText("end");

        endLabel2.setBackground(new java.awt.Color(255, 51, 51));
        endLabel2.setIcon(new javax.swing.ImageIcon("./res/mower.png")); // NOI18N
        endLabel2.setText("end");

        endLabel3.setBackground(new java.awt.Color(255, 51, 51));
        endLabel3.setIcon(new javax.swing.ImageIcon("./res/mower.png")); // NOI18N
        endLabel3.setText("end");

        endLabel4.setBackground(new java.awt.Color(255, 51, 51));
        endLabel4.setIcon(new javax.swing.ImageIcon("./res/mower.png")); // NOI18N
        endLabel4.setText("end");

        zombiePosition1.setIcon(new javax.swing.ImageIcon("./res/zombieStartStation.png"));
        zombiePosition1.setText("zombiePosition1");


        zombiePosition3.setIcon(new javax.swing.ImageIcon("./res/zombieStartStation.png"));
        zombiePosition3.setText("zombiePosition1");

        zombiePosition4.setIcon(new javax.swing.ImageIcon("./res/zombieStartStation.png"));
        zombiePosition4.setText("zombiePosition1");

        zombiePosition5.setIcon(new javax.swing.ImageIcon("./res/zombieStartStation.png"));
        zombiePosition5.setText("zombiePosition1");

        zombiePosition6.setIcon(new javax.swing.ImageIcon("./res/zombieStartStation.png"));
        zombiePosition6.setText("zombiePosition1");

        starsCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        starsCount.setText("0");

        plant2Item.setIcon(new javax.swing.ImageIcon("./res/flowerAttackerCard.png")); // NOI18N
        plant2Item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (plant2Item.isEnabled() && Database.getStars() >= ITEMS.PLANT_2.getPrice()) {
                    item = ITEMS.PLANT_2;
                    plant2Item.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 55)));
                    plant1Item.setBorder(null);
                    potatoItem.setBorder(null);
                    sunFlowerItem.setBorder(null);
                }
            }
        });

        potatoItem.setIcon(new javax.swing.ImageIcon("./res/potato.png"));
        potatoItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (potatoItem.isEnabled() && Database.getStars() >= ITEMS.PLANT_POTATO.getPrice()) {
                    item = ITEMS.PLANT_POTATO;
                    potatoItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(250, 245, 55)));
                    plant1Item.setBorder(null);
                    plant2Item.setBorder(null);
                    sunFlowerItem.setBorder(null);
                }
            }
        });


        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(separator5)
                        .addComponent(separator3)
                        .addComponent(separator4)
                        .addComponent(separator2)
                        .addComponent(separator1)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(endLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zombiePosition4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(endLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zombiePosition6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(endLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zombiePosition3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(endLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zombiePosition5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                                .addComponent(starsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sunFlowerItem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(plant1Item)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(plant2Item)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(potatoItem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(zombiePosition1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sunFlowerItem)
                                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel5))
                                                        .addComponent(plant1Item, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(plant2Item)
                                                        .addComponent(potatoItem)))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(starsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(zombiePosition1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(endLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(zombiePosition5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(separator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(endLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(zombiePosition3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(separator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(zombiePosition6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(separator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(endLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(zombiePosition4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel endLabel1;
    private javax.swing.JLabel endLabel2;
    private javax.swing.JLabel endLabel3;
    private javax.swing.JLabel endLabel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel plant1Item;
    private javax.swing.JLabel plant2Item;
    private javax.swing.JLabel potatoItem;
    private javax.swing.JLabel sunFlowerItem;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private JLabel star;
    private javax.swing.JPanel panel;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator3;
    private javax.swing.JSeparator separator4;
    private javax.swing.JSeparator separator5;
    private JLabel zombiePosition1;
    private JLabel zombiePosition2;
    private JLabel zombiePosition3;
    private JLabel zombiePosition4;
    private JLabel zombiePosition5;
    private JLabel zombiePosition6;
    private JLabel starsCount;
}
