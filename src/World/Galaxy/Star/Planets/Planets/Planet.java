package World.Galaxy.Star.Planets.Planets;

import World.Galaxy.Star.Planets.Moon.Moon;
import World.Galaxy.Star.Stars.Star;
import World.Tournament.Arena;

import java.util.ArrayList;

/**
 * Created by student5 on 5/11/17.
 */
public class Planet {
    private int megaMileRadius;
    private ArrayList<Moon> moons = new ArrayList<>();
    private int distanceFromStar, averageTemparature;
    private Arena arena;
    public Planet(Star star){
        megaMileRadius = (int)(Math.random()*40)+1;
        //max orbit from star is 10000 megamiles;
        boolean validDistance = false;
        distanceFromStar = (int) (Math.random() * 9000 + 1000);
        if (Math.random() < .1){
            this.arena = new Arena();
        }
        else {
            this.arena = null;
        }

        //radius of earth is 4000 or 4 megamiles
        //unit to measure planet size could be megamiles which are 1000 miles per megamile (would allow really big planets without dealing with overflows)
        //lets call most standard sized plants around 3000 to 10000 miles in radius
        //big planets like ice and rock giants are 10000 to 25000 miles. (36 megamiles)
        //dwarf planets are 1500 miles to 3000 miles.
        //this should be the general standart of gas giants. should be 25000 to 45000
        //moons should be around 1 megamile. minor moons are labled as < 1 megamile.
        //moons should be minable. same with planets.
        //the bigger a planet the more moons they will have

        for (int x = 0;x < Math.random() * megaMileRadius/3;x++){
            moons.add(new Moon(this));
            setTemparature();
        }
    }

    public int getDistanceFromStar() {
        return distanceFromStar;
    }

    public int getMegaMileRadius() {
        return megaMileRadius;
    }

    public Arena getArena() {
        return arena;
    }

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public void setTemparature(){
        averageTemparature = (int)((Math.random()*30-15)+distanceFromStar*(double)(100/130));
    }
}
