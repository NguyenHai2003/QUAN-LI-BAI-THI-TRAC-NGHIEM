package appTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CauHoiThiDAO;
import DAO.MonHocDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import appTest.Login;
import model.CauHoiThi;
import model.MonHoc;
import model.SinhVien; 
import helper.EditHelper;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ThongTinThi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int soLuongCau = 0;
	private int thoiGian = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinThi frame = new ThongTinThi();
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
	public ThongTinThi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 768, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbMaSV = new JLabel("Mã sinh viên: "+Login.sinhVien.getMaSV());
		lbMaSV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbMaSV.setBounds(10, 10, 202, 13);
		panel.add(lbMaSV);
		
		JLabel lbHoTen = new JLabel("Họ tên: "+Login.sinhVien.getHo() +" "+ Login.sinhVien.getTen());
		lbHoTen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbHoTen.setBounds(10, 33, 202, 13);
		panel.add(lbHoTen);
		
		
		JLabel lbNgaySinh = new JLabel("Ngày sinh: "+ Login.sinhVien.getNgaySinh());
		lbNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbNgaySinh.setBounds(390, 10, 278, 13);
		panel.add(lbNgaySinh);
		
		JLabel lbGioiTinh = new JLabel("Giới tính: "+Login.sinhVien.getGioiTinh());
		lbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbGioiTinh.setBounds(390, 33, 278, 13);
		panel.add(lbGioiTinh);
		
		JLabel lbQueQuan = new JLabel("Quê quán: "+Login.sinhVien.getQueQuan());
		lbQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbQueQuan.setBounds(390, 56, 278, 13);
		panel.add(lbQueQuan);
		
		JLabel lbCMND = new JLabel("CMND: "+Login.sinhVien.getCMND());
		lbCMND.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbCMND.setBounds(10, 56, 202, 13);
		panel.add(lbCMND);
		
		JComboBox cbMonHoc = new JComboBox();
		cbMonHoc.setBounds(221, 167, 376, 21);
		contentPane.add(cbMonHoc);
		try {
			for(MonHoc mh : MonHocDAO.getAllMonHoc()) {
				cbMonHoc.addItem(mh.getTenMH());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JComboBox cbThoiGian = new JComboBox();
		cbThoiGian.setBounds(221, 240, 376, 21);
		contentPane.add(cbThoiGian);
		cbThoiGian.addItem("Vui lòng chọn bài kiểm tra");
		cbThoiGian.addItem("Test");
		cbThoiGian.addItem("15 phút");
		cbThoiGian.addItem("Giữa kỳ - 45 phút");
		cbThoiGian.addItem("Cuối kỳ - 90 phút");
	    cbMonHoc.setSelectedIndex(0); 
	    
		cbThoiGian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedTime = (String) cbThoiGian.getSelectedItem();
				switch (selectedTime) {
					case "Test":
						thoiGian = 1;
						soLuongCau = 1;
						break;
					case "15 phút":
						thoiGian = 15;
						soLuongCau = 15;
						break;
					case "Giữa kỳ - 45 phút":
						thoiGian = 45;
						soLuongCau = 45;
						break;
					case "Cuối kỳ - 90 phút":
						thoiGian = 90;
						soLuongCau = 90;
						break;
					case "Vui lòng chọn bài kiểm tra":
						thoiGian = 0;
						soLuongCau = 0;
						break;
				}
			}
		});
		
		JButton btnThi = new JButton("Thi");
		btnThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thoiGian != 0 && soLuongCau != 0) {
					Thi frame = null;
					try {
						
						List<CauHoiThi> listCauHoi = CauHoiThiDAO.getRandomCauHoiThi(soLuongCau, EditHelper.timMaMonHoc(cbMonHoc.getSelectedItem().toString(), MonHocDAO.getAllMonHoc()));
						frame = new Thi(listCauHoi, thoiGian);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					frame.setVisible(true);
				}
			}
		});
		btnThi.setBounds(357, 358, 85, 21);
		contentPane.add(btnThi);
		
		JLabel lblNewLabel = new JLabel("Môn:");
		lblNewLabel.setBounds(133, 171, 76, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lbKiemTra = new JLabel("Kiểm tra:");
		lbKiemTra.setBounds(133, 244, 85, 13);
		contentPane.add(lbKiemTra);
		
	}
}
