package io.board_mate.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
  @GetMapping("/health")
  public String healthCheck() {
    return "ok";
  }
}
