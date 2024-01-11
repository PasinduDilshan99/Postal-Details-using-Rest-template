package com.example.demo.controller;


import com.example.demo.output.PostOfficeResponseBean;
import com.example.demo.service.PostService;
import com.example.demo.service.impl.PostalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postal")
public class PostDetailsController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/byCity" , method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public PostOfficeResponseBean getPostalByCity(@RequestParam String city){
        PostOfficeResponseBean postResponse = postService.fetchPostOfficeDetailsByCity(city);
        return postResponse;
    }
}
