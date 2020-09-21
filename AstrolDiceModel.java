import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class AstrolDiceModel {

/*

astrology dice inspired by: https://eclecticwitchcraft.com/astrology-dice/ and 
https://aminoapps.com/c/the-witches-united/page/blog/divination-astrodice/L22k_D5Xs8ug8j4zJpxjjPRz5qQVebQo42 

*/
	
	private static Random rand = new Random();
	private static List<String> lines = Collections.emptyList();
	private static String astroSign = "sign", astroPlanet="planet";
	private static int astroHouse=0;
	
	
	public static void main(String[] args) throws IOException {
		lines = Files.readAllLines(Paths.get("astroDice.txt"), StandardCharsets.UTF_8);
		// System.out.print(getSign() + "\n" + getPlanet() + "\n" + getHouse()); // for testing
	}
	
	
	public String getPlanet() throws IOException {
		lines = Files.readAllLines(Paths.get("astroDice.txt"), StandardCharsets.UTF_8);
		return planet(lines);
	}

	public String getSign() throws IOException {
		lines = Files.readAllLines(Paths.get("astroDice.txt"), StandardCharsets.UTF_8);
		return sign(lines);
	}

	public String getHouse() throws IOException {
		lines = Files.readAllLines(Paths.get("astroDice.txt"), StandardCharsets.UTF_8);
		return house(lines);
	}
	
	private static String planets(List<String> l) {
		// array note: just don't change the order of this without also changing order
		// of txt file
		String[] planets = { "Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
				"Pluto", "South Node", "North Node" };

		int r = rand.nextInt(planets.length);
		astroPlanet = planets[r];
		return astroPlanet;
	}
	
	private static String signs(List<String> l) {
		// array note: just don't change the order of this without also changing order
		// of txt file
		String[] astroSigns = { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio",
				"Sagittarius", "Capricorn", "Aquarius", "Pisces" };
		int r = rand.nextInt(astroSigns.length);
		astroSign = astroSigns[r];
		return astroSign;
	}
	
	private static int houses(List<String> l) {
		int r = rand.nextInt(12) + 1;
		astroHouse = r;
		return astroHouse;
	}
	
	private static String planet(List<String> l) {
		int i = 0;
		Iterator<String> itr = l.iterator();
		while (i < l.size()) {
			if(l.get(i).contains(astroPlanet)) {
				return l.get(i);
			}
			itr.next();
			i++;
		}
		return i + "\t Planet";
		
	}

	private static String sign(List<String> l) {
		int i = 0;
		Iterator<String> itr = l.iterator();
		while (i < l.size()) {
			if(l.get(i).contains(astroSign)) {
				return l.get(i);
			}
			itr.next();
			i++;
		}
		return i + "\t Sign";
	}

	private static String house(List<String> l) {
		int i = 0;
		Iterator<String> itr = l.iterator();
		while (i < l.size()) {
			if(l.get(i).contains(astroHouse + "-")) {
				return l.get(i);
			}
			itr.next();
			i++;
		}
		return i + "\t House";
	}
	
	public String getP() {
		return planets(lines);
	}
	public String getS() {
		return signs(lines);
	}
	public int getH() {
		return houses(lines);
	}
	
	// determines what images to display
	public String detPImg() {
		return astroPlanet+".png";
	}
	
	public String detSImg() {
		return astroSign+".png";
	}
	
	// determines what house # to display
	public int showH() {
		return astroHouse;
	}

}
