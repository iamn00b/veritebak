import java.io.*;
import java.util.*;

public class Veritebak {

	public String[] dictionary;
	public String current;

	public Veritebak(String[] dictionary) {
		this.dictionary = dictionary;
	}

	public boolean tebak(String tebakan) {
		return (current.equals(tebakan));
	}

	public String acak(String kata) {
		List<String> kataAcakList = Arrays.asList(kata.split(""));
		Collections.shuffle(kataAcakList);

		String kataAcak = "";
		for (String huruf : kataAcakList) {
		  kataAcak += huruf;
		}

		return kataAcak;
	}

	public static void main(String argv[]) throws Exception {

		// Scanner dan inisiasi permainan
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Veritebak game = new Veritebak(argv);

		// randomizer
		Random rng = new Random();

		// Forever Loop
		while (true) {

			// ambil kata
			game.current = game.dictionary[rng.nextInt(game.dictionary.length)];
			System.out.println("Hints : " + game.acak(game.current));

			boolean hasil = false;
			while (!hasil) {

				System.out.print("Jawab : ");
				hasil = game.tebak(input.readLine());

				if (hasil) 
					System.out.println("BENAR! Anda Berhasil!");
				else
					System.out.println("SALAH! Silahkan coba lagi!");
			}
		}
	}
}

// class LowercaseTrie {

// 	Node head;

// 	class Node {
// 		public boolean valid;
// 		public Node[] child;

// 		public Node() {
// 			child = new boolean[26];
// 		}
// 	}

// 	public LowercaseTrie() {
// 		head = new Node();
// 	}

// 	public String add(String s) {
// 		s = s.toLowerCase();
// 		for (int i = 0; i < s.length(); i++) {
// 			int index = s.charAt(i) - 97;
// 			head.child[index]
// 		}
// 		return s;
// 	}
// }