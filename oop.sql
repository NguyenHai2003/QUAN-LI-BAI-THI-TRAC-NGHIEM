USE [master]
GO
/****** Object:  Database [ThiTracNghiem]    Script Date: 08/08/2024 11:11:14 CH ******/
CREATE DATABASE [ThiTracNghiem]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ThiTracNghiem', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ThiTracNghiem.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ThiTracNghiem_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ThiTracNghiem_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ThiTracNghiem] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ThiTracNghiem].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ThiTracNghiem] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET ARITHABORT OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ThiTracNghiem] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ThiTracNghiem] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ThiTracNghiem] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ThiTracNghiem] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET RECOVERY FULL 
GO
ALTER DATABASE [ThiTracNghiem] SET  MULTI_USER 
GO
ALTER DATABASE [ThiTracNghiem] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ThiTracNghiem] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ThiTracNghiem] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ThiTracNghiem] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ThiTracNghiem] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ThiTracNghiem', N'ON'
GO
USE [ThiTracNghiem]
GO
/****** Object:  Table [dbo].[BaiThi]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BaiThi](
	[maBaiThi] [varchar](10) NOT NULL,
	[maMH] [varchar](10) NOT NULL,
	[maSV] [varchar](10) NOT NULL,
	[maDotThi] [varchar](100) NOT NULL,
	[soPhutThi] [int] NOT NULL,
	[diem] [float] NULL,
 CONSTRAINT [PK_BaiThi_1] PRIMARY KEY CLUSTERED 
(
	[maBaiThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CauDaChon]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CauDaChon](
	[maBaiThi] [varchar](10) NOT NULL,
	[id] [varchar](10) NOT NULL,
	[cauDaChon] [nvarchar](10) NULL,
 CONSTRAINT [PK_BaiThi] PRIMARY KEY CLUSTERED 
(
	[maBaiThi] ASC,
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CauHoiThi]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CauHoiThi](
	[id] [varchar](10) NOT NULL,
	[noiDung] [nvarchar](max) NOT NULL,
	[a] [nvarchar](max) NOT NULL,
	[b] [nvarchar](max) NOT NULL,
	[c] [nvarchar](max) NOT NULL,
	[d] [nvarchar](max) NOT NULL,
	[dapAn] [nvarchar](10) NOT NULL,
	[maMH] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GiaoVien]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[GiaoVien](
	[maGV] [varchar](10) NOT NULL,
	[ho] [nvarchar](50) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[CMND] [nvarchar](20) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[queQuan] [nvarchar](100) NOT NULL,
	[hocVi] [nvarchar](100) NOT NULL,
	[maTK] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Lop]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Lop](
	[maLop] [varchar](10) NOT NULL,
	[tenLop] [nvarchar](100) NOT NULL,
	[nienKhoa] [nvarchar](9) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MonHoc]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MonHoc](
	[maMH] [varchar](10) NOT NULL,
	[tenMH] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maMH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NienKhoa]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NienKhoa](
	[nienKhoa] [nvarchar](9) NOT NULL,
 CONSTRAINT [PK_NienKhoa] PRIMARY KEY CLUSTERED 
(
	[nienKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SinhVien](
	[maSV] [varchar](10) NOT NULL,
	[ho] [nvarchar](50) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[CMND] [varchar](20) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[queQuan] [nvarchar](250) NOT NULL,
	[SDT] [nchar](10) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[maLop] [varchar](10) NOT NULL,
	[maTK] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[maSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [varchar](10) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[vaiTro] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[BaiThi] ([maBaiThi], [maMH], [maSV], [maDotThi], [soPhutThi], [diem]) VALUES (N'485a3e8f06', N'MH001', N'SV001', N'test_hk1_2024-2025', 1, 10)
INSERT [dbo].[CauDaChon] ([maBaiThi], [id], [cauDaChon]) VALUES (N'485a3e8f06', N'CH001', N'B')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH001', N'Giá trị của hàm số sin(π/2) là bao nhiêu?', N'0', N'1', N'-1', N'π', N'B', N'MH001')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH002', N'Tích phân của hàm số 1/x trên đoạn [1, e] là bao nhiêu?', N'1', N'ln(e)', N'e', N'2', N'B', N'MH001')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH003', N'Giá trị của đạo hàm hàm số x^2 tại x=1 là bao nhiêu?', N'0', N'1', N'2', N'3', N'C', N'MH001')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH004', N'Giá trị của giới hạn lim(x→0) sin(x)/x là bao nhiêu?', N'1', N'0', N'∞', N'-1', N'A', N'MH001')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH005', N'Tích phân của hàm số sin(x) từ 0 đến π là bao nhiêu?', N'2', N'π', N'0', N'1', N'B', N'MH001')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH006', N'Java có mấy đặc điểm chung?', N'3', N'2', N'4', N'1', N'C', N'MH002')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH007', N'Từ khóa nào dùng để khai báo lớp trong Java?', N'object', N'class', N'interface', N'package', N'B', N'MH002')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH008', N'Phương thức main() trong Java phải khai báo là gì?', N'public static void main(String[] args)', N'public void main()', N'void main()', N'public static main()', N'A', N'MH002')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH009', N'Java có hỗ trợ đa kế thừa trực tiếp không?', N'Có', N'Không', N'Có nhưng có điều kiện', N'Không biết', N'B', N'MH002')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH010', N'Kiểu nào sau đâu là kiểu số nguyên?', N'int', N'boolean', N'float', N'double', N'A', N'MH002')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH011', N'Từ nào đồng nghĩa với "happy"?', N'Sad', N'Joyful', N'Tired', N'Angry', N'B', N'MH003')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH012', N'Từ "cat" trong tiếng Anh nghĩa là gì?', N'Con mèo', N'Con chó', N'Con chuột', N'Con thỏ', N'A', N'MH003')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH013', N'Thì quá khứ của động từ "go" là gì?', N'Gone', N'Went', N'Go', N'Going', N'B', N'MH003')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH014', N'Giới từ "on" trong tiếng Anh dùng để chỉ gì??', N'Nơi chốn', N'Thời gian', N'Cả hai', N'Không cái nào', N'C', N'MH003')
INSERT [dbo].[CauHoiThi] ([id], [noiDung], [a], [b], [c], [d], [dapAn], [maMH]) VALUES (N'CH015', N'Từ nào là tính từ trong câu "She is a beautiful girl"?', N'She', N'is', N'beautiful', N'girl', N'C', N'MH003')
INSERT [dbo].[GiaoVien] ([maGV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [hocVi], [maTK]) VALUES (N'GV001', N'Nguyen', N'Van Tan', N'123456789', CAST(N'1985-05-15' AS Date), N'Nam', N'Ha Noi', N'Tien si', N'GV001')
INSERT [dbo].[GiaoVien] ([maGV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [hocVi], [maTK]) VALUES (N'GV002', N'Tran', N'Thi Thanh ', N'987654321', CAST(N'1985-05-22' AS Date), N'Nu', N'Ho Chi Minh', N'Cu nhan', N'GV002')
INSERT [dbo].[Lop] ([maLop], [tenLop], [nienKhoa]) VALUES (N'ATTT', N'An toan thong tin', N'2021-2026')
INSERT [dbo].[Lop] ([maLop], [tenLop], [nienKhoa]) VALUES (N'CNTT', N'Cong nghe thong tin 2', N'2021-2026')
INSERT [dbo].[Lop] ([maLop], [tenLop], [nienKhoa]) VALUES (N'KT', N'Ke toan', N'2021-2025')
INSERT [dbo].[Lop] ([maLop], [tenLop], [nienKhoa]) VALUES (N'MKT', N'Marketing', N'2021-2025')
INSERT [dbo].[MonHoc] ([maMH], [tenMH]) VALUES (N'MH001', N'Giai tich')
INSERT [dbo].[MonHoc] ([maMH], [tenMH]) VALUES (N'MH002', N'Lap trinh huong doi tuong')
INSERT [dbo].[MonHoc] ([maMH], [tenMH]) VALUES (N'MH003', N'Tieng Anh 2')
INSERT [dbo].[NienKhoa] ([nienKhoa]) VALUES (N'2024-2025')
INSERT [dbo].[NienKhoa] ([nienKhoa]) VALUES (N'2025-2026')
INSERT [dbo].[SinhVien] ([maSV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [SDT], [email], [maLop], [maTK]) VALUES (N'SV001', N'Nguyen', N'Van B', N'112233445', CAST(N'2005-08-19' AS Date), N'Nam', N'Hanoi', N'123       ', N'a@gmail.com', N'CNTT', N'SV001')
INSERT [dbo].[SinhVien] ([maSV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [SDT], [email], [maLop], [maTK]) VALUES (N'SV002', N'Le', N'Thi Dao', N'223344556', CAST(N'2006-11-30' AS Date), N'Nu', N'Hai Phong', N'1234      ', N'b@gmail.com', N'ATTT', NULL)
INSERT [dbo].[SinhVien] ([maSV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [SDT], [email], [maLop], [maTK]) VALUES (N'SV003', N'Tran', N'A', N'3424321221', CAST(N'2003-11-05' AS Date), N'Nam', N'Ho Chi Minh', N'12354     ', N'c@gmail.com', N'CNTT', N'SV003')
INSERT [dbo].[SinhVien] ([maSV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [SDT], [email], [maLop], [maTK]) VALUES (N'SV004', N'Nguyen', N'Lam', N'123121', CAST(N'2003-02-21' AS Date), N'Nam', N'Binh Dinh', N'12314     ', N'tyas@gmail.com', N'CNTT', N'SV004')
INSERT [dbo].[SinhVien] ([maSV], [ho], [ten], [CMND], [ngaySinh], [gioiTinh], [queQuan], [SDT], [email], [maLop], [maTK]) VALUES (N'SV005', N'Dao', N'Huy', N'1353515', CAST(N'2002-05-17' AS Date), N'Nam', N'Da Nang', N'51351     ', N'fjshj@gmail.com', N'CNTT', N'SV005')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'GV001', N'1234', N'Giáo viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'GV002', N'1234', N'Giáo viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'GV005', N'1234', N'Sinh viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'SV001', N'1234', N'Sinh viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'SV002', N'1234', N'Sinh viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'SV003', N'1234', N'Sinh viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'SV004', N'1234', N'Sinh viên')
INSERT [dbo].[TaiKhoan] ([maTK], [password], [vaiTro]) VALUES (N'SV005', N'1234', N'Sinh viên')
ALTER TABLE [dbo].[BaiThi]  WITH CHECK ADD  CONSTRAINT [FK_BaiThi_MonHoc] FOREIGN KEY([maMH])
REFERENCES [dbo].[MonHoc] ([maMH])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[BaiThi] CHECK CONSTRAINT [FK_BaiThi_MonHoc]
GO
ALTER TABLE [dbo].[BaiThi]  WITH CHECK ADD  CONSTRAINT [FK_BaiThi_SinhVien] FOREIGN KEY([maSV])
REFERENCES [dbo].[SinhVien] ([maSV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[BaiThi] CHECK CONSTRAINT [FK_BaiThi_SinhVien]
GO
ALTER TABLE [dbo].[CauDaChon]  WITH CHECK ADD  CONSTRAINT [FK_BaiThi_CauHoiThi] FOREIGN KEY([id])
REFERENCES [dbo].[CauHoiThi] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CauDaChon] CHECK CONSTRAINT [FK_BaiThi_CauHoiThi]
GO
ALTER TABLE [dbo].[CauDaChon]  WITH CHECK ADD  CONSTRAINT [FK_CauDaChon_BaiThi] FOREIGN KEY([maBaiThi])
REFERENCES [dbo].[BaiThi] ([maBaiThi])
GO
ALTER TABLE [dbo].[CauDaChon] CHECK CONSTRAINT [FK_CauDaChon_BaiThi]
GO
ALTER TABLE [dbo].[CauHoiThi]  WITH CHECK ADD  CONSTRAINT [FK_CauHoiThi_MonHoc] FOREIGN KEY([maMH])
REFERENCES [dbo].[MonHoc] ([maMH])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CauHoiThi] CHECK CONSTRAINT [FK_CauHoiThi_MonHoc]
GO
ALTER TABLE [dbo].[GiaoVien]  WITH CHECK ADD  CONSTRAINT [FK_GiaoVien_TaiKhoan1] FOREIGN KEY([maTK])
REFERENCES [dbo].[TaiKhoan] ([maTK])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[GiaoVien] CHECK CONSTRAINT [FK_GiaoVien_TaiKhoan1]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_Lop] FOREIGN KEY([maLop])
REFERENCES [dbo].[Lop] ([maLop])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_Lop]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_TaiKhoan] FOREIGN KEY([maTK])
REFERENCES [dbo].[TaiKhoan] ([maTK])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_TaiKhoan]
GO
/****** Object:  StoredProcedure [dbo].[sp_TinhDiemBaiThi]    Script Date: 08/08/2024 11:11:14 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_TinhDiemBaiThi]
    @maBaiThi VARCHAR(10),
    @diem FLOAT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @soCauDung INT;
    DECLARE @tongCauChon INT;
    SET @soCauDung = 0;
    SET @tongCauChon = 0;

    SELECT @soCauDung = COUNT(*)
    FROM [dbo].[CauDaChon] AS cdc
    INNER JOIN [dbo].[CauHoiThi] AS cht
    ON cdc.[id] = cht.[id]
    WHERE cdc.[maBaiThi] = @maBaiThi
      AND cdc.[cauDaChon] = cht.[dapAn];

    SELECT @tongCauChon = COUNT(*)
    FROM [dbo].[CauDaChon]
    WHERE [maBaiThi] = @maBaiThi;

    IF @tongCauChon > 0
    BEGIN
        SET @diem = CAST(@soCauDung AS FLOAT) / CAST(@tongCauChon AS FLOAT) * 10.0;
    END
    ELSE
    BEGIN
        SET @diem = 0;
    END
END


GO
USE [master]
GO
ALTER DATABASE [ThiTracNghiem] SET  READ_WRITE 
GO
