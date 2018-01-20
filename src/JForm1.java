import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class JForm1 extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Launch");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JForm1 frame = new JForm1(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JForm1(String[] args) {
		setTitle("MoKe Programme Updater");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		btnNewButton.setBounds(127, 11, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FunWriter.startFunWriter(args);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("FunWriter");
		lblNewJgoodiesLabel.setBounds(10, 11, 107, 23);
		contentPane.add(lblNewJgoodiesLabel);
		contentPane.add(btnNewButton);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(10, 264, 530, 14);
		contentPane.add(progressBar_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 283, 530, 14);
		contentPane.add(progressBar);
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DataSafe.startDataSafe();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLaunch.setBounds(127, 45, 89, 23);
		contentPane.add(btnLaunch);
		
		JButton btnLaunch_1 = new JButton("Launch");
		btnLaunch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MC_Server_Creator.startMC_Server_Creator();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLaunch_1.setBounds(127, 79, 89, 23);
		contentPane.add(btnLaunch_1);
		
		JButton btnLaunch_2 = new JButton("Launch");
		btnLaunch_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					YouTube_dl_GUI.startYouTube_dl_GUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLaunch_2.setBounds(127, 113, 89, 23);
		contentPane.add(btnLaunch_2);
		
		JButton btnLaunch_3 = new JButton("Launch");
		btnLaunch_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Taschenrechner.startTaschenrechner();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLaunch_3.setBounds(127, 147, 89, 23);
		contentPane.add(btnLaunch_3);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DataSafe");
		lblNewJgoodiesLabel_1.setBounds(10, 49, 107, 14);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("MC Server Creator");
		lblNewJgoodiesLabel_2.setBounds(10, 83, 107, 14);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("YouTube-dl GUI");
		lblNewJgoodiesLabel_3.setBounds(10, 117, 107, 14);
		contentPane.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Taschenrechner");
		lblNewJgoodiesLabel_4.setBounds(10, 151, 107, 14);
		contentPane.add(lblNewJgoodiesLabel_4);
	}
}
