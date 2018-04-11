package equipo.once.elizabeth.richard.wilson.controllers.view;

import equipo.once.elizabeth.richard.wilson.controllers.view.admin.AdminController;
import equipo.once.elizabeth.richard.wilson.controllers.view.inquilino.InquilinoController;
import equipo.once.elizabeth.richard.wilson.controllers.view.tecnico.TecnicoController;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;


@Controller
public abstract class CommonViewController {
    protected static Logger logger = Logger.getLogger(CommonViewController.class.getName());


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


    public String obtenerRole(Authentication authentication){
        Collection<GrantedAuthority> authorities = ((User) authentication.getPrincipal()).getAuthorities();
        GrantedAuthority grantedAuthority = authorities.stream().findFirst().get();

        String authority = grantedAuthority.getAuthority();
        return authority;
    }

    public String paginaParaRole(String role){
        String pagina = "";
        switch (role){
            case "ROLE_ADMIN" :
                pagina = AdminController.ADMIN_INDEX_VIEW;
                break;
            case "ROLE_TECNICO" :
                pagina = TecnicoController.TECNICO_INDEX_VIEW;

                break;
            case "ROLE_INQUILINO" :
                pagina = InquilinoController.INQUILINO_INDEX;

                break;
            case "ROLE_PROPIETARIO" :
                pagina = AdminController.ADMIN_INDEX_VIEW;
                break;
        }
       return pagina;
    }
}
