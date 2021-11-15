public class ExtractNumbersFromStringArray {

	// idea:
	// part2 :
	/*
	part 2 will dolater on

	part 1:

	i think craeting a class called item and having diff class object inside this class

	class Item{
	// so basically having Object as key and val as list that particualr Object
		HashMap<Integer,HashMap<Object, List<Object>>> item;
		Hotel hotel;
		Airport airport;
		TouristsActivity activity;
	}

	// we can use map like
	map(key = item id, value = map(key = type, val = list of that type like all airports ))
	// constructor
	public Item(){
		item = new HashMap<>();
	}

	ok so lets say we have method filter
	in that we will have params as item id, type, star rating

	public List<Item> filter(Object type, String rating){

		List<Items> res = new ArrayList<>();
		for(HashMap<Object, List<Object>> item: items.keySet()){

			if(item.containsKey(type)){
				List<Object> tmpType = item.get(type);
				for(Object tmpItem: tmpType){
					if(tmpItem.starRating >= rating){
						res.add(tmpItem);
					}
				}

			}
		}

		return res;
	}

	//other classes:


	class Hotel{
		// for start rating lets say we have variable  for star rating
		String starRating;
		int id;
		String name
		// as such
	}

	class Airport{
		String starRating;
		//same for this

	}

	class TouristsActivity{
	// for prices we can use a hashet as no duplicates for prices
	// lets take a list

	Set<Integer> prices = new HashSet<>();
	set.add(10);
	set.add(25);
	set.add(50);
	set.add(100);

	// ask: do u want me to set 4 particaluar acticivites with these above prices
	}

	// it will
	part 2:


	the idea can be
	we can consider the given array as denominations
	// greedy algo
	we can take the biggest price  first and check if


	// assumeing we have list of prices or set as the lookpu will be faster


	// ok we cna use tourist acticity class to  get the set of prices
	// i thot no duplictes of price and lookup is faster

public int solution(TouristActivity activity, int amount) {
	List<Inetegr> prices = activity.getPrices();
	//sort list
	List<Inteher> res = new ArrayList<>();
	for(int p : prices){
		if(amount >= p){
			res.add(p);
			amount = ampount - p;
		}
	}  // loop end here
	//LeftOver amount
	if(budgetAmount > 0 ){
		res.add(budgetAmount);
	}

	return res;

    return solution(0, prices, amount);
  }

	 */
}
