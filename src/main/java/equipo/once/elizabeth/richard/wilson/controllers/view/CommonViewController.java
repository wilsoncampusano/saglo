package equipo.once.elizabeth.richard.wilson.controllers.view;

import equipo.once.elizabeth.richard.wilson.controllers.view.admin.AdminController;
import equipo.once.elizabeth.richard.wilson.controllers.view.inquilino.InquilinoController;
import equipo.once.elizabeth.richard.wilson.controllers.view.tecnico.TecnicoController;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Tecnico;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.services.InquilinoService;
import equipo.once.elizabeth.richard.wilson.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InquilinoService inquilinoService;


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

    protected Inquilino obtenerInquilino(Authentication authentication){
        User principal = (User) authentication.getPrincipal();

        Usuario usuario = usuarioService.buscarPorUsername(principal.getUsername());

        Inquilino inquilino = inquilinoService.buscarPorUsuario(usuario);
        return inquilino;
    }

    protected Tecnico obtenerTecnico(Authentication authentication){
        return new Tecnico();
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
