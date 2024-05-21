package com.example.crmservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LoginToInn {
    public static final Map<String, String> inn = Map.of(
            "1", "111111111111",
            "2", "222222222222",
            "3", "333333333333",
            "4", "444444444444"
    );

    @PostMapping("/accounts")
    public Map<String, String> getInn(@RequestBody List<String> logins){
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            return logins.stream().filter(login -> inn.get(login) != null)
                    .collect(Collectors.toMap(Function.identity(), inn::get));
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
