package View;

import Model.Personas;
import Model.PersonasDAO;
import javax.swing.JComboBox;
import Model.Programas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class RegistroView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistroView.class.getName());

    public RegistroView() {
        //conposicion de ventana
        initComponents();
        setResizable(false);
        setTitle("registro de usuarios");
        setLocationRelativeTo(null);

        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        txtRut.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Evitar borrar el primer dígito con Backspace o Supr
                if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
                    e.consume();
                }
            }
        });

        txtFono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String texto = getTxtFono().getText();
                char c = e.getKeyChar();

                // Evitar que Reemplacen el primer dígito
                if (txtFono.getCaretPosition() == 0) {
                    e.consume();
                }
                // Bloquear si ya hay 8 dígitos
                if (texto.length() >= 9) {
                    e.consume();
                }
                // Permitir solo números
                if (Character.isAlphabetic(c)) {
                    e.consume();
                }
            }

            public void keyPressed(KeyEvent e) {
                // Evitar borrar con Backspace
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && txtFono.getCaretPosition() == 1) {
                    e.consume();
                }
                // Evitar borrar con Suprimir
                if (e.getKeyCode() == KeyEvent.VK_DELETE && txtFono.getCaretPosition() == 0) {
                    e.consume();
                }
            }
        });

    }

    //CAPTURAR DATOS
    public javax.swing.JTextField getTxtNombre() {
        return txtNombre;
    }

    public javax.swing.JTextField getTxtRut() {
        return txtRut;
    }

    public javax.swing.JTextField getTxtFono() {
        return txtFono;
    }

    public JPanel getJpanAgregar() {
        return jpanAgregar;
    }

    public javax.swing.JTable getTablePersonas() {
        return tablePersonas;
    }

    public JComboBox<Programas> getComboProgramas() {
        return comboProgramas;
    }

    //--METODOS--
    public void limpiarCampos() {
        txtNombre.setText("");
        txtRut.setText("");
        txtFono.setText("");
    }

    public void cargarTablaPersonas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("RUT");
        model.addColumn("Teléfono");
        model.addColumn("Progama");
        model.addColumn("fecha");

        // ESTABLECER EL MODELO EN LA TABLA
        tablePersonas.setModel(model);

        // INSTANCIAR DAO
        PersonasDAO dao = new PersonasDAO();
        List<Personas> lista = dao.listPersonas();

        // AGREGAR UN OBJETO PERSONA AL MODELO
        for (Personas persona : lista) {
            Object[] fila = {
                persona.getNombre(),
                persona.getRut(),
                persona.getTelefono(),
                persona.getNombre_progama(),
                persona.getFecha()
            };
            model.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jpanAgregar = new javax.swing.JPanel();
        lblAñadir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        txtFono = new javax.swing.JTextField();
        comboProgramas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 33, 32));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 32, 96));
        jLabel5.setText("Ficha de registros de usuarios Biblioteca Pablo Neruda");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 26, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Rut", "Telefono", "Progama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePersonas.setMaximumSize(new java.awt.Dimension(214748, 80));
        tablePersonas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePersonas);
        if (tablePersonas.getColumnModel().getColumnCount() > 0) {
            tablePersonas.getColumnModel().getColumn(0).setResizable(false);
            tablePersonas.getColumnModel().getColumn(1).setResizable(false);
            tablePersonas.getColumnModel().getColumn(2).setResizable(false);
            tablePersonas.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 471, 300));

        jPanel2.setBackground(new java.awt.Color(255, 192, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanAgregar.setBackground(new java.awt.Color(255, 192, 0));
        jpanAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAñadir.setBackground(new java.awt.Color(255, 192, 0));
        lblAñadir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblAñadir.setForeground(new java.awt.Color(0, 32, 96));
        lblAñadir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAñadir.setText("AÑADIR");
        jpanAgregar.add(lblAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(jpanAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 100, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 32, 96));
        jLabel1.setText("Nombre");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 19, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 32, 96));
        jLabel2.setText("Rut");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 32, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 32, 96));
        jLabel3.setText("Fono");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 154, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 32, 96));
        jLabel4.setText("Progama");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 220, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 45, 250, 30));

        txtRut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 115, 250, 30));

        txtFono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFono.setText("9");
        txtFono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFonoActionPerformed(evt);
            }
        });
        jPanel2.add(txtFono, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 180, 250, 30));

        comboProgramas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboProgramas.setModel(comboProgramas.getModel());
        comboProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramasActionPerformed(evt);
            }
        });
        jPanel2.add(comboProgramas, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 246, 250, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 360));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel6.setText("alpha 0.2");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboProgramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgramasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgramasActionPerformed

    private void txtFonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFonoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new RegistroView().setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JComboBox<Programas> comboProgramas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel jpanAgregar;
    public javax.swing.JLabel lblAñadir;
    private javax.swing.JTable tablePersonas;
    private javax.swing.JTextField txtFono;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables

    public Object lblAñadir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
