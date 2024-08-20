package appTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.GiaoVienDAO;
import DAO.SinhVienDAO;
import DAO.TaiKhoanDAO;
import model.GiaoVien;
import model.SinhVien;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTDN;
	private JTextField txtMK;
	public static SinhVien sinhVien;
	public static GiaoVien giaoVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(84, 68, 135, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setBounds(84, 124, 135, 26);
		contentPane.add(lblMtKhu);
		
		txtTDN = new JTextField();
		txtTDN.setBounds(201, 68, 295, 26);
		contentPane.add(txtTDN);
		txtTDN.setColumns(10);
		
		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(201, 124, 295, 26);
		contentPane.add(txtMK);
		
		JButton btnDN = new JButton("Đăng nhập");
		btnDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(TaiKhoanDAO.checkLogin(txtTDN.getText(), txtMK.getText()) == true) {
						if(TaiKhoanDAO.getVaiTroByMaTK(txtTDN.getText()).equals("Sinh viên")) {
							sinhVien = TaiKhoanDAO.getSinhVienByMaTK(txtTDN.getText());
						}
						else if(TaiKhoanDAO.getVaiTroByMaTK(txtTDN.getText()).equals("Giáo viên")) {
							giaoVien = TaiKhoanDAO.getGiaoVienByMaTK(txtTDN.getText());
						}
						System.out.println(sinhVien.getMaTK());
						ThongTinThi frame = new ThongTinThi();
						frame.setVisible(true);
					}
						
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDN.setBounds(265, 195, 111, 26);
		contentPane.add(btnDN);
		
		
	}
}
