package com.sasha.spring.bike_shop.controller;

import com.sasha.spring.bike_shop.entity.Bike;
import com.sasha.spring.bike_shop.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyBikesController {
    @Autowired
    private BikeService bikeService;

    @RequestMapping("/")
    public String firstPage(){
        return "fist-view";
    }

    @RequestMapping("/basket")
    public String showBasketAllBikes(Model model){
        List<Bike> allBikes =  bikeService.getAllBikes();
        model.addAttribute("allB", allBikes);
        return "basket-all-bikes";
    }

    @RequestMapping("/addNewBike")
    public String addNewBike(Model model){
        Bike bike = new Bike();
        model.addAttribute("bike", bike);
        return "bike-info";
    }

    @RequestMapping("/saveBike")
    public String saveBike(@Valid @ModelAttribute("bike") Bike bike,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "bike-info";
        }else {
            bike.setPrice(bike.choosePrice(bike.getProductName()));
            bikeService.saveBike(bike);
            return "redirect:/basket";
        }
    }

    @RequestMapping("/updateInfo")
    public String updateBike(@RequestParam("bikeId") int id, Model model){
        Bike bike = bikeService.getBike(id);
        model.addAttribute("bike", bike);
        return "bike-info";
    }


    @RequestMapping("/deleteBike")
    public String deleteBike(@RequestParam("bikeId") int id){
        bikeService.deleteBike(id);
        return "redirect:/basket";
    }
}
