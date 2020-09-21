import java.util.*;

public class SimpleFortuneTellingDice {

// inspired by: https://aminoapps.com/c/pagans-witches/page/blog/dice-divination-some-methods/o3Pw_4vDhduDb3WelEGMdQqlZLo2adzYJ6o
// because i'm bored	

	static Random rand = new Random();

	public static void main(String[] args) {
		
		// 4 options:
		// 1. yes no; evens - yes, odds no
		// 2. past present future 
			// first: past, second: present, third: future; evens: positive, odds: neg
		// 3. Future Outcome; 9 outcomes; use map?
		// 4. 

		intro();
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		while (option > 0 && option < 4) {
			if(option == 1) {
				YesNo();
				intro();
				option = scan.nextInt();
			} else if(option == 2) {
				PastPresentFuture();
				intro();
				option = scan.nextInt();
			} else if (option == 3) {
				System.out.println(results(FutureOutcome())+"\n");
				intro();
				option = scan.nextInt();
			}
		}
	}
	
	public static void intro() {

		System.out.println(
				"Enter a number 1 - 3; <=0 to quit\n"+
				"<= 0. quit" +
				"\n1. Yes or No: "+
						"\n\t Evens = Yes; Odds = No" + 
				"\n2. Past, Present, and Future: " + 
						"\n\t First #: Past, Second #: Present, Third #: Future;" 
				+ "\n\t Evens = Positive outcome, Odds = Negative outcome" + 
				"\n3. Future Outcome: will predict something that might happen in the near future."
		);
	}
	
	public static String results(int t) {
		String[] res = { // meanings won't change, so why use something complicated?
				"0. w/e m8. ", // this one shouldn't be displayed
				"1- Sorrow",
				"2- Joy",
				"3- A Gift",
				"4- New Love",
				"5- Silver Is Coming Your Way",
				"6- Gold Is Coming Your Way",
				"7- Someone Will Tell You A Secret",
				"8- Three Good Things Will Happen To You",
				"9- Your True Love Is, Indeed, True"
		};
		return res[t];
	}
	
	
	public static int FutureOutcome() {
		int total = 0;
		for(int i = 0; i < 3; i++) {
			int n = rand.nextInt(6) + 1;
			// System.out.print(n + " "); //for check
			total += n;
		} 
		// System.out.println(total); // for check
		if(total > 9) {
			total -= 10; 
			total += 1; // easiest way, tbh
		}
		return total;
	}
	
	public static void PastPresentFuture() { //2
		int[] nums = new int[3];
		for(int i = 0; i < 3; i++) {
			int n = rand.nextInt(6) + 1;
			nums[i] = n;
			
			System.out.print(n + " ");
		} 
		System.out.println("\n");
	}
	
	public static void YesNo() { //1
		int n = rand.nextInt(6) + 1;
		System.out.println(n+"\n");
	}
	
	
	
	
	
}
