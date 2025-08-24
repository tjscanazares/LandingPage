/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labact2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 *
 * @author User
 */
public class LandingPage {
    JFrame frame = new JFrame();
    JPanel[] mainPanel = new JPanel[2];
    
    public LandingPage(){
        frame.setSize(1500, 850);
        frame.setResizable(false);
//        frame.setLayout(new BorderLayout(30,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dui");
        frame.setLocationRelativeTo(null);
//        frame.setBackground(Color.PINK);
        
      
        mainPanels();
        contentSubPanel();
        infoSubPanel();
        frame.setVisible(true);      
    }
    
    public void mainPanels(){
        mainPanel[0] = createPanel(new Dimension(375, 850), new Color(0xFAF4E8));
        mainPanel[1] = createPanel(new Dimension(1125, 850), Color.BLACK);
        
        frame.add(mainPanel[0], BorderLayout.WEST);
        frame.add(mainPanel[1], BorderLayout.EAST);
    }
    
    public void contentSubPanel(){
        JPanel[] sub_panel = new JPanel[3];
        sub_panel[0] = createPanel(new Dimension(1125, 60), new Color(0xFAF4E8));
        sub_panel[1] = createPanel(new Dimension(1125, 300), new Color(0xFAF4E8));
        sub_panel[2] = createPanel(new Dimension(1125, 490),new Color(0xFAF4E8));
        
        mainPanel[1].setLayout(new BorderLayout());
        mainPanel[1].add(sub_panel[0], BorderLayout.NORTH);
        mainPanel[1].add(sub_panel[1], BorderLayout.CENTER);
        mainPanel[1].add(sub_panel[2], BorderLayout.SOUTH);
        
        
        sub_panel[0].setLayout(new FlowLayout(FlowLayout.RIGHT));
        sub_panel[0].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sub_panel[0].add(notif(new Dimension(150, 30)));
        sub_panel[0].add(notifDivider(30));
        sub_panel[0].add(profile(new Dimension(150,30)));
        

        
        ImageIcon logo = new ImageIcon("C:\\Users\\User\\Downloads\\duiTrans.png");
        Image img = logo.getImage();
        Image scaledImg = img.getScaledInstance(500, 540, Image.SCALE_SMOOTH);
        logo = new ImageIcon(scaledImg);
        JLabel picLabel = new JLabel(logo);
        picLabel.setBorder(BorderFactory.createEmptyBorder(-110, 0, 0, 0));
        
        sub_panel[1].setLayout(new BorderLayout());
        sub_panel[1].add(picLabel, BorderLayout.NORTH);
        
        sub_panel[2].setLayout(new GridLayout(3, 1, 0, 20));
        sub_panel[2].setBorder(BorderFactory.createEmptyBorder(10, 40, 150, 150));
        sub_panel[2].add(addTask(new Dimension(950,30)));
        sub_panel[2].add(newFolder(new Dimension(950,30)));
        sub_panel[2].add(MyTask(new Dimension(950,30)));
    }
    
