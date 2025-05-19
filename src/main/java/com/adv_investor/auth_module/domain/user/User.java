package com.adv_investor.auth_module.domain.user;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String cpfDocument;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserProfile profile;

    private Boolean isActive;

    public User(String cpfDocument, String name, String password, String email, UserProfile profile) {
        this.cpfDocument = cpfDocument;
        this.name = name;
        this.password = password;
        this.email = email;
        this.profile = profile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.profile == UserProfile.CONSERVATIVE) {
            return List.of( new SimpleGrantedAuthority("ROLE_CONSERVATIVE"), new SimpleGrantedAuthority("ROLE_USER") );
        } else {
            return List.of( new SimpleGrantedAuthority("ROLE_USER") );
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.cpfDocument;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
