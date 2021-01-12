import javax.swing.*;
import java.awt.*;

public class Interface {

    private JDialog dialogPort;

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

    private JList<String> listeBatiments;
    private JList<String> listeCapteurs2;

    private JTable listeCapteurs1;
    private JTable tableauInfosCapteur;
    private JTable tableauSeuilsDefaut;

    private JTextField textDateFin;
    private JTextField textDateDebut;
    private JTextField textPort;

    private JTree treeCapteurs;

    public Interface() {
        JFrame frame = new JFrame();
        initialisation(frame);
    }

    private void initialisation(JFrame frame) {

        /* Boite de dialogue pour le port */

        dialogPort = new JDialog();
        JPanel panelPort = new JPanel(new java.awt.GridLayout(5, 1));
        JLabel labelConnexion = new JLabel();
        JLabel labelPort = new JLabel();
        textPort = new JTextField();
        btnAnnulerPort = new JButton();
        btnValiderPort = new JButton();

        dialogPort.setResizable(false);
        dialogPort.setMinimumSize(new Dimension(450, 200));
        dialogPort.setLocationRelativeTo(null);

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

        dialogPort.add(panelPort);



        /* Fenêtre principale - Gestion des capteurs */

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Gestion des capteurs");
        frame.setMinimumSize(new java.awt.Dimension(600, 400));
        frame.setPreferredSize(new java.awt.Dimension(800, 500));

        JTabbedPane onglets = new JTabbedPane();

        onglets.setBorder(BorderFactory.createTitledBorder(null, "NeoCampus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));
        onglets.setPreferredSize(new Dimension(500, 450));



        /* Onglet 1 - Visualisation en temps réel */

        JPanel onglet1 = new JPanel(new java.awt.BorderLayout());
        JPanel panelFiltres1 = new JPanel(new java.awt.BorderLayout());
        JPanel panelFluides1 = new JPanel(new java.awt.GridLayout(4, 0));
        JScrollPane scrollPanelListeCapteurs1 = new JScrollPane();
        JScrollPane scrollPanelBatiments = new JScrollPane();
        listeCapteurs1 = new JTable();
        listeBatiments = new JList<>();
        checkEau1 = new JCheckBox();
        checkElectricite1 = new JCheckBox();
        checkAirComprime1 = new JCheckBox();
        checkTemperature1 = new JCheckBox();

        panelFiltres1.setBorder(BorderFactory.createTitledBorder("Filtres"));
        listeBatiments.setBorder(BorderFactory.createTitledBorder("Bâtiments"));

        // REQUETE POUR GET TOUS LES BATIMENTS //

        listeBatiments.setModel(new AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 26566465468184384384", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });

        // REQUETE POUR GET TOUS LES CAPTEURS //

        listeCapteurs1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        checkEau1.setText("Eau");
        checkElectricite1.setText("Electricite");
        checkAirComprime1.setText("Air comprime");
        checkTemperature1.setText("Temperature");

        scrollPanelListeCapteurs1.setViewportView(listeCapteurs1);
        scrollPanelBatiments.setViewportView(listeBatiments);

        panelFluides1.add(checkEau1);
        panelFluides1.add(checkElectricite1);
        panelFluides1.add(checkAirComprime1);
        panelFluides1.add(checkTemperature1);
        panelFiltres1.add(panelFluides1, java.awt.BorderLayout.PAGE_START);
        panelFiltres1.add(scrollPanelBatiments, java.awt.BorderLayout.CENTER);
        onglet1.add(panelFiltres1, java.awt.BorderLayout.LINE_END);
        onglet1.add(scrollPanelListeCapteurs1, java.awt.BorderLayout.CENTER);

        onglets.addTab("Visualisation en temps reel", onglet1);



        /* Onglet 2 - Visualisation en temps différé */

        JPanel onglet2 = new JPanel(new java.awt.BorderLayout());
        JPanel panelFiltres2 = new JPanel(new java.awt.BorderLayout());
        JPanel panelFluides2 = new JPanel(new java.awt.GridLayout(4, 0));
        JPanel panelDates = new JPanel(new java.awt.BorderLayout());
        JPanel panelDates2 = new JPanel(new java.awt.FlowLayout());
        JPanel panelCourbes = new JPanel(new java.awt.GridLayout(3, 0));
        JPanel panelCourbe1 = new JPanel();
        JPanel panelCourbe2 = new JPanel();
        JPanel panelCourbe3 = new JPanel();
        JScrollPane scrollPanelListeCapteurs2 = new JScrollPane();
        JLabel labelDe = new JLabel();
        JLabel labelA = new JLabel();
        listeCapteurs2 = new JList<>();
        checkEau2 = new JCheckBox();
        checkElectricite2 = new JCheckBox();
        checkAirComprime2 = new JCheckBox();
        checkTemperature2 = new JCheckBox();
        textDateDebut = new JTextField();
        textDateFin = new JTextField();
        btnValiderDates = new JButton();

        panelFiltres2.setBorder(BorderFactory.createTitledBorder("Filtres"));
        listeCapteurs2.setBorder(BorderFactory.createTitledBorder("Capteurs"));

        // REQUETE POUR GET TOUS LES NOMS DE CAPTEURS

        listeCapteurs2.setModel(new AbstractListModel<>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });

        panelFiltres2.add(scrollPanelListeCapteurs2, java.awt.BorderLayout.CENTER);

        panelCourbe1.setBackground(new java.awt.Color(204, 255, 204));
        panelCourbe2.setBackground(new java.awt.Color(255, 255, 204));
        panelCourbe3.setBackground(new java.awt.Color(255, 204, 255));

        checkEau2.setText("Eau");
        checkElectricite2.setText("Electricite");
        checkAirComprime2.setText("Air comprime");
        checkTemperature2.setText("Temperature");
        labelDe.setText("de : ");
        textDateDebut.setText("01/01/2000");
        labelA.setText(" à : ");
        textDateFin.setText("01/01/2022");
        btnValiderDates.setText("Valider");

        scrollPanelListeCapteurs2.setViewportView(listeCapteurs2);

        panelFluides2.add(checkEau2);
        panelFluides2.add(checkElectricite2);
        panelFluides2.add(checkAirComprime2);
        panelFluides2.add(checkTemperature2);
        panelDates2.add(labelDe);
        panelDates2.add(textDateDebut);
        panelDates2.add(labelA);
        panelDates2.add(textDateFin);
        panelDates.add(panelDates2, BorderLayout.CENTER);
        panelDates.add(btnValiderDates, BorderLayout.PAGE_END);
        panelFiltres2.add(panelFluides2, java.awt.BorderLayout.PAGE_START);
        panelFiltres2.add(panelDates, java.awt.BorderLayout.PAGE_END);
        panelCourbes.add(panelCourbe1);
        panelCourbes.add(panelCourbe2);
        panelCourbes.add(panelCourbe3);
        onglet2.add(panelFiltres2, java.awt.BorderLayout.LINE_END);
        onglet2.add(panelCourbes, java.awt.BorderLayout.CENTER);

        onglets.addTab("Visualisation en temps differe", onglet2);



        /* Onglet 3 - Gestion des capteurs */

        JPanel onglet3 = new JPanel(new java.awt.BorderLayout());
        JPanel panelTableaux = new JPanel(new java.awt.BorderLayout());
        JPanel panelInfosCapteur = new JPanel(new java.awt.BorderLayout());
        JPanel panelSeuilsDefaut = new JPanel(new java.awt.BorderLayout());
        JScrollPane scrollPanelInfosCapteur = new JScrollPane();
        JScrollPane scrollPanelSeuilsDefaut = new JScrollPane();
        JScrollPane scrollPanelTree = new JScrollPane();

        tableauInfosCapteur = new JTable();
        tableauSeuilsDefaut = new JTable();
        btnModifierSeuils = new JButton();
        treeCapteurs = new JTree();

        panelSeuilsDefaut.setBorder(BorderFactory.createTitledBorder("Seuils par defaut"));
        panelInfosCapteur.setBorder(BorderFactory.createTitledBorder("Informations du capteur"));
        panelTableaux.setPreferredSize(new java.awt.Dimension(300, 300));
        panelSeuilsDefaut.setPreferredSize(new Dimension(300, 120));

        tableauInfosCapteur.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Batiment", null},
                        {"Etage", null},
                        {"Type de fluide", null},
                        {"Seuil minimum", null},
                        {"Seuil maximum", null}
                },
                new String[]{"Informations", "Valeurs"}
        ) {
            boolean[] canEdit = new boolean[]{false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tableauSeuilsDefaut.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"EAU", 0, 10, "m3"},
                        {"ELECTRICITE", 10, 500, "kWh"},
                        {"TEMPERATURE", 17, 22, "°C"},
                        {"AIR COMPRIME", 0, 6, "m3/h"}
                },
                new String[]{"Fluide", "Seuil min", "Seuil max", "Unite"}
        ) {
            Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tableauSeuilsDefaut.getColumnModel().getColumn(0).setPreferredWidth(150);

        btnModifierSeuils.setText("Modifier les seuils");

        scrollPanelInfosCapteur.setViewportView(tableauInfosCapteur);
        scrollPanelSeuilsDefaut.setViewportView(tableauSeuilsDefaut);
        scrollPanelTree.setViewportView(treeCapteurs);

        panelInfosCapteur.add(scrollPanelInfosCapteur, java.awt.BorderLayout.CENTER);
        panelInfosCapteur.add(btnModifierSeuils, java.awt.BorderLayout.PAGE_END);
        panelSeuilsDefaut.add(scrollPanelSeuilsDefaut, java.awt.BorderLayout.CENTER);
        panelTableaux.add(panelInfosCapteur, BorderLayout.CENTER);
        panelTableaux.add(panelSeuilsDefaut, BorderLayout.SOUTH);
        onglet3.add(panelTableaux, BorderLayout.EAST);
        onglet3.add(scrollPanelTree, java.awt.BorderLayout.CENTER);

        onglets.addTab("Gestion des capteurs", onglet3);

        frame.add(onglets);
        frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Interface());
    }
}
