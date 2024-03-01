package com.eazybytes.controller;

import com.eazybytes.model.Notice;
import com.eazybytes.repository.NoticeRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {

    private final NoticeRepository repository;

    public NoticesController(NoticeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices(){
        List<Notice> notices = repository.findAllActiveNotices();
        if (notices != null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(notices);
        }else {
            return null;
        }
    }


}
