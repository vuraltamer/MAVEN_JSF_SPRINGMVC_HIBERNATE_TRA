package onuz;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginController", eager = true)
@RequestScoped
public class LoginController implements Serializable{
	
	private static final long serialVersionUID = 3031813568119851867L;
	private String username;
	private String password;
	private boolean loginButtonRender = false;


	public boolean isLoginButtonRender() {
		return loginButtonRender;
	}
	public void setLoginButtonRender(boolean loginButtonRender) {
		this.loginButtonRender = loginButtonRender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public String  login() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (username == null ) {
            context.addMessage(null, new FacesMessage("Unknown login, try again"));
            username = null;
            password = null;
            return null;
        } else {
            context.getExternalContext().getSessionMap().put("username", username);
            context.getExternalContext().getSessionMap().put("password", password);
            loginButtonRender = true;
            return "index?faces-redirect=true";
        }
    }
    
    public String logout() {
    	loginButtonRender= false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        return "index?faces-redirect=true";
    }
    
    public String getLoginName(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (loginButtonRender == true)
        	return (String) context.getExternalContext().getSessionMap().get("username");
    	return null;
    }

}