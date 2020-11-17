

public class SinhVien {
	private String maSV, hoDem, ten, gt;
	private int ngay, thang, nam;
	
	public SinhVien(String maSV, String hoDem, String ten, int ngay, int thang, int nam, String gt) {
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.ten = ten;
		this.gt = gt;
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	
	public SinhVien() {
		
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGt() {
		return gt;
	}
	public void setGt(String gt) {
		this.gt = gt;
	}
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}

	public String getline() {
		String out = maSV+";"+hoDem+";"+ten+";"+ngay+"/"+thang+"/"+nam+";"+gt;
		return out;
	}
	
	
}
