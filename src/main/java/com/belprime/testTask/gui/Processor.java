package com.belprime.testTask.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;

import static com.belprime.testTask.util.Constants.TITLE;

public class Processor {
    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private static JTextArea answer = new JTextArea();
    private static String msg;
    //    private final ConcurrentHashMap<String, String> map;
    private JPanel table;

/*    private Processor(ConcurrentHashMap<String, String> map) {
        this.map = map;
        table = new Table(map);
    }*/

    private static void createAndShowGUI(Container container, JPanel table) {


        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        final JTextField textField = new JTextField(50);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 20, 20);
        container.add(textField, constraints);

        final JButton searchBtn = new JButton("Search");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 20, 20);
        container.add(searchBtn, constraints);

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                msg = textField.getText();
                answer.setText(String.valueOf(msg));
//
                System.out.println(answer.getText());

                SwingUtilities.updateComponentTreeUI(container);
            }
        });

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 20;
        constraints.gridwidth = 3;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(30, 20, 20, 20);
        container.add(table, constraints);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(TITLE);
//        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        final WebSearchService service = new WebSearchService(MessageProvider.getUserRequestsViaSwing(answer.getText()));
//        ConcurrentHashMap<String, String> map = service.getMap();
        createAndShowGUI(frame.getContentPane(), new Table(map));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Table table = new Table(map);
//        Table.createAndShowGUI();
        map.put(answer.getText(), answer.getText());

        map.put("url-1", "title-1");
        map.put("url-2", "title-2");
        map.put("url-3", "title-3");
        createAndShowGUI(frame.getContentPane(), new Table(map));

        frame.pack();
        frame.setVisible(true);
    }
}




/*
       EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
        });*/
