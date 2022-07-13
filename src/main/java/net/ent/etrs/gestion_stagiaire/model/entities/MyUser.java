package net.ent.etrs.gestion_stagiaire.model.entities;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Role;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USER")
@NoArgsConstructor
public class MyUser implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "USER_ID")
    private Integer userId;

    @Getter @Setter
    @Column(name = "USER_NAME", unique = true)
    private String username;

    @Getter @Setter
    @Column(name = "PASSWORD")
    @JsonIgnore
    private String password;

    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired;

    @Column(name = "ACCOUNT_NON_LOCKED")
    private boolean accountNonLocked;

    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name="USER_ROLES",
            joinColumns=@JoinColumn(name="USER_ID")
    )
    @Column(name = "ROLE")
    @Getter
    private List<Role> roles = new ArrayList<>();

//    @JsonCreator
//    public MyUser(@JsonProperty("id") final Integer userId, @JsonProperty("userName") String username, @JsonProperty("password") String password){
//        this.userId = userId;
//        this.username = username;
//        this.password = password;
////        super("default", "default", true, true, true, true, new ArrayList<>());
//        //        this.accountNonExpired = true;
////        this.accountNonLocked = true;
////        this.credentialsNonExpired = true;
////        this.enabled = true;
//    }

//    public MyUser(String username, String password) {
//        super(username, password, true, true, true, true, new ArrayList<>());
//    }

//    /**
//     * Construct the <code>User</code> with the details required by
//     * {@link DaoAuthenticationProvider}.
//     *
//     * @param username              the username presented to the
//     *                              <code>DaoAuthenticationProvider</code>
//     * @param password              the password that should be presented to the
//     *                              <code>DaoAuthenticationProvider</code>
//     * @param enabled               set to <code>true</code> if the user is enabled
//     * @param accountNonExpired     set to <code>true</code> if the account has not expired
//     * @param credentialsNonExpired set to <code>true</code> if the credentials have not
//     *                              expired
//     * @param accountNonLocked      set to <code>true</code> if the account is not locked
//     * @param authorities           the authorities that should be granted to the caller if they
//     *                              presented the correct username and password and the user is enabled. Not null.
//     * @throws IllegalArgumentException if a <code>null</code> value was passed either as
//     *                                  a parameter or as an element in the <code>GrantedAuthority</code> collection
//     */
//    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//    }

    public void grantAuthority(Role authority) {
        if ( roles == null ) roles = new ArrayList<>();
        roles.add(authority);
    }

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println("roles :::::: ");
        System.out.println("roles.size() : " + roles.size());
        roles.forEach(System.out::println);
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.toString())));
        return authorities;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}
