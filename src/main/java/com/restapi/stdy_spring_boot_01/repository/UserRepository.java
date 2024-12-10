package com.restapi.stdy_spring_boot_01.repository;

import com.restapi.stdy_spring_boot_01.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


public interface UserRepository extends R2dbcRepository<User, String> {
    Mono<User> findByEmail(String email);
}
