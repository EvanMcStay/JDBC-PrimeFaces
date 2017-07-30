import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class KnobView implements Serializable {  
   
    private int value = 50;  
   
    public int getValue() {  
        return value;  
    }  
   
    public void setValue(int value) {  
        this.value = value;  
    }  
   
    public void onChange(){  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You have selected: " + value, null));  
    }  
}