package model;

public class Product 
{
	String p_name;
	String price;
	String sportname;
	String p_size;
	String p_desc;
	String seller_id;	
    int p_id;
	
	public Product()	{
		p_name="";
		price="";
		sportname="";
		p_size="";
		p_desc="";
		seller_id="";	
	    
	}
	public int getProductId()
	{
		return p_id;
	}
	public void setProductId(int p_id)
	{
		this.p_id=p_id;
	}
	
	public String getProductName() {
		return p_name;
	}

	public void setProductName(String p_name) {
		this.p_name = p_name;
	}
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getSportName() {
		return sportname;
	}

	public void setSportName(String sportname) {
		this.sportname = sportname;
	}
	public String getSize() {
		return p_size;
	}

	public void setSize(String p_size) {
		this.p_size = p_size;
	}
	public String getDescription() {
		return p_desc;
	}

	public void setDescription(String p_desc) {
		this.p_desc = p_desc;
	}	
}
