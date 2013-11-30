package war;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.PropertyModel;

public class WishListPage extends WebPage {
    public String wishText;
	
	public WishListPage() {
    	
    	TextField wishTextField = new TextField("wishText", new PropertyModel(this, "wishText")); 
    	WicketApplication app = (WicketApplication) this.getApplication();
    	final WishCollection collection = app.getCollection();
        List<Wish> wishes = collection.getWishes();    
        
        Form form = new Form("wishForm")
        {
        	@Override
        	public void onSubmit()
        	{
        		Wish wish = new Wish(getWishText(), MySession.get().getUserId());        		
        		collection.addWish(wish);
        	}
        	
        };
        
        form.add(wishTextField);
        add(form);
       
        PropertyListView wishListView = new PropertyListView("wish_list", wishes) {
           private static final long serialVersionUID = 1L;
           
           	@Override
            protected void populateItem(ListItem item) {
           		Wish wish = (Wish)item.getModelObject();
           		item.add(new Label("author", wish.getAuthor()));            
           		item.add(new Label("text", wish.getText()));                
            }
        };
        this.add(wishListView);
    }
}