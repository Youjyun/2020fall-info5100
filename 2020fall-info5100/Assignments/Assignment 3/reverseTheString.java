public class reverseTheString {

	public String reverse(String s) {

		String res = "";
		String[] words = s.trim().split("\\s+");
		for (int i = words.length - 1; i > 0; --i) {
			res += words[i] + " ";
		}
		return res + words[0];
	}

	public static void main(String[] args) {

		reverseTheString str = new reverseTheString();
		System.out.println(str.reverse("the sky is blue"));

	}

}
