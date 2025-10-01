import java.util.*;
public class Ticket_Itinerary {

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> reverseMap = new HashMap<>();

        for(String from : tickets.keySet()){
            // key -> key;
            // val -> ticket.get(key)
            reverseMap.put(tickets.get(from), from);   //FROM becomes TO and TO becomes FROM
        }

        for(String from : tickets.keySet()){
            if(!reverseMap.containsKey(from)){
                return from;
            }
        }
        //if not found returns null signifying no possible start
        return null;
    }

    public static void main(String args[]){
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        System.out.println("Itenirary of Tickets : ");
        for(String from : tickets.keySet()){
            System.out.println(from + " --> " + tickets.get(from));
        }

        String Start = getStart(tickets);

        System.out.println("\n Final Route : ");
        while(tickets.containsKey(Start)){    // if the start exists in HaspMap
            System.out.print(Start + " --> ");
            Start = tickets.get(Start);
        }
        System.out.println(Start);
    }
}
