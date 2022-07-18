package net.ent.etrs.gestion_stagiaire.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class MyUser implements Serializable {

    @Getter
    @Setter
    private Integer userId;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String token;

    @Getter
    private List<Role> roles = new ArrayList<>();


    public void addRoles(final Role role) throws Exception {
        if (roles == null) {
            throw new Exception("Role must not be null");
        }
        roles.add(role);
    }


}
