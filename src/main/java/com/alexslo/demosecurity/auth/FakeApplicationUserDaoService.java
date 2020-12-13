package com.alexslo.demosecurity.auth;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.alexslo.demosecurity.security.ApplicationUserRole.ADMIN;
import static com.alexslo.demosecurity.security.ApplicationUserRole.ADMIN_TRAINEE;
import static com.alexslo.demosecurity.security.ApplicationUserRole.STUDENT;

@Repository("fake_user_dao")
@RequiredArgsConstructor
public class FakeApplicationUserDaoService implements ApplicationUserDao {

  private final PasswordEncoder passwordEncoder;

  @Override
  public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
    return getApplicationUsers()
        .stream()
        .filter(applicationUser -> username.equals(applicationUser.getUsername()))
        .findFirst();
  }

  private List<ApplicationUser> getApplicationUsers() {

    return Lists.newArrayList(
        ApplicationUser.builder()
            .username("Student")
            .password(passwordEncoder.encode("zzz123"))
            .authorities(STUDENT.getGrantedAuthorities())
            .build(),

        ApplicationUser.builder()
            .username("Admin")
            .password(passwordEncoder.encode("zzz123"))
            .authorities(ADMIN.getGrantedAuthorities())
            .build(),

        ApplicationUser.builder()
            .username("Trainee")
            .password(passwordEncoder.encode("zzz123"))
            .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
            .build()
    );
  }

}
