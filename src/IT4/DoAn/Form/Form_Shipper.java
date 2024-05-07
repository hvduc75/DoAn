package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import IT4.DoAn.Model.Shipper;
import IT4.DoAn.Service.ShipperService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Form_Shipper extends javax.swing.JPanel {

    ShipperService shipperservice;
    DefaultTableModel defaultTableModel;
    private Main testInstance;
    private int rowTable;

    public Form_Shipper(Main testInstance) {
        this.testInstance = testInstance;
        initComponents();
        shipperservice = new ShipperService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ShipperTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Kiểm tra xem có phải double-click không
                if (e.getClickCount() == 1) {
                    int row = ShipperTable.rowAtPoint(e.getPoint());
                    rowTable = row;
                } else if (e.getClickCount() == 2) {
                    // Xử lý hành động khi double-click
                    int row = ShipperTable.rowAtPoint(e.getPoint());
                    // Thực hiện hành động khi double-click xảy ra trên dòng row
                    // Ví dụ: Hiển thị thông tin chi tiết của dòng được chọn
                    Shipper shipper = getTableData(row);
                    UpdateOrDeleteShipper HVD = new UpdateOrDeleteShipper(shipper, testInstance);
                    HVD.setVisible(true);
                }
            }
//            Chưa Fix được
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                if (e.isPopupTrigger()) {
//                    int row = ShipperTable.rowAtPoint(e.getPoint());
//      ShipperTable.setComponentPopupMenu(ShipperPopupMenu);              if (row >= 0 && row < ShipperTable.getRowCount()) {
//                        rowTable = 2;
//                    }
//                }
//            }
        });

        ShipperTable.setComponentPopupMenu(ShipperPopupMenu);
        ShipperTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("BirthDay");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("StartWork");
        defaultTableModel.addColumn("Phone");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("Description");
        defaultTableModel.addColumn("Star");

        setTableData(shipperservice.getAllShipper("(SHIPPER_STATUS=1 OR SHIPPER_STATUS=0)"));
    }

    private void setTableData(List<Shipper> shippers) {
        for (Shipper shipper : shippers) {
            float x = shipper.getScore();
            BigDecimal number = new BigDecimal(Float.toString(x));
            number = number.setScale(1, BigDecimal.ROUND_HALF_UP);
            defaultTableModel.addRow(new Object[]{shipper.getShipper_Id(), shipper.getName(), shipper.getBirthDay(),
                shipper.getGender(), shipper.getStartWork(), shipper.getPhone(), shipper.getEmail(), shipper.getAddress(),
                shipper.getDescription(), number});
        }
    }

    private Shipper getTableData(int row) {
        Shipper shipper = new Shipper();
        int shipperId = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(row, 0)));
        String name = String.valueOf(ShipperTable.getValueAt(row, 1));
        String birthDay = String.valueOf(ShipperTable.getValueAt(row, 2));
        String Gender = String.valueOf(ShipperTable.getValueAt(row, 3));
        String startWork = String.valueOf(ShipperTable.getValueAt(row, 4));
        String phone = String.valueOf(ShipperTable.getValueAt(row, 5));
        String email = String.valueOf(ShipperTable.getValueAt(row, 6));
        String Address = String.valueOf(ShipperTable.getValueAt(row, 7));
        String description = String.valueOf(ShipperTable.getValueAt(row, 8));
        shipper.setShipper_Id(shipperId);
        shipper.setName(name);
        shipper.setBirthDay(birthDay);
        shipper.setDescription(description);
        shipper.setGender(Gender);
        shipper.setStartWork(startWork);
        shipper.setPhone(phone);
        shipper.setEmail(email);
        shipper.setAddress(Address);
        return shipper;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShipperPopupMenu = new javax.swing.JPopupMenu();
        CreateContainer = new javax.swing.JMenuItem();
        UpdateOrDelete = new javax.swing.JMenuItem();
        SwitchStatus = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShipperTable = new javax.swing.JTable();
        ShowComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        CreateContainer.setText("Tạo Thùng Hàng Cho Shipper");
        CreateContainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateContainerActionPerformed(evt);
            }
        });
        ShipperPopupMenu.add(CreateContainer);

        UpdateOrDelete.setText("Chỉnh Sửa Thông Tin Shipper");
        UpdateOrDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateOrDeleteActionPerformed(evt);
            }
        });
        ShipperPopupMenu.add(UpdateOrDelete);

        SwitchStatus.setText("Thay Đổi Trạng Thái Cho Shipper");
        SwitchStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwitchStatusActionPerformed(evt);
            }
        });
        ShipperPopupMenu.add(SwitchStatus);

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

        ShipperTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ShipperTable.setRowHeight(30);
        ShipperTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setViewportView(ShipperTable);

        ShowComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Đang Online", "Đang Offline" }));
        ShowComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Hiển thị theo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(ShowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReload)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnReload)
                        .addComponent(jLabel1))
                    .addComponent(ShowComboBox))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
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
        AddShipper HVD = new AddShipper(testInstance);
        HVD.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void ShowComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowComboBoxActionPerformed
        String Selected = String.valueOf(ShowComboBox.getSelectedItem());
        if (Selected == "Tất Cả") {
            defaultTableModel.setRowCount(0);
            setTableData(shipperservice.getAllShipper("SHIPPER_CHECK_DELETE = 0 AND (SHIPPER_STATUS = 0 OR SHIPPER_STATUS = 1)"));
        } else if (Selected == "Đang Online") {
            defaultTableModel.setRowCount(0);
            setTableData(shipperservice.getAllShipper("SHIPPER_CHECK_DELETE = 0 AND SHIPPER_STATUS = 1"));
        } else if (Selected == "Đang Offline") {
            defaultTableModel.setRowCount(0);
            setTableData(shipperservice.getAllShipper("SHIPPER_CHECK_DELETE = 0 AND SHIPPER_STATUS = 0"));
        }
    }//GEN-LAST:event_ShowComboBoxActionPerformed

    private void CreateContainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateContainerActionPerformed
        testInstance.setForm(new CreateContainer(testInstance));
        repaint();
    }//GEN-LAST:event_CreateContainerActionPerformed

    private void SwitchStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwitchStatusActionPerformed
        int ShipperId = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 0)));
        Shipper shipper = shipperservice.getShipperById(ShipperId);
        Boolean shipperStatus = shipper.getStatus();
        if (shipperStatus) {
            shipperservice.UpdateStatus(false, ShipperId);
        } else {
            shipperservice.UpdateStatus(true, ShipperId);
        }
        testInstance.setForm(new Form_Shipper(testInstance));
        repaint();
    }//GEN-LAST:event_SwitchStatusActionPerformed

    private void UpdateOrDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateOrDeleteActionPerformed
        Shipper shipper = getTableData(rowTable);
        UpdateOrDeleteShipper HVD = new UpdateOrDeleteShipper(shipper, testInstance);
        HVD.setVisible(true);
    }//GEN-LAST:event_UpdateOrDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CreateContainer;
    private javax.swing.JPopupMenu ShipperPopupMenu;
    private javax.swing.JTable ShipperTable;
    private javax.swing.JComboBox<String> ShowComboBox;
    private javax.swing.JMenuItem SwitchStatus;
    private javax.swing.JMenuItem UpdateOrDelete;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