    public void infoSubPanel(){
        JPanel[] sub_panel = new JPanel[2];
        sub_panel[0] = createPanel(new Dimension(295,540), Color.WHITE);
        sub_panel[1] = createPanel(new Dimension(295,200), Color.WHITE);
        
        mainPanel[0].setLayout(new BorderLayout());
        mainPanel[0].setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 30));
        mainPanel[0].add(sub_panel[0], BorderLayout.NORTH);
        mainPanel[0].add(sub_panel[1], BorderLayout.SOUTH);
        
        sub_panel[0].add(createMenuItem("Ni Hao", 295,50,"C:\\\\Users\\\\User\\\\Downloads\\\\nihaoTrans.png",40, () -> company()));
        sub_panel[0].add(divider(295));
        sub_panel[0].add(createMenuItem("Home", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\Home.png",35, () -> openHome()));
        sub_panel[0].add(divider(295));
        sub_panel[0].add(createMenuItem("Completed Tasks", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\CompTask.png",35, () -> completedTask()));
        sub_panel[0].add(divider(295));
        sub_panel[0].add(createMenuItem("View Folders", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\ViewFolder.png",35, () -> viewFolder()));
        sub_panel[0].add(divider(295));
        sub_panel[0].add(createMenuItem("Missed Tasks", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\MissedTask.png",35, () -> missedTasks()));
        sub_panel[0].add(divider(295));
        sub_panel[0].add(createMenuItem("Calendar", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\Calendar.png",35, () -> viewCalendar()));
        sub_panel[0].add(divider(295));
        sub_panel[0].add(createMenuItem("Today's Tasks", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\TodaysTask.png",35, () -> todayTask()));        
        sub_panel[1].setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));
        sub_panel[1].add(createMenuItem("Settings", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\Settings.png",35, () -> settings()));
        sub_panel[1].add(divider(295));
        sub_panel[1].add(createMenuItem("Log Out", 295, 40,"C:\\Users\\User\\Downloads\\Icons\\Logout.png",35, () -> logOut()));
        
    }
    
    public JPanel createMenuItem(String text, int width, int height, String iconPath, int iconSize, Runnable action) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        JLabel label = new JLabel(text, scaleIcon(iconPath, iconSize, iconSize), JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setIconTextGap(10);

        panel.add(label);

        panel.addMouseListener(new MouseAdapter() {  
            @Override
            public void mouseEntered(MouseEvent e){
                panel.setBackground(new Color(0xFAF4E8)); 
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                panel.setBackground(Color.WHITE);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                action.run();
            }
        });

        return panel;
    }
    
    private ImageIcon scaleIcon(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void company() {
        JOptionPane.showMessageDialog(null, "Company");
    }    
    public void openHome() {
        JOptionPane.showMessageDialog(null,"Home");
    }
    public void completedTask() {
        JOptionPane.showMessageDialog(null, "Shows the list of completed tasks.");
    }    
    public void viewFolder() {
        JOptionPane.showMessageDialog(null, "Shows folders made by the user.");
    }
    public void missedTasks() {
        JOptionPane.showMessageDialog(null, "Shows missed tasks.");
    }
    public void viewCalendar() {
        JOptionPane.showMessageDialog(null, "Views Calendar.");
    }
    public void todayTask() {
        JOptionPane.showMessageDialog(null, "Shows the list of tasks due today.");
    }
    public void settings() {
        JOptionPane.showMessageDialog(null, "Shows the settings of the application.");
    }
    public void logOut() {
        JOptionPane.showMessageDialog(null, "Log Out.");
    }
    
    public JPanel profile(Dimension dim){
        JPanel profilePanel = new JPanel();
        profilePanel.setPreferredSize(dim);
        profilePanel.setBackground(new Color(0xFAF4E8));
        profilePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        ImageIcon profile = new ImageIcon("C:\\Users\\User\\Downloads\\plus.jpg");
        Image pfp = profile.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        profile = new ImageIcon(pfp);
        
        JLabel label = new JLabel("Account Name");
        label.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel iconLabel = new JLabel(profile);

        profilePanel.add(label);
        profilePanel.add(iconLabel);
        
        profilePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                profilePanel.setBackground(new Color(0xFAF4E8));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                profilePanel.setBackground(new Color(0xFAF4E8));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Shows account settings.");
            }
        });
        
        return profilePanel;
    }
    
    public JPanel notif(Dimension dim) {
        JPanel notifPanel = new JPanel();
        notifPanel.setPreferredSize(dim);
        notifPanel.setBackground(new Color(0xFAF4E8));
        notifPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        ImageIcon notif = new ImageIcon("C:\\Users\\User\\Downloads\\Dui Icons\\Notif.png");
        Image ntf = notif.getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH);
        notif = new ImageIcon(ntf);

        JLabel label = new JLabel("Notification");
        label.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel iconLabel = new JLabel(notif);

        notifPanel.add(label);
        notifPanel.add(iconLabel);

        notifPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                notifPanel.setBackground(new Color(0xFAF4E8));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                notifPanel.setBackground(new Color(0xFAF4E8));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Shows notifications and reminders.");
            }
        });
        
        return notifPanel;
    }
    
    public JPanel addTask(Dimension dim){
        JPanel addTaskPanel = new JPanel();
        addTaskPanel.setPreferredSize(dim);
        addTaskPanel.setBackground(Color.WHITE);
        addTaskPanel.setLayout(new FlowLayout(FlowLayout.LEFT,40, 10));
        
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Dui Icons\\NewTask.png");
        Image img = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        
        JLabel label = new JLabel("New Task", icon, JLabel.LEFT);
        label.setFont(new Font("SansSerif", Font.BOLD, 26)); 
        label.setIconTextGap(15);
//        label.setForeground(new Color(0xF69E99));
        
        addTaskPanel.add(label);
        
        addTaskPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addTaskPanel.setBackground(new Color(0x9EDACD));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addTaskPanel.setBackground(Color.WHITE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Lets the user add tasks.");
            }
        });
        
        return addTaskPanel;
    }
    
    public JPanel newFolder(Dimension dim){
        JPanel newFolderPanel = new JPanel();
        newFolderPanel.setPreferredSize(dim);
        newFolderPanel.setBackground(Color.WHITE);
        newFolderPanel.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
        
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Dui Icons\\createFolder.png");
        Image img = icon.getImage().getScaledInstance(70, 75, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        
        JLabel label = new JLabel("Create Folder", icon, JLabel.LEFT);
        label.setFont(new Font("SansSerif", Font.BOLD, 26)); 
        label.setIconTextGap(15);
        
        newFolderPanel.add(label);
        
        newFolderPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                newFolderPanel.setBackground(new Color(0xFCE9A7));
//                label.setForeground(new Color(0xFCE9A7));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newFolderPanel.setBackground(Color.WHITE);
//                label.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Lets the user create folders.");
            }
        });
        
        return newFolderPanel;
    }
    
    public JPanel MyTask(Dimension dim){
        JPanel MyTaskPanel = new JPanel();
        MyTaskPanel.setPreferredSize(dim);
        MyTaskPanel.setBackground(Color.WHITE);
        MyTaskPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Dui Icons\\MyTasks.png");
        Image img = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel label = new JLabel("My Tasks", icon, JLabel.LEFT);
        label.setFont(new Font("SansSerif", Font.BOLD, 26)); 
        label.setIconTextGap(15);

        MyTaskPanel.add(label);
        
        MyTaskPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                MyTaskPanel.setBackground(new Color(0xF69E99));
//                label.setForeground(new Color(0xF69E99));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MyTaskPanel.setBackground(Color.WHITE);
//                label.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Lets the user view their tasks.");
            }
        });
                
        return MyTaskPanel;
    }
    
    private JPanel divider(int width) {
        JPanel line = new JPanel();
        line.setPreferredSize(new Dimension(width, 2)); 
        line.setMaximumSize(new Dimension(width, 2));
        line.setBackground(Color.GRAY); 
        return line;
    }
    
    private JPanel notifDivider(int height) {
        JPanel line = new JPanel();
        line.setPreferredSize(new Dimension(2, height));
        line.setMaximumSize(new Dimension(2, height));
        line.setBackground(Color.GRAY);
        
        return line;
    }
    
    public JPanel createPanel(Dimension dim, Color col) {
        JPanel panel = new JPanel();
        panel.setBackground(col);
        panel.setPreferredSize(dim);
        return panel;
    }
}
