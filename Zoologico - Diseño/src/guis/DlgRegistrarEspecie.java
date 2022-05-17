package guis;

import control.ControlRegistrarEspecie;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import objetos.Animal;
import objetos.Cuidador;
import objetos.Especie;
import objetos.Habitat;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class DlgRegistrarEspecie extends javax.swing.JDialog {

    FondoPanelEspecie fondo = new FondoPanelEspecie();
    
    private final ControlRegistrarEspecie control = new ControlRegistrarEspecie();
    
    public DlgRegistrarEspecie(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        
        cuidadores = control.recuperaCuidadores();
        habitats = control.recuperaHabitats();
        
        inicializar();
    }
    
    private final List<Cuidador> cuidadores;
    private final List<Habitat> habitats;
    
    private List<Animal> animales;
    
    private Especie especie;

    private void inicializar() {
        if (cuidadores == null) {
            JOptionPane.showMessageDialog(this, "Error recuperando los cuidadores.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            comboBoxCuidador.removeAllItems();
            comboBoxCuidador.addItem("Seleccione...");
            for (Cuidador cuidador : cuidadores) {
                comboBoxCuidador.addItem(cuidador.getNombre());
            }
        }
        
        if (habitats == null) {
            JOptionPane.showMessageDialog(this, "Error recuperando los habitats.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            comboBoxHabitat.removeAllItems();
            comboBoxHabitat.addItem("Seleccione...");
            for (Habitat habitat : habitats) {
                comboBoxHabitat.addItem(habitat.getNombre());
            }
        }
        
        liberarCampos(false);
    }
    
    private void liberarCampos(boolean b) {
        this.campoNombreEspecieCientífico.setEditable(b);
        this.areaTextoDescripcionEspecie.setEditable(b);
        this.comboBoxCuidador.setEnabled(b);
        this.comboBoxHabitat.setEnabled(b);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNombreEspecie = new javax.swing.JTextField();
        btnVerificarNombreEspecie = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNombreEspecieCientífico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoDescripcionEspecie = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        comboBoxHabitat = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCuidador = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        campoTextoAnimalesAgregados = new javax.swing.JTextField();
        btnCancelarAnimales = new javax.swing.JButton();
        btnGuardarEspecie = new javax.swing.JButton();
        btnEditarAnimales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRO/ACTUALIZACIÓN DE ESPECIE");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Nombre especie:");

        btnVerificarNombreEspecie.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVerificarNombreEspecie.setText("Verificar");
        btnVerificarNombreEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarNombreEspecieActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nombre científico:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Descripción general:");

        areaTextoDescripcionEspecie.setColumns(20);
        areaTextoDescripcionEspecie.setRows(5);
        jScrollPane1.setViewportView(areaTextoDescripcionEspecie);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Habitat:");

        comboBoxHabitat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Cuidador:");

        comboBoxCuidador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Animales agregados a la especie: ");

        campoTextoAnimalesAgregados.setEditable(false);

        btnCancelarAnimales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelarAnimales.setText("Cancelar");
        btnCancelarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAnimalesActionPerformed(evt);
            }
        });

        btnGuardarEspecie.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardarEspecie.setText("Guardar");
        btnGuardarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEspecieActionPerformed(evt);
            }
        });

        btnEditarAnimales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditarAnimales.setText("Editar animales");
        btnEditarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAnimalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoTextoAnimalesAgregados))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(73, 73, 73)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxCuidador, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarAnimales))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(campoNombreEspecieCientífico))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(campoNombreEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnVerificarNombreEspecie)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnGuardarEspecie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarAnimales)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNombreEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerificarNombreEspecie))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoNombreEspecieCientífico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBoxHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboBoxCuidador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(campoTextoAnimalesAgregados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarAnimales)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEspecie)
                    .addComponent(btnCancelarAnimales))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEspecieActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarEspecieActionPerformed

    private void btnCancelarAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAnimalesActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarAnimalesActionPerformed

    private void btnEditarAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnimalesActionPerformed
        editarAnimales();
    }//GEN-LAST:event_btnEditarAnimalesActionPerformed

    private void btnVerificarNombreEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarNombreEspecieActionPerformed
        verificar();
    }//GEN-LAST:event_btnVerificarNombreEspecieActionPerformed

    private void editarAnimales() {
        if(animales == null) animales = new ArrayList();
        
        new DlgEditarAnimales((Frame)this.getParent(), true, animales).setVisible(true);
        
        this.campoTextoAnimalesAgregados.setText(String.valueOf(animales.size()));
    }
    
    private boolean verificar() {
        Especie especie = control.buscarEspecieEspanol(campoNombreEspecie.getText());
        if (especie != null) {
            liberarCampos(false);

            JOptionPane.showMessageDialog(this, "Ya está registrada una especie con ese nombre.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            
            this.campoNombreEspecieCientífico.setText(especie.getNombreCientifico());
            this.areaTextoDescripcionEspecie.setText(especie.getDescripcionGeneral());
            
            ObjectId idCuidador = especie.getIdCuidador();
            for (int i = 0; i < cuidadores.size(); i++) {
                if(cuidadores.get(i).getId().equals(idCuidador)) {
                    this.comboBoxCuidador.setSelectedIndex(i+1);
                }
            }
            
            ObjectId idHabitat = especie.getIdsHabitatsDondePuedeVivir().get(0);
            for (int i = 0; i < habitats.size(); i++) {
                if(habitats.get(i).getId().equals(idHabitat)) {
                    this.comboBoxHabitat.setSelectedIndex(i+1);
                }
            }
            return false;
        } else {
            liberarCampos(true);
            return true;
        }
    }

    private boolean validar() {
        boolean valido = true;
        String errores = "";
        if (this.campoNombreEspecie.getText().equals("")) {
            errores = errores + (errores.equals("") ? "" : "\n") + "Introduzca el nombre común de la especie.";
            valido = false;
        }
        if (this.campoNombreEspecieCientífico.getText().equals("")) {
            errores = errores + (errores.equals("") ? "" : "\n") + "Introduzca el nombre científico de la especie.";
            valido = false;
        } else {
            if(control.buscarEspecieCientifico(campoNombreEspecieCientífico.getText())!=null) {
                errores = errores + (errores.equals("") ? "" : "\n") + "Ya está registrada una especie con ese nombre científico.";
                valido = false;
            }
        }
        if (this.areaTextoDescripcionEspecie.getText().equals("")) {
            errores = errores + (errores.equals("") ? "" : "\n") + "Introduzca la descripción de la especie.";
            valido = false;
        }
        if (this.comboBoxHabitat.getSelectedIndex() == 0) {
            errores = errores + (errores.equals("") ? "" : "\n") + "Seleccione un tipo de hábitat.";
            valido = false;
        }
        if (this.comboBoxCuidador.getSelectedIndex() == 0) {
            errores = errores + (errores.equals("") ? "" : "\n") + "Seleccione el cuidador de la especie.";
            valido = false;
        }
        if (animales == null) animales = new ArrayList();
        if (animales.isEmpty()) {
            errores = errores + (errores.equals("") ? "" : "\n") + "Agregue al menos un animal.";
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(this, "Hay errores en los siguientes campos: \n" + errores, "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        return valido;
    }

    private void guardar() {
        if (verificar() && validar()) {
            
            if(especie==null) especie = new Especie();
            
            ObjectId id = new ObjectId();
            especie.setId(id);
            
            especie.setNombreEspanol(this.campoNombreEspecie.getText());
            especie.setNombreCientifico(this.campoNombreEspecieCientífico.getText());
            especie.setDescripcionGeneral(this.areaTextoDescripcionEspecie.getText());
            List<ObjectId> habitats = new ArrayList();
            habitats.add(this.habitats.get(this.comboBoxHabitat.getSelectedIndex() - 1).getId());
            especie.setIdsHabitatsDondePuedeVivir(habitats);
            especie.setIdCuidador(this.cuidadores.get(this.comboBoxCuidador.getSelectedIndex() - 1).getId());
            especie.setAnimales(animales);
            
            for (Animal animal : animales) animal.setIdEspecie(especie.getId());
            
            if (control.guardar(especie)) {
                JOptionPane.showMessageDialog(this, "Especie registrada satisfactoriamente.\n"+
                        "Id: "+id.toString(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido guardar la especie.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoDescripcionEspecie;
    private javax.swing.JButton btnCancelarAnimales;
    private javax.swing.JButton btnEditarAnimales;
    private javax.swing.JButton btnGuardarEspecie;
    private javax.swing.JButton btnVerificarNombreEspecie;
    private javax.swing.JTextField campoNombreEspecie;
    private javax.swing.JTextField campoNombreEspecieCientífico;
    private javax.swing.JTextField campoTextoAnimalesAgregados;
    private javax.swing.JComboBox<String> comboBoxCuidador;
    private javax.swing.JComboBox<String> comboBoxHabitat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    class FondoPanelEspecie extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("/imagenes/FondoPrueba.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
