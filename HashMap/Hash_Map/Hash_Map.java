import java.util.HashMap;
import java.util.Set;
public class Hash_Map {
    public static void main(String args[]){
        //HashMap - country(key), population(value)
        HashMap<String, Integer> map = new HashMap<>();

        //Insertion
        map.put("India", 120);
        map.put("U.S", 30);
        map.put("China", 150);

        System.out.println(map);      //unordered

        map.put("China", 180);        //does not add new value but updates as the key "China" already exists
        System.out.println(map);

        //Search
        if(map.containsKey("India")) {
            System.out.println("Key \"India\" exists in the map");
        }
        else{
            System.out.println("Key \"India\" does not exist in the map");
        }

        //Returning value using key  - Searching for a value or a key
        System.out.println(map.get("China"));    // key exists prints VALUE
        System.out.println(map.get("Indonesia"));     // key does not exist prints NULL

        System.out.println(map.containsKey("India"));   // key exists prints TRUE
        System.out.println(map.containsKey("Indonesia"));     // key does not exist prints FALSE

        System.out.println(map.containsValue(180));    // value exists prints TRUE
        System.out.println(map.containsValue(0));     // value does not exist prints FALSE

        // Iterating
        // it is similar to  ->  for(int val : arr)
        // so - >   for( Map.Entry<String, Integer>      is the Datatype dec
        // e is the variable holding the value itself each time of the iteration
        //  : map.entrySet()       ->   converts HashMap into a Set of Entries and allows e to iterate in the somewhat Set
        for(HashMap.Entry<String, Integer> e : map.entrySet()){
            System.out.println("Key : "+e.getKey());
            System.out.println("Value : "+e.getValue() + "\n");
        }

        // Another way to Iterate - using keySet()
        //converts HashMap int a Set of Keys and allows e to iterate in the somewhat Set
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " " + map.get(key));
        }

        // Removing
        map.remove("China");
        System.out.println(map);
    }
}
