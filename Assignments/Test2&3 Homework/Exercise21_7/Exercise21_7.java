import java.util.*;

 public class Exercise21_7 {
 public static void main(String[] args) {
 // Set text in a string
 String text = "Good morning. Have a good class. " +
 "Have a good visit. Have fun!";

 // Create a TreeMap to hold words as key and count as value
 Map<String, Integer> map = new TreeMap<>();
//In this section of this code the computer fails to function properly. Declaring a unclosed character class near index 14. I am unsure of what to do with this since this segment is taken strictly out of the book.
 String[] words = text.split("[ \n\t\r.,;:!?{}(");
 for (int i = 0; i < words.length; i++) {
 String key = words[i].toLowerCase();

 if (key.length() > 0) {
 if (!map.containsKey(key)) {
 map.put(key, 1);
 }
 else {
 int value = map.get(key);
 value++;
 map.put(key, value);
 }
 }
 }

System.out.println(entriesbyValues(map));
 }
static <K,V extends Comparable<? super V>>
SortedSet<Map.Entry<K,V>>entriesbyValues(Map<K,V> map)
   {
      SortedSet<Map.Entry<K,V>> sortedValues = new TreeSet<Map.Entry<K,V>>(
         new Comparator<Map.Entry<K,V>>()
         {
            @Override public int compare(Map.Entry<K,V> v1, Map.Entry<K,V> v2)
            {
               int result = v1.getValue().compareTo(v2.getValue());
               return result !=0 ? result : 1;
            }
         }
      );
   sortedValues.addAll(map.entrySet());
   return sortedValues;
}//end entriesbyValues
}//end exervise
