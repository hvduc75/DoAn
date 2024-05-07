package IT4.DoAn.Form;

import IT4.DoAn.Model.Shipper;
import IT4.DoAn.Service.OrderService;
import IT4.DoAn.Service.SearchService;
import IT4.DoAn.Service.ShipperService;
import javax.swing.JOptionPane;

public class Form_FeedBack extends javax.swing.JFrame {

    ShipperService shipperService;
    SearchService searchService;
    OrderService orderService;
    private int Shipper_id;
    private int Order_id;

    public Form_FeedBack(int shipperId, int orderId) {
        shipperService = new ShipperService();
        searchService = new SearchService();
        orderService = new OrderService();
        this.Order_id = orderId;
        this.Shipper_id = shipperId;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderDescription = new javax.swing.JTextArea();
        ShipperStar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnConfirm.setBackground(new java.awt.Color(0, 51, 255));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Confirm");
        btnConfirm.setBorderPainted(false);
        btnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirm.setFocusPainted(false);
        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Phản Hồi về Đơn Hàng");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Đánh Giá Shipper");

        OrderDescription.setColumns(20);
        OrderDescription.setRows(5);
        jScrollPane1.setViewportView(OrderDescription);

        ShipperStar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "4", "3", "2", "1" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShipperStar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnConfirm)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShipperStar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmMouseClicked
        int Confirm = JOptionPane.showConfirmDialog(this, "Xác nhận hoàn thành đơn hàng");
        if (Confirm == JOptionPane.YES_OPTION) {
            Shipper shipper = shipperService.getShipperById(Shipper_id);
            float Star = shipper.getScore(); // Sử dụng float thay vì Float
            float newStar = Float.valueOf(String.valueOf(ShipperStar.getSelectedItem())); // Chuyển đổi từ Integer sang float
            int OrderNum = Integer.valueOf(String.valueOf(searchService.NOODelivered(Shipper_id)));
            int OrderNotFeedBack = Integer.valueOf(String.valueOf(searchService.NOODeliveredNotFeedBack(Shipper_id)));
            float test = (Star * (OrderNum - OrderNotFeedBack) + newStar) / ((OrderNum - OrderNotFeedBack) + 1);
            String OrderFeedBack = OrderDescription.getText();
            orderService.UpdateFeedBack(OrderFeedBack, Order_id);
            shipperService.UpdateStar(test, Shipper_id);
            this.dispose();
        }
    }//GEN-LAST:event_btnConfirmMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea OrderDescription;
    private javax.swing.JComboBox<String> ShipperStar;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
