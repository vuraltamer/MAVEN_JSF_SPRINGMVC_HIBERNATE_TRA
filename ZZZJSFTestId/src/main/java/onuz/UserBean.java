package onuz;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userBean", eager = true)
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 3031813568119851867L;
	private String ad = "asd";

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
}