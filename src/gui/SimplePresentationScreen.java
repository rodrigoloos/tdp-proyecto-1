package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField tfLU;
	private JTextField tfApellido;
	private JTextField tfNombre;
	private JTextField tfMail;
	private JTextField tfGitHub;
	private JLabel lblImage;
	

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		setVisible(true);
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		Date objDate = new Date(); 
		String l=studentData.getPathPhoto();
		ImageIcon image= new ImageIcon(this.getClass().getResource(l));
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 11, 46, 14);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 36, 46, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 61, 46, 14);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(10, 86, 46, 14);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("GitHub URL");
		lblGithubUrl.setBounds(10, 111, 69, 14);
		tabInformation.add(lblGithubUrl);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setBounds(10, 158, 405, 14);
		lblFecha.setText("Esta ventana fue generada el: "+objDate.toGMTString());
		tabInformation.add(lblFecha);
		
		tfLU = new JTextField();
		tfLU.setEditable(false);
		tfLU.setBounds(94, 8, 181, 20);
		tabInformation.add(tfLU);
		tfLU.setText(""+studentData.getId());
		tfLU.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setEditable(false);
		tfApellido.setColumns(10);
		tfApellido.setBounds(94, 33, 181, 20);
		tfApellido.setText(studentData.getLastName());
		tabInformation.add(tfApellido);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setColumns(10);
		tfNombre.setBounds(94, 58, 181, 20);
		tfNombre.setText(studentData.getFirstName());
		tabInformation.add(tfNombre);
		
		tfMail = new JTextField();
		tfMail.setEditable(false);
		tfMail.setColumns(10);
		tfMail.setBounds(94, 83, 181, 20);
		tfMail.setText(studentData.getMail());
		tabInformation.add(tfMail);
		
		tfGitHub = new JTextField();
		tfGitHub.setEditable(false);
		tfGitHub.setColumns(10);
		tfGitHub.setBounds(94, 108, 181, 20);
		tfGitHub.setText(studentData.getGithubURL());
		tabInformation.add(tfGitHub);
		
		lblImage = new JLabel(" ");
		lblImage.setBounds(302, 11, 113, 136);
		
		Image imgEscalada = image.getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
		
		lblImage.setIcon(iconoEscalado);
		tabInformation.add(lblImage);
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
}
