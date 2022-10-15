/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validators;

import com.sessionbeans.CustomersFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author thanh
 */
@FacesValidator("uniqueEmailValidator")
public class UniqueEmailValidator implements Validator {

    CustomersFacadeLocal customersFacade = lookupCustomersFacadeLocal();

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {

        String model = (String) o;

        if (!customersFacade.checkUniqueCustomerEmail(model)) {
            FacesMessage msg = new FacesMessage(
                    "Email is already exists");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }

    private CustomersFacadeLocal lookupCustomersFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomersFacadeLocal) c.lookup("java:global/AiPhoneHong/AiPhoneHong-ejb/CustomersFacade!com.sessionbeans.CustomersFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
