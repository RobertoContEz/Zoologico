package guis;

import control.ControlRegistrarQueja;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import negocio.Conversiones;
import objetos.Guia;
import objetos.Itinerario;
import objetos.Queja;
import objetos.Recorrido;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * Esta clase representa gráficamente la interacción entre el usuario y el sistema al momento de registrar una Queja
 */
public class DlgRegistrarQueja extends javax.swing.JDialog {

    private final ControlRegistrarQueja control = new ControlRegistrarQueja();
    
    /**
     * Creates new form DlgRegistrarQueja
     */
    public DlgRegistrarQueja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        recorridos = control.recuperarRecorridosUltimoMes();
        itinerarios = control.recuperarItinerariosDeLosRecorridos(recorridos);
        recorridosPorItinerario = control.ordenarRecorridos(itinerarios, recorridos);
        
        inicializar();
    }
    
    private final List<Recorrido> recorridos;
    private final List<Itinerario> itinerarios;
    private final HashMap<Itinerario,List<Recorrido>> recorridosPorItinerario;

    private void inicializar() {
        if(itinerarios==null) {
            JOptionPane.showMessageDialog(this, "Error recuperando los registros de los itinerarios.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.comboBoxItinerarioQueja.removeAllItems();
            this.comboBoxItinerarioQueja.addItem("Seleccione...");
            for (Itinerario itinerario : itinerarios) {
                this.comboBoxItinerarioQueja.addItem(itinerario.getNombre());
            }
        }
        this.comboBoxFechaRecorridoQueja.removeAllItems();
        this.comboBoxHoraRecorridoQueja.removeAllItems();
        
        liberarCampos(false);
    }
    
    private void liberarCampos(boolean b) {
        this.comboBoxFechaRecorridoQueja.setEnabled(b);
        this.comboBoxHoraRecorridoQueja.setEnabled(b);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxItinerarioQueja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboBoxFechaRecorridoQueja = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        campoTextoNombreGuia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboBoxHoraRecorridoQueja = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoQueja = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        campoTextoCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoTextoNumeroTelefonico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoTextoNombreQueja = new javax.swing.JTextField();
        btnEnviarQueja = new javax.swing.JButton();
        btnRegresarQueja = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR QUEJA");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Nombre del itinerario:");

        comboBoxItinerarioQueja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxItinerarioQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxItinerarioQuejaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Fecha del recorrido:");

        comboBoxFechaRecorridoQueja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxFechaRecorridoQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFechaRecorridoQuejaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del guía:");

        campoTextoNombreGuia.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Hora:");

        comboBoxHoraRecorridoQueja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Queja:");

        areaTextoQueja.setColumns(20);
        areaTextoQueja.setRows(5);
        jScrollPane1.setViewportView(areaTextoQueja);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Correo electrónico:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Número telefónico:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Nombre (opcional):");

        btnEnviarQueja.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEnviarQueja.setText("Enviar");
        btnEnviarQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarQuejaActionPerformed(evt);
            }
        });

        btnRegresarQueja.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnRegresarQueja.setText("Regresar");
        btnRegresarQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarQuejaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("REGISTRO DE QUEJA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoNombreQueja)
                            .addComponent(campoTextoNumeroTelefonico)
                            .addComponent(campoTextoCorreo)
                            .addComponent(jScrollPane1)
                            .addComponent(comboBoxHoraRecorridoQueja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoTextoNombreGuia)
                            .addComponent(comboBoxFechaRecorridoQueja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxItinerarioQueja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnEnviarQueja, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnRegresarQueja)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel9)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxItinerarioQueja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxFechaRecorridoQueja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoTextoNombreGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxHoraRecorridoQueja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(campoTextoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(campoTextoNumeroTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(campoTextoNombreQueja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarQueja)
                    .addComponent(btnRegresarQueja))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxItinerarioQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxItinerarioQuejaActionPerformed
        cargarFechas();
    }//GEN-LAST:event_comboBoxItinerarioQuejaActionPerformed

    private void comboBoxFechaRecorridoQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFechaRecorridoQuejaActionPerformed
        cargarHoras();
    }//GEN-LAST:event_comboBoxFechaRecorridoQuejaActionPerformed

    private void btnEnviarQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarQuejaActionPerformed
        guardar();
    }//GEN-LAST:event_btnEnviarQuejaActionPerformed

    private void btnRegresarQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarQuejaActionPerformed
        dispose();
    }//GEN-LAST:event_btnRegresarQuejaActionPerformed

    private List<LocalDate> fechas;
    private HashMap<LocalDate,List<Recorrido>> recorridosPorFecha;
    private Recorrido recorrido;
    private Itinerario itinerario;
    
    private void cargarFechas() {
        int i = this.comboBoxItinerarioQueja.getSelectedIndex();
        if(i<=0) {
            liberarCampos(false);
            return;
        }
        
        fechas = new ArrayList();
        recorridosPorFecha = new HashMap();
        Itinerario  itinerario = itinerarios.get(i-1);
        List<Recorrido> recorridos = recorridosPorItinerario.get(itinerario);
        
        if(recorridos != null) for (Recorrido recorrido : recorridos) {
            LocalDate fecha = recorrido.getFechaHora().toLocalDate();
            if(fechas.contains(fecha)) {
                recorridosPorFecha.get(fecha).add(recorrido);
            } else {
                fechas.add(fecha);
                List<Recorrido> r = new ArrayList();
                r.add(recorrido);
                recorridosPorFecha.put(fecha, r);
            }
            this.recorrido = recorrido;
        }
        fechas = new ArrayList(new HashSet(fechas));
        
        if(fechas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error recuperando las fechas de los recoridos del itinerario.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.comboBoxFechaRecorridoQueja.removeAllItems();
            this.comboBoxFechaRecorridoQueja.addItem("Seleccione...");
            for (LocalDate fecha : fechas) {
                this.comboBoxFechaRecorridoQueja.addItem(Conversiones.fechaATexto(fecha));
            }
            this.comboBoxFechaRecorridoQueja.setEnabled(true);
        }
        cargarGuia();
    }

    private void cargarGuia() {
        Guia guia = control.recuperarGuia(recorrido);
        this.campoTextoNombreGuia.setText(guia.getNombre());
    }

    private LocalDate fecha;
    private List<LocalTime> horas;
    private HashMap<LocalTime,Recorrido> recorridosPorHora;
    
    private void cargarHoras() {
        int i = this.comboBoxFechaRecorridoQueja.getSelectedIndex();
        if(i<=0) {
            liberarCampos(false);
            return;
        }
        
        horas = new ArrayList();
        recorridosPorHora = new HashMap();
        fecha = fechas.get(i-1);
        List<Recorrido> recorridos = recorridosPorFecha.get(fecha);
        
        for (Recorrido recorrido : recorridos) {
            LocalTime hora = recorrido.getFechaHora().toLocalTime();
            recorridosPorHora.put(hora, recorrido);
            horas.add(hora);
        }
        
        if(horas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error recuperando las horas de los recoridos de esa fecha.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.comboBoxHoraRecorridoQueja.removeAllItems();
            this.comboBoxHoraRecorridoQueja.addItem("Seleccione...");
            for (LocalTime hora : horas) {
                this.comboBoxHoraRecorridoQueja.addItem(Conversiones.horaATexto(hora));
            }
            this.comboBoxHoraRecorridoQueja.setEnabled(true);
        }
    }
    
    private void guardar() {
        if(validar()) {
            Queja queja = new Queja();
            
            queja.setFecha(fecha);
            queja.setHora(hora);
            queja.setQueja(textoQueja);
            queja.setCorreo(correo);
            queja.setTelefono(telefono);
            queja.setIdRecorrido(recorrido.getId());
            
            if(control.guardar(queja)) {
                JOptionPane.showMessageDialog(this, "Se ha enviado la queja a la administración del zoológico.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido enviar la queja.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private LocalTime hora;
    private String textoQueja;
    private String correo;
    private String telefono;
    private String nombre;
    
    private boolean validar() {
        boolean valido = true;
        String errores = "";
        
        int i = this.comboBoxItinerarioQueja.getSelectedIndex();
        if(i == 0) {
            errores = errores + (errores.equals("")?"":"\n") + "Seleccione itinerario, fecha y hora antes de enviar su queja.";
        } else {
            itinerario = itinerarios.get(i-1);
            
            i = this.comboBoxFechaRecorridoQueja.getSelectedIndex();
            if(i <= 0) {
                errores = errores + (errores.equals("")?"":"\n") + "Seleccione la fecha y la hora del recorrido antes de enviar su queja.";
            } else {
                fecha = fechas.get(i-1);
                
                i = this.comboBoxHoraRecorridoQueja.getSelectedIndex();
                if(i <= 0) {
                    errores = errores + (errores.equals("")?"":"\n") + "Seleccione la hora del recorrido antes de enviar su queja.";
                } else {
                    hora = horas.get(i-1);
                }
            }
        }
        
        textoQueja = this.areaTextoQueja.getText();
        if(textoQueja.equals("")) {
            errores = errores + (errores.equals("")?"":"\n") + "Redacte su queja en el area de texto por favor.";
            valido = false;
        }
        
        correo = this.campoTextoCorreo.getText();
        if(correo.equals("")) {
            errores = errores + (errores.equals("")?"":"\n") + "Introduzca su correo.";
            valido = false;
        } else {
            if(!validarCorreo(correo)) {
                errores = errores + (errores.equals("")?"":"\n") + "El correo introducido no es válido";
                valido = false;
            }
        }
        
        telefono = this.campoTextoNumeroTelefonico.getText();
        if(telefono.equals("")) {
            errores = errores + (errores.equals("")?"":"\n") + "Introduzca su teléfono.";
            valido = false;
        } else {
            if(!validarTelefono(telefono)) {
                errores = errores + (errores.equals("")?"":"\n") + "Introduzca su teléfono con el formato \"(nnn)-nnn-nnnn\".";
                valido = false;
            }
        }
        
        nombre = this.campoTextoNombreQueja.getText();
        if(nombre.equals("")) nombre = null;
        
        if(!valido) {
            errores = (errores.equals("")?"":"No ha sido posible enviar la queja por los siguientes motivos: \n"+errores);
            JOptionPane.showMessageDialog(this, errores, "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        
        return valido;
    }
    
    private boolean validarCorreo(String correo) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
    
    private boolean validarTelefono(String tel) {
        // Patron para validar el teléfono
        Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-.●]?([0-9]{3})[-.●]?([0-9]{4})$");
 
        Matcher mather = pattern.matcher(tel);
        return mather.find();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoQueja;
    private javax.swing.JButton btnEnviarQueja;
    private javax.swing.JButton btnRegresarQueja;
    private javax.swing.JTextField campoTextoCorreo;
    private javax.swing.JTextField campoTextoNombreGuia;
    private javax.swing.JTextField campoTextoNombreQueja;
    private javax.swing.JTextField campoTextoNumeroTelefonico;
    private javax.swing.JComboBox<String> comboBoxFechaRecorridoQueja;
    private javax.swing.JComboBox<String> comboBoxHoraRecorridoQueja;
    private javax.swing.JComboBox<String> comboBoxItinerarioQueja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
