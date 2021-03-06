/**
 * Name:         Math Helper
 * Version:      0.11.2
 * Version Date: 04/20/2015
 * Team:         "Cool Math" - Consists of Kenneth Chin, Chris Moraal, Elena Eroshkina, and Austin Clark
 * Purpose:      The "Math Helper" software is used to aid parents and teachers with the teaching and testing
 *                 of students, grades PreK through Grade 4, in the subject of Mathematics. The lessons and
 *                 tests provided cover a subset of skills as specified by the Massachusetts Department of
 *                 Education's (DOE) website, found at:
 *                              http://www.doe.mass.edu/frameworks/math/2000/toc.html
 *                 The DOE category, �Number Sense and Operations� for Grades Pre-K through Grade 4,
 *                 is the subset that the "Math Helper" software covers.
 *                 
 *               Features and services of the "Math Helper" software include, Login/Logout mechanics,
 *                 practice and formal testing, and tutorials of the above-specified skills. Additional
 *                 features include test completion results, test completion summaries, and test
 *                 completion rewards.
 */
package project.interfaces;

/**
 * Used as an observer subject abstraction for objects that can be clicked via the mouse.
 * @author Kenneth Chin
 *
 */
public interface Clickable {

	/**
	 * Registers a ClickableObserver to be notified if this Clickable has been clicked by the mouse.
	 * @param obs The ClickableObserver to be notified.
	 */
	public void registerObserver(ClickableObserver obs);
	
	/**
	 * Removes a ClickableObserver from the list of ClickableObservers that are notified when this
	 *  Clickable is clicked by the mouse.
	 * @param obs The ClickableObserver to be removed.
	 */
	public void removeObserver(ClickableObserver obs);
	
	/**
	 * Calls the The ClickableObserver.clicked() method of all registered ClickableObservers when
	 *  this Clickable has been clicked by the mouse.
	 */
	public void notifiyObserver();
}
