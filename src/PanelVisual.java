import G03.Contenedores;
import G03.Puerto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVisual extends JFrame implements ActionListener {
    private JButton mostrarPlanoDelHubButton;
    private JButton mostrarDatosDeUnButton;
    private JButton mostrarNúmeroDeContenedoresButton;
    private JButton apilarContenedorButton;
    private JButton desapilarContenedorButton;
    private JTextField textField_Id;
    private JTextField textField_Peso;
    private JTextField textField_Pais;
    private JTextField textFile_Descripcion;
    private JTextField textField_EmpresaReceptora;
    private JTextField textField_EmpresaEmisora;
    private JTextField textField_Columna;
    private JTextField textField_NumPais;
    private JPanel PanelMain;
    private JTextField textField_Texto;
    private JTextArea textAreaPlano;
    private JTextArea textAreaDatos;
    private JComboBox comboBoxPrioridad;
    private JComboBox comboBoxAduana;

    public PanelVisual() {
        setContentPane(PanelMain);
        setTitle("Hub de Contenedores");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mostrarDatosDeUnButton.addActionListener(this);
        mostrarPlanoDelHubButton.addActionListener(this);
        mostrarNúmeroDeContenedoresButton.addActionListener(this);
        apilarContenedorButton.addActionListener(this);
        desapilarContenedorButton.addActionListener(this);
    }

    Puerto HC=new Puerto();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==apilarContenedorButton) {
            Contenedores Cont = new Contenedores(Integer.parseInt(textField_Id.getText()), Integer.parseInt(textField_Peso.getText()), textField_Pais.getText(), Boolean.parseBoolean(comboBoxAduana.getModel().getSelectedItem().toString()), Integer.parseInt(comboBoxPrioridad.getModel().getSelectedItem().toString()), textFile_Descripcion.getText().toCharArray(), textField_EmpresaEmisora.getText().toCharArray(), textField_EmpresaReceptora.getText().toCharArray());
            HC.Apilar(Cont);
            textField_Texto.setText("Se ha apilado el contenedor correctamente");
        }
        if (e.getSource()==desapilarContenedorButton){
            HC.Desapilar(Integer.parseInt(textField_Columna.getText())-1);
            textField_Texto.setText("Se ha desapilado el contenedor correctamente");
        }
        if (e.getSource()==mostrarPlanoDelHubButton){
            textAreaPlano.setText(HC.Plano());
        }
        if (e.getSource()==mostrarDatosDeUnButton){
            textAreaDatos.setText(HC.Datos(Integer.parseInt(textField_Id.getText())));
        }
        if (e.getSource()==mostrarNúmeroDeContenedoresButton){
            textField_NumPais.setText(HC.Pais(textField_NumPais.getText()));
        }
    }
}

