import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class SpinnerView 
{
    private int number1;   
    private double number2;  
    private int number3;   
    private int number4; 
    private int number5;
    
    public void SpinnerView()
    {	}
 
    public int getNumber3() 
    {
        return number3;
    }
 
    public void setNumber3(int number3) 
    {
        this.number3 = number3;
    }
}