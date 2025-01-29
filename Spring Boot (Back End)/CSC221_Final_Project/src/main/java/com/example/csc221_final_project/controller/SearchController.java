package com.example.csc221_final_project.controller;


import com.example.csc221_final_project.service.SearchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameselection")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/sports")
    public Boolean sports (@RequestParam("sportsName") String sportsName) {

        return searchService.sports(sportsName);
    }
}
