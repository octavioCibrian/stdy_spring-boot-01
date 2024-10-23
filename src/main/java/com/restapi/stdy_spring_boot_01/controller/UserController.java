package com.restapi.stdy_spring_boot_01.controller;


import com.restapi.stdy_spring_boot_01.exceptions.EmailUniquenessException;
import com.restapi.stdy_spring_boot_01.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.restapi.stdy_spring_boot_01.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/simple")
    public Mono<User> createUserSimple(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PostMapping
    public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
        return userRepository.findByEmail(user.email())

                .flatMap(existingUser -> Mono.error(new EmailUniquenessException("Email already exists!")))
                .then(userRepository.save(user))
                .map(ResponseEntity::ok)
                .doOnNext(savedUser -> System.out.println("New user created: "+savedUser))
                .onErrorResume(e -> {
                    System.out.println("an exception has ocurred: "+ e.getMessage());
                    if(e instanceof EmailUniquenessException) {
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.CONFLICT).build());
                    } else {
                        return Mono.just(ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .build());
                    }
                });
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userRepository.deleteById(id);
    }
}
