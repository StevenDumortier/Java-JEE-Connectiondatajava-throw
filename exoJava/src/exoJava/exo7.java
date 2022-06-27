package exoJava;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class exo7{

	  public static void main(String args[]) {

	    Scanner sc = new Scanner(System.in);
	    List<Integer> list = new ArrayList<Integer>();

	    while (true) {
	        try {
	            System.out.print("Entrez un nombre :");
	            String response = sc.nextLine(); 
	            if (response.equals("q")) {
	              break;
	            } else {
	              int newNumber = Integer.parseInt(response);
	              if (!list.contains(newNumber)){ 
	                list.add(newNumber);
	              } else {
	                Integer positionDoublon = list.indexOf(newNumber)+1;
	                System.out.println("Chiffre d�ja ajout� � la saisie !�" + positionDoublon);
	              }
	            }
	          } catch (NumberFormatException e) {
	            System.out.println("L'erreur est: " + e);
	          }
	    
	    }

	    Iterator i = list.iterator();

	    while (i.hasNext()) {
	      System.out.println(i.next());
	    }

	    System.out.println("Vous avez saisi " + list.size() + " nombres.");

	  }
}
	

	


