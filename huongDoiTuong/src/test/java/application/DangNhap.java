package application;

import javax.swing.JPanel;
import DAO.TaiKhoanDAO;
import model.GiaoVien;
import model.SinhVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class DangNhap extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtDangNhap;
    private JTextField txtMatKhau;
    public static SinhVien sinhVien = new SinhVien();
    public static GiaoVien giaoVien = new GiaoVien();

    public DangNhap() {
        setLayout(null); 

        JLabel lblNewLabel = new JLabel("HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(303, 42, 800, 50); 
        add(lblNewLabel);

        JLabel lblCSTi = new JLabel("CƠ SỞ TẠI TP HỒ CHÍ MINH");
        lblCSTi.setHorizontalAlignment(SwingConstants.CENTER);
        lblCSTi.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblCSTi.setBounds(303, 102, 800, 50);
        add(lblCSTi);

        JLabel lblThiTrcNghim = new JLabel("THI TRẮC NGHIỆM");
        lblThiTrcNghim.setHorizontalAlignment(SwingConstants.CENTER);
        lblThiTrcNghim.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblThiTrcNghim.setBounds(291, 322, 800, 50); 
        add(lblThiTrcNghim);

        JLabel lblNewLabel_1 = new JLabel(" Tên đăng nhập:");
        lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/images/login.png")));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(466, 399, 183, 30);
        add(lblNewLabel_1);

        txtDangNhap = new JTextField();
        txtDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDangNhap.setBounds(692, 399, 300, 30);
        add(txtDangNhap);

        JLabel lblNewLabel_1_1 = new JLabel(" Mật khẩu:");
        lblNewLabel_1_1.setIcon(new ImageIcon(Home.class.getResource("/images/key.png")));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(466, 449, 183, 30);
        add(lblNewLabel_1_1);

        txtMatKhau = new JTextField();
        txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtMatKhau.setBounds(692, 449, 300, 30);
        add(txtMatKhau);

        JButton btnDangNhap = new JButton("Đăng nhập");
        btnDangNhap.setBackground(new Color(192, 192, 192));
        btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDangNhap.setBounds(469, 528, 150, 40);
        btnDangNhap.addActionListener(e -> {
            try {
                if (TaiKhoanDAO.checkLogin(txtDangNhap.getText(), txtMatKhau.getText())) {
                    if (TaiKhoanDAO.getVaiTroByMaTK(txtDangNhap.getText()).equals("Sinh viên")) {
                        sinhVien = TaiKhoanDAO.getSinhVienByMaTK(txtDangNhap.getText());
                    } else if (TaiKhoanDAO.getVaiTroByMaTK(txtDangNhap.getText()).equals("Giáo viên")) {
                        giaoVien = TaiKhoanDAO.getGiaoVienByMaTK(txtDangNhap.getText());
                    }
                    System.out.println(sinhVien.getMaTK());
                    JOptionPane.showMessageDialog(DangNhap.this, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        add(btnDangNhap);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/images/ptit.jpg")));
        lblNewLabel_2.setBounds(589, 162, 200, 150);
        add(lblNewLabel_2);
    }
}

