package equipo.once.elizabeth.richard.wilson.services.impl;

import equipo.once.elizabeth.richard.wilson.repository.UsuarioRepository;
import equipo.once.elizabeth.richard.wilson.seguridad.Usuario;
import equipo.once.elizabeth.richard.wilson.seguridad.UsuarioRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 4/11/2018.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario byUsername = usuarioRepository.findByUsername(s);


        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        for(UsuarioRole role : byUsername.roles){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.role.toUpperCase()));
        }

        User user = new User(byUsername.username, byUsername.password, grantedAuthoritySet);
        return user;
    }
}
