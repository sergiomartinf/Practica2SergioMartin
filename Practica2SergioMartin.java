import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practica2SergioMartin extends JFrame implements ActionListener{
    CardLayout tarjetas;
    JLabel label;
    JPanel panelTarjetas, panelSup, panelIzq, panelDer;
    JPanel[] arrayTarj = new JPanel[5];
    JEditorPane textInst;
    JButton sig,ant;
    String[] botNam = {"INSTRUCCIONES","FORMULARIO","PAIS","RESULTADO","SALIR"};
    JButton[] arrayBotones = new JButton[5];
    public Practica2SergioMartin(){
        initPantalla();
        initPaneles();
        initLabels();
        initBotones();
        initTarjetas();
        initInstrucciones();
        initFormulario();
        initPais();
        setVisible(true);
    }

    public void initPantalla(){
        setLayout(new BorderLayout());
        setTitle("Practica 2: Sergio Martín");
        setSize(1400, 820);
        setResizable(false);
        this.getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initLabels(){
        //TODO Label de la imagen del panel superior
        //TODO No me funciona el logo, he cogido imagenes .png y aun asi me salen con fondo
        ImageIcon logo = new ImageIcon(".\\img\\logo.png");
        JLabel icono = new JLabel();
        icono.setIcon(new ImageIcon(logo.getImage().getScaledInstance(250, 100, 0)));
        panelSup.add(icono);

        //TODO Label del formulario del panel superior
        label = new JLabel("FORMULARIO");
        label.setSize(700,300);
        label.setFont(new Font("SansSerif", Font.BOLD, 64));
        label.setForeground(Color.white);
        panelSup.add(label);
    }
    //TODO Método para declarar los paneles y añadirlos al cardlayout
    public void initPaneles(){
        panelSup = new JPanel(new FlowLayout(FlowLayout.CENTER,0,60));
        panelSup.setBackground(new Color(47, 74, 91));
        panelSup.setPreferredSize(new Dimension(getWidth(),180));
        add(panelSup, BorderLayout.NORTH);

        panelDer = new JPanel(new FlowLayout(FlowLayout.CENTER,0,150));
        panelDer.setBackground(new Color(14, 43, 61));
        panelDer.setPreferredSize(new Dimension(180,getHeight()));
        add(panelDer, BorderLayout.EAST);

        panelIzq = new JPanel(new FlowLayout(FlowLayout.CENTER,0,60));
        panelIzq.setBackground(new Color(14, 43, 61));
        panelIzq.setPreferredSize(new Dimension(180,getHeight()));
        add(panelIzq, BorderLayout.WEST);

        tarjetas = new CardLayout();
        panelTarjetas = new JPanel(tarjetas);
        panelTarjetas.setBackground(new Color(47, 74, 91));
        panelTarjetas.setPreferredSize(new Dimension(getWidth(),getHeight()));
        add(panelTarjetas);
    }

    public void initDegradado(){
        Color color1 = new Color(0x666f7f);
        Color color2 = new Color(0x262d3d);
        float x1=0;
        float y1=0;
        float x2=getWidth();
        float y2=getHeight();

        Graphics2D g2 = (Graphics2D) g.create();
    }
    //TODO Método para generar las distintas tarjetas que componen el CardLayout
    public void initTarjetas(){
        String[] nomTarj = {"1","2","3","4","5"};
        //TODO Bucle que recorre el array de las tarjetas que van dentro del panel del medio
        for (int i = 0; i < arrayTarj.length; i++) {
            arrayTarj[i] = new JPanel();
            arrayTarj[i].setBackground(new Color(47, 74, 91));
            //If para que en las que no sea las instrucciones tengaa un layout null(para poder colocarlas mejor)
            if (arrayTarj[i] != arrayTarj[0]){
                arrayTarj[i].setLayout(null);
            }
            panelTarjetas.add(arrayTarj[i],nomTarj[i]);
        }
    }

    public void initInstrucciones(){
        //TODO HTML de las instrucciones, primer panel del array de tarjetas
        textInst = new JEditorPane();
        textInst.setContentType("text/html");
        textInst.setText("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body style='color:white;'>\n" +
                "\n" +
                "<h1>INSTRUCCIONES PARA RELLENAR EL FORMULARIO</h1>\n" +
                "<p>Debes rellenar el formulario entero en orden para poder enviarlo. </p>\n" +
                "<p>Para acceder a la siguiente pestaña puedes utlizar los botones que tienes en el menu de la derecha o bien utilizar los apartados de las distintas</p>\n" +
                "<p>partes del formulario citadas a la izquierda.</p>\n" +
                "<p>La pestaña de 'Formulario' te pedirá que rellenes los siguientes campos: <ul>\n" +
                "  <li>Nombre</li>\n" +
                "  <li>Email (Se comprobará que sea un email válido)</li>\n" +
                "  <li>Contraseña (Entre 8 y 16 caracteres, al menos un dígito, una mayúscula, una minúscula y un carácter que no sea letra ni número)</li>\n" +
                "</ul></p>\n" +
                "<p>La pestaña de 'Pais' consiste en que rellenes los siguientes campos. <ul>\n" +
                "  <li>Pais (Permite elegir solo entre España o Estados Unidos)</li>\n" +
                "  <li>Provincia o Estado (Para elegir entre Provincia o Estado depende de la opcion de país escogida)</li>\n" +
                "</ul></p>\n" +
                "<p>En la pestaña 'Resultado' te mostrará los campos rellenados en el formulario junto con los del pais y la provincia</p>\n" +
                "<p></p>\n" +
                "<h2>Gracias por su colaboración</h2>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        textInst.setBackground(new Color(47, 74, 91));
        textInst.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 16));
        arrayTarj[0].add(textInst);
    }

    public void initFormulario(){
        String[] nomForm = {"Nombre:","Apellidos:","Email:","Contraseña:"};
        JLabel[] labelForm = new JLabel[4];
        JTextField[] txtForm = new JTextField[3];
        JPasswordField pswd;

        //TODO Bucle para crear los botones del segundo panel (Nombre, Apellidos, Correo y Contraseña)
        int camY = 100; //Intervalo de la posicion Y
        for (int i = 0; i < labelForm.length; i++) {
            labelForm[i] = new JLabel(nomForm[i]);
            labelForm[i].setBounds(350,camY,100,30);
            labelForm[i].setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 16));
            labelForm[i].setForeground(Color.WHITE);
            arrayTarj[1].add(labelForm[i]);
            camY += 80;
        }
        //TODO Bucle para crear los JTextFields del segundo panel
        int chY = 100;
        for (int i = 0; i < txtForm.length; i++) {
            txtForm[i] = new JTextField();
            txtForm[i].setBounds(480,chY,200,30);
            arrayTarj[1].add(txtForm[i]);
            chY += 80;
        }
        //TODO Campo de la contraseña
        pswd = new JPasswordField();
        pswd.setBounds(480,chY,200,30);
        arrayTarj[1].add(pswd);
    }

    public void initPais(){
        String ruta = System.getProperties().getProperty(".\\txt\\lista.txt");

        JLabel pais = new JLabel("Pais");
        pais.setBounds(480,100,100,30);
        pais.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 20));
        pais.setForeground(Color.WHITE);
        arrayTarj[2].add(pais);

        JLabel prov = new JLabel("Provincia / Estado");
        prov.setBounds(420,250,200,30);
        prov.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 20));
        prov.setForeground(Color.WHITE);
        arrayTarj[2].add(prov);

        /*
        JList<String> lista = new JList<String>(ruta);
        lista.setBounds(480,150,100,50);
        arrayTarj[2].add(lista);*/
    }

    //TODO Método para generar los botones del menu de la derecha
    public void initBotones(){
        //TODO Botón de siguiente del menu de la derecha
        sig = new JButton("SIGUIENTE");
        sig.setPreferredSize(new Dimension(150,60));
        sig.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 16));
        sig.setForeground(Color.white);
        sig.setBackground(new Color(14, 43, 61));
        sig.setBorder(null);
        sig.setFocusable(false);
        sig.addActionListener(this);
        panelDer.add(sig);

        //TODO Botón de anterior del menu de la derecha
        ant = new JButton("ANTERIOR");
        ant.setPreferredSize(new Dimension(150,60));
        ant.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 16));
        ant.setForeground(Color.white);
        ant.setBackground(new Color(14, 43, 61));
        ant.setBorder(null);
        ant.setFocusable(false);
        ant.addActionListener(this);
        panelDer.add(ant);

        //TODO Bucle para generar los botones del menu de la izquierda
        for (int i = 0; i < arrayBotones.length; i++) {
            arrayBotones[i] = new JButton(botNam[i]);
            arrayBotones[i].setPreferredSize(new Dimension(150,50));
            arrayBotones[i].setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 13));
            arrayBotones[i].setBorder(null);
            arrayBotones[i].setFocusable(false);
            arrayBotones[i].setForeground(Color.white);
            arrayBotones[i].setBackground(new Color(14, 43, 61));
            arrayBotones[i].addActionListener(this);
            panelIzq.add(arrayBotones[i]);
        }
    }

    public static void main(String[] args) {
        new Practica2SergioMartin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO Uso de los botones siguiente y anterior
        if(e.getSource().equals(sig)){
            tarjetas.next(panelTarjetas);
        } else if (e.getSource().equals(ant)) {
            tarjetas.previous(panelTarjetas);
        }
        //TODO Uso de los botones del menu de la izquierda, cada una esta enlazada a una tarjeta del array mediante .show
        if (e.getSource().equals(arrayBotones[0])){
            tarjetas.show(panelTarjetas,"1");
        } else if (e.getSource().equals(arrayBotones[1])) {
            tarjetas.show(panelTarjetas,"2");
        }else if (e.getSource().equals(arrayBotones[2])) {
            tarjetas.show(panelTarjetas,"3");
        }else if (e.getSource().equals(arrayBotones[3])) {
            tarjetas.show(panelTarjetas,"4");
        }else if (e.getSource().equals(arrayBotones[4])) {
            System.exit(0);
        }

    }
}
