
public class Diem {
	private String maSV, maMonHoc;
	private float diem;
	public Diem(String maSV, String maMonHoc, float diem) {
		super();
		this.maSV = maSV;
		this.maMonHoc = maMonHoc;
		this.diem = diem;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public String getline() {
		String out = maSV+";"+maMonHoc+";"+diem;
		return out;
	}
}
