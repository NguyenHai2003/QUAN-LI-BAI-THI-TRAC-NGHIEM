package appTest;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

import DAO.CauHoiThiDAO;
import model.CauHoiThi;

public class CauHoiThiForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CauHoiThiForm frame = new CauHoiThiForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CauHoiThiForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1143, 589);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1129, 52);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(10, 10, 85, 32);
        panel.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.setBounds(129, 10, 85, 32);
        panel.add(btnSua);

        JButton btnXoa = new JButton("Xoa");
        btnXoa.setBounds(246, 10, 85, 32);
        panel.add(btnXoa);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(378, 10, 85, 32);
        panel.add(btnLuu);

        JButton btnTim = new JButton("Tìm");
        btnTim.setBounds(508, 10, 85, 32);
        panel.add(btnTim);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBounds(642, 10, 85, 32);
        panel.add(btnThoat);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 49, 1129, 503);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "ID", "Mã môn", "Câu hỏi", "Chi tiết"
            }
        ));

        table.getColumn("Chi tiết").setCellRenderer(new ButtonRenderer());
        table.getColumn("Chi tiết").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        TableColumn idColumn = table.getColumnModel().getColumn(0);
        TableColumn maMonColumn = table.getColumnModel().getColumn(1);
        TableColumn cauHoiColumn = table.getColumnModel().getColumn(2);
        TableColumn chiTietColumn = table.getColumnModel().getColumn(3);

        idColumn.setPreferredWidth(50); 
        maMonColumn.setPreferredWidth(100); 
        cauHoiColumn.setPreferredWidth(700); 
        chiTietColumn.setPreferredWidth(100); 

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1129, 343);
        panel_1.add(scrollPane);

        importDataToTable();
    }

    private void importDataToTable() {
        List<CauHoiThi> listCauHoi = new ArrayList<>();
        try {
            CauHoiThiDAO chDAO = new CauHoiThiDAO();
            listCauHoi = chDAO.getAllCauHoiThi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (CauHoiThi ch : listCauHoi) {
            model.addRow(new Object[]{ch.getId(), ch.getMaMH(), ch.getNoiDung(), "Chi tiết"});
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Chi tiết" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "Chi tiết" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
        	if (isPushed) {
                int selectedRow = table.getSelectedRow();
                String id = table.getValueAt(selectedRow, 0).toString();
                ChiTietCauHoiThiForm frame = new ChiTietCauHoiThiForm(id);
                frame.setVisible(true);
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
