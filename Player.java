import java.util.ArrayList;

public class Player {
	
	private int health = 0;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	/**
	 * Constructor, sets the initial health and items list of the player.
	 * @param initialHealth  value to set the players health to
	 * @param items2  list of items to set the players starting items to.
	 */
	public Player(int initialHealth, ArrayList<Item> items2) {
		health = initialHealth;
		items = new ArrayList<Item>(items2);
	}
	
	/**
	 * constructor used to create an empty player class so that the methods can be used.
	 */
	public Player() {
		
	}
	
	/**
	 * adds an item to the players list of items.
	 * Possible privacy leak since this changes the players list of items directly, but this is necessary
	 * because if a player picks up an item we want to add it to their items list, rather than a copy of it.
	 * @param item  item to add to the players inventory.
	 */
	public void addItem(Item item){
		items.add(item);
	}
	
	/**
	 * removes an amount of health from the player.
	 * possible privacy leak since this changes the health instance variable directly, but it's necessary
	 * because we want to change the amount of health the player actually has, so we need to change their
	 * instance variable directly.
	 * @param amount  amount of health to remove from the player.
	 */
	public void updateHealth(int amount) {
		health = health-amount;
	}
	
	/**
	 * checks to see if the player is alive
	 * @return isAlive boolean that is true if the player is alive, false if they have died.
	 */
	public boolean isAlive() {
		boolean isAlive = true;
		if (health >0) {
			isAlive = true;
		}
		else if (health <=0) {
			isAlive = false;
		}
		return isAlive;
	}
	
	/**
	 * checks to see if the players inventory contains the item
	 * @param item  item that we're checking if the player has
	 * @return hasItem  boolean that's true if they have the item, false if they don't.
	 */
	public boolean hasItem (Item item) {
		boolean hasItem = false;
		for (int index = 0; index < items.size();index++) {
			if (items.get(index).getId() == item.getId()) {
				hasItem = true;
			}
		}
		return hasItem;
	}
	
	/**
	 * 
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * startHealth is used to set the initial health variable that we pass to the constructor
	 * in the player class. it is set to a different int depending on which character the user
	 * decides to pick.
	 * @param characterChoose  int representing which of the 6 characters the player chose.
	 * @return health   the health that their chosen characters has, to be passed to the player constructor later
	 */
	public int startHealth(int characterChoose) {
		if (characterChoose == 1) {
			health = 5;
		}
		else if (characterChoose == 2) {
			health = 10;
		}
		else if (characterChoose == 3) {
			health = 7;
		}
		else if (characterChoose == 4) {
			health = 8;
		}
		else if (characterChoose == 5) {
			health = 4;
		}
		else if (characterChoose == 6) {
			health = 1;
		}
		return health;
	}
	
	/**
	 * startItems is used to set the starting items list that we pass to the constructor in the
	 * player class. it is set to contain different items depending on which character the user
	 * decides to pick.
	 * @param characterChoose  int representing which of the 6 characters the player chose.
	 * @return items   the players starting item list.
	 */
	public ArrayList<Item> startItems(int characterChoose) {
		if (characterChoose == 1) {
			items.add(new Item(1, "Fire Key"));
		}
		else if (characterChoose == 2) {
			items.add(new Item(1, "Fire Key"));
			items.add(new Item(2, "Earth Key"));
			items.add(new Item(3, "Metal Key"));
			items.add(new Item(4, "Water Key"));
			items.add(new Item(5, "Wood Key"));
		}
		else if (characterChoose == 3) {
			items.add(new Item(2, "Earth Key"));
		}
		else if (characterChoose == 4) {
			items.add(new Item(3, "Metal Key"));
		}
		else if (characterChoose == 5) {
			items.add(new Item(4, "Water Key"));
			items.add(new Item(5, "Wood Key"));
		}
		else if (characterChoose == 6) {
			items.add(new Item(0, "none"));
		}
		return items;
	}
		
}