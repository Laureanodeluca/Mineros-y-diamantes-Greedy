package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import Principal.Logic;
import Principal.Structure;
import TDAs.DefaultComparator;
import TDAs.EmptyPriorityQueueException;
import TDAs.Entrada;
import TDAs.Entry;
import TDAs.Heap;
import TDAs.PriorityQueue;
import graph.SimpleGraph;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.Dimension;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	
	Structure myStructure = new Structure();
	private Logic myLogic= new Logic(myStructure);
	SimpleGraph graph = new SimpleGraph();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(1240, 800));
		frame.setBounds(100, 100, 899, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel IngresoDeTexto = new JPanel();
		frame.getContentPane().add(IngresoDeTexto, BorderLayout.SOUTH);

		
		JPanel Medio = new JPanel();
		frame.getContentPane().add(Medio, BorderLayout.CENTER);
		GridBagLayout gbl_Medio = new GridBagLayout();
		gbl_Medio.columnWidths = new int[]{0, 0, 0};
		gbl_Medio.rowHeights = new int[]{0, 0, 0, 0};
		gbl_Medio.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_Medio.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		Medio.setLayout(gbl_Medio);
		
		JPanel Grafico = new JPanel();
		GridBagConstraints gbc_Grafico = new GridBagConstraints();
		gbc_Grafico.gridwidth = 2;
		gbc_Grafico.insets = new Insets(0, 0, 5, 0);
		gbc_Grafico.fill = GridBagConstraints.BOTH;
		gbc_Grafico.gridx = 0;
		gbc_Grafico.gridy = 0;
		Medio.add(Grafico, gbc_Grafico);
		Grafico.setLayout(new BoxLayout(Grafico, BoxLayout.X_AXIS));
		
		JPanel Vision = new JPanel();
		GridBagConstraints gbc_Vision = new GridBagConstraints();
		gbc_Vision.gridwidth = 2;
		gbc_Vision.fill = GridBagConstraints.BOTH;
		gbc_Vision.insets = new Insets(0, 0, 5, 0);
		gbc_Vision.gridx = 0;
		gbc_Vision.gridy = 1;
		Medio.add(Vision, gbc_Vision);
		FlowLayout flowLayout = (FlowLayout) Vision.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setAlignOnBaseline(true);
		
		JLabel Suma = new JLabel("Sumatoria de costo total:");
		Suma.setVerticalAlignment(SwingConstants.TOP);
		Vision.add(Suma);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setColumns(30);
		textArea.setDropMode(DropMode.INSERT);
		textArea.setFont(new Font("Arial", Font.PLAIN, 10));
		textArea.setRows(1);
		textArea.setTabSize(30);
		Vision.add(textArea);
		
		JPanel Resultado = new JPanel();
		GridBagConstraints gbc_Resultado = new GridBagConstraints();
		gbc_Resultado.gridwidth = 2;
		gbc_Resultado.fill = GridBagConstraints.BOTH;
		gbc_Resultado.gridx = 0;
		gbc_Resultado.gridy = 2;
		Medio.add(Resultado, gbc_Resultado);
		
		JLabel Resultados = new JLabel("Esfuerzo total:");
		Resultado.add(Resultados);
		
		JTextArea Res = new JTextArea();
		Res.setTabSize(200);
		Res.setDropMode(DropMode.INSERT);
		Resultado.add(Res);

		JPanel HeapDiamantes = new JPanel();
		frame.getContentPane().add(HeapDiamantes, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("Lista de diamantes");
		HeapDiamantes.add(lblNewLabel_2);
		
		JTextArea Diamantes = new JTextArea();
		Diamantes.setDropMode(DropMode.INSERT);
		HeapDiamantes.add(Diamantes);
		
		JPanel HeapMineros = new JPanel();
		frame.getContentPane().add(HeapMineros, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de mineros");
		HeapMineros.add(lblNewLabel_1);
		
		JTextArea Mineros = new JTextArea();
		Mineros.setDropMode(DropMode.INSERT);
		HeapMineros.add(Mineros);
		
		JPanel Titulo = new JPanel();
		frame.getContentPane().add(Titulo, BorderLayout.NORTH);
		
		JLabel TituloP = new JLabel("Problema mineros de diamante");
		TituloP.setFont(new Font("Arial Black", Font.PLAIN, 30));
		TituloP.setForeground(Color.BLACK);
		Titulo.add(TituloP);
		
		JLabel lblNewLabel = new JLabel("Cuantos mineros desea que entren?(Max 15)");
		IngresoDeTexto.add(lblNewLabel);
		
		textField = new JTextField();
		IngresoDeTexto.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter\r\n");
		IngresoDeTexto.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Res.setText("");
				Mineros.setText("");
				Diamantes.setText("");
				textArea.setText("");
				graph.clearPoints();
				graph.clearFunctions();
				graph.removeAllShapes();
				graph.repaint();
				
				Entry<String,Integer> auxD;
				Entry<String,Integer> auxM;
				
				if (Integer.parseInt(textField.getText())<=15) {
					myLogic.IngresoMyD(Integer.parseInt(textField.getText()));
					
					Entry<Entry<Integer, String>, Entry<Integer, String>> S[] = myLogic.minerosDeDiamanteGreedy();
					System.out.println(myLogic.solucionToString(S) + "\nEsfuerzo total: " + myLogic.esfuerzoTotal(S));
					Res.setText(""+(float)myLogic.esfuerzoTotal(S));
					
					Grafico.add(graph);
					
					for(int i=0; i<S.length;i++){
						
							auxM =new Entrada(S[i].getKey().getValue(),S[i].getKey().getKey());
							auxD =new Entrada(S[i].getValue().getValue(),S[i].getValue().getKey());
							graph.addPoint(0,auxM.getValue(),new Color(239,127,26));
							graph.addPoint(auxD.getValue(),0,new Color(12,183,242));
							graph.addShape(new SimpleGraph.Line(0,auxM.getValue(),auxD.getValue(), 0, Color.RED));
							
							textArea.setText(textArea.getText()+"Sqrt("+ S[i].getKey().getKey() + "² + " + S[i].getValue().getKey() + "² ) +" );
							
							Mineros.setText(Mineros.getText()+"(" + auxM.getKey() +": "+ String.valueOf(auxM.getValue()) + ") \n" );
							Diamantes.setText(Diamantes.getText()+"( " + auxD.getKey() +": "+ String.valueOf(auxD.getValue())  + ") \n" );
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Pruebe un numero menor a 15");
				}
			}
		});
		
	}

}
