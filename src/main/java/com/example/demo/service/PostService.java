package com.example.demo.service;

import com.example.demo.output.PostOfficeResponseBean;

public interface PostService {
    public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String city);
}
