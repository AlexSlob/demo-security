package com.alexslo.demosecurity.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class ApplicationUser implements UserDetails {

  private final String username;
  private final String password;
  private final Set<? extends GrantedAuthority> authorities;
  @Builder.Default
  private final boolean isAccountNonExpired = true;
  @Builder.Default
  private final boolean isAccountNonLocked = true;
  @Builder.Default
  private final boolean isCredentialsNonExpired = true;
  @Builder.Default
  private final boolean isEnabled = true;
}
