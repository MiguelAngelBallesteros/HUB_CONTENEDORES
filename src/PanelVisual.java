import G03.Contenedores;
import G03.Hub;

import javax.swing.*;
import java.awt.*;
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
    private JTextField textField_Aduana;
    private JTextField textField_Prioridad;

    public PanelVisual() {
        setTitle("Hub de Contenedores");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6,4));

        JLabel textLabel_Id = new JLabel("ID:");
        JLabel textLabel_Peso = new JLabel("Peso:");
        JLabel textLabel_Pais = new JLabel("Pais:");
        JLabel textLabel_Descricion = new JLabel("Descripcion:");
        JLabel textLabel_Aduana = new JLabel("Control de Aduanas (True o False):");
        JLabel textLabel_Prioridad = new JLabel("Prioridad (Valor entre 1 y 3):");
        JLabel textLabel_EmpresaReceptora = new JLabel("Empresa Receptora:");
        JLabel textLabel_EmpresaEmisora = new JLabel("Empresa Emisora:");

        add(textLabel_Id);
        add(textField_Id);
        add(textLabel_Peso);
        add(textField_Peso);
        add(textLabel_Pais);
        add(textField_Pais);
        add(textLabel_Aduana);
        add(textField_Aduana);
        add(textLabel_Prioridad);
        add(textField_Prioridad);
        add(textLabel_Descricion);
        add(textFile_Descripcion);
        add(textLabel_EmpresaEmisora);
        add(textField_EmpresaEmisora);
        add(textLabel_EmpresaReceptora);
        add(textField_EmpresaReceptora);
        add(apilarContenedorButton);
        add(desapilarContenedorButton);
        add(mostrarPlanoDelHubButton);
        add(mostrarDatosDeUnButton);
        add(mostrarNúmeroDeContenedoresButton);

        mostrarDatosDeUnButton.addActionListener(this);
        mostrarPlanoDelHubButton.addActionListener(this);
        mostrarNúmeroDeContenedoresButton.addActionListener(this);
        apilarContenedorButton.addActionListener(this);
        desapilarContenedorButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==apilarContenedorButton){
            Contenedores Cont=new Contenedores(Integer.parseInt(textField_Id.getText()),Integer.parseInt(textField_Peso.getText()),textField_Pais.getText(),Boolean.parseBoolean(textField_Aduana.getText()),Integer.parseInt(textField_Prioridad.getText()),textFile_Descripcion.getText().toCharArray(),textField_EmpresaEmisora.getText().toCharArray(),textField_EmpresaReceptora.getText().toCharArray());
            Hub HC=new Hub();
            HC.ApilarContenedor(Cont);
        }
        else if (e.getSource()==desapilarContenedorButton){
            int columna;
        }
    }
}

