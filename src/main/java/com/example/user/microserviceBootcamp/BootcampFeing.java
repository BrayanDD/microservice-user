package com.example.user.microserviceBootcamp;

import com.example.user.adapters.driving.http.dtos.response.TechnologyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "msvc-bootcamp",url = "localhost:8092/api/v1/onclass")
public interface BootcampFeing {

    @GetMapping("/technologies")
    List<TechnologyDto> getAllTechnologies(@RequestHeader("Authorization")String token,@RequestParam int page,
                                           @RequestParam int size,
                                           @RequestParam String order);
}
