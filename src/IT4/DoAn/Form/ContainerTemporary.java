package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import IT4.DoAn.Model.Container;
import IT4.DoAn.Model.Order;
import IT4.DoAn.Model.Shipper;
import IT4.DoAn.Service.ContainerService;
import IT4.DoAn.Service.OrderService;
import IT4.DoAn.Service.ShipperService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class ContainerTemporary extends javax.swing.JFrame {

    DefaultTableModel defaultTableModel;
    OrderService orderService;
    ShipperService shipperService;
    ContainerService containerService;
    private Main testInstance;
    private Vector OrderID;
    private int rowTable;

    public ContainerTemporary(List<Order> orders, Vector OrderID, Main testInstance) {
        this.testInstance = testInstance;
        this.OrderID = OrderID;
        defaultTableModel = new DefaultTableModel();
        shipperService = new ShipperService();
        containerService = new ContainerService();
        orderService = new OrderService();

        initComponents();
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên đơn hàng");
        defaultTableModel.addColumn("Điểm nhận hàng");
        defaultTableModel.addColumn("Điểm giao hàng");
        defaultTableModel.addColumn("Mô tả");
        defaultTableModel.addColumn("Khoảng cách");
        defaultTableModel.addColumn("Giá trị");
        ContainerTable.setModel(defaultTableModel);
        for (Order order : orders) {
            setTableData(order);
        }

        List<Shipper> shippers = shipperService.getAllShipper("SHIPPER_STATUS=1");
        for (Shipper shipper : shippers) {
            String[] address = shipper.getAddress().split("/");
            String test = address[address.length - 1];
            ShipperIdComboBox.addItem(shipper.getShipper_Id() + "-" + String.valueOf(shipper.getName() + "-" + test));
        }
        
        ContainerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Kiểm tra xem có phải click chuột không
                if (e.getClickCount() == 1) {
                    int row = ContainerTable.rowAtPoint(e.getPoint());
                    rowTable = row;
                }
            }
        });
        
        JPopupMenu pop = new JPopupMenu();
            JMenuItem menuItem = new JMenuItem("Bỏ đơn hàng ra khỏi thùng");
            pop.add(menuItem);
            ContainerTable.setComponentPopupMenu(pop);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int orderId = Integer.valueOf(String.valueOf(ContainerTable.getValueAt(rowTable, 0)));
                    defaultTableModel.removeRow(rowTable);
                    for (int i = 0; i < OrderID.size(); i++) {
                        int test = Integer.valueOf(String.valueOf(OrderID.elementAt(i)));
                        if(orderId == test) {
                            OrderID.remove(i);
                        }
                    }
                }
            });
    }

    private void setTableData(Order order) {
        String price = order.getPrice() + "000đ";
        String distance = order.getDistance() + "km";
        defaultTableModel.addRow(new Object[]{order.getId(), order.getName(),
            order.getReceive_Location(), order.getDelivery_Location(), order.getFeedback(),
            distance, price});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ContainerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ShipperIdComboBox = new javax.swing.JComboBox<>();
        BtnDelete = new javax.swing.JButton();
        btnAddShipper = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ContainerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ContainerTable.setRowHeight(30);
        jScrollPane1.setViewportView(ContainerTable);

        jLabel2.setText("Chọn Shipper");

        BtnDelete.setBackground(new java.awt.Color(255, 0, 0));
        BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        BtnDelete.setText("Hủy Thùng Hàng");
        BtnDelete.setBorderPainted(false);
        BtnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDelete.setFocusPainted(false);
        BtnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDeleteMouseClicked(evt);
            }
        });

        btnAddShipper.setBackground(new java.awt.Color(0, 255, 0));
        btnAddShipper.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddShipper.setForeground(new java.awt.Color(255, 255, 255));
        btnAddShipper.setText("Add Shipper");
        btnAddShipper.setBorderPainted(false);
        btnAddShipper.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddShipper.setFocusPainted(false);
        btnAddShipper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddShipperMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShipperIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddShipper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDelete)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddShipper, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShipperIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAddShipperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddShipperMouseClicked
        if (ContainerTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có đơn hàng trong thùng hàng vui lòng thêm đơn hàng !!!");
        } else {
            String test = String.valueOf(ShipperIdComboBox.getSelectedItem());
            String[] NameShipper = test.split("-");
            int shipperId = Integer.valueOf(NameShipper[0]);
            boolean islegal = false;
            Shipper shipper = shipperService.getShipperById(shipperId);
            float x = shipper.getScore();
            BigDecimal number = new BigDecimal(Float.toString(x));
            number = number.setScale(1, BigDecimal.ROUND_HALF_UP);
            int OrderNumber = ContainerTable.getRowCount() + 1;
            if (shipper.getScore() >= 4) {
                islegal = true;
            }
            else if(shipper.getScore() >= 3) {
                if(OrderNumber > 6){
                    JOptionPane.showMessageDialog(this, "Với số sao hiện tại của bạn là " + number + " bạn không thể chọn số lượng hàng lớn hơn " + (OrderNumber - 1));
                }else{
                    islegal = true;
                }
            }
            else if(shipper.getScore() >= 2) {
                if(OrderNumber > 4){
                    JOptionPane.showMessageDialog(this, "Với số sao hiện tại của bạn là " + number + " bạn không thể chọn số lượng hàng lớn hơn " + (OrderNumber - 1));
                }else{
                    islegal = true;
                }
            }
            else if(shipper.getScore() >= 1) {
                if(OrderNumber > 2){
                    JOptionPane.showMessageDialog(this, "Với số sao hiện tại của bạn là " + number + " bạn không thể chọn số lượng hàng lớn hơn " + (OrderNumber - 1));
                }else{
                    islegal = true;
                }
            }
            if(islegal) {
                int confirm = JOptionPane.showConfirmDialog(this, "Thêm Shipper thành công vui lòng xác nhận để hoàn thành!");
            if (confirm == JOptionPane.YES_OPTION) {
                Container container = new Container();
                container.setShipper_Id(shipperId);
                LocalDateTime currentTime = LocalDateTime.now();
                LocalDateTime roundedDateTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
                Timestamp currentTimestamp = Timestamp.valueOf(roundedDateTime);
                container.setDate_Create(currentTimestamp);
                containerService.addContainer(container);
                int container_ID = containerService.getContainer_ID(currentTimestamp);

                for (int i = 0; i < OrderID.size(); i++) {
                    // Cần chuẩn hóa lại code cho tối ưu
                    int orderId = Integer.valueOf(String.valueOf(OrderID.elementAt(i)));
                    orderService.UpdateCONTAINER_ID(container_ID, orderId);
                    Order order = orderService.getOrderById(orderId);
                    Double plus = order.getDistance() / 2;
                    LocalDateTime futureDateTime = currentTimestamp.toLocalDateTime();
                    LocalDateTime newTime = futureDateTime.plusHours(plus.longValue());
                    Timestamp newTimestamp = Timestamp.valueOf(newTime);
                    orderService.UpdateDateExpected(newTimestamp, orderId);
                    if (order.getDelivery_Count() == 2) {
                        orderService.UpdateDelete(order.getId());
                    }
                    orderService.UpdateDeliveryCount(order.getDelivery_Count() + 1, orderId);
                    orderService.UpdateStatus(2, orderId);
                }
            }
            testInstance.setForm(new CreateContainer(testInstance));
            repaint();
            this.dispose();
            }
        }
    }//GEN-LAST:event_btnAddShipperMouseClicked

    private void BtnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDeleteMouseClicked
        testInstance.setForm(new CreateContainer(testInstance));
        repaint();
        this.dispose();
    }//GEN-LAST:event_BtnDeleteMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JTable ContainerTable;
    private javax.swing.JComboBox<String> ShipperIdComboBox;
    private javax.swing.JButton btnAddShipper;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
