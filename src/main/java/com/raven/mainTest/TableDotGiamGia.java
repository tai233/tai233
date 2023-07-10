package com.raven.mainTest;

import com.raven.domainModel.DotGiamGia;
import com.raven.service.DotGiamGiaService;
import com.raven.serviceImpl.DotGiamGiaServiceImpl;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TableDotGiamGia extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DotGiamGiaService dotGiamGiaService = new DotGiamGiaServiceImpl();

    public TableDotGiamGia() {
        initComponents();
        LoadTableDotGiamGia((ArrayList<DotGiamGia>) dotGiamGiaService.getAll());

    }

    private void LoadTableDotGiamGia(ArrayList<DotGiamGia> listDotGiamGia) {
        defaultTableModel = (DefaultTableModel) table_DGG.getModel();

        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "Mã GIAM GIÁ", "TÊN ĐỢT GIẢM GIÁ", "NGÀY BẮT ĐẦU",
            "NGÀY KẾT THÚC", "GIÁ MIN", "GIÁ MAX", "PHẦN TRĂM GIẢM GIÁ", "TRANG THÁI",});

        defaultTableModel.setRowCount(0);
        for (DotGiamGia dotGiamGia : listDotGiamGia) {
            System.out.println("111" + dotGiamGia.getTrangThai());
            if (dotGiamGia.getTrangThai() == 1) {
                defaultTableModel.addRow(new Object[]{
                    dotGiamGia.getId(),
                    dotGiamGia.getMaGiamGia(),
                    dotGiamGia.getTenDotGiamGia(),
                    dotGiamGia.getNgayBatDau(),
                    dotGiamGia.getNgayKetThuc(),
                    dotGiamGia.getGiaTriNhoNhat(),
                    dotGiamGia.getGiaTriLonNhat(),
                    dotGiamGia.getPhanTramGiamGia(),
                    dotGiamGia.htTrangThai()

                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_DGG = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_DGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_DGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_DGGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_DGG);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_DGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DGGMouseClicked
        // TODO add your handling code here:
//        int row = table_DGG.getSelectedRow();
//
//        String ten = table_DGG.getValueAt(row, 2).toString();
//        String phanTram = table_DGG.getValueAt(row, 7).toString();
//        BanHangView frame2 = new BanHangView();
//        frame2.setTextFieldValues1(ten, phanTram);
//        frame2.setVisible(true);
//        dispose();
    }//GEN-LAST:event_table_DGGMouseClicked

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
            java.util.logging.Logger.getLogger(TableDotGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableDotGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableDotGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableDotGiamGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableDotGiamGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_DGG;
    // End of variables declaration//GEN-END:variables
}
