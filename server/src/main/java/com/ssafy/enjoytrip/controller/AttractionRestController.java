package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.AttractionInfoDto;
import com.ssafy.enjoytrip.model.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/enjoytripapi/attractionapi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttractionRestController {
    @Autowired
    AttractionService attarctionService;
    @GetMapping("/gokakao")
    private String gokakao()  {
        return "KakaoMap";
    }

    @GetMapping("/search")
    private ResponseEntity<?> kakao(@RequestParam String area, @RequestParam String type,@RequestParam String word) {
        List<AttractionInfoDto> attractions = attarctionService.search(Integer.parseInt(area), Integer.parseInt(type), word);
        System.out.println(attractions);
        if(attractions != null)
            return new ResponseEntity<List<AttractionInfoDto>>(attractions, HttpStatus.OK);
        else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}