package com.example.csc221_final_project.service;

import org.springframework.stereotype.Service;

@Service
public class SearchService {
    public Boolean sports(String sportsName) {
        if ((sportsName.equals("Football")) || (sportsName.equals("Soccer")) || (sportsName.equals("Basketball")) || (sportsName.equals("All Sports"))) {
            return true;
        }
        return false;
    }

}
