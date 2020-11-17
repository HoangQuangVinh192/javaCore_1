
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		ArrayList<SinhVien> dsSV = new ArrayList<>();
		ArrayList<MonHoc> dsMH = new ArrayList<>();
		ArrayList<Diem> dsDiem = new ArrayList<>();
		docFile(dsSV);
		docFileMonHoc(dsMH);
		docFileDiem(dsDiem);
		
		
		Scanner sc = new Scanner(System.in);
		int chon= -1;
		do {
			
			System.out.println("\t========== Quản lý sinh viên============");
			System.out.println("\t1. Cập nhật danh sách");
			System.out.println("\t2. Hiển thị bảng điểm");
			System.out.println("\t3. Tìm kiếm");
			System.out.println("\t4. Thoát");
			System.out.print("Nhập lựa chọn: ");
			chon=sc.nextInt();
			switch (chon) {
			case 1:
				int chon1=-1;
				do {
					System.out.println("################################");
					System.out.println("\t\t Cập nhật danh sách");
					System.out.println("\t1. Cập nhật danh sách sinh viên");
					System.out.println("\t2. Cập nhật danh sách môn học");
					System.out.println("\t3. Cập nhật bảng điểm");
					System.out.println("\t4. Thoát");
					System.out.print("Nhập lựa chọn: ");
					chon1=sc.nextInt();
					switch(chon1) {
					case 1:
						int chon11=-1;
						do {
							System.out.println("################################");
							System.out.println("\t\t Cập nhật danh sách sinh viên");
							System.out.println("\t1. Thêm sinh viên");
							System.out.println("\t2. Sửa sinh viên");
							System.out.println("\t3. Xóa sinh viên");
							System.out.println("\t4. Hiển thị danh sách");
							System.out.println("\t5. Thoát");
							System.out.print("Nhập lựa chọn: ");
							chon11=sc.nextInt();
							switch (chon11) {
							case 1:
								themSV(dsSV);
								break;
							case 2:
								suaSV(dsSV);
								break;
							case 3:
								xoaSV(dsSV, dsDiem);
								break;
							case 4:
								SapXepDSSV(dsSV);
								hienThiDSSinhVien(dsSV);
								break;
							case 5:
								break;
							default:
								System.out.println("Nhập sai yêu cầu");
								break;
							}
						}while(chon11!=5);
						
						break;
					case 2:
						int chon12=-1;
						do {
							System.out.println("################################");
							System.out.println("\t\t Cập nhật danh sách môn học");
							System.out.println("\t1. Thêm môn học");
							System.out.println("\t2. Sửa môn học");
							System.out.println("\t3. Xóa môn học");
							System.out.println("\t4. Hiển thị danh sách");
							System.out.println("\t5. Thoát");
							System.out.print("Nhập lựa chọn: ");
							chon12=sc.nextInt();
							switch (chon12) {
							case 1:
								themMonHoc(dsMH);
								break;
							case 2:
								suaMonHoc(dsMH);
								break;
							case 3:
								xoaMH(dsMH, dsDiem);
								break;
							case 4:
								SapXepDSMH(dsMH);
								hienThiDSMonHoc(dsMH);
								break;
							case 5:
								break;
							default:
								System.out.println("Nhập sai yêu cầu");
								break;
							}
						}while(chon12!=5);
						break;
					case 3:
						int chon13=-1;
						do {
							System.out.println("################################");
							System.out.println("\t\t Cập nhật danh sách môn học");
							System.out.println("\t1. Nhập điểm");
							System.out.println("\t2. Sửa điểm");
							System.out.println("\t3. Xóa điểm");
							System.out.println("\t4. Thoát");
							System.out.print("Nhập lựa chọn: ");
							chon13=sc.nextInt();
							switch (chon13) {
							case 1:
								nhapDiem(dsDiem, dsSV, dsMH);
								break;
							case 2:
								suaDiem(dsDiem);
								break;
							case 3:
								xoaDiem(dsDiem);
								break;
							case 4:
								break;
							default:
								System.out.println("Nhập sai yêu cầu");
								break;
							}
						}while(chon13!=4);
						break;
					case 4:
						ghiFile(dsSV);
						ghiFileDiem(dsDiem);
						ghiFileMonHoc(dsMH);
						break;
					default:
						System.out.println("Nhập sai yêu cầu");
						break;
					}
				}while(chon1!=4);
				break;
			case 2:
				int chon2=-1;
				do {
					System.out.println("################################");
					System.out.println("\t\t Hiển thị bảng điểm");
					System.out.println("\t1. Theo sinh viên");
					System.out.println("\t2. Theo môn học");
					System.out.println("\t3. Thoát");
					System.out.print("Nhập lựa chọn: ");
					chon2=sc.nextInt();
					switch (chon2) {
					case 1:
						hienThiBangDiemSV(dsSV, dsMH, dsDiem);
						break;
					case 2:
						hienThiDSSVTheoMonHoc(dsSV, dsMH, dsDiem);
						break;
					case 3:
						break;
					default:
						System.out.println("Nhập sai yêu cầu");
						break;
					}
				}while(chon2!=3);
				break;
			case 3:
				int chon3=-1;
				do {
					System.out.println("################################");
					System.out.println("\t\t Tìm kiếm");
					System.out.println("\t1. Tìm sinh viên");
					System.out.println("\t2. Tìm môn học");
					System.out.println("\t3. Thoát");
					System.out.print("Nhập lựa chọn: ");
					chon3=sc.nextInt();
					switch (chon3) {
					case 1:
						timKiemSinhVien(dsSV, dsMH, dsDiem);
						break;
					case 2:
						timKiemMonHoc(dsSV, dsMH, dsDiem);
						break;
					case 3:
						break;
					default:
						System.out.println("Nhập sai yêu cầu");
						break;
					}
				}while(chon3!=3);
				break;
			case 4:
				System.out.println("========Kết thúc chương trình========");
				break;
			default:
				System.out.println("Nhập lại yêu cầu");
				break;
			}
		}while(chon!=4);
		
	}

	private static void hienThiDSMonHoc(ArrayList<MonHoc> dsMH) {
		System.out.println("--->Danh sách môn học:");
		System.out.printf("\t%-15s%-30s%-10s\n", "Mã môn học", "Tên môn học", "Hệ số");
		for (MonHoc i : dsMH) {
			System.out.printf("\t%-15s%-30s%-10.1f\n",i.getMaMonHoc(), i.getTenMonHoc(), i.getHeSo());
		}
	}

	private static void hienThiDSSinhVien(ArrayList<SinhVien> dsSV) {
		System.out.println("--->Danh sách sinh viên:");
		System.out.printf("\t%-15s%-20s%-15s%-15s%-15s\n","Mã sinh viên","Họ đệm", "Tên sinh viên", "Ngày sinh", "Giới tính");
		int trang=50;
		Scanner sc = new Scanner(System.in);
		int i=trang-50;
		while(i<trang)
		{
			System.out.printf("\t%-15s%-20s%-15s%-15s%-15s\n",dsSV.get(i).getMaSV(), dsSV.get(i).getHoDem(), dsSV.get(i).getTen(), dsSV.get(i).getNgay()+"/"+dsSV.get(i).getThang()+"/"+dsSV.get(i).getNam(), dsSV.get(i).getGt());
			if(i==trang-1)
			{
				do {
					System.out.print("Nhập số trang 1,2,3,4,5,..."+(dsSV.size()/50-1)+","+(dsSV.size()/50)+","+(dsSV.size()/50+1)+"(0 để thoát): ");
					trang=sc.nextInt();
					if(trang==dsSV.size()/50+1)
					{
						i=(dsSV.size()/50 *50)-1;
						trang=dsSV.size();
					}
					else {
						trang=trang*50;
						i=trang-51;
					}
				} while(trang>dsSV.size());
				if(trang==0)
					break;
			}
			i++;
		}
		
	}

	private static void timKiemMonHoc(ArrayList<SinhVien> dsSV, ArrayList<MonHoc> dsMH, ArrayList<Diem> dsDiem) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhập mã môn học cần tìm: ");
		String maTim=sc.nextLine();
		boolean check=false;
		for(int i=0; i<dsMH.size(); i++)
		{
			if(dsMH.get(i).getMaMonHoc().trim().equals(maTim.trim()))
			{
				System.out.println("----->Tìm kiếm thành công");
				check=true;
				System.out.println("Tên môn học: "+dsMH.get(i).getTenMonHoc());
				float diemTB = 0;
				int dem=0;
				ArrayList<String> dsSVHoc= new ArrayList<>();
				ArrayList<Float> dsDiemSV= new ArrayList<>();
				for(int j=0; j<dsDiem.size(); j++)
				{
					if(dsMH.get(i).getMaMonHoc().trim().equals(dsDiem.get(j).getMaMonHoc().trim()))
					{
						dsSVHoc.add(dsDiem.get(j).getMaSV());
						dsDiemSV.add(dsDiem.get(j).getDiem());
						diemTB+=dsDiem.get(j).getDiem();
						dem++;
					}
				}
				if(dem==0)
				{
					System.out.println("-----> Môn học không có sinh viên");
				}
				else
				{
					System.out.printf("\t\t%-10s%-30s%-10s\n","Mã sv","Họ tên", "Điểm");
					for (int j=0; j<dsSVHoc.size(); j++) {
						for (SinhVien jtem : dsSV) {
							if(dsSVHoc.get(j).equals(jtem.getMaSV()))
							{
								System.out.printf("\t\t%-10s%-30s%-10.2f\n",jtem.getMaSV(), jtem.getHoDem()+" "+jtem.getTen(), dsDiemSV.get(j));
							}
						}
					}
					System.out.printf("\t%-40s%5.2f\n","----------->Điểm trung bình chung: ",diemTB/dem);
				}
			}
			
		}
		if(check==false)
		{
			System.out.println("--->Không có môn học mã " + maTim);
		}
		System.out.println("---------------------------");
	}

	private static void timKiemSinhVien(ArrayList<SinhVien> dsSV, ArrayList<MonHoc> dsMH, ArrayList<Diem> dsDiem) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhập mã sinh viên: ");
		String maTim=sc.nextLine();
		boolean check=false;
		for(int i=0; i<dsSV.size(); i++)
		{
			if(dsSV.get(i).getMaSV().trim().equals(maTim.trim()))
			{
				System.out.println("---->Tìm kiếm thành công");
				check=true;
				ArrayList<String> dsMonHoc= new ArrayList<String>();
				ArrayList<Float> dsD= new ArrayList<Float>();
				System.out.println("Họ tên sinh viên: "+dsSV.get(i).getHoDem()+" "+dsSV.get(i).getTen());
				float tongDiem=0, tongHeSo=0;
				for(int j=0; j<dsDiem.size(); j++)
				{
					if(dsDiem.get(j).getMaSV().trim().equals(dsSV.get(i).getMaSV().trim()))
					{
						dsD.add(dsDiem.get(j).getDiem());
						
						for (MonHoc item : dsMH) {
							if(item.getMaMonHoc().trim().equals(dsDiem.get(j).getMaMonHoc().trim()))
							{
								dsMonHoc.add(item.getTenMonHoc());
								tongDiem+=dsDiem.get(j).getDiem()*item.getHeSo();
								tongHeSo+=item.getHeSo();
							}
						}
					}
				}
				if(tongDiem==0)
				{
					System.out.println("----->Sinh viên chưa học môn nào");
				}
				else
				{
					System.out.printf("\t\t%-25s%-10s\n","Môn học","Điểm");
					for(int k=0; k<dsMonHoc.size(); k++)
					{
						System.out.printf("\t\t%-25s%-10.2f\n",dsMonHoc.get(k), dsD.get(k));
					}
					System.out.printf("\t%20s%5.2f\n","------>Điểm tổng kết",tongDiem/tongHeSo);
				}
				break;
			}
		}
		if(check==false)
			System.out.println("Sinh viên không tồn tại");
		System.out.println("----------------------------------------");
	}

	private static void hienThiDSSVTheoMonHoc(ArrayList<SinhVien> dsSV, ArrayList<MonHoc> dsMH,
			ArrayList<Diem> dsDiem) {
		int trang=2;
		Scanner sc = new Scanner(System.in);
		int i=trang-2;
		while(i<trang)
		{
			System.out.println("Mã môn học: "+dsMH.get(i).getMaMonHoc());
			System.out.println("Tên môn học: "+dsMH.get(i).getTenMonHoc());
			float diemTB = 0;
			int dem=0;
			ArrayList<String> dsSVHoc= new ArrayList<>();
			ArrayList<Float> dsDiemSV= new ArrayList<>();
			for(int j=0; j<dsDiem.size(); j++)
			{
				if(dsMH.get(i).getMaMonHoc().trim().equals(dsDiem.get(j).getMaMonHoc().trim()))
				{
					dsSVHoc.add(dsDiem.get(j).getMaSV());
					dsDiemSV.add(dsDiem.get(j).getDiem());
					diemTB+=dsDiem.get(j).getDiem();
					dem++;
				}
			}
			if(dem==0)
			{
				System.out.println("-----> Môn học không có sinh viên");
			}
			else
			{
				System.out.printf("\t\t%-10s%-30s%-10s\n","Mã sv","Họ tên", "Điểm");
				for (int j=0; j<dsSVHoc.size(); j++) {
					for (SinhVien jtem : dsSV) {
						if(dsSVHoc.get(j).equals(jtem.getMaSV()))
						{
							System.out.printf("\t\t%-10s%-30s%-10.2f\n",jtem.getMaSV(), jtem.getHoDem()+" "+jtem.getTen(), dsDiemSV.get(j));
						}
					}
				}
				System.out.printf("\t%-40s%5.2f\n","----------->Điểm trung bình chung: ",diemTB/dem);
			}
			
			if(i==trang-1)
			{
				do {
					System.out.print("Nhập số trang 1,2,3,4,5,..."+(dsMH.size()/2-1)+","+(dsMH.size()/2)+","+(dsMH.size()/2+1)+"(0 để thoát): ");
					trang=sc.nextInt();
					if(trang==dsMH.size()/2+1)
					{
						i=(dsMH.size()/2 *2)-1;
						trang=dsMH.size();
						System.out.println(i+"  "+trang);
					}
					else {
						trang=trang*2;
						i=trang-3;
					}
				} while(trang>dsMH.size());
				if(trang==0)
					break;
			}
			i++;
			System.out.println("---------------------------");
		}
		
	}

	private static void hienThiBangDiemSV(ArrayList<SinhVien> dsSV, ArrayList<MonHoc> dsMH, ArrayList<Diem> dsDiem) {
		SapXepDSSV(dsSV);
		int trang = 5;
		Scanner sc = new Scanner(System.in);
		int i=trang-5;
		while(i<trang)
		{
			ArrayList<String> dsMonHoc= new ArrayList<String>();
			ArrayList<Float> dsD= new ArrayList<Float>();
			System.out.println("Mã sinh viên: "+dsSV.get(i).getMaSV());
			System.out.println("Họ tên sinh viên: "+dsSV.get(i).getHoDem()+" "+dsSV.get(i).getTen());
			float tongDiem=0, tongHeSo=0;
			for(int j=0; j<dsDiem.size(); j++)
			{
				if(dsDiem.get(j).getMaSV().trim().equals(dsSV.get(i).getMaSV().trim()))
				{
					dsD.add(dsDiem.get(j).getDiem());
					
					for (MonHoc item : dsMH) {
						if(item.getMaMonHoc().trim().equals(dsDiem.get(j).getMaMonHoc().trim()))
						{
							dsMonHoc.add(item.getTenMonHoc());
							tongDiem+=dsDiem.get(j).getDiem()*item.getHeSo();
							tongHeSo+=item.getHeSo();
						}
					}
				}
			}
			if(tongDiem==0)
			{
				System.out.println("----->Sinh viên chưa học môn nào");
			}
			else
			{
				System.out.printf("\t\t%-25s%-10s\n","Môn học","Điểm");
				for(int k=0; k<dsMonHoc.size(); k++)
				{
					System.out.printf("\t\t%-25s%-10.2f\n",dsMonHoc.get(k), dsD.get(k));
				}
				System.out.printf("\t%20s%5.2f\n","------>Điểm tổng kết",tongDiem/tongHeSo);
			}
			if(i==trang-1)
			{
				do {
					System.out.print("Nhập số trang 1,2,3,4,5,..."+(dsSV.size()/5-1)+","+(dsSV.size()/5)+","+(dsSV.size()/5+1)+"(0 để thoát): ");
					trang=sc.nextInt();
					if(trang==dsSV.size()/5+1)
					{
						i=i=dsSV.size()/5 *5-1;
						trang=dsSV.size();
					}
					else {
						trang=trang*5;
						i=trang-6;
					}
				} while(trang>dsSV.size());
				if(trang==0)
					break;
			}
			i++;
			System.out.println("----------------------------------------");
		}
	}

	private static void xoaSV(ArrayList<SinhVien> dsSV, ArrayList<Diem> dsDiem) {
		Scanner sc= new Scanner(System.in);
		String maXoa;
		System.out.print("Nhập mã sinh viên muốn xóa: ");
		maXoa=sc.nextLine();
		if(KtMaSV(maXoa, dsSV)==true)
			System.out.println("------->Không có sinh viên mã "+maXoa);
		else {
			if(ktMaSVDiem(maXoa, dsDiem)==true)
				System.out.println("------->Sinh viên đã học");
			else
			{
				for (int i=0; i<dsSV.size(); i++) {
					if(dsSV.get(i).getMaSV().trim().equals(maXoa))
						dsSV.remove(i);
				}
				System.out.println("--------->Xóa sinh viên thành công");
			}
		}
		
	}


	private static void xoaDiem(ArrayList<Diem> dsDiem) {
		Scanner sc = new Scanner(System.in);
		String masv, mamh;
		boolean ktMaSV=true, ktMaMH=true;
		do {
			if(ktMaSV==false)
				System.out.println("--------->Sinh viên này chưa nhập học!");
			System.out.print("Nhập mã sinh viên: ");
			masv=sc.nextLine();
			ktMaSV=ktMaSVDiem(masv, dsDiem);
		}while(ktMaSV==false);
		
		do {
			if(ktMaMH==false)
				System.out.println("--------->Sinh viên chưa học môn này!");
			System.out.print("Nhập mã môn học: ");
			mamh=sc.nextLine();
			ktMaMH=ktMaMHDiem(mamh, dsDiem);
		}while(ktMaMH==false);
		for (int i=0; i<dsDiem.size(); i++) {
			if(dsDiem.get(i).getMaMonHoc().equals(mamh) && dsDiem.get(i).getMaSV().equals(masv))
			{
				dsDiem.remove(i);
				break;
			}
		}
		System.out.println("------>Xóa thành công");
	}

	private static void suaDiem(ArrayList<Diem> dsDiem) {
		Scanner sc = new Scanner(System.in);
		String masv, mamh;
		boolean ktMaSV=true, ktMaMH=true;
		do {
			if(ktMaSV==false)
				System.out.println("--------->Sinh viên này chưa nhập học!");
			System.out.print("Nhập mã sinh viên: ");
			masv=sc.nextLine();
			ktMaSV=ktMaSVDiem(masv, dsDiem);
		}while(ktMaSV==false);
		
		do {
			if(ktMaMH==false)
				System.out.println("--------->Sinh viên chưa học môn này!");
			System.out.print("Nhập mã môn học: ");
			mamh=sc.nextLine();
			ktMaMH=ktMaMHDiem(mamh, dsDiem);
		}while(ktMaMH==false);
		float d;
		do {
			try {
				System.out.print("Nhập điểm: ");
				d=sc.nextFloat();
			}
			catch (Exception e) {
				System.out.println("Nhập sai điểm!");
				sc.nextLine();
				d=-1;
			}
		}while (d<0 || d>10);
		for (Diem i : dsDiem) {
			if(i.getMaMonHoc().equals(mamh) && i.getMaSV().equals(masv))
				i.setDiem(d);
		}
		System.out.println("----->Sửa điểm thành công");
	}

	private static boolean ktMaMHDiem(String mamh, ArrayList<Diem> dsDiem) {
		for (Diem i : dsDiem) {
			if(i.getMaMonHoc().trim().equals(mamh.trim()))
				return true;
		}
		return false;
	}

	private static boolean ktMaSVDiem(String masv, ArrayList<Diem> dsDiem) {
		for (Diem i : dsDiem) {
			if(i.getMaSV().trim().equals(masv.trim()))
				return true;
		}
		return false;
	}

	private static void nhapDiem(ArrayList<Diem> dsDiem, ArrayList<SinhVien> dsSV, ArrayList<MonHoc> dsMH) {
		Scanner sc = new Scanner(System.in);
		String masv=null, mamh=null;
		float d;
		boolean ktDiem=true;
		do {
			if(ktDiem==false)
			{
				System.out.println("Sinh viên "+masv+" đã học môn "+mamh);
			}
			boolean checkMaSV=false;
			do {
				if(checkMaSV==true)
					System.out.println("Mã sinh viên không tồn tại");
				System.out.print("Nhập mã sinh viên: ");
				masv=sc.nextLine();
				checkMaSV=KtMaSV(masv, dsSV);
			}while(checkMaSV==true);
			
			boolean checkMaMH=false;
			do {
				if(checkMaMH==true)
					System.out.println("Mã môn học không tồn tại");
				System.out.print("Nhập mã môn học: ");
				mamh=sc.nextLine();
				checkMaMH=ktMaMH(mamh, dsMH);
			}while(checkMaMH==true);
			ktDiem=KTtonTaiDiem(masv, mamh, dsDiem);
		}while(ktDiem==false);
			
		do {
			try {
				System.out.print("Nhập điểm: ");
				d=sc.nextFloat();
			}
			catch (Exception e) {
				System.out.println("Nhập sai điểm!");
				sc.nextLine();
				d=-1;
			}
		}while (d<0 || d>10);
		
		Diem diem= new Diem(masv, mamh, d);
		dsDiem.add(diem);
		System.out.println("------->Nhập điểm thành công");
	}

	private static boolean KTtonTaiDiem(String masv, String mamh, ArrayList<Diem> dsDiem) {
		for (Diem item : dsDiem) {
			if(item.getMaSV().trim().equals(masv) && item.getMaMonHoc().trim().equals(mamh))
				return false;
		}
		return true;
	}

	private static void ghiFileDiem(ArrayList<Diem> dsDiem) {
		FileWriter frw = null;
		BufferedWriter bufW = null;
		try {
			frw = new FileWriter("diem.txt");
			bufW = new BufferedWriter(frw);
			bufW.write("# Ma - Ten - tuoi - sdt - diem");
			bufW.newLine();
			for (int i = 0; i < dsDiem.size(); i++) {
				String line = dsDiem.get(i).getline();
				bufW.write(line);
				bufW.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bufW!=null) bufW.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void docFileDiem(ArrayList<Diem> dsDiem) {
		FileReader frd = null;
		BufferedReader bufR=null;
		try {
			frd = new FileReader("diem.txt");
			bufR = new BufferedReader(frd);
			String line;
			while ((line = bufR.readLine()) != null) {
				if(!line.startsWith("#")) {
					String[] parts = line.split(";");
					String maSV = parts[0];
					String maMH = parts[1]; 
					String d = parts[2];
					float diem = Float.parseFloat(d);
					Diem dm = new Diem(maSV, maMH, diem);
					dsDiem.add(dm);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(bufR!=null) bufR.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void xoaMH(ArrayList<MonHoc> dsMH, ArrayList<Diem> dsDiem) {
		Scanner sc= new Scanner(System.in);
		String maXoa;
		System.out.print("Nhập mã môn học muốn xóa: ");
		maXoa=sc.nextLine();
		if(ktMaMH(maXoa, dsMH)==true)
			System.out.println("------->Không có môn học mã "+maXoa);
		else {
			if(ktMaMHDiem(maXoa, dsDiem)==true)
				System.out.println("------->Môn học đã có sinh viên học");
			else
			{
				for (int i=0; i<dsMH.size(); i++) {
					if(dsMH.get(i).getMaMonHoc().trim().equals(maXoa))
						dsMH.remove(i);
				}
				System.out.println("-------->Xóa môn học thành công");
			}
		}
		
	}

	private static void SapXepDSMH(ArrayList<MonHoc> dsMH) {
		Comparator<MonHoc> c = new Comparator<MonHoc>() {

			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				Locale vi = new Locale("vi", "vn");
				Collator col = Collator.getInstance(vi);
				return col.compare(o1.getTenMonHoc(), o2.getTenMonHoc());
			}
			
		};
		
		dsMH.sort(c);
		
	}

	private static void suaMonHoc(ArrayList<MonHoc> dsMH) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã môn cần sửa");
		String maTim=sc.nextLine();
		int index=-1;
		for(int i=0; i<dsMH.size(); i++)
		{
			if(dsMH.get(i).getMaMonHoc().equals(maTim))
				index=i;
		}
		if(index==-1)
		{
			System.out.println("Không tìm môn học mã "+maTim);
		}
		else {
			String ten;
			System.out.print("Nhập tên môn học sửa: ");
			ten=sc.nextLine();
			Float hs;
			do {
				try {
					System.out.print("Nhập hệ số: ");
					hs=sc.nextFloat();
				}
				catch (Exception e) {
					System.out.println("Nhập lại hệ số");
					sc.nextLine();
					hs=(float) -1;
				}
			}while (hs<0 || hs>5);
			dsMH.get(index).setTenMonHoc(ten);
			dsMH.get(index).setHeSo(hs);
			System.out.println("-------->Sửa môn học thành công");
		}
		
	}

	private static void themMonHoc(ArrayList<MonHoc> dsMH) {
		Scanner sc = new Scanner(System.in);
		boolean checkMa=true;
		int currenCode=dsMH.size()+1;
		String ma;
		do {
			if(checkMa==false)
				currenCode++;
			ma=currenCode+"";
			checkMa=ktMaMH(ma, dsMH);
		}while(checkMa==false);
		String ten;
		System.out.print("Nhập tên môn học: ");
		ten=sc.nextLine();
		Float hs;
		do {
			try {
				System.out.print("Nhập hệ số: ");
				hs=sc.nextFloat();
			}
			catch (Exception e) {
				System.out.println("Nhập lại hệ số");
				sc.nextLine();
				hs=(float) -1;
			}
		}while (hs<0 || hs>5);
		
		MonHoc mh = new MonHoc(ma, ten, hs);
		dsMH.add(mh);
		System.out.println("-------->Thêm môn học thành công");
	}

	private static boolean ktMaMH(String ma, ArrayList<MonHoc> dsMH) {
		for (MonHoc item : dsMH) {
			if(ma.equals(item.getMaMonHoc()))
				return false;
		}
		return true;
	}

	private static void ghiFileMonHoc(ArrayList<MonHoc> dsMH) {
		FileWriter frw = null;
		BufferedWriter bufW = null;
		try {
			frw = new FileWriter("monhoc.txt");
			bufW = new BufferedWriter(frw);
			bufW.write("# Ma - Ten - tuoi - sdt - diem");
			bufW.newLine();
			for (int i = 0; i < dsMH.size(); i++) {
				String line = dsMH.get(i).getline();
				bufW.write(line);
				bufW.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bufW!=null) bufW.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void docFileMonHoc(ArrayList<MonHoc> dsMH) {
		FileReader frd = null;
		BufferedReader bufR=null;
		try {
			frd = new FileReader("monhoc.txt");
			bufR = new BufferedReader(frd);
			String line;
			while ((line = bufR.readLine()) != null) {
				if(!line.startsWith("#")) {
					String[] parts = line.split(";");
					String ma = parts[0];
					String ten = parts[1]; 
					String heSo = parts[2];
					float hs = Float.parseFloat(heSo);
					MonHoc mh = new MonHoc(ma, ten, hs);
					dsMH.add(mh);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(bufR!=null) bufR.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void SapXepDSSV(ArrayList<SinhVien> dsSV) {
		Comparator<SinhVien> c = new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				Locale vi = new Locale("vi", "vn");
				Collator col = Collator.getInstance(vi);
				return col.compare(o1.getTen(), o2.getTen());
			}	
		};
		dsSV.sort(c);	
	}

	private static void suaSV(ArrayList<SinhVien> dsSV) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã sinh viên cần sửa: ");
		String maTim=sc.nextLine();
		int index=-1;
		for(int i=0; i<dsSV.size(); i++)
		{
			if(dsSV.get(i).getMaSV().equals(maTim))
				index=i;
		}
		if(index==-1)
		{
			System.out.println("Không tìm thấy sinh viên mã "+maTim);
		}
		else {
			String ho, ten, gt;
			int ngay=-1, thang=-1, nam=-1;
			boolean checkTen=true;
			do {
				if(checkTen==false)
				{
					System.out.println("Họ đệm không hợp lệ");
					checkTen=true;
				}
				System.out.print("Nhập họ đệm: ");
				ho=sc.nextLine();
				checkTen=ktTen(ho);
			}while(checkTen==false);
			do {
				if(checkTen==false) {
					System.out.println("Tên không hợp lệ");
					checkTen=true;
				}
				System.out.print("Nhập tên: ");
				ten=sc.nextLine();
				checkTen=ktTen(ten);
			}while (checkTen==false);
			boolean kt=true;
			do {
				if(kt==false) {
					System.out.println("Ngày tháng năm không hợp lệ!");
					kt=true;
				}
				do {
					try {
						System.out.print("Nhập ngày sinh: ");
						ngay=sc.nextInt();
					}
					catch (Exception e) {
						sc.nextLine();
						System.out.println("Ngày sinh không hợp lệ!");
						kt=false;
					}
				}while(kt==false);
				
				do {
					try {
						System.out.print("Nhập tháng sinh: ");
						thang=sc.nextInt();
					}
					catch (Exception e) {
						sc.nextLine();
						System.out.println("Tháng sinh không hợp lệ!");
						kt=false;
					}
				}while(kt==false);
				
				do {
					try {
						
						System.out.print("Nhập năm sinh: ");
						nam=sc.nextInt();
					}
					catch (Exception e) {
						sc.nextLine();
						System.out.println("Năm sinh không hợp lệ!");
						kt=false;
					}
				}while(kt==false);
				
				kt=ktNgayThangNam(ngay, thang, nam);
			}while(kt==false);
			sc.nextLine();
			boolean ktGT=true;
			do {
				if(ktGT==false)
				{
					System.out.println("Giới tính Nam/Nữ!");
				}
				
				System.out.print("Nhập giới tính: ");
				gt= sc.nextLine();
				ktGT=checkGT(gt);
			}while(ktGT==false);
			dsSV.get(index).setHoDem(ho);
			dsSV.get(index).setTen(ten);
			dsSV.get(index).setNam(nam);
			dsSV.get(index).setNgay(ngay);
			dsSV.get(index).setThang(thang);
			dsSV.get(index).setGt(gt);
			System.out.println("--------->Sửa thành công");
		}
	}

	private static void themSV(ArrayList<SinhVien> dsSV) {
		String ma=null;
		boolean checkMa=true;
		int currenCode=dsSV.size()+1;
		do{
			if(checkMa==false)
				currenCode++;
			ma="SV"+currenCode;
			checkMa=KtMaSV(ma, dsSV);
		}while(checkMa==false);
		
		Scanner sc = new Scanner(System.in);
		String ho, ten, gt;
		int ngay=-1, thang=-1, nam=-1;
		boolean checkTen=true;
		do {
			if(checkTen==false)
			{
				System.out.println("Họ đệm không hợp lệ");
				checkTen=true;
			}
			System.out.print("Nhập họ đệm: ");
			ho=sc.nextLine();
			checkTen=ktTen(ho);
		}while(checkTen==false);
		do {
			if(checkTen==false) {
				System.out.println("Tên không hợp lệ");
				checkTen=true;
			}
			System.out.print("Nhập tên: ");
			ten=sc.nextLine();
			checkTen=ktTen(ten);
		}while (checkTen==false);
		boolean kt=true;
		do {
			if(kt==false) {
				System.out.println("Ngày tháng năm không hợp lệ!");
				kt=true;
			}
			do {
				try {
					System.out.print("Nhập ngày sinh: ");
					ngay=sc.nextInt();
				}
				catch (Exception e) {
					sc.nextLine();
					System.out.println("Ngày sinh không hợp lệ!");
					kt=false;
				}
			}while(kt==false);
			
			do {
				try {
					System.out.print("Nhập tháng sinh: ");
					thang=sc.nextInt();
				}
				catch (Exception e) {
					sc.nextLine();
					System.out.println("Tháng sinh không hợp lệ!");
					kt=false;
				}
			}while(kt==false);
			
			do {
				try {
					
					System.out.print("Nhập năm sinh: ");
					nam=sc.nextInt();
				}
				catch (Exception e) {
					sc.nextLine();
					System.out.println("Năm sinh không hợp lệ!");
					kt=false;
				}
			}while(kt==false);
			
			kt=ktNgayThangNam(ngay, thang, nam);
		}while(kt==false);
		sc.nextLine();
		boolean ktGT=true;
		do {
			if(ktGT==false)
			{
				System.out.println("Giới tính Nam/Nữ!");
			}
			
			System.out.print("Nhập giới tính: ");
			gt= sc.nextLine();
			ktGT=checkGT(gt);
		}while(ktGT==false);
		SinhVien s = new SinhVien(ma, ho, ten, ngay, thang, nam, gt);
		dsSV.add(s);
		System.out.println("-------->Thêm sinh viên thành công");
	}
	private static boolean KtMaSV(String s, ArrayList<SinhVien> dsSV)
	{
		for (SinhVien item : dsSV) {
			if(s.equals(item.getMaSV()))
				return false;
		}
		return true;
	}
	private static boolean checkGT(String gt) {
		if(gt.trim().equals("Nam") || gt.trim().equals("Nữ"))
			return true;
		else
			return false;
	}

	public static boolean ktNamNhuan(int nam)
	{
		if(nam%4==0 && nam%100!=0 || nam%400==0)
			return true;
		return false;
	}
	public static int tinhSoNgayTrongThang(int thang, int nam)
	{
		int numDayOfMonth = 0;
		switch(thang)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDayOfMonth=31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDayOfMonth=30;
			break;
		case 2:
			if(ktNamNhuan(nam))
				numDayOfMonth=29;
			else
				numDayOfMonth=28;
			break;
		}
		return numDayOfMonth;
	}
	public static boolean ktNgayThangNam(int ngay, int thang, int nam)
	{
		if(nam<0)
			return false;
		if(thang<1 || thang >12)
			return false;
		if(ngay<1 || ngay> tinhSoNgayTrongThang(thang, nam))
			return false;
		return true;
	}
	
	private static boolean ktTen(String ho) {
		Pattern so = Pattern.compile("[0-9]");
		Pattern kiTuDacBiet = Pattern.compile("[!@#$%&*()+=_|<>?{}\\[\\]~-]");

		Matcher hasKiTuDacBiet = kiTuDacBiet.matcher(ho);
		Matcher hasSo = so.matcher(ho);
		if(hasKiTuDacBiet.find() || hasSo.find() || ho.trim().equals(""))
			return false;
		else
			return true;
	}

	private static void ghiFile(ArrayList<SinhVien> dsSV) {
		FileWriter frw = null;
		BufferedWriter bufW = null;
		try {
			frw = new FileWriter("sinhvien.txt");
			bufW = new BufferedWriter(frw);
			bufW.write("# Ma - Ten - tuoi - sdt - diem");
			bufW.newLine();
			for (int i = 0; i < dsSV.size(); i++) {
				String line = dsSV.get(i).getline();
				bufW.write(line);
				bufW.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bufW!=null) bufW.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void docFile(ArrayList<SinhVien> listSV)  {
		FileReader frd = null;
		BufferedReader bufR=null;
		try {
			frd = new FileReader("sinhvien.txt");
			bufR = new BufferedReader(frd);
			String line;
			while ((line = bufR.readLine()) != null) {
				if(!line.startsWith("#")) {
					String[] parts = line.split(";");
					String ma = parts[0];
					String hoDem = parts[1];
					String ten = parts[2]; 
					String ngaySinh = parts[3];
					String gt = parts[4];
					String[] so = ngaySinh.split("/");
					int ngay = Integer.parseInt(so[0]);
					int thang = Integer.parseInt(so[1]);
					int nam = Integer.parseInt(so[2]);
					
					SinhVien sv = new SinhVien(ma, hoDem, ten, ngay, thang, nam, gt);
					listSV.add(sv);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(bufR!=null) bufR.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
