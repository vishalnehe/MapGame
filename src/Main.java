import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<String, String> directions = new HashMap<String, String>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of computer", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));

        directions.put("NORTH", "N");
        directions.put("SOUTH", "S");
        directions.put("WEST", "W");
        directions.put("EAST", "E");
        directions.put("QUIT", "Q");

        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are ");
            for (String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();
            String[] direction = scanner.nextLine().toUpperCase().split(" ");
            boolean found = false;
            for (String d: direction) {
                if(directions.containsKey(d)){
                    loc = exits.get(directions.get(d));
                    found = true;
                    break;
                } else if(exits.containsKey(d)){
                    loc = exits.get(d);
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
