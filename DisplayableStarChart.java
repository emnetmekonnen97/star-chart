/**
 * Name: Emnet Mekonnen
 * Date: 5/20/2024
 * CSC 202
 * Project 4-DisplayableStarChart.java 
 * 
 * An interface so that StarChart is guaranteed to have the methods
 * required by StarDisplay.
 */
import java.awt.Graphics;

public interface DisplayableStarChart {
	/**
	 * Adds star to the star chart
	 * @param star -- the star object to be added
	 * @param name -- the name of the star
	 */
	public abstract void addStar(Star star, String name);
	
	/**
	 * Adds a constellation to the star chart
	 * @param constellationName -- the name of the constellation
	 * @param starNames -- array of names that form the constellation
	 */
	public abstract void addConstellation(String constellationName, String[] starNames);
	
	/**
	 * checks if any constellation is displayed
	 * @return -- true if a constellation is displayed, false if not
	 */
	public abstract boolean isAnyConstellationDisplayed();
	
	/**
	 * checks if the constellation that is passed in is displayed
	 * @param name -- the name of the constellation 
	 * @return -- true if the constellation is displayed, false if not
	 */
	public abstract boolean isThisConstellationDisplayed(String name);
	
	/**
	 * Removes a constellation from the star chart
	 * @param constellationName -- name of the constellation to be removed
	 */
	public abstract void removeConstellation(String constellationName);
	
	/**
	 * Gets the name of the star
	 * @param star -- the star object 
	 * @return -- name of the star object
	 */
	public abstract String getName(Star star);
	
	/**
	 * Gets the star by using the name
	 * @param name -- name of the star
	 * @return -- star object
	 */
	public abstract Star getStar(String name);
	
	/**
	 * "Destroys" a star and other stars near it
	 * @param star -- star object to be destroyed
	 * @return -- the number of stars that were destroyed
	 */
	public abstract int supernova(Star star);
	
	/**
	 * Draws the stars and constellations 
	 * @param g -- graphics object
	 * @param showStarName -- boolean that shows if the star name should be displayed or not
	 */
	public abstract void draw(Graphics g, boolean showStarName);
}
