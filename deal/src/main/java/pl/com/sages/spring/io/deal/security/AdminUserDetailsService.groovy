package pl.com.sages.spring.io.deal.security

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@TypeChecked
@Component
class AdminUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder

    private final Map<String, User> users = [:]

    @Autowired
    AdminUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder
        initUsers()
    }

    private void initUsers() {
        users.put('admin', new User('admin', passwordEncoder.encode('admin'), [
            new SimpleGrantedAuthority("ROLE_ADMIN")
        ]))
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (users.containsKey(username)) {
            User user = users.get(username)
            return new User(user.username, user.password, user.authorities);
        }
        throw new UsernameNotFoundException("Invalid credentials!")
    }
}
