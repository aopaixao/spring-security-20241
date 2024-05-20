package br.org.serratec.academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.org.serratec.academia.entities.User;
import br.org.serratec.academia.entities.UserDetailsImpl;
import br.org.serratec.academia.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) 
    		throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
        		.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UserDetailsImpl(user);
    }

}