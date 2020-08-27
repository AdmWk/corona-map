package pl.adm.coronamap.repositories;


import org.springframework.stereotype.Repository;
import pl.adm.coronamap.voivodeship.Voivodeship;

import java.util.ArrayList;
import java.util.List;
@Repository
public class VoivodeshipRepo {
    List<Voivodeship> voivodeships;
    public VoivodeshipRepo() {
        voivodeships = fillVoivodeShips();
    }

    public List<Voivodeship> fillVoivodeShips() {
        List<Voivodeship> voivodeList = new ArrayList<>();
        voivodeList.add(new Voivodeship("dolnoslaskie",2904207,19947,146 ));
        voivodeList.add(new Voivodeship("kujawsko-pomorskie",2086210,17972 ,116 ));
        voivodeList.add(new Voivodeship("lubelskie",2139726,25122,85 ));
        voivodeList.add(new Voivodeship("lubuskie",1018075,13988,73 ));
        voivodeList.add(new Voivodeship("lodzkie",2493603,18219,137 ));
        voivodeList.add(new Voivodeship("malopolskie",3372618,15183,222 ));
        voivodeList.add(new Voivodeship("mazowieckie",5349114,35558,150 ));
        voivodeList.add(new Voivodeship("opolskie",996011,9412,106 ));
        voivodeList.add(new Voivodeship("podkarpackie",2127657,17846,119 ));
        voivodeList.add(new Voivodeship("podlaskie",1188800,20187,59 ));
        voivodeList.add(new Voivodeship("pomorskie",2307710,18310,126 ));
        voivodeList.add(new Voivodeship("slaskie",4570849,12333,371 ));
        voivodeList.add(new Voivodeship("swietokrzyskie",1257179,11711,107 ));
        voivodeList.add(new Voivodeship("warminsko-mazurskie",1439675,24173,60 ));
        voivodeList.add(new Voivodeship("wielkopolskie",3475323,29826,117 ));
        voivodeList.add(new Voivodeship("zachodniopomorskie",1710482,22892,75 ));
        return  voivodeList;
    }

}
