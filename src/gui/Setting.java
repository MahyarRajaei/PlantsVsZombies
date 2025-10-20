/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.Database;
import main.GameHandler;

/**
 *
 * @author mr
 */
public class Setting extends javax.swing.JFrame {

    /**
     * Creates new form Setting
     */
    public Setting() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        zombieIncrease = new javax.swing.JLabel();
        zombieDecrise = new javax.swing.JLabel();
        zombieCount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sunDecrease = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SunIncrease = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dorallDecrease = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dorallIncrease = new javax.swing.JLabel();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Zombies Count: ");

        zombieIncrease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zombieIncrease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zombieIncrease.setText("+");
        zombieIncrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombieIncreaseMouseClicked(evt);
            }
        });

        zombieDecrise.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zombieDecrise.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zombieDecrise.setText("-");
        zombieDecrise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombieDecriseMouseClicked(evt);
            }
        });

        zombieCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zombieCount.setText(GameHandler.getZombieCount() + "");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Sun:");

        sunDecrease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sunDecrease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sunDecrease.setText("-");
        sunDecrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sunDecreaseMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(GameHandler.getDollarInStart() + "");

        SunIncrease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SunIncrease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SunIncrease.setText("+");
        SunIncrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SunIncreaseMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Dorall:");

        dorallDecrease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dorallDecrease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dorallDecrease.setText("-");
        dorallDecrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dorallDecreaseMouseClicked(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(GameHandler.getSunInStart() + "");

        dorallIncrease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dorallIncrease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dorallIncrease.setText("+");
        dorallIncrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dorallIncreaseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(23, 23, 23)
                                                .addComponent(zombieDecrise, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(zombieCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(zombieIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(92, 92, 92)
                                                                .addComponent(sunDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addGap(81, 81, 81)
                                                                .addComponent(dorallDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(SunIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dorallIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(zombieIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(zombieDecrise, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(zombieCount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(sunDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SunIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(dorallDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dorallIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(317, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void zombieIncreaseMouseClicked(java.awt.event.MouseEvent evt) {

        GameHandler.setZombieCount(GameHandler.getZombieCount() + 1);
        zombieCount.setText(GameHandler.getZombieCount() + "");

    }

    private void zombieDecriseMouseClicked(java.awt.event.MouseEvent evt) {
        GameHandler.setZombieCount(GameHandler.getZombieCount() - 1);
        zombieCount.setText(GameHandler.getZombieCount() + "");
    }

    private void SunIncreaseMouseClicked(java.awt.event.MouseEvent evt) {
        GameHandler.setSunInStart(GameHandler.getSunInStart() + 1);
        jLabel11.setText(GameHandler.getSunInStart() + "");
    }

    private void sunDecreaseMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        GameHandler.setSunInStart(GameHandler.getSunInStart() - 1);
        jLabel11.setText(GameHandler.getSunInStart() + "");
    }

    private void dorallIncreaseMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

        GameHandler.setDollarInStart(GameHandler.getDollarInStart() + 1);
        jLabel7.setText(GameHandler.getDollarInStart() + "");
    }

    private void dorallDecreaseMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        GameHandler.setDollarInStart(GameHandler.getDollarInStart() - 1);
        jLabel7.setText(GameHandler.getDollarInStart() + "");
    }



    // Variables declaration - do not modify
    private javax.swing.JLabel SunIncrease;
    private javax.swing.JLabel dorallDecrease;
    private javax.swing.JLabel dorallIncrease;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel sunDecrease;
    private javax.swing.JLabel zombieCount;
    private javax.swing.JLabel zombieDecrise;
    private javax.swing.JLabel zombieIncrease;
    // End of variables declaration
}
