package server;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public final class MySession extends WebSession {
	private static final long serialVersionUID = 1L;
	
	private String myUserId;
 
    public MySession(Request request) {
        super(request);
    }
 
    public final String getUserId() {
        return myUserId;
    }
 
    public final void setUserId(String myuserId) {
        this.myUserId = myuserId;
    }
 
    // if you use java >= 1.5 you can make use of covariant return types
    public static MySession get() {
        return (MySession)WebSession.get();
    }
}