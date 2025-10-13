import java.util.Objects;

public class Planet {

    private final double distance;

    private double orbitalPeriod;

    private double radius;

    private double mass;

    private String planetName;

    private double luminosity;

    private final double c = 1000;

    private final double d = 0.75;

    private final double h = 7.0;
    private final double v = 0.6;

    public String getName(){
        return planetName;
    }

    /**
     *
     * @param planetName
     * @param distance
     */
    public Planet(String planetName, double distance) {
        this.planetName = planetName;
        this.distance = distance;
    }
    public Planet(String planetName, double mass, double radius, double luminosity, double distance) {
        this.planetName = planetName;
        this.distance = distance;
        this.luminosity = luminosity;
        this.radius = radius;
        this.mass = mass;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Planet that = (Planet) obj;
        return distance == that.getDistance() && that.getName().equals(planetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetName, distance);
    }



    //calculate distance from star to planet
    public double getDistance(){
        double roundedDistance = Math.round(distance * c)/c;
        return roundedDistance;
    }

    //calculates luminosity
    public String getHabitable() {
        double luminosityFactor = Math.sqrt(luminosity);
        if ((d * luminosityFactor <= distance) && (distance <= 2.0 * luminosityFactor)
                && (v <= mass) && (mass <= h)){
            return "yes";
        }else {
        return "no";
     }
    }

    //calculates the mass of planets
    public double getGravity() {
        double gravity = Math.round(mass/(radius * radius)*c)/c;
        return gravity;
    }


    //calculates the orbital period from the star
    public double getOrbitalPeriod() {
        double period = Math.round(Math.sqrt(distance * distance * distance)*c)/c;
        return period;
    }

    public String toString() {
        if (mass == 0) {
            return planetName + "  is " + getDistance() + "AU from its star"
                    + ", and orbits in " + getOrbitalPeriod() + " years\n";
        } else {
        return planetName+ " has a mass of " +Math.round(mass*c)/c+ " Earths with a surface gravity of "
                +getGravity()+ "g, is " +distance+ "AU from its star, and orbits in "
                +getOrbitalPeriod()+ " years: could be habitable? " +getHabitable()+ "\n";
    }
    }
}
