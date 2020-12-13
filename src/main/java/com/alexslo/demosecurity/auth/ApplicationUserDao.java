package com.alexslo.demosecurity.auth;

import java.util.Optional;

public interface ApplicationUserDao {

  Optional<ApplicationUser> selectApplicationUserByUsername(String userName);
}
