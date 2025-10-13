import java.util.ArrayList;
public class SolarSystem {
    private String systemName;
    private double luminosity;
    private ArrayList<Planet> myPlanets = new ArrayList<>();



    public SolarSystem(String systemName){
        this.systemName = systemName;
    }

    public SolarSystem(String systemName, double luminosity){
        this.systemName = systemName;
        this.luminosity = luminosity;


    }
    public void addPlanet(String mySystem, double distance){
        Planet myPlant = new Planet(mySystem, distance);
        myPlanets.add(myPlant);
    }
    public void addPlanet(String mySystem, double mass, double radius, double distance){
        Planet planet = new Planet(mySystem, mass, radius, luminosity, distance);
        myPlanets.add(planet);
    }


    public Planet furthest(){
        if (myPlanets.isEmpty()) {
            return null;
        }
        Planet closestSoFar = myPlanets.get(0);
        for (Planet p : myPlanets) {
            if (p.getDistance() > closestSoFar.getDistance()) {
                closestSoFar = p;
            }
        }
        return closestSoFar;
    }

    public Planet closest() {
        Planet closestSoFar = myPlanets.get(0);
        for (Planet p : myPlanets) {
            if (p.getDistance() < closestSoFar.getDistance()) {
                closestSoFar = p;
            }
        }return closestSoFar;
    }


    public Planet getPlanetByName(String msg) {
        Planet planet = null;
        if (myPlanets.isEmpty()) {
            return null;
        }
        for (int i = 0; i < myPlanets.size(); i++) {
            if (myPlanets.get(i).getName() == msg){
                return myPlanets.get(i);
            }
        }return planet;
    }


    public String toString(){   //
        String plants = "";
        for (int i = 0; i < myPlanets.size(); i++){
            plants += myPlanets.get(i);
        }return "Star " +systemName+" has planets:\n" +plants;
    }
}
