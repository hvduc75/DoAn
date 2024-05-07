package IT4.DoAn.Form;

import IT4.DoAn.Service.StatisticalService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Form_Statistical extends javax.swing.JPanel {

    StatisticalService statisticalService;
    DefaultTableModel defaultTableModel;
    
    public Form_Statistical() {
        initComponents();
        statisticalService = new StatisticalService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        monthComboBox.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatisticalTable = new javax.swing.JTable();
        monthComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh Thu Của Shipper");

        StatisticalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        StatisticalTable.setRowHeight(30);
        jScrollPane1.setViewportView(StatisticalTable);

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Theo Tháng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        int month = Integer.valueOf(String.valueOf(monthComboBox.getSelectedItem()));
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime roundedDateTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
        java.sql.Timestamp currentTimestamp = Timestamp.valueOf(roundedDateTime);
        int year = currentTime.getYear();
        System.out.println("Năm: " + year);
        String startOfMonth = year + "-" + String.format("%02d", month) + "-01 00:00:00.0";
        String endOfMonth = "";
        if(month == 12) {
            month = 01;
            year = year + 1;
            endOfMonth = year + "-" + String.format("%02d", month) +  "-01 00:00:00.0";
        } else {
            endOfMonth = year + "-" + String.format("%02d", month+1) +  "-01 00:00:00.0";
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
        StatisticalTable.setModel(defaultTableModel);
    }//GEN-LAST:event_monthComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StatisticalTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> monthComboBox;
    // End of variables declaration//GEN-END:variables
}
