package webUI;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import server.MySession;


public class Login extends WebPage {

	private String userId;
	  private String password;

	  public Login()
	  {
	    TextField userIdField = new TextField("userId", new PropertyModel(this,"userId"));

	    PasswordTextField passField = new PasswordTextField("password", new PropertyModel(this, "password"));

	    Form form = new LoginForm("loginForm");
	    form.add(userIdField);
	    form.add(passField);
	    add(form);
	  }

	  class LoginForm extends Form
	  {
		private static final long serialVersionUID = 1L;

		public LoginForm(String id)
	    {
	       super(id);
	    }

	    @Override
	    public void onSubmit()
	    {	    	
	    	if(getUserId().equals("wicket") && getPassword().equals(password))
	    	{
	    		getMySession().setUserId(userId);	    		
	    		//Perexod na stranicu WishListPage
	    		setResponsePage(WishListPage.class);	    		
	    	}	       
	    }
	  }
	  
	  public MySession getMySession(){
	        return (MySession)getSession();
	    }

	  public String getUserId()
	  {
	    return userId;
	  }
	  public String getPassword()
	  {
	    return password;
	  }

	  public void setUserId(String userId)
	  {
	    this.userId = userId;
	  }

	  public void setPassword(String password)
	  {
	    this.password = password;
	  }
	}
