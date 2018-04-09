package equipo.once.elizabeth.richard.wilson.controllers.view;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public abstract class CommonViewController {

    protected String dateFormatString = "dd/MM/yyyy";

    protected final String MENSAJE_KEY = "mensaje";

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        dateFormat.setLenient(false);
        webDataBinder.setIgnoreInvalidFields(true);
        webDataBinder.setIgnoreUnknownFields(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
