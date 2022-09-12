package com.learnapi.chucknorrisquotes.controller;

import com.learnapi.chucknorrisquotes.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/norrisAPI")
public class QuoteController {
    private final DataService service;

    public QuoteController(DataService service) {
        this.service = service;
    }
//    @GetMapping("/sayhello")
//    public String sayHello(){
//        return "Hello";
//    }
//
//    @GetMapping("/IWantALaugh")
//    public JSONObject makeAJoke(){
//        String url = "https://api.chucknorris.io/jokes/random";
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, JSONObject.class);
//    }
//
//    @GetMapping("GetCategories")
//    public List<String> listCategories(){
//        String url = "https://api.chucknorris.io/jokes/categories";
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, List.class);
//    }
//
//    @GetMapping("GetRandom")
//    public String getRandom(){
//        String url = "http://localhost:8080/norrisAPI/GetCategories";
//        RestTemplate restTemplate = new RestTemplate();
//        ArrayList<?> categories = (ArrayList<?>) restTemplate.getForObject(url, List.class);
//        Random random = new Random();
//        assert categories != null;
//        return restTemplate.getForObject("https://api.chucknorris.io/jokes/random?category=" + categories.get(Math.abs(random.nextInt()) % categories.size()), String.class);
//    }

    @GetMapping("BinanceData")
    public void getLiveCoinInfo(){
        service.getCoinInfo();
    }

}
