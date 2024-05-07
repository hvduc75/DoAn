package IT4.DoAn.Component;

import IT4.DoAn.Event.EventMenuSelected;
import IT4.DoAn.Model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {
    
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }

    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Trang Chủ", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "Thống Kê", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Xem Thùng Hàng", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("4", "Tạo Thùng Hàng", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "Quản Lý Shipper", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("6", "Quản Lý Đơn Hàng", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
               
        listMenu1.addItem(new Model_Menu("", " My Data", Model_Menu.MenuType.TITLE));
        
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("7", "Test", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("8", "Trợ Giúp", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("9", "Giới Thiệu", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("10", "Đăng Xuất", Model_Menu.MenuType.MENU));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        listMenu1 = new IT4.DoAn.Swing.ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IT4/DoAn/Icon/logo.png"))); // NOI18N
        jLabel1.setText("  Nhóm12");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    
    private int x;
    private int y;
    
    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private IT4.DoAn.Swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
