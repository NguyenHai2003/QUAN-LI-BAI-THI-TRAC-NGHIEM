# Đồ án môn Lập trình hướng đối tượng - OOP
## Ứng dụng Quản lý Thi Trắc Nghiệm

Ứng dụng này cung cấp các chức năng để quản lý thi trắc nghiệm, bao gồm quản lý môn học, lớp học, sinh viên, điểm thi, câu hỏi thi và các chức năng liên quan đến thi trắc nghiệm. Ứng dụng được tổ chức thành nhiều phần chính, mỗi phần cung cấp các tính năng cụ thể.

## Chức năng của Chương trình

### A. Đăng nhập
- Đăng nhập dựa vào mã sinh viên và password.
- Nếu tài khoản đăng nhập là GV và pass là GV thì sẽ có toàn quyền.

### B. Quản lý (Giáo viên)
1. **Quản lí lớp học**
    - Thêm, xóa, hiệu chỉnh thông tin các lớp.
2. **Quản lí sinh viên**
    - Thêm, xóa, hiệu chỉnh thông tin sinh viên theo mã lớp.
3. **Quản lí môn học**
    - Thêm, xóa, hiệu chỉnh thông tin của môn học.
4. **Quản lí câu hỏi thi**
   - Thêm, xóa, hiệu chỉnh thông tin của môn học.
   - Mỗi câu hỏi có một ID.
5. **Xem điểm thi**
   - Xem điểm thi môn học của một lớp.
### C. Sinh viên
1. **Thi Trắc nghiệm**
    - Trước khi thi, hỏi người thi môn thi, số câu hỏi thi, số phút thi.
    - Lấy ngẫu nhiên các câu hỏi trong danh sách câu hỏi thi của môn.
      
2. **In Chi tiết các Câu hỏi đã thi của một Môn học của một Sinh viên**
    - In chi tiết các câu hỏi đã thi của một môn học cho một sinh viên.

3. **In Bảng điểm Thi Trắc nghiệm của một Môn học của một Lớp**
    - Nếu có sinh viên chưa thi thì ghi “Chưa thi”.

---
