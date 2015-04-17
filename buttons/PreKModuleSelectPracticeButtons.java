/**
 * Name:         Math Helper
 * Version:      0.10.0
 * Version Date: 04/16/2015
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
import project.run.GUIManager;
import project.screens.DifficultySelectScreen;
import project.screens.ModuleSelectScreen;
import project.tests.PreKTestArithmetic;
import project.tests.PreKTestCounting;
import project.tests.PreKTestMatching;
import project.tests.PreKTestSequences;
import project.tools.ContentPane;
import project.tools.ImageLoader;

/**
 * This class is used to describe the set of Practice module buttons available to a PreK-K student.
 *  Each button executes the appropriate Practice module. Each button implements
 *  ModuleSelectButtonInterface. A title describing the collection of buttons may be obtained via
 *  the getTitleText() method.
 * @author Kenneth Chin
 */
public class PreKModuleSelectPracticeButtons implements EnumerableButtonFactory{
	
	//The file path prefix for all button images starting from the program's root directory.
	private static final String   PREK_IMAGE_PATH = "\\images\\moduleSelect\\preK-K\\ActiveButtons\\";
	private static final String   TITLE_TEXT      = "Practice a Skill"; //The Title of this collection of buttons.

	private int numberOfButtons = Button.values().length; //The number of buttons in this collection.
	
	/**
	 * Creates a collection of Practice module buttons. Each button implements ModuleSelectButtonInterface.
	 * @throws IOException Thrown if any of the button's image files can not be read.
	 */
	public PreKModuleSelectPracticeButtons() throws IOException{
		initButtons();
	}
	
	/**
	 * Creates and sets the ContentPane for each button. Disabled buttons are not clickable.
	 * @throws IOException Thrown if any of the button's image files can not be read.
	 */
	private void initButtons() throws IOException{
		Button[] buttons = Button.values();
		for(int i=0; i<buttons.length; i++){
			String imagePath = PREK_IMAGE_PATH + buttons[i].getFileName();
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
	 * This enum describes the individual buttons of PreKModuleSelectPracticeButtons. Each button
	 *  implements ModuleSelectButtonInterface, and is used to execute a specified Practice module
	 *  for PreK-K students.
	 * @author Kenneth Chin
	 */
	public enum Button implements ModuleSelectButtonInterface{

		/**
		 * The Counting Prek-K Practice module button.
		 */
		COUNTING   ("Counting",  "1_counting.png"  , 300, 225) {
			
			private GUIManager manager;
			private DifficultySelectScreen difficultyScreen;
			
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the DifficultySelectScreen!");
				this.manager = screen.getManager();
				screen.tearDown();
				try {
					difficultyScreen = new DifficultySelectScreen(manager, this);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				System.out.println("Opening the " + level.getName() + " " + getName() + " Practice!");
				difficultyScreen.tearDown();
				try {
					new PreKTestCounting(manager, true, level);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}
		},
		/**
		 *  The Matching Prek-K Practice module button.
		 */
		MATCHING   ("Matching",  "2_matching.png"  , 590, 225) {
			
			private GUIManager manager;
			private DifficultySelectScreen difficultyScreen;
			
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the DifficultySelectScreen!");
				this.manager = screen.getManager();
				screen.tearDown();
				try {
					difficultyScreen = new DifficultySelectScreen(manager, this);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				System.out.println("Opening the " + level.getName() + " " + getName() + " Practice!");
				difficultyScreen.tearDown();
				try {
					new PreKTestMatching(manager, true, level);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}
		},
		/**
		 * The Sequences Prek-K Practice module button.
		 */
		SEQUENCES  ("Sequences", "3_sequences.png" , 303, 400) {
			
			private GUIManager manager;
			private DifficultySelectScreen difficultyScreen;
			
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the DifficultySelectScreen!");
				this.manager = screen.getManager();
				screen.tearDown();
				try {
					difficultyScreen = new DifficultySelectScreen(manager, this);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				System.out.println("Opening the " + level.getName() + " " + getName() + " Practice!");
				difficultyScreen.tearDown();
				try {
					new PreKTestSequences(manager, true, level);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}
		},
		/**
		 * The Comparison Prek-K Practice module button.
		 */
		COMPARISON ("Comparison","4_comparison.png", 593, 400) {
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
		 * The Fractions Prek-K Practice module button.
		 */
		FRACTIONS  ("Fractions", "5_fractions.png" , 300, 225) {
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
		 * The Coins Prek-K Practice module button.
		 */
		COINS      ("Coins",     "6_coins.png"     , 590, 225) {
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
		 * The Arithmetic Prek-K Practice module button.
		 */
		ARITHMETIC ("Arithmetic","7_arithmetic.png", 300, 400) {
			private GUIManager manager;
			private DifficultySelectScreen difficultyScreen;
			
			@Override
			public void doAction(ModuleSelectScreen screen) {
				System.out.println("Opening the DifficultySelectScreen!");
				this.manager = screen.getManager();
				screen.tearDown();
				try {
					difficultyScreen = new DifficultySelectScreen(manager, this);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}

			@Override
			public void difficultySelected(DifficultyLevel level) {
				System.out.println("Opening the " + level.getName() + " " + getName() + " Practice!");
				difficultyScreen.tearDown();
				try {
					new PreKTestArithmetic(manager, true, level);
				} catch (IOException e) {
					manager.handleException(e);
				}
			}
		},
		/**
		 * The Estimate Prek-K Practice module button.
		 */
		ESTIMATE   ("Estimate",  "8_estimate.png"  , 590, 400) {
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
		 * The Final Prek-K Practice module button.
		 */
		FINAL      ("Final",     "9_final.png"     , 300, 225) {
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
		public abstract void doAction(ModuleSelectScreen screen);
		
		@Override
		public abstract void difficultySelected(DifficultyLevel level);
	}
}