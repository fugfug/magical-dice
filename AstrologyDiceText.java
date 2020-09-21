import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

// done, but messy. text only
// like a magic 8 ball, but with a more mystical twist
// inspired by: https://eclecticwitchcraft.com/astrology-dice/

public class AstrologyDiceText {

	private static Random rand = new Random();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("First: ask a question, the more specific the question the better. \r\n" + 
				"\tInstead of saying \"will I earn more money\" try asking \"will my boss give me the promotion I've been trying to get\"\r\n" + 
				"Second: Roll the Dice and read them like this\r\n" + 
				"\tPlanets- What\r\n" + 
				"\tSigns- How\r\n" + 
				"\tHouses- Where\n");
		
		// this is useless but whatever. 
		Scanner scan = new Scanner(System.in);
		System.out.println("Ask your question and remember to be specific: ");
		String question = scan.nextLine();
		System.out.println("\n--------------- Please Wait --------------- \n");
		Thread.sleep(rand.nextInt(10000)); // a pause is unnecessary, but it looks soooo much cooler. ha
		
		List<String> lines = Collections.emptyList();
		lines = Files.readAllLines(Paths.get("astroDice.txt"), StandardCharsets.UTF_8);

		System.out.println(planet(lines));
		System.out.println("--------------- Please Wait --------------- \n");
		Thread.sleep(rand.nextInt(5000)); // also unnecessary, but it looks so much cooler.
		System.out.println(sign(lines));
		System.out.println("\n--------------- Please Wait --------------- \n");
		Thread.sleep(rand.nextInt(5000));
		System.out.println(houses(lines));
 
	}

	public static String planet(List<String> l) {
		// array note: just don't change the order of this without also changing order
		// of txt file
		String[] planets = { "Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
				"Pluto", "South Node", "North Node" };
		
		int r = rand.nextInt(planets.length);
		int i = 0;
		Iterator<String> itr = l.iterator();
		while (i < l.size()) {
			if (l.get(i).contains(planets[r])) {
				return l.get(i).replaceAll("([.;])", "\n");
				// thanks: https://stackoverflow.com/questions/43569023/java-how-to-split-a-string-into-a-new-line-after-every-punctuation-mark
			}
			itr.next();
			i++;
		}
		return "Ask again later";
	}

	public static String sign(List<String> l) {
		String[] astroSigns = { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius",
				"Capricorn", "Aquarius", "Pisces" };
		int r = rand.nextInt(astroSigns.length);
		int i = 0;
		Iterator<String> itr = l.iterator();
		while (i < l.size()) {
			if (l.get(i).contains(astroSigns[r])) {
				return l.get(i).replaceAll("([.;])", "\n");
			}
			itr.next();
			i++;
		}
		return "Ask again later";
	}

	public static String houses(List<String> l) {
		int i = 0;
		int r = rand.nextInt(12) + 1;
		Iterator<String> itr = l.iterator();
		while (i < l.size()) {
			if (l.get(i).contains(r + "-")) {
				return l.get(i).replaceAll("([.;])", "\n");
			}
			itr.next();
			i++;
		}
		return "Ask again later";
	}

}
