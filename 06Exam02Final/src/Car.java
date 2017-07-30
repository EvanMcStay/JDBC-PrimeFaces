import javax.faces.bean.ManagedBean;

@ManagedBean
public class Car 
{
	private String id, brand, color;
	private int year, miles;
	private boolean isClean;
	
	public Car()
	{}
	
	public Car(String id, String brand, int year, String color, int miles, boolean isClean)
	{
		super();
		this.id = id;
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.miles = miles;
		this.isClean = isClean;
	}
	
	//Setters and Getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public boolean isClean() {
		return isClean;
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
}
