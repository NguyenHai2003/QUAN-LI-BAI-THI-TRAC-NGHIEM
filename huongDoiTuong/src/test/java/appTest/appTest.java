package appTest;
import DAO.BaiThiDAO;
import model.BaiThi;


public class appTest {
    public static void main(String[] args) {
        BaiThiDAO baiThiDAO = new BaiThiDAO();
        String maBaiThi = "BT002"; // Thay thế bằng mã bài thi thực tế mà bạn muốn kiểm tra
        
        try {
            // Tính điểm bài thi bằng mã bài thi cụ thể
            float diem = baiThiDAO.tinhDiemBaiThi(maBaiThi);
            // In điểm ra màn hình
            System.out.println("Điểm bài thi với mã " + maBaiThi + ": " + diem);
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra
            e.printStackTrace();
            System.out.println("Đã xảy ra lỗi khi tính điểm bài thi.");
        }
    }
}
