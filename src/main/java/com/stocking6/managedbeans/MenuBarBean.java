package com.stocking6.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
  
public class MenuBarBean {  
      
    public void save(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void update(ActionEvent actionEvent) {  
        addMessage("Data updated");  
    }  
      
    public void delete(ActionEvent actionEvent) {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  
