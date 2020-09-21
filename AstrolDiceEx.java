import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AstrolDiceEx {
	// for experimentation

	public static void main(String[] args) throws IOException {

		List<String> lines = Collections.emptyList();
		lines = Files.readAllLines(Paths.get("astroDice.txt"), StandardCharsets.UTF_8);

		houses(lines); // house
		System.out.println();
		ass(AstrEnum.astro(), lines);
		planet(lines);

	}

	
	
	public static void ass(AstrEnum a, List<String> l) {
		Iterator<String> itr = l.iterator();
		int i = 0;
		System.out.println(a); // CHECK
		while (i < l.size()) {
			if(l.get(i).contains(a.toString())) {
				System.out.println(l.get(i));
			}
			itr.next();
			i++;
		}
	}

	public enum AstrEnum { // omfg an array would've been simpler and faster whytf did i use enum?!
		// https://stackoverflow.com/questions/35277214/how-to-randomly-select-an-enum-value
		ARIES(1), TAURUS(2), GEMINI(3), CANCER(4), LEO(5), VIRGO(6), 
		LIBRA(7), SCORPIO(8), SAGITTARIUS(9), CAPRICORN(10), AQUARIUS(11), PISCES(12);

		private AstrEnum(int i) {}

		public static AstrEnum astro() {
			AstrEnum[] astr = AstrEnum.values();
			Random rand = new Random();
			return astr[rand.nextInt(astr.length)];
		}
	}

	public static void planet(List<String> l) {
		// array note: just don't change the order of this without also changing order of txt file
		String[] planets = { 
			"Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", 
			"Saturn", "Uranus", "Neptune", "Pluto", "South Node", "North Node"
		};
		Random rand = new Random();
		int r = rand.nextInt(planets.length);
		int i = 0;
		Iterator<String> itr = l.iterator();
		System.out.println(r+ " "+planets[r]);
		while(i < l.size()) {
			if(l.get(i).contains(planets[r])) {
				System.out.println(l.get(i));
			}
			itr.next();
			i++;
		}
	}
	
	public static void houses(List<String> l) {
		int i = 0;
		Random rand = new Random();
		int r = rand.nextInt(12) + 1;
		Iterator<String> itr = l.iterator();
		// System.out.println(r); //check
		while (i < l.size()) {
			// System.out.println(lines.get(i).contains("01-")); //check
			if (l.get(i).contains(r + "-")) {
				System.out.print(l.get(i));
			}
			itr.next();
			i++;
		}
	}
	
	// combining planets and astro signs
	public static void f(List<String> l) {
		String[] planets = { "Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
				"Pluto", "South Node", "North Node" };
		String[] ass = { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius",
				"Capricorn", "Aquarius", "Pisces" };

		Random rand = new Random();
		int rAss = rand.nextInt(12), rPlan = rand.nextInt(12);
		int i = 0, j = 0;
		Iterator<String> itr = l.iterator();
		while (i < l.size() && j < l.size()) {
			if (l.get(i).contains(planets[rAss])) {
				System.out.println(l.get(i));
			}
			itr.next();
			i++;
			
			if (l.get(j).contains(ass[rPlan])) {
				System.out.println(l.get(j));
			}
			l.iterator().next();
			j++;
		} 
	} 

}
