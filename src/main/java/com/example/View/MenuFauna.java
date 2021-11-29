package com.example.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * View class for the menu of the Fauna.
 * 
 * @author Ruymán Crespo Díaz
 * @author Silvia Oliva Rodríguez
 * @author José Ramón Navarro González
 * @version 1.0
 */
public class MenuFauna extends JFrame {

        // - - - PUBBLIC FIELDS - - -
        public JButton buttonUpdate;
        public JButton buttonDelete;
        public JButton buttonSearch;
        public JButton buttonInsert;
        public JTextField boxLastName;
        public JTextField boxAge;
        public JTextField boxName;
        public JLabel labelMessages;
        public JComboBox<String> comboBox;

        // - - - PRIVATE FIELDS - - -
        private JLabel labelName;
        private JLabel labelImage;
        private JSeparator separator;
        private JPanel firstPanel;
        private JLabel labelLastName;
        private JLabel labelAge;

        /**
         * Constructor of the view.
         */
        public MenuFauna() {
                initComponents();
                this.setTitle("FaunaDB");
                this.setResizable(true);
                this.setLocationRelativeTo(null);
                this.setSize(650, 700);

                // Icon in the title bar
                Image icon = new ImageIcon("/img/icoFauna.png").getImage();
                this.setIconImage(icon);

                this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }

        /**
         * Initializes the components of the view.
         */
        private void initComponents() {
                GridBagConstraints gridBagConstraints;

                firstPanel = new JPanel();
                labelName = new JLabel();
                boxName = new JTextField();
                boxLastName = new JTextField();
                labelLastName = new JLabel();
                boxAge = new JTextField();
                labelAge = new JLabel();
                buttonDelete = new JButton();
                buttonInsert = new JButton();
                buttonUpdate = new JButton();
                separator = new JSeparator();
                labelMessages = new JLabel();
                buttonSearch = new JButton();
                labelImage = new JLabel();
                comboBox = new JComboBox<>();

                firstPanel.setLayout(new GridBagLayout());

                labelName.setFont(new Font("Calibri", 0, 18));
                labelName.setText("First Name:");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.ipadx = 1;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(63, 37, 0, 0);
                firstPanel.add(labelName, gridBagConstraints);

                boxName.setFont(new Font("Calibri", 0, 18));
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridheight = 2;
                gridBagConstraints.ipadx = 150;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(60, 18, 0, 0);
                boxName.setMaximumSize(new Dimension(boxName.getWidth(), boxName.getHeight()));
                firstPanel.add(boxName, gridBagConstraints);

                boxLastName.setFont(new Font("Calibri", 0, 18));
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.gridheight = 3;
                gridBagConstraints.ipadx = 150;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(18, 18, 0, 0);
                firstPanel.add(boxLastName, gridBagConstraints);

                labelLastName.setFont(new Font("Calibri", 0, 18));
                labelLastName.setText("Last name:");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.ipadx = 2;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(21, 37, 0, 0);
                firstPanel.add(labelLastName, gridBagConstraints);

                boxAge.setFont(new Font("Calibri", 0, 18));
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.gridheight = 3;
                gridBagConstraints.ipadx = 150;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(18, 18, 0, 0);
                firstPanel.add(boxAge, gridBagConstraints);

                labelAge.setFont(new Font("Calibri", 0, 18));
                labelAge.setHorizontalAlignment(SwingConstants.RIGHT);
                labelAge.setText("Age:");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.ipadx = 25;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(21, 37, 0, 0);
                firstPanel.add(labelAge, gridBagConstraints);

                labelMessages.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 9;
                gridBagConstraints.gridwidth = 3;
                gridBagConstraints.gridheight = 10;
                gridBagConstraints.ipadx = 284;
                gridBagConstraints.ipady = 82;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(25, 30, 47, 0);
                firstPanel.add(labelMessages, gridBagConstraints);

                // -- SEPARATOR --

                separator.setOrientation(SwingConstants.VERTICAL);
                separator.setForeground(Color.BLACK);
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridheight = 9;
                gridBagConstraints.ipadx = 18;
                gridBagConstraints.ipady = 167;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(58, 30, 0, 0);
                firstPanel.add(separator, gridBagConstraints);

                // --- BUTTONS ---

                buttonInsert.setFont(new Font("Calibri", 1, 16)); // INSERT BUTTON
                buttonInsert.setText("Insert");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.ipadx = 62;
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(62, 49, 0, 0);
                firstPanel.add(buttonInsert, gridBagConstraints);

                buttonUpdate.setFont(new Font("Calibri", 1, 16)); // UPDATE BUTTON
                buttonUpdate.setText("Update");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.ipadx = 50; // 90
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(18, 49, 0, 0);
                firstPanel.add(buttonUpdate, gridBagConstraints);

                buttonSearch.setFont(new Font("Calibri", 1, 16)); // SEARCH BUTTON
                buttonSearch.setText("Search");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 6;
                gridBagConstraints.ipadx = 51; // 71
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(18, 49, 0, 0);
                firstPanel.add(buttonSearch, gridBagConstraints);

                buttonDelete.setFont(new Font("Calibri", 1, 16)); // DELETE BUTTON
                buttonDelete.setText("Delete");
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 9;
                gridBagConstraints.ipadx = 58; // 71
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(18, 49, 0, 0);
                firstPanel.add(buttonDelete, gridBagConstraints);

                // Dropdown with random names as array
                comboBox.setFont(new Font("Calibri", 1, 16)); // DELETE BUTTON
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 11;
                gridBagConstraints.ipadx = 58; // 71
                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                gridBagConstraints.insets = new Insets(18, 49, 0, 0);
                firstPanel.add(comboBox, gridBagConstraints);

                // --- IMAGE ---

                // Adds a margin to the left of the label
                labelImage.setBorder(BorderFactory.createEmptyBorder(0, 45, 0, 0));

                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 6;
                gridBagConstraints.ipadx = 618;
                gridBagConstraints.ipady = 158;
                ImageIcon image = new ImageIcon("img/logoFauna.png");

                labelImage.setSize(new Dimension(image.getIconWidth() / 3, image.getIconHeight() / 3));
                // Resizes the image to the size of the label
                ImageIcon icon = new ImageIcon(
                                image.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(),
                                                Image.SCALE_DEFAULT));

                labelImage.setIcon(icon);

                gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                firstPanel.add(labelImage, gridBagConstraints);

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstPanel,
                                                GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstPanel,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                firstPanel.setBackground(Color.lightGray);

                this.pack();

        }

}
