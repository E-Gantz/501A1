import java.util.Random;

public class Item {
	private int id;
	private String name;
	
	/**
	 * Constructor, sets the id and the name for the new item
	 * @param id  int from 1 to 5, depending on which item we are creating
	 * @param name the name of the item we are creating
	 */
	public Item(int id, String name) {
		setID(id);
		setName(name);
	}
	
	/**
	 * copy constructor
	 * @param toCopy  the item that we're copying.
	 */
	public Item(Item toCopy) {
		setID(toCopy.id);
		setName(toCopy.name);
	}
	
	/**
	 * constructor, creates a random item.
	 */
	public Item(){
		int randomID = new Random().nextInt(5) + 1;
		if (randomID == 1) {
			setID(1);
			setName("Fire Key");
		}
		else if (randomID == 2) {
			setID(2);
			setName("Earth Key");
		}
		else if (randomID == 3) {
			setID(3);
			setName("Metal Key");
		}
		else if (randomID == 4) {
			setID(4);
			setName("Water Key");
		}
		else if (randomID == 5) {
			setID(5);
			setName("Wood Key");
		}
	}
	
	/**
	 * possible privacy leak since we're directly returning a reference, but it's to a primitive
	 * so that shouldn't be an issue.
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param anId id to set the items id to
	 */
	private void setID(int anId) {
		this.id = anId;
	}
	
	/**
	 * possible privacy leak since we're directly returning a reference, but it's to a primitive
	 * so that shouldn't be an issue.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name  name to set the items name to.
	 */
	private void setName(String name) {
		this.name = name;
	}
	
}