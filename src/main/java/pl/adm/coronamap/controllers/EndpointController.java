package pl.adm.coronamap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.adm.coronamap.repositories.*;

@Controller
public class EndpointController {
    CasesRepo casesRepo;
    @Autowired
    public EndpointController(CasesRepo casesRepo) {
        this.casesRepo = casesRepo;
    }


    @GetMapping("/map")
    public String mapa(Model model){
        model.addAttribute("colors",casesRepo.getColors());
        model.addAttribute("infected",casesRepo.getInfected());
        model.addAttribute("breakpointsList",casesRepo.getBreakpointsList());
        model.addAttribute("generalInfo",casesRepo.getGeneralInfo());
        model.addAttribute("date",casesRepo.getDate());
        model.addAttribute("voivodeship",casesRepo.getVoivodeship());
        return "map";
    }
}
