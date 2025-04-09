package com.restapi.stdy_spring_boot_01.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class KeycloakRoleConverter implements Converter<Jwt, Flux<GrantedAuthority>> {

    @Override
    public Flux<GrantedAuthority> convert(final Jwt jwt) {
        // Extracting roles from realm_access
        return Flux.fromIterable(getRolesFromToken(jwt))
                .map(roleName -> "ROLE_" + roleName.toString().toUpperCase()) // Prefixing role with ROLE_
                .map(SimpleGrantedAuthority::new);
    }

    private List<String> getRolesFromToken(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
        if (realmAccess == null) {
            return Collections.emptyList();
        }

        List<String> roles = (List<String>) realmAccess.get("roles");
        if (roles == null) {
            return Collections.emptyList();
        }

        return roles;
    }
}
