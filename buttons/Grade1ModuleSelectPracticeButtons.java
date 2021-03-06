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
package project.buttons;

import java.awt.image.BufferedImage;
import java.io.IOException;

import project.constants.DifficultyLevel;
import project.interfaces.EnumerableButtonFactory;
import project.interfaces.ModuleSelectButtonInterface;
import project.screens.ModuleSelectScreen;
import project.tools.ContentPane;
import project.tools.ImageLoader;

/**
 * This class is used to describe the set of Practice module buttons available to a Grade1-2 student.
 *  Each button executes the appropriate Practice module. Each button implements
 *  ModuleSelectButtonInterface. A title describing the collection of buttons may be obtained via
 *  the getTitleText() method.
 * @author Kenneth Chin
 */
public class Grade1ModuleSelectPracticeButtons implements EnumerableButtonFactory{
	
	//The file path prefix for all button images starting from the program's root directory.
	private static final String   GRADE1_IMAGE_PATH = "\\images\\moduleSelect\\grade1-2\\ActiveButtons\\";
	private static final String   TITLE_TEXT        = "Practice a Skill"; //The Title of this collection of buttons.

	private int numberOfButtons = Button.values().length; //The number of buttons in this collection.
	
	/**
	 * Creates a collection of Practice module buttons. Each button implements ModuleSelectButtonInterface.
	 * @throws IOException Thrown if any of the button's image files can not be read.
	 */
	public Grade1ModuleSelectPracticeButtons() throws IOException{
		initButtons();
	}
	
	/**
	 * Creates and sets the ContentPane for each button. Disabled buttons are not clickable.
	 * @throws IOException Thrown if any of the button's image files can not be read.
	 */
	private void initButtons() throws IOException{
		Button[] buttons = Button.values();
		for(int i=0; i<buttons.length; i++){
			String imagePath = GRADE1_IMAGE_PATH + buttons[i].getFileName();
			ContentPane button = makeButton(imagePath, buttons[i].getName());
			buttons[i].setButton(button);
		}
	}
	
	/**
	 * A helper method that creates the ContentPane for a button.
	 * @param imagePath A String describing the button's image file path from the program's root directory.
	 * @param name A String describing the button's name.
	 * @return The ContentPane for the specified button.
	 * @throws IOException Thrown if the button's image file can not be read.
	 */
	private ContentPane makeButton(String imagePath, String name) throws IOException{
		BufferedImage image = ImageLoader.getBufferedImage(imagePath);
		ContentPane   panel = new ContentPane(image, true, false); 
		panel.setName(name);
		return panel;
	}
	
	@Override
	public ModuleSelectButtonInterface[] getButtons(){
		return Button.values();
	}
	
	@Override
	public int getNumberOfButtons(){
		return numberOfButtons;
	}
	
	@Override
	public String getTitleText(){
		return TITLE_TEXT;
	}

	
	/**
	 * This enum describes the individual buttons of Grade1ModuleSelectPracticeButtons. Each button
	 *  implements ModuleSelectButtonInterface, and is used to execute a specified Practice module
	 *  for Grade1-2 students.
	 * @author Kenneth Chin
	 */
	public enum Button implements ModuleSelectButtonInterface{

		/**
		 * The Expansion Grade1-2 Practice module button.
		 */
		EXPANSION   ("Expansion",  "1_expansion.png"  , 300, 200) {

			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 *  The Measure Grade1-2 Practice module button.
		 */
		MEASURE   ("Measure",  "2_measure.png"  , 590, 200) {

			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Fractions Grade1-2 Practice module button.
		 */
		FRACTIONS  ("Fractions", "3_fractions.png" , 303, 375) {

			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Comparison Grade1-2 Practice module button.
		 */
		COMPARISON ("Comparison","4_comparison.png", 593, 375) {
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Odd & Even Grade1-2 Practice module button.
		 */
		ODD_EVEN  ("Odd & Even", "5_odd&even.png" , 300, 200) {
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Money Grade1-2 Practice module button.
		 */
		MONEY      ("Money",     "6_money.png"     , 590, 200) {
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Word Problems Grade1-2 Practice module button.
		 */
		WORD_PROB ("Word Problems","7_wordProblems.png", 300, 375) {

			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + "Practice!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Arithmetic Grade1-2 Practice module button.
		 */
		ARITHMETIC   ("Arithmetic",  "8_arithmetic.png"  , 590, 375) {
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		},
		/**
		 * The Estimation Grade1-2 Practice module button.
		 */
		ESTIMATION      ("Estimation", "9_estimation.png", 300, 200) {
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the " + getName() + " Practice!");
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				// TODO Auto-generated method stub
				
			}
		};
	
		private String name;     //The button's name.
		private String fileName; //The button's image file path from the program's root directory.
		private int x;           //The button's x-origin.
		private int y;           //The button's y-origin.
		
		private ContentPane button; //The button's ContentPane.
	
		/**
		 * The constructor for all Button objects.
		 * @param name A String describing the button's name.
		 * @param fileName A String describing the button's image file path from the program's root directory.
		 * @param xOrigin An int describing the button's x-origin.
		 * @param yOrigin An int describing the button's y-origin.
		 */
		private Button(String name, String fileName, int xOrigin, int yOrigin){
			this.name = name;
			this.fileName = fileName;
			x = xOrigin;
			y = yOrigin;
		}
		
		@Override
		public String getName(){
			return name;
		}
	
		@Override
		public String getFileName(){
			return fileName;
		}
	
		@Override
		public int getX(){
			return x;
		}
	
		@Override
		public int getY(){
			return y;
		}
	
		/**
		 * Used to set this button's ContentPane.
		 * @param button This button's ContentPane.
		 */
		private void setButton(ContentPane button){
			this.button = button;
		}
	
		@Override
		public ContentPane getButton(){
			return button;
		}
		
		@Override
		public int getOrdinal(){
			return this.ordinal();
		}
		
		@Override
		public abstract void doAction(ModuleSelectScreen screen);
		
		@Override
		public abstract void difficultySelected(DifficultyLevel level);
	}
}