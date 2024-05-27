package IT4.DoAn.Main;

import IT4.DoAn.Event.EventMenuSelected;
import IT4.DoAn.Form.Form_Search;
import IT4.DoAn.Form.Form_Home;
import IT4.DoAn.Form.Form_Order;
import IT4.DoAn.Form.Form_Shipper;
import IT4.DoAn.Form.Introduce;
import IT4.DoAn.Form.Login;
import IT4.DoAn.Form.CreateContainer;
import IT4.DoAn.Form.Form_Statistical;
import IT4.DoAn.Form.TestPanel;
import java.awt.Color;
import javax.swing.JComponent;

public class Main extends javax.swing.JFrame {

    private Form_Home home;
    private Form_Search formSearch;
    private Form_Statistical formStatistical;
    private CreateContainer NewCreateContainer;
    private Form_Shipper formShipper;
    private Form_Order formOrder;
    private TestPanel testPanel;
    private Login login;
    private Introduce introduce;
    
    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    home = new Form_Home();
                    setForm(home);
                }else if (index == 1) {
                    formStatistical = new Form_Statistical();
                    setForm(formStatistical);
                } else if (index == 2) {
                    formSearch = new Form_Search(Main.this);
                    setForm(formSearch);
                }  else if (index == 3) {
                    NewCreateContainer = new CreateContainer(Main.this);
                    setForm(NewCreateContainer);
                } else if (index == 4) {
                    formShipper = new Form_Shipper(Main.this);
                    setForm(formShipper);
                    index = 3;
                } else if(index == 5) {
                    formOrder = new Form_Order(Main.this);
                    setForm(formOrder);
                } else if(index == 12) {
                    testPanel = new TestPanel(Main.this);
                    setForm(testPanel);
                } else if(index == 14) {
                    introduce = new Introduce();
                    setForm(introduce);
                } else if(index == 15) {
                    login  = new Login();
                    login.setVisible(true);
                    Main.this.dispose();
                }
            }
        });
        setForm(new Form_Home());
    }
    
    public void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new IT4.DoAn.Swing.PanelBorder();
        menu = new IT4.DoAn.Component.Menu();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        mainPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private IT4.DoAn.Component.Menu menu;
    private IT4.DoAn.Swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
