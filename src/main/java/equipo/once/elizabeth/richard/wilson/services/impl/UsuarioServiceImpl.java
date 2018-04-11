package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.RoleRepository;
import equipo.once.elizabeth.richard.wilson.entities.dao.UsuarioRepository;
import equipo.once.elizabeth.richard.wilson.entities.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created on 4/11/2018.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void guardar(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.password));
        //TODO: agregar roles
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
