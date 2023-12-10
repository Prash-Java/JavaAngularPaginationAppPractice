package com.java.pagination.angularapp.resource;

import com.java.pagination.angularapp.domain.HttpResponse;
import com.java.pagination.angularapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("page", userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10))))
                        .message("Users Retrieved")
                        .status(OK.toString())
                        .statusCode(OK.value())
                        .build()
        );
    }
}
