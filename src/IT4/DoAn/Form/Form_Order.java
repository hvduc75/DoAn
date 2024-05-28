package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import IT4.DoAn.Model.Order;
import IT4.DoAn.Service.OrderService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Order extends javax.swing.JPanel {

    OrderService orderService;
    DefaultTableModel defaultTableModel;
    private Main testInstance;
    private int rowTable;

    public Form_Order(Main testInstance) {
        this.testInstance = testInstance;
        initComponents();
        orderService = new OrderService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        OrderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Kiểm tra xem có phải double-click không
                if (e.getClickCount() == 2) {
                    // Xử lý hành động khi double-click
                    int row = OrderTable.rowAtPoint(e.getPoint());
                    rowTable = row;
                    Order order = getTableData(row);
                    UpdateOrDeleteOrder HVD = new UpdateOrDeleteOrder(order, testInstance);
                    HVD.setVisible(true);
                }
            }
        });
        OrderTable.setComponentPopupMenu(OrderPopupMenu);
        OrderTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên đơn hàng");
        defaultTableModel.addColumn("Điểm nhận hàng");
        defaultTableModel.addColumn("Điểm giao hàng");
        defaultTableModel.addColumn("Tình trạng đơn hàng");
        defaultTableModel.addColumn("Mô tả");
        defaultTableModel.addColumn("Khoảng cách");
        defaultTableModel.addColumn("Giá trị");
        defaultTableModel.addColumn("Tên khách hàng");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Ngày đặt");
        defaultTableModel.addColumn("Ngày dự kiến");

        setTableData(orderService.getAllOrder());
    }

    private void setTableData(List<Order> orders) {
        for (Order order : orders) {
            String price = order.getPrice() + "00đ";
            String distance = order.getDistance() + "km";
            String x = "";
            String y = "";
            if (order.getStatus() == 1) {
                x = "Chưa Giao";
                y = "Chưa Xác Định";
            } else if (order.getStatus() == 2) {
                x = "Đang Giao";
                y = String.valueOf(order.getDelivery_Expected());
            } else if (order.getStatus() == 3) {
                x = "Đã Giao";
                y = String.valueOf(order.getDelivery_Expected());
            }
            defaultTableModel.addRow(new Object[]{order.getId(), order.getName(),
                order.getReceive_Location(), order.getDelivery_Location(), x, order.getDescription(),
                distance, price, order.getUser_name(), order.getUser_phone(), order.getDate_Create(), y});
        }
    }

    private void setTableData(Order order) {
        String price = order.getPrice() + "000đ";
        String distance = order.getDistance() + "km";
        String x = "";
        String y = "";
        if (order.getStatus() == 1) {
            x = "Chưa Giao";
            y = "Chưa Xác Định";
        } else if (order.getStatus() == 2) {
            x = "Đang Giao";
            y = String.valueOf(order.getDelivery_Expected());
        } else if (order.getStatus() == 3) {
            x = "Đã Giao";
            y = String.valueOf(order.getDelivery_Expected());
        }
        defaultTableModel.addRow(new Object[]{order.getId(), order.getName(),
            order.getReceive_Location(), order.getDelivery_Location(), x, order.getFeedback(),
            distance, price, order.getDate_Create(), y});
    }

    private Order getTableData(int row) {
        Order order = new Order();
        int orderId = Integer.valueOf(String.valueOf(OrderTable.getValueAt(row, 0)));
        order = orderService.getOrderById(orderId);
        return order;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OrderPopupMenu = new javax.swing.JPopupMenu();
        UpdateOrDelete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();

        UpdateOrDelete.setText("Chỉnh sửa thông tin đơn hàng");
        UpdateOrDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOrDeleteActionPerformed(evt);
            }
        });
        OrderPopupMenu.add(UpdateOrDelete);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(51, 255, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setText("+ ADD");
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(0, 255, 255));
        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReload.setText("Reload");
        btnReload.setBorderPainted(false);
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.setFocusPainted(false);
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });

        jLabel1.setText("Số Điện Thoại");

        PhoneNumber.setMinimumSize(new java.awt.Dimension(64, 25));

        btnSearch.setBackground(new java.awt.Color(0, 102, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setBorderPainted(false);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFocusPainted(false);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        OrderTable.setRowHeight(30);
        OrderTable.setSelectionBackground(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(OrderTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                        .addComponent(btnReload)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        AddOrder HVD = new AddOrder(testInstance);
        HVD.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        try {
            String phoneNumber = PhoneNumber.getText();
            if (PhoneNumber.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Form_Order.this, "Vui lòn nhập vào số điện thoại của người dùng");
            } else {
                defaultTableModel.setRowCount(0);
                setTableData(orderService.getAllOrdersByUserPhone(phoneNumber));
                OrderTable.setComponentPopupMenu(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Form_Order.this, "Số điện thoại này không tồn tại trong hệ thống vui lòng kiểm tra lại !!!");
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        testInstance.setForm(new Form_Order(testInstance));
        repaint();
    }//GEN-LAST:event_btnReloadMouseClicked

    private void UpdateOrDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOrDeleteActionPerformed
        Order order = getTableData(rowTable);
        UpdateOrDeleteOrder HVD = new UpdateOrDeleteOrder(order, testInstance);
        HVD.setVisible(true);
    }//GEN-LAST:event_UpdateOrDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu OrderPopupMenu;
    private javax.swing.JTable OrderTable;
    private javax.swing.JTextField PhoneNumber;
    private javax.swing.JMenuItem UpdateOrDelete;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
