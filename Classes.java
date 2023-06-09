/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Logic.Logic;
/**
 *
 * @author niran
 */
public class Classes extends javax.swing.JFrame {

    
    /**
     * Creates new form Staffs
     */
    public Classes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        Classes_Blue_Ribbon = new javax.swing.JPanel();
        Classes_logo = new javax.swing.JLabel();
        Classes_Text = new javax.swing.JLabel();
        Classes_Table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Classes_Blue_Ribbon.setBackground(new java.awt.Color(0, 34, 73));
        Classes_Blue_Ribbon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Classes_Blue_RibbonMouseDragged(evt);
            }
        });
        Classes_Blue_Ribbon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Classes_Blue_RibbonMousePressed(evt);
            }
        });
        Classes_Blue_Ribbon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Classes_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/group_52px_1.png")));
        Classes_Blue_Ribbon.add(Classes_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 60, 60));

        Classes_Text.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Classes_Text.setForeground(new java.awt.Color(45, 118, 232));
        Classes_Text.setText("CLASSES");
        Classes_Text.setMaximumSize(new java.awt.Dimension(125, 15));
        Classes_Blue_Ribbon.add(Classes_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 390, 40));

        Classes_Table.setLayout(null);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            
            new Object [][] {
                
            },
            new String [] {
                "1st Period", "2nd Period", "3rd Period", "4th Period", "5th Period", "6th Period", "7th Period", "8th Period"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Classes_Table.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 1100, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Classes_Blue_Ribbon, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
            .addComponent(Classes_Table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Classes_Blue_Ribbon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Classes_Table, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Classes_Blue_RibbonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Classes_Blue_RibbonMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_Classes_Blue_RibbonMouseDragged

    public void Classes_Blue_RibbonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Classes_Blue_RibbonMousePressed
;
    }//GEN-LAST:event_Classes_Blue_RibbonMousePressed

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
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Classes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Classes_Blue_Ribbon;
    public javax.swing.JPanel Classes_Table;
    public javax.swing.JLabel Classes_Text;
    public javax.swing.JLabel Classes_logo;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}