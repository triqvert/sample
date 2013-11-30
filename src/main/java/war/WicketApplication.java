package war;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{   
	public static WishCollection _collection;
	
    /**
     * Constructor
     */
	
	@Override
    public final Session newSession(Request request, Response response) {
        return new MySession(request);
	}
	
	public WicketApplication()
	{
	}
		
	/**
	 * @see wicket.Application#getHomePage()
	 */
	
		@Override
		public Class<? extends WebPage> getHomePage()
		{
			return Login.class;
		}
	
		@Override
		public void init()
		{
			this._collection = new WishCollection();
			Wish wish1 = new Wish("I Wish to be a Star", "user");
			this._collection.addWish(wish1);
		}
		
		public WishCollection getCollection()
		{
			return this._collection;
		}
}
