package war;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

public class WishListPage extends WebPage {
    public WishListPage() {
    	
    	WicketApplication app = (WicketApplication) this.getApplication();
    	WishCollection collection = app.getCollection();
        List<Wish> wishes = collection.getWishes();        
       
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