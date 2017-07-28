package java8ex3;

public class Task_24 {

	public static void main(String[] args) {
		Pair<Integer, Integer> p1 = new Pair<>(1, 4);
		System.out.println(p1.getLeft() + " , " + p1.getRight());
		
		Pair<Integer, Integer> result = p1.map(x -> {
			return new Pair<Integer, Integer>(x.getLeft() + 1, x.getRight() + 2);
		});
		System.out.println(result.getLeft() + " , " + result.getRight());
	}
}
