package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import IT4.DoAn.Model.Shipper;
import IT4.DoAn.Service.OrderService;
import IT4.DoAn.Service.ReceiptService;
import IT4.DoAn.Service.SearchService;
import IT4.DoAn.Service.ShipperService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class Form_Search extends javax.swing.JPanel {

    ShipperService shipperService;
    SearchService searchService;
    OrderService orderService;
    ReceiptService receiptService;
    DefaultTableModel defaultTableModel;
    private Main testInstance;
    private int rowTable;

    public Form_Search(Main testInstance) {
        this.testInstance = testInstance;
        shipperService = new ShipperService();
        searchService = new SearchService();
        orderService = new OrderService();
        receiptService = new ReceiptService();

        initComponents();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ShipperTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Kiểm tra xem có phải click chuột không
                if (e.getClickCount() == 1) {
                    int row = ShipperTable.rowAtPoint(e.getPoint());
                    rowTable = row;
                } else if (e.getClickCount() == 2) {
                    // Xử lý hành động khi double-click
                }
            }
        });
    }

    private void setTableData(Shipper shipper) {
        defaultTableModel.addRow(new Object[]{shipper.getShipper_Id(), shipper.getName(), shipper.getBirthDay(), shipper.getGender(), shipper.getStartWork(), shipper.getPhone(), shipper.getEmail(), shipper.getAddress(), shipper.getDescription(), shipper.getScore(), shipper.getScore()});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDTextField = new javax.swing.JTextField();
        DeliveringPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbDeliveringNum = new javax.swing.JLabel();
        DeliveredPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlbDeliveredNum = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShipperTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        DeliveringPanel.setBackground(new java.awt.Color(51, 255, 0));
        DeliveringPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeliveringPanelMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Đang Giao");

        jlbDeliveringNum.setText(" ");

        javax.swing.GroupLayout DeliveringPanelLayout = new javax.swing.GroupLayout(DeliveringPanel);
        DeliveringPanel.setLayout(DeliveringPanelLayout);
        DeliveringPanelLayout.setHorizontalGroup(
            DeliveringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveringPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlbDeliveringNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        DeliveringPanelLayout.setVerticalGroup(
            DeliveringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveringPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jlbDeliveringNum)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        DeliveredPanel.setBackground(new java.awt.Color(51, 255, 0));
        DeliveredPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeliveredPanelMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Đã Giao");

        jlbDeliveredNum.setText(" ");

        javax.swing.GroupLayout DeliveredPanelLayout = new javax.swing.GroupLayout(DeliveredPanel);
        DeliveredPanel.setLayout(DeliveredPanelLayout);
        DeliveredPanelLayout.setHorizontalGroup(
            DeliveredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveredPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeliveredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jlbDeliveredNum, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        DeliveredPanelLayout.setVerticalGroup(
            DeliveredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveredPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jlbDeliveredNum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearch.setBackground(new java.awt.Color(51, 255, 0));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm Kiếm");
        btnSearch.setBorderPainted(false);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFocusPainted(false);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        ShipperTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ShipperTable.setRowHeight(30);
        jScrollPane1.setViewportView(ShipperTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Shipper");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnSearch)
                        .addGap(72, 72, 72)
                        .addComponent(DeliveringPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(DeliveredPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeliveringPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeliveredPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchHandle() {
        int ShipperId = Integer.valueOf(IDTextField.getText());
        try {
            defaultTableModel.setColumnCount(0);
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
            defaultTableModel.setRowCount(0);
            setTableData(shipperService.getShipperById(ShipperId));
            jlbDeliveringNum.setText(String.valueOf(searchService.NOOBDelivered(ShipperId)));
            jlbDeliveredNum.setText(String.valueOf(searchService.NOODelivered(ShipperId)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Shipper bạn tìm không tồn tại trong hệ thống vui lòng nhập lại ShipperID !!!");
        }

        JPopupMenu pop = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Tạo thùng hàng cho Shipper");
        JMenuItem menuItem1 = new JMenuItem("Chỉnh sửa thông tin cho Shipper");
        pop.add(menuItem);
        pop.add(menuItem1);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Form_Search.this, "Tạo thùng hàng mới cho Shipper này");
            }
        });
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateOrDeleteShipper HVD = new UpdateOrDeleteShipper(shipperService.getShipperById(ShipperId), testInstance);
                HVD.setVisible(true);
            }
        });
        ShipperTable.setComponentPopupMenu(pop);
    }

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        btnSearchHandle();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void DeliveringPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeliveringPanelMouseClicked
        try {
            int ShipperId = Integer.valueOf(IDTextField.getText());
            Vector<String> header = new Vector<>();
            Vector<Vector<String>> data = searchService.getAllBDOrderInformation(ShipperId);
            header.add("ID");
            header.add("Shipper Name");
            header.add("Order ID");
            header.add("Container_ID");
            header.add("Order Name");
            header.add("Order Price");
            header.add("Order Creation Date");
            header.add("Expected Delivery Date");
            defaultTableModel.setDataVector(data, header);
            ShipperTable.setModel(defaultTableModel);
            ShipperTable.setComponentPopupMenu(null);

            JPopupMenu pop = new JPopupMenu();
            JMenuItem menuItem = new JMenuItem("Xác nhận hoàn thành đơn hàng");
            JMenuItem menuItem1 = new JMenuItem("Hủy đơn hàng");
            pop.add(menuItem);
            pop.add(menuItem1);
            ShipperTable.setComponentPopupMenu(pop);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int Confirm = JOptionPane.showConfirmDialog(Form_Search.this, "Xác nhận hoàn thành đơn hàng");
                    if (Confirm == JOptionPane.YES_OPTION) {
                        int order_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 2)));
                        int con_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 3)));
                        orderService.UpdateStatus(3, order_Id);
                        LocalDateTime currentTime = LocalDateTime.now();
                        LocalDateTime roundedDateTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
                        Timestamp currentTimestamp = Timestamp.valueOf(roundedDateTime);
                        orderService.UpdateDateActual(currentTimestamp, order_Id);
                        String reason = "";
                        receiptService.AddReceipt(con_Id, order_Id, reason);
                        orderService.UpdateDelete(order_Id);
                        defaultTableModel.removeRow(rowTable);
                        jlbDeliveringNum.setText(String.valueOf(searchService.NOOBDelivered(ShipperId)));
                        jlbDeliveredNum.setText(String.valueOf(searchService.NOODelivered(ShipperId)));

                    }
                }
            });
            menuItem1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int order_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 2)));
                    int con_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 3)));
                    DeleteReason HVD = new DeleteReason(order_Id, con_Id);
                    HVD.setVisible(true);
                    HVD.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            defaultTableModel.removeRow(rowTable);
                            jlbDeliveringNum.setText(String.valueOf(searchService.NOOBDelivered(ShipperId)));
                        }
                    });
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Form_Search.this, "Không có thông tin vui lòng tìm kiếm shipper để xem thêm");
        }
    }//GEN-LAST:event_DeliveringPanelMouseClicked

    private void DeliveredPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeliveredPanelMouseClicked
        try {
            int ShipperId = Integer.valueOf(IDTextField.getText());
            Vector<String> header = new Vector<>();
            Vector<Vector<String>> data = searchService.getAllDOrderInformation(ShipperId);
            header.add("ID");
            header.add("Shipper Name");
            header.add("Order_ID");
            header.add("Order Name");
            header.add("Order Price");
            header.add("Order Creation Date");
            header.add("Actual Delivery Date");
            defaultTableModel.setDataVector(data, header);
            ShipperTable.setModel(defaultTableModel);
            JPopupMenu pop = new JPopupMenu();
            // Thêm JMenuItem vào JPopupMenu
            JMenuItem menuItem = new JMenuItem("Xem Lịch sử giao hàng");
            JMenuItem menuItem1 = new JMenuItem("Đánh giá shipper và mặt hàng");
            JMenuItem menuItem2 = new JMenuItem("Xắp xếp theo các đơn hàng chưa được đánh giá");
            pop.add(menuItem);
            pop.add(menuItem1);
            pop.add(menuItem2);
            ShipperTable.setComponentPopupMenu(pop);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int order_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 2)));
                    System.out.println(order_Id);
                    DeliveryHistory HVD = new DeliveryHistory(order_Id);
                    HVD.setVisible(true);
                }
            });
            menuItem1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int shipper_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 0)));
                    int order_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 2)));
                    Vector<String> header = new Vector<>();
                    Vector<Vector<String>> data = searchService.getAllDOrderInformationFeedbacked(shipper_Id, order_Id);
                    if (data.size() == 1) {
                        JOptionPane.showMessageDialog(Form_Search.this, "Đơn hàng này đã được đánh giá rồi");
                    } else {
                        Form_FeedBack HVD = new Form_FeedBack(shipper_Id, order_Id);
                        HVD.setVisible(true);
                        HVD.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            defaultTableModel.removeRow(rowTable);
                        }
                    });
                    }
                }
            });
            menuItem2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int shipper_Id = Integer.valueOf(String.valueOf(ShipperTable.getValueAt(rowTable, 0)));
                    Vector<String> header = new Vector<>();
                    Vector<Vector<String>> data = searchService.getAllDOrderInformationNotFeedback(shipper_Id);
                    header.add("ID");
                    header.add("Shipper Name");
                    header.add("Order_ID");
                    header.add("Order Name");
                    header.add("Order Price");
                    header.add("Order Creation Date");
                    header.add("Actual Delivery Date");
                    defaultTableModel.setDataVector(data, header);
                    ShipperTable.setModel(defaultTableModel);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Form_Search.this, "Không có thông tin vui lòng tìm kiếm shipper để xem thêm");
        }
    }//GEN-LAST:event_DeliveredPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeliveredPanel;
    private javax.swing.JPanel DeliveringPanel;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JTable ShipperTable;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbDeliveredNum;
    private javax.swing.JLabel jlbDeliveringNum;
    // End of variables declaration//GEN-END:variables
}
