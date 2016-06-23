package onuz;

import java.io.Serializable;
import java.sql.SQLException;

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
    	UserController userController = new UserController();
    	userController.setUserName(username);
    	userController.setUserPassword(password);
        FacesContext context = FacesContext.getCurrentInstance();

        try {
			if (JDBCConnection.getUser(userController) == true) {
	            context.getExternalContext().getSessionMap().put("username", username);
	            context.getExternalContext().getSessionMap().put("password", password);
	            loginButtonRender = true;
	            return "index?faces-redirect=true";
			}
			else if (userController.getUserName() == null || userController.getUserPassword() == null ) {
	        	addMessage("System Error", "Please try again later.");
	            return null;
	        } else {
	            username = null;
	            password = null;
	            addMessage("System Error", "Please try again later.");
	            return "index?faces-redirect=true";
	        }			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

    }
    
    public String logout() {
    	loginButtonRender= false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        return "index?faces-redirect=true";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
}