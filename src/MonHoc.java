
public class MonHoc {
	private String maMonHoc, tenMonHoc;
	private float heSo;
	public MonHoc(String maMonHoc, String tenMonHoc, float heSo) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.heSo = heSo;
	}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public float getHeSo() {
		return heSo;
	}
	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}
	public String getline() {
		String out = maMonHoc+";"+tenMonHoc+";"+heSo;
		return out;
	}
}
