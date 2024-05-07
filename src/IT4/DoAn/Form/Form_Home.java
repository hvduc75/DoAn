package IT4.DoAn.Form;

import IT4.DoAn.Model.Model_Card;
import IT4.DoAn.Model.Shipper;
import IT4.DoAn.Service.StatisticalService;
import IT4.DoAn.Swing.ScrollBar;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {

    StatisticalService statisticalService;
    
    public Form_Home() {
        statisticalService = new StatisticalService();
        initComponents();
        int ShipperNum = statisticalService.getShipperNumber();
        int ShipperOnline = statisticalService.getShipperNumberOnline();
        int ShipperOffline = statisticalService.getShipperNumberOffline();
        int OrderNum = statisticalService.getOrderNumber();
        int OrderDelivering = statisticalService.getOrderNumberDelivering();
        int OrderDelivered = statisticalService.getOrderNumberDelivered();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/IT4/DoAn/icon/stock.png")), "Số Lượng         " + ShipperNum, "Đang Online    " + ShipperOnline, "Đang Offline   " + ShipperOffline, "Danh Sách Shipper"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/IT4/DoAn/icon/profit.png")), "Số Lượng      " + OrderNum + " ", "Đang Giao    " + OrderDelivering + " ", "Đã Giao        " + OrderDelivered + " ", "Danh Sách Đơn Hàng"));
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        setTableData(statisticalService.getAllShipperByScore());
    }

    private void setTableData(List<Shipper> shippers) {
        for (Shipper shipper : shippers) {
            float x = shipper.getScore();
            BigDecimal number = new BigDecimal(Float.toString(x));
            number = number.setScale(1, BigDecimal.ROUND_HALF_UP);
            table.addRow(new Object[]{shipper.getShipper_Id(), shipper.getName(), shipper.getBirthDay(), shipper.getGender(), shipper.getStartWork(), shipper.getPhone(), shipper.getEmail(), shipper.getAddress(), shipper.getDescription(), number});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new IT4.DoAn.Component.Card();
        card2 = new IT4.DoAn.Component.Card();
        panelBorder1 = new IT4.DoAn.Swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new IT4.DoAn.Swing.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Shipper Rankings");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "BirthDay", "Gender", "StartWork", "Phone", "Email", "Address", "Description", "Star"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(626, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable)
                        .addGap(20, 20, 20))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private IT4.DoAn.Component.Card card1;
    private IT4.DoAn.Component.Card card2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private IT4.DoAn.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private IT4.DoAn.Swing.Table table;
    // End of variables declaration//GEN-END:variables
}
