package appTest;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.CauHoiThiDAO;
import model.CauHoiThi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class ChiTietCauHoiThiForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ChiTietCauHoiThiForm(String id) {
		
		CauHoiThi cauHoi = null;
		try {
            cauHoi = CauHoiThiDAO.getCauHoiThiById(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 757, 47);
		panel.setBackground(new Color(72, 209, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbID = new JLabel("ID: " + cauHoi.getId());
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbID.setBounds(29, 11, 216, 25);
		panel.add(lbID);
		
		JLabel lbTenMon = new JLabel("Môn học: " + cauHoi.getTenMH());
		lbTenMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenMon.setBounds(212, 11, 535, 25);
		panel.add(lbTenMon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 48, 757, 269);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 757, 169);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JTextArea txtCauHoi = new JTextArea();
		txtCauHoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCauHoi.setText("  Câu hỏi: " + cauHoi.getNoiDung());
		txtCauHoi.setBounds(0, 0, 757, 169);
		panel_3.add(txtCauHoi);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 168, 757, 101);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbA = new JRadioButton("A. " + cauHoi.getA());
		rdbA.setBounds(29, 18, 336, 23);
		panel_4.add(rdbA);
		
		JRadioButton rdbB = new JRadioButton("B. " + cauHoi.getB());
		rdbB.setBounds(397, 18, 336, 23);
		panel_4.add(rdbB);
		
		JRadioButton rdbC = new JRadioButton("C. " + cauHoi.getC());
		rdbC.setBounds(29, 58, 336, 23);
		panel_4.add(rdbC);
		
		JRadioButton rdbD = new JRadioButton("D. " + cauHoi.getD());
		rdbD.setBounds(397, 58, 336, 23);
		panel_4.add(rdbD);
		
		 ButtonGroup group = new ButtonGroup();
	        group.add(rdbA);
	        group.add(rdbB);
	        group.add(rdbC);
	        group.add(rdbD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(0, 317, 757, 47);
		contentPane.add(panel_2);
		
		JLabel lbDapAn = new JLabel("Đáp án: " + cauHoi.getDapAn());
		lbDapAn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDapAn.setBounds(29, 11, 216, 25);
		panel_2.add(lbDapAn);
		
		
	}

}
