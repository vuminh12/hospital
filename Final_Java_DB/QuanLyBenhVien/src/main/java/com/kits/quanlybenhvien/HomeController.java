package com.kits.quanlybenhvien;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home", produces = "application/json")
@CrossOrigin(origins = "*")
public class HomeController {
}
