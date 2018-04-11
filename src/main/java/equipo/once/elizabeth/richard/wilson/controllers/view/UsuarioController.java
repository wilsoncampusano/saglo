package equipo.once.elizabeth.richard.wilson.controllers.view;

import equipo.once.elizabeth.richard.wilson.controllers.view.util.UsuarioValidator;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.services.SecurityService;
import equipo.once.elizabeth.richard.wilson.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created on 4/11/2018.
 */
@Controller
public class UsuarioController extends CommonViewController{
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UsuarioValidator usuarioValidator;

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("usuario", new Usuario());

        return "registro";
    }

    @RequestMapping(value = "/registrado", method = RequestMethod.GET)
    public String registrado(@RequestParam("usuario") String usuario, Model model) {
        model.addAttribute("usuario", usuario);
        return "registrado";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String registration(Usuario userForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) {
        usuarioValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registro";
        }

        usuarioService.guardar(userForm);

        //securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        model.addAttribute("usuario", userForm.username);
        redirectAttrs.addAttribute("usuario", userForm.username);
        return "redirect:/registrado";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, Authentication authentication) {
        String ROLE = obtenerRole(authentication);
        String paginaParaRole = paginaParaRole(ROLE);
        logger.info(String.format("%s con %s , %s", ROLE, paginaParaRole, authentication));
        return "redirect:"+paginaParaRole;
    }

}
