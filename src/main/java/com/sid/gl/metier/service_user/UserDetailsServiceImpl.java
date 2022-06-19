package com.sid.gl.metier.service_user;

import com.sid.gl.DTO.users.UserGetDTO;
import com.sid.gl.entities.User;
import com.sid.gl.mappers.ClientImplMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private  IAccountService accountService;
    private ClientImplMapper doMapper;
    @Override
    public UserDetails loadUserByUsername(String telephone) throws UsernameNotFoundException {
        UserGetDTO user = accountService.findUserByTelephone(telephone);
        if(user==null) throw new UsernameNotFoundException("Not found user!!");
        User user1 = doMapper.fromUserGetDTO(user);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user1.getProfil().getNameProfil()));
        return new org.springframework.security.core.userdetails.User(user1.getTelephone(),user1.getPassword(),authorities);
    }
}
