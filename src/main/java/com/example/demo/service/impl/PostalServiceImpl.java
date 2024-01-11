package com.example.demo.service.impl;

import com.example.demo.output.PostOfficeDetailsBean;
import com.example.demo.output.PostOfficeResponseBean;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PostalServiceImpl implements PostService {


    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    public PostalServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String cityValue) {
        String url = "https://api.postalpincode.in/postoffice/{city}";
        url = url.replace("{city}", cityValue);
        System.out.println("url is : " + url);

        ResponseEntity<PostOfficeResponseBean[]> postalResponseEntity =
                restTemplate.getForEntity(url, PostOfficeResponseBean[].class);

        System.out.println(postalResponseEntity.getStatusCode());
        //System.out.println(Arrays.toString(postalResponseEntity.getBody()));
        PostOfficeResponseBean[] responseBeanArray = postalResponseEntity.getBody();

        assert responseBeanArray != null;
        for (PostOfficeResponseBean responseBean : responseBeanArray){
            List<PostOfficeDetailsBean> postOfficeListBean = responseBean.getPostOffice();
            for (PostOfficeDetailsBean pob: postOfficeListBean){
                System.out.println(pob.getName() + "----" + pob.getCountry() );
            }

        }
        return responseBeanArray[0];
    }
}
