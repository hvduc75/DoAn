package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import IT4.DoAn.Model.Order;
import IT4.DoAn.Service.ContainerService;
import IT4.DoAn.Service.OrderService;
import IT4.DoAn.Service.ShipperService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class CreateContainer extends javax.swing.JPanel {

    OrderService orderService;
    ShipperService shipperService;
    ContainerService containerService;
    DefaultTableModel defaultTableModel;
    private Main testInstance;
    private int rowTable;
    private List<Order> orders1;

    public CreateContainer(Main testInstance) {
        this.testInstance = testInstance;
        orderService = new OrderService();
        shipperService = new ShipperService();
        containerService = new ContainerService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        orders1 = new ArrayList<>();
        initComponents();
        ContainerOfShipperTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = ContainerOfShipperTable.rowAtPoint(e.getPoint());
                    rowTable = row;
                }
            }
        });
        JPopupMenu pop = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Thêm đơn hàng vào thùng");
        pop.add(menuItem1);
        ContainerOfShipperTable.setComponentPopupMenu(pop);

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int order_Id = Integer.valueOf(String.valueOf(ContainerOfShipperTable.getValueAt(rowTable, 0)));
                Order order = orderService.getOrderById(order_Id);
                orders1.add(order);
                OrderID.add(order_Id);
                int index = AddressComboBox.getSelectedIndex();
                    defaultTableModel.removeRow(rowTable);
                if (ContainerOfShipperTable.getRowCount() == 0) {
                    AddressComboBox.removeItemAt(index);
                }  
            }
        });
        List<Order> orders = orderService.getAllOrder();
        String[] array = new String[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            array[i] = orders.get(i).getDelivery_Location();
        }
        Set<String> AddressArray = new HashSet<>(Arrays.asList(array));
        for (String value : AddressArray) {
            AddressComboBox.addItem(value);
        }
    }

    private void setTableData(Order order) {
        String price = order.getPrice() + "000đ";
        String distance = order.getDistance() + "km";
        defaultTableModel.addRow(new Object[]{order.getId(), order.getName(),
            order.getReceive_Location(), order.getDelivery_Location(), order.getFeedback(),
            distance, price});
    }

    Vector OrderID = new Vector();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ContainerOfShipperTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        AddressComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        ContainerOfShipperTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ContainerOfShipperTable.setRowHeight(30);
        jScrollPane1.setViewportView(ContainerOfShipperTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xem Thùng Hàng Hiện Tại");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(0, 255, 0));
        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReload.setForeground(new java.awt.Color(255, 255, 255));
        btnReload.setText("Reload");
        btnReload.setBorderPainted(false);
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.setFocusPainted(false);
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });

        AddressComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(AddressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnReload)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddressComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddressComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressComboBoxActionPerformed
        defaultTableModel.setColumnCount(0);
        String value = String.valueOf(AddressComboBox.getSelectedItem());
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên đơn hàng");
        defaultTableModel.addColumn("Điểm nhận hàng");
        defaultTableModel.addColumn("Điểm giao hàng");
        defaultTableModel.addColumn("Mô tả");
        defaultTableModel.addColumn("Khoảng cách");
        defaultTableModel.addColumn("Giá trị");
        defaultTableModel.setRowCount(0);
        ContainerOfShipperTable.setModel(defaultTableModel);
        List<Order> orders = orderService.getOrderByAddress(value);
        for (Order order : orders) {
            setTableData(order);
        }
    }//GEN-LAST:event_AddressComboBoxActionPerformed

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        testInstance.setForm(new CreateContainer(testInstance));
        repaint();
    }//GEN-LAST:event_btnReloadMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ContainerTemporary HVD = new ContainerTemporary(orders1, OrderID, testInstance);
        HVD.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AddressComboBox;
    private javax.swing.JTable ContainerOfShipperTable;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
