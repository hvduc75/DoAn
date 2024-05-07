package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import java.time.LocalDate;
import javax.swing.SpinnerNumberModel;

public class TestPanel extends javax.swing.JPanel {

    public TestPanel(Main testInstance) {

        initComponents();
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        ngay.setValue(day);
        thang.setValue(month);
        nam.setValue(year);
        SpinnerNumberModel model = (SpinnerNumberModel) nam.getModel();
        model.setMaximum(year);
        model.setMinimum(1900);
        SpinnerNumberModel model1 = (SpinnerNumberModel) thang.getModel();
        model1.setMaximum(month);
        model1.setMaximum(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ngay = new javax.swing.JSpinner();
        thang = new javax.swing.JSpinner();
        nam = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        ngay.setModel(new javax.swing.SpinnerNumberModel());

        thang.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thangStateChanged(evt);
            }
        });

        jButton1.setText("check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(jButton1)
                .addContainerGap(275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void thangStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thangStateChanged
        int month = Integer.valueOf(String.valueOf(thang.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            // Đặt giá trị tối đa cho JSpinner
            SpinnerNumberModel model = (SpinnerNumberModel) ngay.getModel();
            model.setMaximum(31);
//            model.setValue(31);
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // Đặt giá trị tối đa cho JSpinner
            SpinnerNumberModel model = (SpinnerNumberModel) ngay.getModel();
            model.setMaximum(30);
//            model.setValue(30);
        } else {
            // Tháng 2 - xem xét năm nhuận
            SpinnerNumberModel model = (SpinnerNumberModel) ngay.getModel();
            int nam1 = Integer.valueOf(String.valueOf(nam.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                model.setMaximum(29); // Năm nhuận
//                model.setValue(29);
            } else {
                model.setMaximum(28); // Năm không nhuận
//                model.setValue(28);
            }
        }
    }//GEN-LAST:event_thangStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("" + ngay.getValue() + "/" + thang.getValue() + "/" + nam.getValue());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JSpinner nam;
    private javax.swing.JSpinner ngay;
    private javax.swing.JSpinner thang;
    // End of variables declaration//GEN-END:variables
}
