/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyDiem extends javax.swing.JFrame {

    ArrayList<Student> list = new ArrayList<>();
    DefaultTableModel model;
    Connection con = Connect.Connect();
    int vitri;

    /**
     * Creates new form QuanLyDiem
     */
    public QuanLyDiem() {
        initComponents();
        setLocationRelativeTo(null);

        loadtable();
        top3();

        Table.setModel(model);

    }

    public void diemtb() {
        Student sv = new Student();
        sv.getDiemtb();

    }

    public void Display(int i) {
        Student sv = list.get(i);
        lbHoten.setText(sv.hoten);
        lbDiemtb.setText(String.valueOf(sv.Diemtb));
        tfMasv.setText(sv.masv);
        tfTienganh.setText(String.valueOf(sv.tienganh));
        tfGDTC.setText(String.valueOf(sv.GDTC));
        tfTinhoc.setText(String.valueOf(sv.tinhoc));
        lbDiemtb.setText(String.valueOf(sv.getDiemtb()));
    }

    public void loadtable() {

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select hoten,Students.masv,tienganh,tinhoc,gdtc from Grade join students on grade.masv=students.masv");
            while (rs.next()) {
                Vector row = new Vector();
                float tienganh = rs.getFloat(3);
                float tinhoc = rs.getFloat(4);
                float gdtc = rs.getFloat(5);
                float Diemtb = Math.round(((tienganh + tinhoc + gdtc) / 3) * 100) / 100;
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(tienganh);
                row.add(tinhoc);
                row.add(gdtc);
                row.add(Diemtb);
                list.add(new Student(rs.getString(1), rs.getString(2), tienganh, tinhoc, gdtc, Diemtb));

//                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e);
        }
    }

    public DefaultTableModel top3() {
        String head[] = {"Mã Sinh viên", "Họ tên", "Tiếng anh", "Tin học", "GDTC", "Điểm tb"};
        model = new DefaultTableModel(head, 0);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select top 3 Students.masv, hoten , tienganh, tinhoc,gdtc, sum((tienganh+tinhoc+gdtc)/3) as diemtb from grade join students on grade.masv=students.masv group by Students.masv, hoten,tienganh,tinhoc,gdtc order by diemtb desc");
            while (rs.next()) {
                Vector row = new Vector();
                float tienganh = rs.getFloat(3);
                float tinhoc = rs.getFloat(4);
                float gdtc = rs.getFloat(5);
                float Diemtb = Math.round(((tienganh + tinhoc + gdtc) / 3) * 100) / 100;
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(tienganh);
                row.add(tinhoc);
                row.add(gdtc);
                row.add(Diemtb);

                model.addRow(row);

            }
        } catch (Exception e) {
            System.out.println("Loi: " + e);
        }
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbHoten = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfMasv = new javax.swing.JTextField();
        tfTienganh = new javax.swing.JTextField();
        tfTinhoc = new javax.swing.JTextField();
        tfGDTC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lbDiemtb = new javax.swing.JLabel();
        btnDau = new javax.swing.JButton();
        btnTruoc = new javax.swing.JButton();
        btnSau = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ma SV:");

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnTimkiem.setText("Search");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimkiem)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTimkiem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Ho ten: ");

        lbHoten.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                lbHotenAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setText("Ma SV:");

        jLabel5.setText("Tieng anh: ");

        jLabel6.setText("Tin hoc:");

        jLabel7.setText("Giao duc tc:");

        jLabel8.setText("Diem TB:");

        lbDiemtb.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbDiemtb.setText("0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfMasv, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(tfTienganh)
                            .addComponent(tfTinhoc)
                            .addComponent(tfGDTC))
                        .addGap(100, 100, 100)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMasv, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTienganh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lbDiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnDau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dautien.png"))); // NOI18N
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sau.png"))); // NOI18N
        btnTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocActionPerformed(evt);
            }
        });

        btnSau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/truoc.png"))); // NOI18N
        btnSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauActionPerformed(evt);
            }
        });

        btnCuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cuoicung.png"))); // NOI18N
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Quan Ly Diem Sinh Vien");

        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText("3 sinh vien co diem cao nhat:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnDau)
                        .addGap(18, 18, 18)
                        .addComponent(btnSau)
                        .addGap(18, 18, 18)
                        .addComponent(btnTruoc)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(400, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSau, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Tim kiem");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbHotenAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbHotenAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbHotenAncestorMoved

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed

        String tim=tfTimkiem.getText();
        for(Student sv:list){
            if(sv.getMasv().equalsIgnoreCase(tim)){
                JOptionPane.showMessageDialog(null, "Da tim thay sinh vien"+tfTimkiem.getText());
                Display(list.indexOf(sv));
                break;
            }
            else{
                JOptionPane.showMessageDialog(null, "Khong tim thay");
                break;
            }
        }


    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (tfMasv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sinh viên");
            tfMasv.requestFocus();
        } else if (tfTienganh.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập điểm tiếng anh");
            tfTienganh.requestFocus();
        } else if (tfTinhoc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập điểm Tin học");
            tfTinhoc.requestFocus();
        } else if (tfGDTC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập điểm GDTC");
            tfGDTC.requestFocus();
        } else {
            save();
        }


    }//GEN-LAST:event_btnSaveActionPerformed
    public void save() {
        PreparedStatement pr;
        try {
            pr = con.prepareStatement("Insert into grade values(?,?, ?, ?)");
            pr.setString(1, tfMasv.getText());
            pr.setFloat(2, Float.valueOf(tfTienganh.getText()));
            pr.setFloat(3, Float.valueOf(tfTinhoc.getText()));
            pr.setFloat(4, Float.valueOf(tfGDTC.getText()));

            int rs = pr.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Them diem thanh cong");
                Table.setModel(top3());
            } else {
                JOptionPane.showMessageDialog(null, "Them diem khong thanh cong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu");
        }
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        tfGDTC.setText("");
        tfMasv.setText("");
        tfTienganh.setText("");
        tfTimkiem.setText("");
        tfTinhoc.setText("");
        lbDiemtb.setText("0.0");
        lbHoten.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            PreparedStatement pr = con.prepareStatement("Delete grade where masv=?");
            pr.setString(1, tfMasv.getText());
            int rs = pr.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công");
                Table.setModel(top3());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy mã sinh viên");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:

        int row = Table.getSelectedRow();
        tfMasv.setText(Table.getValueAt(row, 1).toString());
        lbHoten.setText(Table.getValueAt(row, 0).toString());
        tfTienganh.setText(Table.getValueAt(row, 2).toString());
        tfTinhoc.setText(Table.getValueAt(row, 3).toString());
        tfGDTC.setText(Table.getValueAt(row, 4).toString());
        lbDiemtb.setText(Table.getValueAt(row, 5).toString());


    }//GEN-LAST:event_TableMouseClicked

    private void btnTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocActionPerformed

        vitri++;
        if (vitri >= list.size()) {
            JOptionPane.showMessageDialog(null, "Dang o cuoi");
            return;
        }
        Display(vitri);

    }//GEN-LAST:event_btnTruocActionPerformed

    private void btnSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauActionPerformed

        vitri--;

        if (vitri == 0) {
            JOptionPane.showMessageDialog(null, "Dang o dau");
            return;
        }
        Display(vitri);
    }//GEN-LAST:event_btnSauActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:

        vitri = 0;
        Display(vitri);
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:

        vitri = list.size() - 1;
        Display(vitri);
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            PreparedStatement pr = con.prepareStatement("update grade set Tienganh=?, tinhoc=?, gdtc=? where Masv=?");
            pr.setFloat(1, Float.valueOf(tfTienganh.getText()));
            pr.setFloat(2, Float.valueOf(tfTinhoc.getText()));
            pr.setFloat(3, Float.valueOf(tfGDTC.getText()));
            pr.setString(4, tfMasv.getText());
            int rs = pr.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Update thanh cong");
                Table.setModel(top3());

            } else {
                JOptionPane.showMessageDialog(null, "Loi update");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi update" + e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    public boolean timkiem() {
        boolean test;
        
        ResultSet rs;
        try {
            PreparedStatement pr = con.prepareStatement("Select hoten,Students.masv,tienganh,tinhoc,gdtc from grade join students on grade.masv=students.masv where Students.Masv=?");
            pr.setString(1, tfTimkiem.getText());
            test = true;

            rs = pr.executeQuery();
            while (rs.next()) {
                float tienganh = rs.getFloat(3);
                float tinhoc = rs.getFloat(4);
                float gdtc = rs.getFloat(5);
                float tb = Math.round(((tienganh + tinhoc + gdtc) / 3) * 100) / 100;
                lbHoten.setText(rs.getString(1));
                tfMasv.setText(rs.getString(2));
                tfTienganh.setText(String.valueOf(tienganh));
                tfTinhoc.setText(String.valueOf(tinhoc));
                tfGDTC.setText(String.valueOf(gdtc));
                lbDiemtb.setText(String.valueOf(tb));
                if (test == true) {
                    JOptionPane.showMessageDialog(null, "Da tim thay sinh vien " + tfTimkiem.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Khong tim thay sinh vien " + tfTimkiem.getText());
                }

            }

        } catch (Exception e) {
            System.out.println("Loi:" + e);
            test = false;
        }
        return test;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSau;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnTruoc;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiemtb;
    private javax.swing.JLabel lbHoten;
    private javax.swing.JTextField tfGDTC;
    private javax.swing.JTextField tfMasv;
    private javax.swing.JTextField tfTienganh;
    private javax.swing.JTextField tfTimkiem;
    private javax.swing.JTextField tfTinhoc;
    // End of variables declaration//GEN-END:variables

}
