package net.ent.etrs.gestion_stagiaire.controller;

import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.entities.UserDTO;
import net.ent.etrs.gestion_stagiaire.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            System.out.println(">>>>>>>>>>MyUserDetailService/loadUserByUsername");
            System.out.println("username : " + username);
            Objects.requireNonNull(username);
            UserDetails user = userRepo.findUserByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException(String.format("Username[%s] not found",username)));
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public MyUser save(UserDTO userDTO) {
        MyUser newUser = new MyUser();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        return userRepo.save(newUser);
    }

//    private List<GrantedAuthority> getGrantedAuthorities(MyUser user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        List<Role> roles = user.getRoles();
//        roles.forEach(r->authorities.add(new SimpleGrantedAuthority(r.toString())));
////        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        return authorities;
//    }
}
