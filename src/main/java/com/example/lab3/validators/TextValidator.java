package com.example.lab3.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.validator.Validator;
import jakarta.faces.component.UIComponent;
import jakarta.faces.validator.FacesValidator;

@FacesValidator("textValidator") // Имя валидатора, которое вы будете использовать в JSF
public class TextValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Double textValue = (Double) value;
        if (textValue < -3 || textValue > 5) {
            System.out.println("ne nais");
            // Создаем сообщение об ошибке
            FacesMessage msg = new FacesMessage("Значение должно быть в пределах от -5 до 5");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            // Генерируем исключение с сообщением
            throw new ValidatorException(msg);
        }
    }
}