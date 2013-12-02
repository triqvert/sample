package data;

public class Wish {
	private String _text = null;
	private String _author = null;
	
	public Wish(){}
	
	public Wish (String text, String author)
	{
		this.setText(text);
		this.setAuthor(author);
	}
	
	public void setText(String text)
	{
		this._text = text;
	}
	
	public String getText()
	{
		return this._text;
	}
	
	public void setAuthor(String author)
	{
		this._author = author;
	}
	
	public String getAuthor()
	{
		return this._author;
	}
}
