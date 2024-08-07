/**
 * Name: Emnet Mekonnen 
 * Date: 5/20/2024
 * CSC 202
 * Project 4-StarChart.java
 * 
 * This class represents information about stars to be displayed including
 * the position of each star, names of stars, and constellations. The
 * distance between two stars can be determined. A supernova can be 
 * simulated creating dead stars.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 * Professor Mueller helped with issues I had with the count and drawing the destroyed
 * stars in the supernova and draw methods
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class StarChart implements DisplayableStarChart {
	private static double SUPERNOVA_DISTANCE = 0.25;
	
	private int width;
	private int height;
	private Set<Star> removedStarSet;
	private Map<Star, String> starNameMap;
	private Map<String, Star> nameStarMap;
	private Map<String, String[]> constellationMap;
	
	/**
	 * Initializes a starchart object with the specified width and height
	 * @param width
	 * @param height
	 */
	public StarChart(int width, int height) {
		this.width = width;
		this.height = height;
		removedStarSet = new HashSet<>();
		starNameMap = new HashMap<>();
		nameStarMap = new HashMap<>();
		constellationMap = new HashMap<>();
	}
	
	@Override
	public void addStar(Star star, String name) {
		starNameMap.put(star, name);
		if(name != null) {
			nameStarMap.put(name, star);
		}
		
	}
	
	@Override
	public void addConstellation(String constellationName, String[] starNames) {
		constellationMap.put(constellationName, starNames);
	}
	
	@Override
	public String getName(Star star) {
		return starNameMap.get(star);
	}
	@Override
	public boolean isAnyConstellationDisplayed() {
		return !constellationMap.isEmpty();
	}
	@Override
	public boolean isThisConstellationDisplayed(String constellationName) {
		return constellationMap.containsKey(constellationName);
	}
	
	@Override
	public void removeConstellation(String constellationName) {
		constellationMap.remove(constellationName);
	}
	
	@Override
	public Star getStar(String name) {
		return nameStarMap.get(name);
	}
	
	@Override
	public int supernova(Star star) {
		int destroyedCount = 0;
		
        if (!removedStarSet.contains(star)) {
            removedStarSet.add(star);
            destroyedCount++;
        }

		for(Star otherStar : starNameMap.keySet()) {
			if(otherStar.distance(star) <= SUPERNOVA_DISTANCE) {
				if(!removedStarSet.contains(otherStar)) {
					removedStarSet.add(otherStar);
					destroyedCount++;
				}
			}
		}
		return destroyedCount;
	}
	
	/*
	 * Draws the stars, if the star is dead 
	 * it will be drawn red otherwise it will stay white
	 */

	private void drawStars(Graphics g, Star star) {
		if(!removedStarSet.contains(star)) {
			g.setColor(star.pixelColor());
		}else {
			g.setColor(Color.RED);
		}
		
		g.fillRect(star.pixelX(width), star.pixelY(height), star.pixelSize(), star.pixelSize());
	}
	
	/*
	 * draws the constellation and name of the constellation if showStarNames is false
	 * draws the names of the stars if showStarNames is true
	 */
	private void drawConstellations(Graphics g, String[] starNames, boolean showStarNames, String names) {
		Star lastStar = nameStarMap.get(starNames[starNames.length - 1]);
		int lastX = lastStar.pixelX(width);
		int lastY = lastStar.pixelY(height);
		
		for(int i = 0; i < starNames.length - 1; i += 2) {
			Star starOne = nameStarMap.get(starNames[i]);
			Star starTwo = nameStarMap.get(starNames[i + 1]);
			
			int x1 = starOne.pixelX(width);
			int x2 = starTwo.pixelX(width);
			int y1 = starOne.pixelY(height);
			int y2 = starTwo.pixelY(height);
			
			g.setColor(Color.YELLOW);
			g.drawLine(x1, y1, x2, y2);
		
			
			if(showStarNames) {
				g.setColor(Color.WHITE);
				g.drawString(starNames[i], x1, y1);
				g.drawString(starNames[i + 1], x2, y2);
			}else {
				g.drawString(names, lastX, lastY);
			}
		}
	}
	
	@Override
	public void draw(Graphics g, boolean showStarNames) {
		for(Star star : starNameMap.keySet()) {
			drawStars(g, star);
		}
		for(String name : constellationMap.keySet()) {
			String[] starNames = constellationMap.get(name);
			drawConstellations(g, starNames, showStarNames, name);
				
		}
		
	}
}
