package Model;

public class Category {
	private int category_Id;
	private String Name;
	private String Image;

	public Category() {
		super();
	}

	public Category(int category_Id, String Name, String Image) {
		super();
		this.category_Id = category_Id;
		this.Name = Name;
		this.Image = Image;
	}

	public Category(String Name, String Image) {
		super();
		this.Name = Name;
		this.Image = Image;
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

}
