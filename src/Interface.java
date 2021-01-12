import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    private JButton btnAnnulerPort;
    private JButton btnModifierSeuils;
    private JButton btnValiderDates;
    private JButton btnValiderPort;

    private JCheckBox checkAirComprime1;
    private JCheckBox checkAirComprime2;
    private JCheckBox checkEau1;
    private JCheckBox checkEau2;
    private JCheckBox checkElectricite1;
    private JCheckBox checkElectricite2;
    private JCheckBox checkTemperature1;
    private JCheckBox checkTemperature2;

    private JDialog dialogPort;

    private JLabel labelA;
    private JLabel labelConnexion;
    private JLabel labelDe;
    private JLabel labelPort;

    private JList<String> listeBatiments;
    private JList<String> listeCapteurs2;

    private JTable listeCapteurs1;
    private JTable tableauInfosCapteur;
    private JTable tableauSeuilsDefaut;

    private JTabbedPane onglets;

    private JPanel onglet1;
    private JPanel onglet2;
    private JPanel onglet3;
    private JPanel panelCourbe1;
    private JPanel panelCourbe2;
    private JPanel panelCourbe3;
    private JPanel panelCourbes;
    private JPanel panelDates;
    private JPanel panelDates2;
    private JPanel panelFiltres1;
    private JPanel panelFiltres2;
    private JPanel panelFluides1;
    private JPanel panelFluides2;
    private JPanel panelTableaux;
    private JPanel panelInfosCapteur;
    private JPanel panelSeuilsDefaut;
    private JPanel panelPort;

    private JScrollPane scrollPanelBatiments;
    private JScrollPane scrollPanelInfosCapteur;
    private JScrollPane scrollPanelListeCapteurs1;
    private JScrollPane scrollPanelListeCapteurs2;
    private JScrollPane scrollPanelSeuilsDefaut;
    private JScrollPane scrollPanelTree;

    private JTextField textDateFin;
    private JTextField textDateDebut;
    private JTextField textPort;

    private JTree treeCapteurs;

    public Interface() {
        initComponents();
    }

    private void initComponents() {

        /* boite de dialogue pour le port */

        dialogPort = new JDialog();
        panelPort = new JPanel();
        labelConnexion = new JLabel();
        labelPort = new JLabel();
        textPort = new JTextField();
        btnAnnulerPort = new JButton();
        btnValiderPort = new JButton();

        dialogPort.setResizable(false);
        dialogPort.setLocationRelativeTo(null);
        panelPort.setLayout(new java.awt.GridLayout(5,1));

        labelConnexion.setFont(new java.awt.Font("Tahoma", 1, 11));
        labelConnexion.setHorizontalAlignment(SwingConstants.CENTER);
        labelConnexion.setText("Connexion à l'interface de visualisation NeoCampus");
        labelPort.setText("Veuillez renseigner le port sur lequel vous souhaitez vous connecter :");

        textPort.setColumns(4);
        textPort.setHorizontalAlignment(JTextField.CENTER);
        textPort.setText("8080");

        btnAnnulerPort.setText("Annuler");
        btnValiderPort.setText("Valider");

        panelPort.add(labelConnexion);
        panelPort.add(labelPort);
        panelPort.add(textPort);
        panelPort.add(btnAnnulerPort);
        panelPort.add(btnValiderPort);

//        GroupLayout dialogPortLayout = new GroupLayout(dialogPort.getContentPane());
//        dialogPort.getContentPane().setLayout(dialogPortLayout);
//        dialogPortLayout.setHorizontalGroup(
//                dialogPortLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(dialogPortLayout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(panelPort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addContainerGap())
//        );
//        dialogPortLayout.setVerticalGroup(
//                dialogPortLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(dialogPortLayout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(panelPort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addContainerGap())
//        );

        onglets = new JTabbedPane();
        onglet1 = new JPanel();
        scrollPanelListeCapteurs1 = new JScrollPane();
        listeCapteurs1 = new JTable();
        panelFiltres1 = new JPanel();
        scrollPanelBatiments = new JScrollPane();
        listeBatiments = new JList<>();
        panelFluides1 = new JPanel();
        checkEau1 = new JCheckBox();
        checkElectricite1 = new JCheckBox();
        checkAirComprime1 = new JCheckBox();
        checkTemperature1 = new JCheckBox();
        onglet2 = new JPanel();
        panelFiltres2 = new JPanel();
        scrollPanelListeCapteurs2 = new JScrollPane();
        listeCapteurs2 = new JList<>();
        panelFluides2 = new JPanel();
        checkEau2 = new JCheckBox();
        checkElectricite2 = new JCheckBox();
        checkAirComprime2 = new JCheckBox();
        checkTemperature2 = new JCheckBox();
        panelDates = new JPanel();
        panelDates2 = new JPanel();
        textDateDebut = new JTextField();
        labelDe = new JLabel();
        textDateFin = new JTextField();
        labelA = new JLabel();
        btnValiderDates = new JButton();
        panelCourbes = new JPanel();
        panelCourbe1 = new JPanel();
        panelCourbe2 = new JPanel();
        panelCourbe3 = new JPanel();
        onglet3 = new JPanel();
        panelTableaux = new JPanel();
        panelInfosCapteur = new JPanel();
        scrollPanelInfosCapteur = new JScrollPane();
        tableauInfosCapteur = new JTable();
        btnModifierSeuils = new JButton();
        panelSeuilsDefaut = new JPanel();
        scrollPanelSeuilsDefaut = new JScrollPane();
        tableauSeuilsDefaut = new JTable();
        scrollPanelTree = new JScrollPane();
        treeCapteurs = new JTree();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des capteurs");
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(800, 500));

        onglets.setBorder(BorderFactory.createTitledBorder(null, "NeoCampus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));
        onglets.setMinimumSize(new java.awt.Dimension(0, 0));

        onglet1.setLayout(new java.awt.BorderLayout());

        scrollPanelListeCapteurs1.setBackground(new java.awt.Color(255, 255, 255));

        listeCapteurs1.setBackground(new java.awt.Color(240, 240, 240));
        listeCapteurs1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPanelListeCapteurs1.setViewportView(listeCapteurs1);

        onglet1.add(scrollPanelListeCapteurs1, java.awt.BorderLayout.CENTER);

        panelFiltres1.setBorder(BorderFactory.createTitledBorder("Filtres"));
        panelFiltres1.setLayout(new java.awt.BorderLayout());

        listeBatiments.setBorder(BorderFactory.createTitledBorder("Bâtiments"));
        listeBatiments.setModel(new AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 26566465468184384384", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        scrollPanelBatiments.setViewportView(listeBatiments);

        panelFiltres1.add(scrollPanelBatiments, java.awt.BorderLayout.CENTER);

        panelFluides1.setLayout(new java.awt.GridLayout(4, 0));

        checkEau1.setText("Eau");
        panelFluides1.add(checkEau1);

        checkElectricite1.setText("Electricite");
        panelFluides1.add(checkElectricite1);

        checkAirComprime1.setText("Air comprime");
        panelFluides1.add(checkAirComprime1);

        checkTemperature1.setText("Temperature");
        panelFluides1.add(checkTemperature1);

        panelFiltres1.add(panelFluides1, java.awt.BorderLayout.PAGE_START);

        onglet1.add(panelFiltres1, java.awt.BorderLayout.LINE_END);

        onglets.addTab("Visualisation en temps reel", onglet1);

        onglet2.setLayout(new java.awt.BorderLayout());

        panelFiltres2.setBorder(BorderFactory.createTitledBorder("Filtres"));
        panelFiltres2.setLayout(new java.awt.BorderLayout());

        listeCapteurs2.setBorder(BorderFactory.createTitledBorder("Capteurs"));
        listeCapteurs2.setModel(new AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        scrollPanelListeCapteurs2.setViewportView(listeCapteurs2);

        panelFiltres2.add(scrollPanelListeCapteurs2, java.awt.BorderLayout.CENTER);

        panelFluides2.setLayout(new java.awt.GridLayout(4, 0));

        checkEau2.setText("Eau");
        panelFluides2.add(checkEau2);

        checkElectricite2.setText("Electricite");
        panelFluides2.add(checkElectricite2);

        checkAirComprime2.setText("Air comprime");
        panelFluides2.add(checkAirComprime2);

        checkTemperature2.setText("Temperature");
        panelFluides2.add(checkTemperature2);

        panelFiltres2.add(panelFluides2, java.awt.BorderLayout.PAGE_START);

        panelDates.setLayout(new java.awt.BorderLayout());

        labelDe.setText("de : ");
        panelDates2.add(labelDe);

        textDateDebut.setText("01/01/2000");
        panelDates2.add(textDateDebut);

        labelA.setText(" à : ");
        panelDates2.add(labelA);

        textDateFin.setText("01/01/2022");
        panelDates2.add(textDateFin);

        panelDates.add(panelDates2, BorderLayout.CENTER);

        btnValiderDates.setText("Valider");
        panelDates.add(btnValiderDates, BorderLayout.PAGE_END);

        panelFiltres2.add(panelDates, java.awt.BorderLayout.PAGE_END);

        onglet2.add(panelFiltres2, java.awt.BorderLayout.LINE_END);

        panelCourbes.setBackground(new java.awt.Color(255, 204, 204));
        panelCourbes.setLayout(new java.awt.GridLayout(3, 0));

        panelCourbe1.setBackground(new java.awt.Color(204, 255, 204));

        GroupLayout panelCourbe1Layout = new GroupLayout(panelCourbe1);
        panelCourbe1.setLayout(panelCourbe1Layout);
        panelCourbe1Layout.setHorizontalGroup(
                panelCourbe1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCourbe1Layout.setVerticalGroup(
                panelCourbe1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCourbes.add(panelCourbe1);

        panelCourbe2.setBackground(new java.awt.Color(255, 255, 204));

        GroupLayout panelCourbe2Layout = new GroupLayout(panelCourbe2);
        panelCourbe2.setLayout(panelCourbe2Layout);
        panelCourbe2Layout.setHorizontalGroup(
                panelCourbe2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCourbe2Layout.setVerticalGroup(
                panelCourbe2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCourbes.add(panelCourbe2);

        panelCourbe3.setBackground(new java.awt.Color(255, 204, 255));

        GroupLayout panelCourbe3Layout = new GroupLayout(panelCourbe3);
        panelCourbe3.setLayout(panelCourbe3Layout);
        panelCourbe3Layout.setHorizontalGroup(
                panelCourbe3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCourbe3Layout.setVerticalGroup(
                panelCourbe3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCourbes.add(panelCourbe3);

        onglet2.add(panelCourbes, java.awt.BorderLayout.CENTER);

        onglets.addTab("Visualisation en temps differe", onglet2);

        onglet3.setLayout(new java.awt.BorderLayout());

        scrollPanelTree.setViewportView(treeCapteurs);

        onglet3.add(scrollPanelTree, java.awt.BorderLayout.CENTER);

        panelTableaux.setPreferredSize(new java.awt.Dimension(300, 300));
        panelTableaux.setLayout(new java.awt.BorderLayout());

        panelInfosCapteur.setBorder(BorderFactory.createTitledBorder("Informations du capteur"));
        panelInfosCapteur.setLayout(new java.awt.BorderLayout());

        tableauInfosCapteur.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Batiment", ""},
                        {"Etage", null},
                        {"Type de fluide", null},
                        {"Seuil minimum", null},
                        {"Seuil maximum", null}
                },
                new String[]{
                        "Informations", "Valeurs"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scrollPanelInfosCapteur.setViewportView(tableauInfosCapteur);

        panelInfosCapteur.add(scrollPanelInfosCapteur, java.awt.BorderLayout.CENTER);

        btnModifierSeuils.setText("Modifier les seuils");
        panelInfosCapteur.add(btnModifierSeuils, java.awt.BorderLayout.PAGE_END);

        panelTableaux.add(panelInfosCapteur, BorderLayout.CENTER);

        panelSeuilsDefaut.setBorder(BorderFactory.createTitledBorder("Seuils par defaut"));
        panelSeuilsDefaut.setPreferredSize(new Dimension(300, 120));
        panelSeuilsDefaut.setLayout(new java.awt.BorderLayout());

        tableauSeuilsDefaut.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"EAU", 0, 10, "m3"},
                        {"ELECTRICITE", 10, 500, "kWh"},
                        {"TEMPERATURE", 17, 22, "°C"},
                        {"AIR COMPRIME", 0, 6, "m3/h"}
                },
                new String[]{
                        "Fluide", "Seuil min", "Seuil max", "Unite"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scrollPanelSeuilsDefaut.setViewportView(tableauSeuilsDefaut);
        if (tableauSeuilsDefaut.getColumnModel().getColumnCount() > 0)
            tableauSeuilsDefaut.getColumnModel().getColumn(0).setPreferredWidth(150);

        panelSeuilsDefaut.add(scrollPanelSeuilsDefaut, java.awt.BorderLayout.CENTER);

        panelTableaux.add(panelSeuilsDefaut, BorderLayout.SOUTH);
        onglet3.add(panelSeuilsDefaut, BorderLayout.EAST);

        onglets.addTab("Gestion des capteurs", onglet3);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(onglets, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(onglets, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Interface());
    }
}
