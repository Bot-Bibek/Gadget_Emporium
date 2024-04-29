package Model;

public class Product {
	private int product_Id;
    private String Name;
    private String Description;
    private float Price;
    private int Discount;
    private int Qunatity;
    private String Images;
    private int category_Id;
    
	public Product() {
		super();
	}
	
	public Product(int product_Id, String Name, String Description, float Price,
			int Discount, int Qunatity, String Images, int category_Id) {
		super();
		this.product_Id = product_Id;
		this.Name = Name;
		this.Description = Description;
		this.Price = Price;
		this.Discount = Discount;
		this.Qunatity = Qunatity;
		this.Images = Images;
		this.category_Id = category_Id;
	}

	public Product(String Name, String Description, float Price, int Discount,
			int Qunatity, String Images) {
		super();
		this.Name = Name;
		this.Description = Description;
		this.Price = Price;
		this.Discount = Discount;
		this.Qunatity = Qunatity;
		this.Images = Images;
	}

	public Product(String Name, String Description, float Price, int Discount,
			int Qunatity, String Images, int category_Id) {
		super();
		this.Name = Name;
		this.Description = Description;
		this.Price = Price;
		this.Discount = Discount;
		this.Qunatity = Qunatity;
		this.Images = Images;
		this.category_Id = category_Id;
	}
	
	public Product(int product_Id, String Name, float Price, int Discount, int Qunatity) {
		super();
		this.product_Id = product_Id;
		this.Name = Name;
		this.Price = Price;
		this.Discount = Discount;
		this.Qunatity = Qunatity;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float Price) {
		this.Price = Price;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int Discount) {
		this.Discount = Discount;
	}

	public int getQunatity() {
		return Qunatity;
	}

	public void setQunatity(int Qunatity) {
		this.Qunatity = Qunatity;
	}

	public String getImages() {
		return Images;
	}

	public void setImages(String Images) {
		this.Images = Images;
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	//calculate price of product by applying discount
    public int getProductPriceAfterDiscount(){
        int discount = (int) ((this.getDiscount()/100.0) * this.getPrice());
        return (int) (this.getPrice() - discount);
    }
	
	@Override
	public String toString() {
		return "Product [product_Id=" + product_Id + ", productName=" + Name + ", productDescription="
				+ Description + ", productPrice=" + Price + ", productDiscount=" + Discount
				+ ", productQunatity=" + Qunatity + ", productImages=" + Images + ", categoryId="
				+ category_Id + "]";
	}
    

}
