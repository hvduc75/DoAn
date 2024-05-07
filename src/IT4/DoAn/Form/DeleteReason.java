package IT4.DoAn.Form;

import IT4.DoAn.Service.OrderService;
import IT4.DoAn.Service.ReceiptService;
import javax.swing.JOptionPane;

public class DeleteReason extends javax.swing.JFrame {

    OrderService orderService;
    ReceiptService receiptService;
    private int order_Id;
    private int con_Id;

    public DeleteReason(int order_Id, int con_Id) {
        receiptService = new ReceiptService();
        orderService = new OrderService();
        initComponents();
        this.con_Id = con_Id;
        this.order_Id = order_Id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DeleteReason = new javax.swing.JTextArea();
        Confirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        DeleteReason.setColumns(20);
        DeleteReason.setRows(5);
        jScrollPane1.setViewportView(DeleteReason);

        Confirm.setBackground(new java.awt.Color(0, 102, 102));
        Confirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Confirm.setForeground(new java.awt.Color(255, 255, 255));
        Confirm.setText("Xác Nhận");
        Confirm.setBorderPainted(false);
        Confirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Confirm.setFocusPainted(false);
        Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Lý Do Hủy Đơn Hàng ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(Confirm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseClicked
        int Confirm = JOptionPane.showConfirmDialog(this, "Xác nhận hủy đơn hàng");
        if (Confirm == JOptionPane.YES_OPTION) {
            String reason = DeleteReason.getText();
            receiptService.AddReceipt(con_Id, order_Id, reason);
            orderService.UpdateStatus(1, order_Id);
            this.dispose();
        }
    }//GEN-LAST:event_ConfirmMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirm;
    private javax.swing.JTextArea DeleteReason;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
