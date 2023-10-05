import java.util.Random;

public class Room {
	private Item doorvariable;
	private boolean isNemesis = false;
	private Challenge roomChallenge;
	private int difficulty;
	
	/**
	 * Constructor that initializes the difficulty and nemesisAppears
	 * @param aDifficulty  the games difficulty
	 * @param aNemesisAppears  if the room is 100% supposed to be a nemesis room, then this will be true.
	 */
	public Room(int aDifficulty, boolean nemesisAppears) {
		doorvariable = new Item();
        difficulty = aDifficulty;
		int nemesisChance = new Random().nextInt(100) + 1;
		if (nemesisAppears || nemesisChance <=33) {
			isNemesis = true;
            aDifficulty++;
		}
		roomChallenge = new Challenge(aDifficulty);
	}

    /**
	 * Constructor that initializes the difficulty and nemesisAppears, no randomization for testing
	 * @param aDifficulty  the games difficulty
	 * @param aNemesisAppears  if the room is 100% supposed to be a nemesis room, then this will be true.
	 */
	public Room(int aDifficulty, boolean nemesisAppears, int useless) {
		doorvariable = new Item();
        difficulty = aDifficulty;
		if (nemesisAppears) {
			isNemesis = true;
            aDifficulty++;
		}
		roomChallenge = new Challenge(aDifficulty);
	}
	
	/**
	 * 
	 * @return shallow copy of door variable  Item required to unlock the door
	 */
	public Item getDoorVariable() {
		return new Item(doorvariable);
	}
	
	/**
	 * 
	 * @return shallow copy of the rooms challenge
	 */
	public Challenge getChallenge() {
		return roomChallenge;
	}
	
	/**
	 * 
	 * @return difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * 
	 * @return isNemesis   boolean returns true if the room is a nemesis room.
	 */
	public boolean isNemesisRoom() {
		return isNemesis;
	}
}