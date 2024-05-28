package IT4.DoAn.Form;

import IT4.DoAn.Model.Order;
import IT4.DoAn.Service.StatisticalService;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Form_Statistical extends javax.swing.JPanel {

    StatisticalService statisticalService;
    DefaultTableModel defaultTableModel;

    public Form_Statistical() {
        initComponents();
        this.statisticalService = new StatisticalService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        MonthRevenue.setValue(month);
        YearRevenue.setValue(year);
        MonthDelivered.setValue(month);
        YearDelivered.setValue(year);
        MonthDelivering.setValue(month);
        YearDelivering.setValue(year);
        ShowTable();
    }
    
    private void ShowTable() {
        StatisticalService statisticalService = new StatisticalService();
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        int month = Integer.valueOf(String.valueOf(MonthRevenue.getValue()));
        int year = Integer.valueOf(String.valueOf(YearRevenue.getValue()));
        String startOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        String endOfMonth = "";
        if (month == 12) {
            month = 01;
            year = year + 1;
            endOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        } else {
            endOfMonth = year + "-" + String.format("%02d", month + 1) + "-01 00:00:00.0";
        }
        Timestamp before = Timestamp.valueOf(startOfMonth);
        Timestamp after = Timestamp.valueOf(endOfMonth);

        Vector<String> header = new Vector<>();
        Vector<Vector<String>> data = statisticalService.getAllStatisticalShipper(before, after);
        header.add("Shipper_ID");
        header.add("Shipper Name");
        header.add("Number Order");
        header.add("Total Price");
        defaultTableModel.setDataVector(data, header);
        RevenueTable.setModel(defaultTableModel);
        RevenueLabel.setText("           Doanh Thu Của Tất Cả Các Shipper Trong Tháng " + MonthRevenue.getValue());
    }

    private void ShowTableDelivering() {
        defaultTableModel.setColumnCount(0);
        defaultTableModel.setRowCount(0);
        int month = Integer.valueOf(String.valueOf(MonthDelivering.getValue()));
        int year = Integer.valueOf(String.valueOf(YearDelivering.getValue()));
        String startOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        String endOfMonth = "";
        if (month == 12) {
            month = 01;
            year = year + 1;
            endOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        } else {
            endOfMonth = year + "-" + String.format("%02d", month + 1) + "-01 00:00:00.0";
        }
        Timestamp before = Timestamp.valueOf(startOfMonth);
        Timestamp after = Timestamp.valueOf(endOfMonth);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên đơn hàng");
        defaultTableModel.addColumn("Điểm nhận hàng");
        defaultTableModel.addColumn("Điểm giao hàng");
        defaultTableModel.addColumn("Mô tả");
        defaultTableModel.addColumn("Khoảng cách");
        defaultTableModel.addColumn("Giá trị");
        defaultTableModel.addColumn("Tên khách hàng");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Ngày đặt");
        defaultTableModel.addColumn("Ngày dự kiến");
        DeliveringTable.setModel(defaultTableModel);
        setTableData(statisticalService.getAllOrderDeliveringByMonth(before, after));
        NumDelivering.setText("         Số Lượng Đơn Hàng Đang Giao Trong Tháng " + MonthDelivering.getValue() + " Là " + DeliveringTable.getRowCount() + " Đơn");
    }

    private void setTableData(List<Order> orders) {
        for (Order order : orders) {
            String price = order.getPrice() + "00đ";
            String distance = order.getDistance() + "km";
            defaultTableModel.addRow(new Object[]{order.getId(), order.getName(),
                order.getReceive_Location(), order.getDelivery_Location(), order.getFeedback(),
                distance, price, order.getUser_name(), order.getUser_phone(), order.getDate_Create(), order.getDelivery_Expected()});
        }
    }

    private void ShowTableDelivered() {
        defaultTableModel.setColumnCount(0);
        defaultTableModel.setRowCount(0);
        int month = Integer.valueOf(String.valueOf(MonthDelivered.getValue()));
        int year = Integer.valueOf(String.valueOf(YearDelivered.getValue()));
        String startOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        String endOfMonth = "";
        if (month == 12) {
            month = 01;
            year = year + 1;
            endOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        } else {
            endOfMonth = year + "-" + String.format("%02d", month + 1) + "-01 00:00:00.0";
        }
        Timestamp before = Timestamp.valueOf(startOfMonth);
        Timestamp after = Timestamp.valueOf(endOfMonth);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên đơn hàng");
        defaultTableModel.addColumn("Điểm nhận hàng");
        defaultTableModel.addColumn("Điểm giao hàng");
        defaultTableModel.addColumn("Mô tả");
        defaultTableModel.addColumn("Khoảng cách");
        defaultTableModel.addColumn("Giá trị");
        defaultTableModel.addColumn("Tên khách hàng");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Ngày đặt");
        defaultTableModel.addColumn("Ngày Thực Tế");
        DeliveredTable.setModel(defaultTableModel);
        setTableData(statisticalService.getAllOrderDeliveredByMonth(before, after));
        NumDelivered.setText("         Số Lượng Đơn Hàng Đã Giao Trong Tháng " + MonthDelivered.getValue() + " Là " + DeliveredTable.getRowCount() + " Đơn");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DemoTabbedPane = new javax.swing.JTabbedPane();
        Revenue = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        RevenueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MonthRevenue = new javax.swing.JSpinner();
        YearRevenue = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        RevenueTable = new javax.swing.JTable();
        DeliveredOrder = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        NumDelivered = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MonthDelivered = new javax.swing.JSpinner();
        YearDelivered = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        DeliveredTable = new javax.swing.JTable();
        DeliveringOrder = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        NumDelivering = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MonthDelivering = new javax.swing.JSpinner();
        YearDelivering = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        DeliveringTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        DemoTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        DemoTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DemoTabbedPaneStateChanged(evt);
            }
        });

        Revenue.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        RevenueLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RevenueLabel.setText("                Doanh Thu Của Shipper");

        jLabel2.setText("Theo Tháng");

        MonthRevenue.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        MonthRevenue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MonthRevenueStateChanged(evt);
            }
        });

        YearRevenue.setModel(new javax.swing.SpinnerNumberModel(1000, 1000, 3000, 1));
        YearRevenue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                YearRevenueStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MonthRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(YearRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RevenueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(YearRevenue)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RevenueLabel)
                            .addComponent(jLabel2))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(MonthRevenue))
                .addContainerGap())
        );

        RevenueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        RevenueTable.setRowHeight(30);
        jScrollPane1.setViewportView(RevenueTable);

        javax.swing.GroupLayout RevenueLayout = new javax.swing.GroupLayout(Revenue);
        Revenue.setLayout(RevenueLayout);
        RevenueLayout.setHorizontalGroup(
            RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        RevenueLayout.setVerticalGroup(
            RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenueLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        DemoTabbedPane.addTab("Doanh Thu Của Shipper", Revenue);

        DeliveredOrder.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        NumDelivered.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NumDelivered.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NumDelivered.setText("TEST");

        jLabel6.setText("Theo Tháng");

        MonthDelivered.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        MonthDelivered.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MonthDeliveredStateChanged(evt);
            }
        });

        YearDelivered.setModel(new javax.swing.SpinnerNumberModel(1000, 1000, 3000, 1));
        YearDelivered.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                YearDeliveredStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MonthDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(YearDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(YearDelivered)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumDelivered)
                            .addComponent(jLabel6))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(MonthDelivered))
                .addContainerGap())
        );

        DeliveredTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DeliveredTable.setRowHeight(30);
        jScrollPane3.setViewportView(DeliveredTable);

        javax.swing.GroupLayout DeliveredOrderLayout = new javax.swing.GroupLayout(DeliveredOrder);
        DeliveredOrder.setLayout(DeliveredOrderLayout);
        DeliveredOrderLayout.setHorizontalGroup(
            DeliveredOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveredOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        DeliveredOrderLayout.setVerticalGroup(
            DeliveredOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveredOrderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        DemoTabbedPane.addTab("Danh Sách Đơn Hàng Đã Giao", DeliveredOrder);

        DeliveringOrder.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        NumDelivering.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NumDelivering.setText("TEST");

        jLabel8.setText("Theo Tháng");

        MonthDelivering.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        MonthDelivering.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MonthDeliveringStateChanged(evt);
            }
        });

        YearDelivering.setModel(new javax.swing.SpinnerNumberModel(1000, 1000, 3000, 1));
        YearDelivering.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                YearDeliveringStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MonthDelivering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(YearDelivering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NumDelivering, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(YearDelivering)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumDelivering)
                            .addComponent(jLabel8))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(MonthDelivering))
                .addContainerGap())
        );

        DeliveringTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DeliveringTable.setRowHeight(30);
        jScrollPane4.setViewportView(DeliveringTable);

        javax.swing.GroupLayout DeliveringOrderLayout = new javax.swing.GroupLayout(DeliveringOrder);
        DeliveringOrder.setLayout(DeliveringOrderLayout);
        DeliveringOrderLayout.setHorizontalGroup(
            DeliveringOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveringOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        DeliveringOrderLayout.setVerticalGroup(
            DeliveringOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeliveringOrderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        DemoTabbedPane.addTab("Danh Sách Đơn Hàng Đang Giao", DeliveringOrder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DemoTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DemoTabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void YearDeliveringStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_YearDeliveringStateChanged
        ShowTableDelivering();
    }//GEN-LAST:event_YearDeliveringStateChanged

    private void MonthDeliveringStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MonthDeliveringStateChanged
        ShowTableDelivering();
    }//GEN-LAST:event_MonthDeliveringStateChanged

    private void YearDeliveredStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_YearDeliveredStateChanged
        ShowTableDelivered();
    }//GEN-LAST:event_YearDeliveredStateChanged

    private void MonthDeliveredStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MonthDeliveredStateChanged
        ShowTableDelivered();
    }//GEN-LAST:event_MonthDeliveredStateChanged

    private void YearRevenueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_YearRevenueStateChanged
        ShowTable();
    }//GEN-LAST:event_YearRevenueStateChanged

    private void MonthRevenueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MonthRevenueStateChanged
        ShowTable();
    }//GEN-LAST:event_MonthRevenueStateChanged

    private void DemoTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DemoTabbedPaneStateChanged
        int index = DemoTabbedPane.getSelectedIndex();
        if (index == 0) {
            ShowTable();
        }
        if (index == 1) {
            ShowTableDelivered();
        }
        if (index == 2) {
            ShowTableDelivering();
        }
    }//GEN-LAST:event_DemoTabbedPaneStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeliveredOrder;
    private javax.swing.JTable DeliveredTable;
    private javax.swing.JPanel DeliveringOrder;
    private javax.swing.JTable DeliveringTable;
    private javax.swing.JTabbedPane DemoTabbedPane;
    private javax.swing.JSpinner MonthDelivered;
    private javax.swing.JSpinner MonthDelivering;
    private javax.swing.JSpinner MonthRevenue;
    private javax.swing.JLabel NumDelivered;
    private javax.swing.JLabel NumDelivering;
    private javax.swing.JPanel Revenue;
    private javax.swing.JLabel RevenueLabel;
    private javax.swing.JTable RevenueTable;
    private javax.swing.JSpinner YearDelivered;
    private javax.swing.JSpinner YearDelivering;
    private javax.swing.JSpinner YearRevenue;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
