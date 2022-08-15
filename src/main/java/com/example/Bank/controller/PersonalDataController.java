package com.example.Bank.controller;

import com.example.Bank.model.PersonalData;
import com.example.Bank.repository.PersonalDataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class PersonalDataController {

  @Autowired
  PersonalDataRepository personalDataRepository;



  @GetMapping("personalDatas")
  String personalDatas (Model model){
    List<PersonalData> personalDatas = personalDataRepository.findAll();
    model.addAttribute("personalDatas", personalDatas);
    return "personalDatas";
  }
  @GetMapping("delete-personalData")
  String delete (String personalNumberOwner){
    personalDataRepository.deleteById(personalNumberOwner);
    return "redirect:personalDatas";
  }
  @GetMapping("create-personalData")
  String create ( ){
    return "create-personalData";
  }

  @PostMapping("create-personalData")
  String create(PersonalData personalData) {
    personalDataRepository.save(personalData);
    return "redirect:personalDatas";
  }

  @GetMapping("update-personalData")
  String update (Model model, String personalNumberOwner){
    PersonalData personalData = personalDataRepository.findById(personalNumberOwner).get();
    model.addAttribute("personalData", personalData);
    return "update-personalData";
  }
  @PostMapping("update-personalData")
  String update (PersonalData personalData){
    personalDataRepository.save(personalData);
    return "redirect:personalDatas";
  }

}
