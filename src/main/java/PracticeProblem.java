import java.util.HashMap;

public class PracticeProblem {

	public static void main(String args[]) {
		int[] cost = new int[]{1, 100, 1, 100, 1, 100, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
	}


public static int fib(int num){
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	return fibHelper(map, num);
}

public static int fibHelper(HashMap<Integer, Integer> map, int num){
	if (num == 0){
		return 0;
	}
	if (num == 1){
		return 1;
	}

	if(map.containsKey(num)){
		return map.get(num);
	}


	int value = fibHelper(map, num-1) + fibHelper(map, num-2);

	map.put(num, value);
System.out.println(map);

	return value;
}


public static int minCostClimbingStairs(int[] cost){
int payed = 0;
int index = 0;
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
int upOne = stairHelper(cost, payed, index, map);
if (cost.length>1){
	index = 1;
int upTwo = stairHelper(cost, payed, index, map);
upOne = Math.min(upOne, upTwo);

}

return upOne;
}

public static int stairHelper(int[] cost, int payed, int index, HashMap <Integer,Integer> map){
if (index>=cost.length){
	return payed;
}

if(map.containsKey(index)){
	return payed + map.get(index);
}
int prevPaid = payed;
payed = payed + cost[index];

int upOne = stairHelper(cost, payed, index+1, map);
int upTwo = stairHelper(cost, payed, index+2, map);

if (upOne>upTwo){
	payed = upTwo;
}
else{
	payed = upOne;
}		
System.out.println(index + " this is index and this is " + payed);
map.put(index, payed-prevPaid);	

return payed;
}

}
