package IT4.DoAn.Form;

import IT4.DoAn.Main.Main;
import IT4.DoAn.Model.Shipper;
import IT4.DoAn.Service.ShipperService;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SpinnerNumberModel;

public class AddShipper extends javax.swing.JFrame {

    private final String PHONE_PATTERN = "^84\\d{9}$";
    private final Pattern pattern_phone = Pattern.compile(PHONE_PATTERN);
    private final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);

    ShipperService shipperservice;
    private Main testInstance;
    private boolean isLegal = true;

    public AddShipper(Main testInstance) {
        this.testInstance = testInstance;
        shipperservice = new ShipperService();
        initComponents();
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        Ngay1.setValue(day);
        Thang1.setValue(month);
        Nam1.setValue(year);
        Ngay2.setValue(day);
        Thang2.setValue(month);
        Nam2.setValue(year);
        SpinnerNumberModel model = (SpinnerNumberModel) Nam1.getModel();
        model.setMaximum(year);
    }

    public boolean validate_phone(String phoneNumber) {
        Matcher matcher = pattern_phone.matcher(phoneNumber);
        return matcher.find();
    }

    public boolean validate_email(String email) {
        Matcher matcher = pattern_email.matcher(email);
        return matcher.find();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        jlbMSG = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NameTextField = new javax.swing.JTextField();
        Thang1 = new javax.swing.JSpinner();
        Phone = new javax.swing.JTextField();
        Thang2 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        Nam2 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        FemaleRadioButton = new javax.swing.JRadioButton();
        MaleRadioButton = new javax.swing.JRadioButton();
        Nam1 = new javax.swing.JSpinner();
        Ngay2 = new javax.swing.JSpinner();
        Ngay1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnInsert.setBackground(new java.awt.Color(255, 0, 0));
        btnInsert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("INSERT");
        btnInsert.setBorderPainted(false);
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.setFocusPainted(false);
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });

        jlbMSG.setForeground(new java.awt.Color(255, 0, 0));
        jlbMSG.setText("--------");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Shipper", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Thang1.setModel(new javax.swing.SpinnerNumberModel(12, 0, 12, 1));
        Thang1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Thang1StateChanged(evt);
            }
        });

        Thang2.setModel(new javax.swing.SpinnerNumberModel(12, 0, 12, 1));
        Thang2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Thang2StateChanged(evt);
            }
        });

        jLabel5.setText("Giới Tính");

        Nam2.setModel(new javax.swing.SpinnerNumberModel(2024, 0, 2024, 1));
        Nam2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Nam2StateChanged(evt);
            }
        });

        jLabel7.setText("Số ĐT");

        FemaleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(FemaleRadioButton);
        FemaleRadioButton.setText("Female");

        MaleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(MaleRadioButton);
        MaleRadioButton.setText("Male");

        Nam1.setModel(new javax.swing.SpinnerNumberModel(2024, 0, 2024, 1));
        Nam1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Nam1StateChanged(evt);
            }
        });

        Ngay2.setModel(new javax.swing.SpinnerNumberModel(31, 0, 31, 1));
        Ngay2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Ngay2StateChanged(evt);
            }
        });

        Ngay1.setModel(new javax.swing.SpinnerNumberModel(31, 0, 31, 1));
        Ngay1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Ngay1StateChanged(evt);
            }
        });

        jLabel6.setText("Ngày Vào Làm");

        jLabel3.setText("Ngày Sinh");

        jLabel2.setText("Tên Shipper");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(MaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FemaleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(Ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Thang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(NameTextField))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Ngay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Thang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Phone))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thang1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(MaleRadioButton)
                    .addComponent(FemaleRadioButton))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Ngay2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thang2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Mô Tả");

        jLabel9.setText("Địa Chỉ");

        jLabel8.setText("Email");

        Description.setColumns(20);
        Description.setRows(5);
        jScrollPane1.setViewportView(Description);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Email)
                    .addComponent(Address)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbMSG, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(jlbMSG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        if (isLegal) {
            Shipper shipper = new Shipper();
            shipper.setName(NameTextField.getText());
            String birthDay = "";
            birthDay += Ngay1.getValue() + "-" + Thang1.getValue() + "-" + Nam1.getValue();
            shipper.setBirthDay(birthDay);
            String gender = "";
            if (MaleRadioButton.isSelected()) {
                gender = "Male";
            }
            if (FemaleRadioButton.isSelected()) {
                gender = "Female";
            }
            shipper.setGender(gender);
            String startWork = "";
            startWork += Ngay2.getValue() + "-" + Thang2.getValue() + "-" + Nam2.getValue();
            shipper.setStartWork(startWork);
            shipper.setPhone(Phone.getText());
            shipper.setEmail(Email.getText());
            shipper.setAddress(Address.getText());
            shipper.setDescription(Description.getText());
            if (NameTextField.getText().isEmpty() || Phone.getText().isEmpty()
                    || Email.getText().isEmpty() || startWork.equals("") || birthDay.equals("")
                    || (MaleRadioButton.isSelected() == false && FemaleRadioButton.isSelected() == false) || Address.getText().isEmpty()
                    || Description.getText().isEmpty()) {
                jlbMSG.setText("Vui lòng nhập đầy đủ thông tin !");
            } else {
                LocalDate currentDate = LocalDate.now();
                int year = (int) Nam1.getValue();
                int month = (int) Thang1.getValue();
                int day = (int) Ngay1.getValue();
                int year1 = (int) Nam2.getValue();
                int month1 = (int) Thang2.getValue();
                int day1 = (int) Ngay2.getValue();
                LocalDate selectedDate = LocalDate.of(year, month, day);
                LocalDate selectedDate1 = LocalDate.of(year1, month1, day1);
                if (selectedDate.isAfter(currentDate) || selectedDate1.isAfter(currentDate)) {
                    if (selectedDate.isAfter(currentDate)) {
                        jlbMSG.setText("Ngày sinh không hợp lệ");
                        return;
                    }
                    if (selectedDate1.isAfter(currentDate)) {
                        jlbMSG.setText("Ngày vào làm không hợp lệ");
                        return;
                    }
                } else {
                    if (validate_phone(Phone.getText()) && validate_email(Email.getText())) {
                        shipper.setPhone(Phone.getText());
                        shipper.setEmail(Email.getText());
                        shipperservice.AddShipper(shipper);
                        testInstance.setForm(new Form_Shipper(testInstance));
                        repaint();
                        this.dispose();
                    } else {
                        if (!validate_phone(Phone.getText())) {
                            jlbMSG.setText("Số điện thoại không hợp lệ VD: +84123456789.");
                        } else if (!validate_email(Email.getText())) {
                            jlbMSG.setText("Email không hợp lệ VD: user123@example.com.");
                        } else {
                            jlbMSG.setText("Số điện thoại và email không hợp lệ.");
                        }
                    }
                }

            }
        }
    }//GEN-LAST:event_btnInsertMouseClicked

    private void Thang1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Thang1StateChanged
        int month = Integer.valueOf(String.valueOf(Thang1.getValue()));
        int dayJSP = Integer.valueOf(String.valueOf(Ngay1.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            isLegal = true;
            jlbMSG.setText("");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (dayJSP == 31) {
                jlbMSG.setText("Tháng " + month + " chỉ có tối đa 30 ngày");
                isLegal = false;
            }
        } else {
            int nam1 = Integer.valueOf(String.valueOf(Nam1.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                if (dayJSP == 31 || dayJSP == 30) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 29 ngày");
                    isLegal = false;
                }
            } else {
                if (dayJSP == 31 || dayJSP == 30 || dayJSP == 29) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 28 ngày");
                    isLegal = false;
                }
            }
        }
    }//GEN-LAST:event_Thang1StateChanged

    private void Ngay1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Ngay1StateChanged
        int month = Integer.valueOf(String.valueOf(Thang1.getValue()));
        int dayJSP = Integer.valueOf(String.valueOf(Ngay1.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            isLegal = true;
            jlbMSG.setText("");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (dayJSP == 31) {
                jlbMSG.setText("Tháng " + month + " chỉ có tối đa 30 ngày");
                isLegal = false;
            } else {
                isLegal = true;
                jlbMSG.setText("");
            }
        } else {
            int nam1 = Integer.valueOf(String.valueOf(Nam1.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                if (dayJSP == 31 || dayJSP == 30) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 29 ngày");
                    isLegal = false;
                } else {
                    isLegal = true;
                    jlbMSG.setText("");
                }
            } else {
                if (dayJSP == 31 || dayJSP == 30 || dayJSP == 29) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 28 ngày");
                    isLegal = false;
                } else {
                    isLegal = true;
                    jlbMSG.setText("");
                }
            }
        }
    }//GEN-LAST:event_Ngay1StateChanged

    private void Thang2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Thang2StateChanged
        int month = Integer.valueOf(String.valueOf(Thang2.getValue()));
        int dayJSP = Integer.valueOf(String.valueOf(Ngay2.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            isLegal = true;
            jlbMSG.setText("");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (dayJSP == 31) {
                jlbMSG.setText("Tháng " + month + " chỉ có tối đa 30 ngày");
                isLegal = false;
            }
        } else {
            int nam1 = Integer.valueOf(String.valueOf(Nam2.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                if (dayJSP == 31 || dayJSP == 30) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 29 ngày");
                    isLegal = false;
                }
            } else {
                if (dayJSP == 31 || dayJSP == 30 || dayJSP == 29) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 28 ngày");
                    isLegal = false;
                }
            }
        }
    }//GEN-LAST:event_Thang2StateChanged

    private void Ngay2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Ngay2StateChanged
        int month = Integer.valueOf(String.valueOf(Thang2.getValue()));
        int dayJSP = Integer.valueOf(String.valueOf(Ngay2.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            isLegal = true;
            jlbMSG.setText("");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (dayJSP == 31) {
                jlbMSG.setText("Tháng " + month + " chỉ có tối đa 30 ngày");
                isLegal = false;
            } else {
                isLegal = true;
                jlbMSG.setText("");
            }
        } else {
            int nam1 = Integer.valueOf(String.valueOf(Nam2.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                if (dayJSP == 31 || dayJSP == 30) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 29 ngày");
                    isLegal = false;
                } else {
                    isLegal = true;
                    jlbMSG.setText("");
                }
            } else {
                if (dayJSP == 31 || dayJSP == 30 || dayJSP == 29) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 28 ngày");
                    isLegal = false;
                } else {
                    isLegal = true;
                    jlbMSG.setText("");
                }
            }
        }
    }//GEN-LAST:event_Ngay2StateChanged

    private void Nam1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Nam1StateChanged
        int month = Integer.valueOf(String.valueOf(Thang1.getValue()));
        int dayJSP = Integer.valueOf(String.valueOf(Ngay1.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            isLegal = true;
            jlbMSG.setText("");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (dayJSP == 31) {
                jlbMSG.setText("Tháng " + month + " chỉ có tối đa 30 ngày");
                isLegal = false;
            }
        } else {
            int nam1 = Integer.valueOf(String.valueOf(Nam1.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                if (dayJSP == 31 || dayJSP == 30) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 29 ngày");
                    isLegal = false;
                }
            } else {
                if (dayJSP == 31 || dayJSP == 30 || dayJSP == 29) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 28 ngày");
                    isLegal = false;
                }
            }
        }
    }//GEN-LAST:event_Nam1StateChanged

    private void Nam2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Nam2StateChanged
        int month = Integer.valueOf(String.valueOf(Thang2.getValue()));
        int dayJSP = Integer.valueOf(String.valueOf(Ngay2.getValue()));
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            isLegal = true;
            jlbMSG.setText("");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (dayJSP == 31) {
                jlbMSG.setText("Tháng " + month + " chỉ có tối đa 30 ngày");
                isLegal = false;
            }
        } else {
            int nam1 = Integer.valueOf(String.valueOf(Nam2.getValue()));
            if (nam1 % 400 == 0 || (nam1 % 4 == 0 && nam1 % 100 != 0)) {
                if (dayJSP == 31 || dayJSP == 30) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 29 ngày");
                    isLegal = false;
                }
            } else {
                if (dayJSP == 31 || dayJSP == 30 || dayJSP == 29) {
                    jlbMSG.setText("Tháng " + month + "/" + nam1 + " chỉ có tối đa 28 ngày");
                    isLegal = false;
                }
            }
        }

    }//GEN-LAST:event_Nam2StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JTextArea Description;
    private javax.swing.JTextField Email;
    private javax.swing.JRadioButton FemaleRadioButton;
    private javax.swing.JRadioButton MaleRadioButton;
    private javax.swing.JSpinner Nam1;
    private javax.swing.JSpinner Nam2;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JSpinner Ngay1;
    private javax.swing.JSpinner Ngay2;
    private javax.swing.JTextField Phone;
    private javax.swing.JSpinner Thang1;
    private javax.swing.JSpinner Thang2;
    private javax.swing.JButton btnInsert;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbMSG;
    // End of variables declaration//GEN-END:variables
}
