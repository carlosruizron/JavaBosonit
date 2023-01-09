package com.example.block7crudvalidation.security;

import com.example.block7crudvalidation.person.application.impls.PersonServiceImpl;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonOut;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecurityController {

    @Autowired
    PersonServiceImpl personService;

    private String getJwtToken(String username, String role) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        String token = Jwts.builder().setId("Bosonit").setSubject(username)
                .claim("roles",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256, "secret".getBytes()).compact();
        return "Bearer " + token;
    }

    @PostMapping("/login/security")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        DtoPersonOut person = personService.getByUsername(username);

        if(person.getUsername().contains(person.getUsername())) {
            if(person.getAdmin()){
                return getJwtToken(person.getUsername(), "ADMIN");
            }
            else {
                return getJwtToken(person.getUsername(), "USER");
            }
        }else {
            return "No coincide usuario/password";
        }
    }
}
