package appTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CauHoiThi;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Thi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<CauHoiThi> listCauHoi;
    private int thoiGian; // thời gian tính theo giây
    private int currentIndex = 0; // Lưu chỉ số câu hỏi hiện tại
    private JTextArea txtCauHoi;
    private JRadioButton rdbA, rdbB, rdbC, rdbD;
    private JLabel lbIndex, lbCountdown;
    private Timer timer;

    public Thi(List<CauHoiThi> ListCauHoi, int thoiGianPhut) {
        this.listCauHoi = ListCauHoi;
        this.thoiGian = thoiGianPhut * 60; // Chuyển đổi phút sang giây
        initialize();
        startCountdown();
        loadCauHoi(currentIndex);
    }

    private void initialize() {
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

        JLabel lbTenMon = new JLabel("Môn học: " + listCauHoi.get(0).getTenMH());
        lbTenMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbTenMon.setBounds(10, 10, 266, 25);
        panel.add(lbTenMon);

        lbCountdown = new JLabel("Thời gian: " + formatTime(thoiGian));
        lbCountdown.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbCountdown.setBounds(368, 10, 223, 25);
        panel.add(lbCountdown);

        JButton btnNop = new JButton("Nộp bài");
        btnNop.setBounds(662, 14, 85, 21);
        btnNop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitExam();
            }
        });
        panel.add(btnNop);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 48, 757, 269);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 757, 169);
        panel_1.add(panel_3);
        panel_3.setLayout(null);

        txtCauHoi = new JTextArea();
        txtCauHoi.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtCauHoi.setBounds(0, 0, 757, 169);
        panel_3.add(txtCauHoi);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 168, 757, 101);
        panel_1.add(panel_4);
        panel_4.setLayout(null);

        rdbA = new JRadioButton("A. ");
        rdbA.setBounds(29, 18, 336, 23);
        panel_4.add(rdbA);

        rdbB = new JRadioButton("B. ");
        rdbB.setBounds(397, 18, 336, 23);
        panel_4.add(rdbB);

        rdbC = new JRadioButton("C. ");
        rdbC.setBounds(29, 58, 336, 23);
        panel_4.add(rdbC);

        rdbD = new JRadioButton("D. ");
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

        JButton btnTruoc = new JButton("Trước");
        btnTruoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPreviousQuestion();
            }
        });
        btnTruoc.setBounds(251, 10, 92, 27);
        panel_2.add(btnTruoc);

        JButton btnSau = new JButton("Sau");
        btnSau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextQuestion();
            }
        });
        btnSau.setBounds(403, 10, 92, 27);
        panel_2.add(btnSau);

        lbIndex = new JLabel("1 / " + listCauHoi.size());
        lbIndex.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbIndex.setBounds(606, 10, 82, 27);
        panel_2.add(lbIndex);
    }

    private void loadCauHoi(int index) {
        if (index >= 0 && index < listCauHoi.size()) {
            CauHoiThi cauHoi = listCauHoi.get(index);
            txtCauHoi.setText("Câu hỏi: " + cauHoi.getNoiDung());
            rdbA.setText("A. " + cauHoi.getA());
            rdbB.setText("B. " + cauHoi.getB());
            rdbC.setText("C. " + cauHoi.getC());
            rdbD.setText("D. " + cauHoi.getD());
            lbIndex.setText((index + 1) + " / " + listCauHoi.size());
        }
    }

    private void showPreviousQuestion() {
        if (currentIndex > 0) {
            currentIndex--;
            loadCauHoi(currentIndex);
        }
    }

    private void showNextQuestion() {
        if (currentIndex < listCauHoi.size() - 1) {
            currentIndex++;
            loadCauHoi(currentIndex);
        }
    }

    private void submitExam() {
        timer.stop(); 
        JOptionPane.showMessageDialog(this, "Đã nộp bài!");
    }

    private void startCountdown() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thoiGian--;
                lbCountdown.setText("Thời gian: " + formatTime(thoiGian));
                if (thoiGian <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(Thi.this, "Hết thời gian!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    submitExam();
                }
            }
        });
        timer.start();
    }

    private String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}
