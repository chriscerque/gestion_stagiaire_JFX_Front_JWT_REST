package net.ent.etrs.gestion_stagiaire.secu;

import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor() {
        System.out.println(">>>>>>>>>>>AuditorAwareImpl/getCurrentAuditor");
//        return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AuditorAwareImpl/getCurrentAuditor");
        System.out.println("authentication : " + authentication);
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        System.out.println("((User) authentication.getPrincipal()).getUsername() : " + ((MyUser) authentication.getPrincipal()).getUsername());
        return Optional.of(((MyUser) authentication.getPrincipal()).getUsername());
    }
}
