
public class Main {

	public static void main(String[] args) {
		Vetor vetor = new Vetor();
		
		vetor.insertAtRank(0, "a");
		System.out.println(vetor.toString());
		vetor.insertAtRank(1, "b");
		System.out.println(vetor.toString());
		vetor.insertAtRank(2, "c");
		System.out.println(vetor.toString());
		vetor.replaceAtRank(0, "a2");
		System.out.println(vetor.toString());
		vetor.removeAtRank(0);
		System.out.println(vetor.toString());
		//vetor.removeAtRank(1);
		//System.out.println(vetor.toString());
		//vetor.replaceAtRank(1, "e");
		//System.out.println(vetor.toString());
	}

}
