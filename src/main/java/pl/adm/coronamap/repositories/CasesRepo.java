package pl.adm.coronamap.repositories;


import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import pl.adm.coronamap.voivodeship.InfectedByRegion;
import pl.adm.coronamap.voivodeship.MapColors;
import pl.adm.coronamap.voivodeship.Voivodeship;
import pl.adm.coronamap.voivodeship.VoivodeshipCases;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Repository
public class CasesRepo {
    int allCasesInPoland;
    String date;
    VoivodeshipRepo voivodeshipRepo;
    VoivodeshipCases voivodeshipCases;
    List<MapColors> colors;
    List<InfectedByRegion> infected;
    List<Integer> breakpointsList;
    List<Integer> generalInfo;
    List<Voivodeship> voivodeship;

    int[] percentageDividers = {90,50, 20, 15, 10, 8, 6};
    public CasesRepo() throws IOException {
        URL url = new URL("https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        voivodeshipCases = new Gson().fromJson(reader, VoivodeshipCases.class);

        allCasesInPoland = voivodeshipCases.getAllCases();
        voivodeshipRepo = new VoivodeshipRepo();



        //Model data for js
        infected = voivodeshipCases.getInfectedByRegion();
        voivodeship = voivodeshipRepo.voivodeships;
        colors=matchColorToRegion(infected, allCasesInPoland);
        breakpointsList = calculateBreakpoints(allCasesInPoland);
        generalInfo = getGeneralInfo(voivodeshipCases);
        date = formatDate(voivodeshipCases.getLastUpdatedAtApify());

        calculatePercentageOfInfectedPeople(infected,voivodeship);
    }

    private void calculatePercentageOfInfectedPeople(List<InfectedByRegion> infected, List<Voivodeship> voivodeships) {
        for(Voivodeship voivode : voivodeships){
            String result;
            Iterator<InfectedByRegion> iterator = infected.iterator();
            while(iterator.hasNext()){
                InfectedByRegion temp = iterator.next();
                if(voivode.getRegion().equals(temp.getRegion())){
                    DecimalFormat df = new DecimalFormat("#.##");
                    result = df.format(((double)temp.getInfectedCount()*100/voivode.getPopulation()));
                    voivode.setPercentageOfPeopleInfected(result);
                }
            }

        }
    }

    private String formatDate(String lastUpdatedAtApify) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm", Locale.ENGLISH);
        LocalDateTime dateF = LocalDateTime.parse(lastUpdatedAtApify, inputFormatter);
        return outputFormatter.format(dateF);
    }

    private List<Integer> getGeneralInfo(VoivodeshipCases voivodeshipCases) {
        List<Integer> allCases = new ArrayList<>();

        //Creating a list of data used as an general information about virus cases in js

        allCases.add(voivodeshipCases.getDeceased()+voivodeshipCases.getInfected());
        allCases.add(voivodeshipCases.getInfected());
        allCases.add(voivodeshipCases.getDeceased());
        return allCases;
    }

    private List<Integer> calculateBreakpoints(int cases) {
        List<Integer> breakpoints = new ArrayList<>();

        //Creating a list of breakpoints of cases for a map legend in js
        //Used to match with colors in a map legend

        breakpoints.add(0);
        for(int i= 0; i<percentageDividers.length;i++){
            breakpoints.add(cases/percentageDividers[i]);
        }
        return breakpoints;
    }
    private List<MapColors> matchColorToRegion(List<InfectedByRegion> infected, int allCases){
        List<MapColors> colorsList = new ArrayList<>();
        for(InfectedByRegion infectedPeople : infected){
            MapColors color = new MapColors();
            int merged = infectedPeople.countInfectedAndDeceased();

            //  Assigning a color to a region
            //  Used in js to determine the map color based on percentage of people infected in a region

            if(merged<allCases/90) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#FFEDA0");
            }

            else if(merged < allCases/50 && merged > allCases/100) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#FED976");
            }

            else if(merged<allCases/20 && merged>allCases/50) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#FEB24C");
            }

            else if(merged<allCases/15 && merged>allCases/20) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#FD8D3C");
            }
            else if(merged<allCases/10 && merged>allCases/15) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#FC4E2A");
            }

            else if(merged<allCases/8 && merged>allCases/10) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#E31A1C");
            }
            else if(merged<allCases/6 && merged>allCases/8) {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#BD0026");
            } else {
                color.setRegion(infectedPeople.getRegion());
                color.setColor("#800026");
            }
            colorsList.add(color);
        }
        return  colorsList;
    }

    public List<Voivodeship> getVoivodeship() {
        return voivodeship;
    }

    public String getDate() {
        return date;
    }

    public List<MapColors> getColors() {
        return colors;
    }

    public List<InfectedByRegion> getInfected() {
        return infected;
    }

    public List<Integer> getBreakpointsList() {
        return breakpointsList;
    }

    public List<Integer> getGeneralInfo() {
        return generalInfo;
    }
}
