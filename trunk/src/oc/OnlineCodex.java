package oc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Hashtable;
import java.util.Vector;

import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.ToolTipManager;

import oc.utils.UpdateCheck;
import org.w3c.dom.Element;

public class OnlineCodex extends BuildaPanel {

	public static int WH40K = 0;
	public static int WHFB = 1;
	public static int NECROMUNDA = 2;
	public static int WH40K_LEGACY = 3;
	public static int WHFB_LEGACY = 4;
	public static int WH40K_FANDEX = 6;
	public static int WH30K = 5;
	public static String armyPackage;
	public static String allyArmyPackage;

	public static void main(String[] args) {
		new OnlineCodex(args); // neuGerrig
	}

	Object[] buildazWh40k = new Object[]{
			"",
			new IconedText("Adeptus Sororitas", "oc/images/VSAdeptus_Sororitas.gif"),
			new IconedText("Black Templars", "oc/images/VSBlack Templars.gif"),
			new IconedText("Blood Angels", "oc/images/VSBlood Angels.gif"),
			new IconedText("Chaosdämonen", "oc/images/VSChaos Daemonen.gif"),
			new IconedText("Chaos Space Marines", "oc/images/VSChaos.gif"),
			//new IconedText("Chaos Space Marines 2007", "oc/images/VSChaos.gif"),
			new IconedText("Dark Angels", "oc/images/VSDark Angels.gif"),
			new IconedText("Dark Eldar", "oc/images/VSDark Eldar.gif"),
			new IconedText("Eldar", "oc/images/VSEldar.gif"),
			new IconedText("Grey Knights", "oc/images/VSGreyKnights.gif"),
			new IconedText("Imperiale Armee", "oc/images/VSImperiale Armee.gif"),
			new IconedText("Necrons", "oc/images/VSNecrons.gif"),
			new IconedText("Orks", "oc/images/VSOrks.gif"),
			new IconedText("Space Marines", "oc/images/VSSpace Marines.gif"),
			new IconedText("Space Wolves", "oc/images/VSSpaceWolves.gif"),
			new IconedText("Sternenreich der Tau", "oc/images/VSSternenreichderTau.gif"),
			new IconedText("Tyraniden", "oc/images/VSTyraniden.gif"),
			"",
			new IconedText("Death Korps of Krieg", "oc/images/VSDeathKorpsofKrieg.gif"),
			new IconedText("Eldar Corsairs (IA 11)", "oc/images/VSEldarCorsairs.gif"),
			new IconedText("Elysian Drop Troop (IA 8)", "oc/images/VSElysianDropTroop.gif"),
			new IconedText("Ork Dread Mob", "oc/images/VSOrks.gif"),
			new IconedText("Panzerkompanie", "oc/images/VSImperiale Armee.gif"),
			new IconedText("Renegades and Heretics", "oc/images/VSImperiale Armee.gif"),
			new IconedText("Siege Vanguard (IA 10)", "oc/images/VSSieg Vanguard.gif"),
			new IconedText("Tyrants Legion", "oc/images/VSImperiale Armee.gif")
	};

	Object[] buildazWHFB = new Object[]{
			"",
			new IconedText("Bretonia", "oc/whfb/images/VSDunkelelfen.gif"),
			new IconedText("Dämonen des Chaos", "oc/whfb/images/VSDunkelelfen.gif"),
			new IconedText("Dunkelelfen", "oc/whfb/images/VSDunkelelfen.gif"),
			new IconedText("Echsenmenschen", "oc/whfb/images/VSEchsenmenschen.gif"),
			new IconedText("Gruftkönige von Khemri", "oc/whfb/images/VSGnoblars.gif"),
			new IconedText("Hochelfen", "oc/whfb/images/VSHochelfen.gif"),
			new IconedText("Imperium", "oc/whfb/images/VSDunkelelfen.gif"),
			new IconedText("Krieger des Chaos", "oc/whfb/images/VSKriegerdes Chaos.gif"),
			new IconedText("Oger", "oc/whfb/images/VSOger.gif"),
			new IconedText("Oger (AB 2004)", "oc/whfb/images/VSOger.gif"),
			new IconedText("Orks und Goblins", "oc/whfb/images/VSOrksUndGoblins.gif"),
			new IconedText("Skaven", "oc/whfb/images/VSSkaven.gif"),
			new IconedText("Tiermenschen", "oc/whfb/images/VSTiermenschen.gif"),
			new IconedText("Vampirfürsten", "oc/whfb/images/VSVampirfuersten.gif"),
			new IconedText("Waldelfen", "oc/whfb/images/VSWaldelfen.gif"),
			new IconedText("Zwerge", "oc/whfb/images/VSZwerge.gif")
	};

	Object[] buildazWh40kLegacy = new Object[]{
			"",
			new IconedText("Blood Angels (Codex 2007)", "oc/images/VSBloodAngels.gif"),
			new IconedText("Dämonenjäger (Codex 2004)", "oc/images/VSDemonHunters.gif"),
			new IconedText("Dark Eldar Kabale (Codex 2003)", "oc/images/VSDark Eldar.gif"),
			new IconedText("Dark Eldar Hagashin (Codex 2003)", "oc/images/VSDark Eldar.gif"),
			new IconedText("Hexenjäger (Codex 2004)", "oc/images/VSWitchHunters.gif"),
			new IconedText("Imperial Guard (Codex 2009)", "oc/images/VSImperialeArmee.gif"),
			new IconedText("Necrons (Codex 2002)", "oc/images/VSNecrons.gif"),
			new IconedText("Space Wolves (Codex 2000)", "oc/images/VSSpaceWolves.gif"),
			new IconedText("Tyraniden (Codex 2005)", "oc/images/VSTyraniden.gif")
	};

	Object[] buildazWh40kFandex = new Object[]{
			"",
			new IconedText("Adeptus Arbites (Bell of lost Souls)", "oc/images/VSAdeptusArbites.gif"),
			new IconedText("Bad Moons (The Waaagh)", "oc/images/VSBadMoons.gif"),
			new IconedText("Deffwing (The Waaagh)", "oc/images/VSDeffwing.gif"),
			new IconedText("Blood Axes (The Waaagh)", "oc/images/VSBloodAxes.gif"),
			new IconedText("Evil Sunz (The Waaagh)", "oc/images/VSEvilSunz.gif"),
			new IconedText("Goffs (The Waaagh)", "oc/images/VSGoffs.gif"),
			new IconedText("Kroot Mercenaries (Kompletely Kroot)", "oc/images/VSKroots.gif"),
			new IconedText("Rebel Grotz (The Waaagh)", "oc/images/VSRebelGrotz.gif"),
			new IconedText("Snakebites (The Waaagh)", "oc/images/VSSnakebites.gif")
	};

	Object[] buildazWHFBLegacy = new Object[]{
			"",
			new IconedText("Chaos Zwerge (2000)", "oc/images/VSChaoszwerge.gif"),
			new IconedText("Gnoblars", "oc/images/VSGnoblars.gif"),
			new IconedText("Gruftkönige (AB 2006)", "oc/whfb/images/VSGnoblars.gif"),
			new IconedText("Orks und Goblins (AB 2006)", "oc/whfb/images/VSOrksUndGoblins.gif"),
			new IconedText("Slayerheer", "oc/images/VSSlayerheer.gif"),
			new IconedText("Söldner", "oc/images/VSSoeldner.gif")
	};

	Object[] buildazNECRO = new Object[]{
			"",
			new IconedText("Cawdor", "oc/necro/images/VSCawdor.gif"),
			new IconedText("Delaque", "oc/necro/images/VSDelaque.gif"),
			new IconedText("Escher", "oc/necro/images/VSEscher.gif"),
			new IconedText("Goliath", "oc/necro/images/VSGoliath.gif"),
			new IconedText("Orlock", "oc/necro/images/VSOrlock.gif"),
			new IconedText("van Saar", "oc/necro/images/VSvanSaar.gif")
	};

	Object[] buildazWh30k = new Object[]{
			"",
			new IconedText("Death Guard", "oc/wh30k/images/VSDeathGuard.gif")/*,
			new IconedText("Emperor's Children", "oc/wh30k/images/VSEmperorsChildren.gif"),
			new IconedText("Sons of Horus", "oc/wh30k/images/VSSonsofHorus.gif"),
			new IconedText("World Eaters", "oc/wh30k/images/VSWorldEaters.gif")*/
	};
	
	//private final JComboBox buildaChooser = new JComboBox(buildazWh40k);
	private JComboBox buildaChooser;
	private JComboBox buildaChooserAllies;
	public static JCheckBox dualFOC;
	public final static int menuHöhe = 23;
	public final static int FRAME_MIN_WIDTH = 750;
	private static OnlineCodex onlineCodex;
	private final JButton openMenu = new JButton();
	private final JButton openCredits = new JButton();
	private final JButton saveButton = new JButton();
	private final JButton loadButton = new JButton();
	private JPanel buildaPanel;
	private final JPanel menuPanel = new JPanel();
	private BuildaVater myBuilder;
	private final Hashtable<String, String> dokumente = new Hashtable<String, String>();
	private final String VERSION = (Version.getInstance().getDay() < 10 ? "0" : "") + Version.getInstance().getDay() + (Version.getInstance().getMonth() < 10 ? ".0" : ".") + Version.getInstance().getMonth() + "." + Version.getInstance().getYear();
	private final String FENSTER = "powered by TabletopWelt.de" + " - Version vom " + VERSION;
	private final JFrame myWindow = new JFrame("OnlineCodex powered by TabletopWelt.de");
	private JDialog myDialog = new JDialog(myWindow, "Fehler", true);
	private int anfangsXPanel = 0;
	private int anfangsYPanel = 0;
	private int clickXWindow = 0;
	private int clickYWindow = 0;
	private boolean loadWithDokumenteHashtable = true; // siehe load und actionPerformed.
	private String aktVolk = "";
	private String aktAlly = "";
	public SaveTextWindow saveTextWindow;
	private LoadWindow loadWindow;
	private BuildaMenu menu;
	private Credits credits;
	private JLabel errorLabel = new JLabel();

	private Preferences prefs = Preferences.userNodeForPackage(oc.OnlineCodex.class);

	public BuildaMenu getMenu() {
		return this.menu;
	}

	public int getBudget() {
		return Integer.parseInt(budget.getText());
	}

	public boolean isApo() {
		return this.menu.apo.isSelected();
	}

	public JPanel getBuildaPanel() {
		return this.buildaPanel;
	}

	public static OnlineCodex getInstance() {
		return onlineCodex;
	}

	@SuppressWarnings("serial")
	static class ComboBoxRenderer extends JLabel implements ListCellRenderer {

		public ComboBoxRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			if (value instanceof IconedText && !value.toString().equals("")) {
				IconedText wert = (IconedText) value;

				this.setIcon(wert.icon);
				this.setText(wert.text);
			} else {
				this.setText(" ");
				this.setIcon(null);
			} // "" wird irgendwie ignoriert

			if (isSelected) {
				this.setBackground(list.getSelectionBackground());
				this.setForeground(list.getSelectionForeground());
			} else {
				this.setBackground(list.getBackground());
				this.setForeground(list.getForeground());
			}

			return this;
		}
	}

	static class IconedText {

		ImageIcon icon;
		String text;

		public IconedText(String t, String path) {
			//try{this.icon = new ImageIcon(this.getClass().getClassLoader().getResource(path));}catch (Exception e) {System.out.println("Volksymbol nicht gefunden: "+path);}
			this.text = t;
		}

		@Override
		public String toString() {  // fürn Reflection-ActionListener unten wichtig
			return text;
		}
	}

	public OnlineCodex(String [] args) {// neuGerri
		boolean gameFound = false;

		try {
			Class.forName("oc.wh40k.armies.VOLKBloodAngels");
			setGame(WH40K);
			gameFound = true;
		} catch (ClassNotFoundException ex) {
		}

		if (!gameFound) {
			try {
				Class.forName("oc.whfb.armies.VOLKHochelfen");
				setGame(WHFB);
				gameFound = true;
			} catch (ClassNotFoundException ex) {
			}
		}

		if (!gameFound) {
			try {
				Class.forName("oc.necro.armies.VOLKEscher");
				setGame(NECROMUNDA);
				gameFound = true;
			} catch (ClassNotFoundException ex) {
			}
		}

		if (!gameFound) {
			try {
				Class.forName("oc.legacy.wh40k.armies.VOLKBloodAngelsCodex2007");
				setGame(WH40K_LEGACY);
				gameFound = true;
			} catch (ClassNotFoundException ex) {
			}
		}
		if (!gameFound) {
			try {
				Class.forName("oc.legacy.whfb.armies.VOLKChaosZwerge2000");
				setGame(WHFB_LEGACY);
				gameFound = true;
			} catch (ClassNotFoundException ex) {
			}
		}

		if (!gameFound) {
			try {
				Class.forName("oc.fan.wh40k.armies.VOLKBadMoonsTheWaaagh");
				setGame(WH40K_FANDEX);
				gameFound = true;
			} catch (ClassNotFoundException ex) {
			}
		}
	
		if (!gameFound) {
			try {
				Class.forName("oc.wh30k.armies.VOLKDeathGuard");
				setGame(WH30K);
				gameFound = true;
			} catch (ClassNotFoundException ex) {
			}
		}

		if (!gameFound) {
			fehler("Es konnte nicht bestimmt werden, welches Spiel geladen werden soll.");
			System.out.println("Es konnte nicht bestimmt werden, welches Spiel geladen werden soll.");
			System.exit(0);
		}

		/**** Please do NOT commit the follogin line with WHFB enabled. ****/
		/**** Will cause release packaging to fail!                     ****/
		//setGame(WHFB);
		//setGame(WH40K_LEGACY);
		//setGame(WH40K_FANDEX);
		//setGame(NECROMUNDA);
		setGame(WH30K);

		armyPackage = "oc.wh40k.";
		if (getGame() == WH40K_LEGACY) {
			armyPackage = "oc.legacy.wh40k.";
		} else if (getGame() == WHFB) {
			armyPackage = "oc.whfb.";
		} else if (getGame() == WHFB_LEGACY) {
			armyPackage = "oc.legacy.whfb.";
		} else if (getGame() == NECROMUNDA) {
			armyPackage = "oc.necro.";
		} else if (getGame() == WH40K_FANDEX) {
			armyPackage = "oc.fan.wh40k.";
		} else if (getGame() == WH30K) {
			armyPackage = "oc.wh30k.";
		}

		onlineCodex = this;

		BuildaHQ.setSprache(Sprache.German);
		ToolTipManager.sharedInstance().setDismissDelay(8000); // wie lange ein tooltip angezeigt wird, bis er wieder weggeht
		BuildaHQ.machTextStrings(false);

		myWindow.setBounds(0, 0, FRAME_MIN_WIDTH, 600);
		myWindow.setLayout(null);
		myWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		myWindow.getContentPane().setBackground(Color.WHITE);
		myWindow.setIconImage(BuildaHQ.oCLogo);
		myWindow.addMouseMotionListener(dragAndDropMouseMotionListener);
		myWindow.addMouseListener(dragAndDropMouseListener);

		if (getGame() == WH40K) {
			myWindow.setTitle("OnlineCodex Wh40k - " + FENSTER);
			buildaChooser = new JComboBox(buildazWh40k);
			buildaChooserAllies = new JComboBox(buildazWh40k);
			dualFOC=new JCheckBox("Doppelter AOP");
		} else if (getGame() == WH40K_LEGACY) {
			myWindow.setTitle("OnlineCodex Wh40k - LEGACY VERSION - " + FENSTER);
			buildaChooser = new JComboBox(buildazWh40kLegacy);
		} else if (getGame() == WHFB) {
			myWindow.setTitle("OnlineCodex WHFB - " + FENSTER);
			buildaChooser = new JComboBox(buildazWHFB);
		} else if (getGame() == WHFB_LEGACY) {
			myWindow.setTitle("OnlineCodex WHFB - LEGACY VERSION - " + FENSTER);
			buildaChooser = new JComboBox(buildazWHFBLegacy);
		} else if (getGame() == NECROMUNDA) {
			myWindow.setTitle("OnlineCodex Necromunda - " + FENSTER);
			buildaChooser = new JComboBox(buildazNECRO);
		} else if (getGame() == WH40K_FANDEX) {
			myWindow.setTitle("OnlineCodex Wh40k - Inoffizielle Codizes - " + FENSTER);
			buildaChooser = new JComboBox(buildazWh40kFandex);
		} else if (getGame() == WH30K) {
			myWindow.setTitle("OnlineCodex Wh30k - Horus Heresy - " + FENSTER);
			buildaChooser = new JComboBox(buildazWh30k);
		} else {
			System.out.println("Es konnte nicht ermittelt werden, welches Spiel geladen weerden soll.");
			System.exit(0);
		}

		buildaChooser.setBounds(5, 3, 200, 18);
		buildaChooser.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
		buildaChooser.addActionListener(volkChangeListener);
		BuildaHQ.newGUIComponent(buildaChooser);
		buildaChooser.setMaximumRowCount(99);
		buildaChooser.setToolTipText(BuildaHQ.translate("Hier können Sie Ihr Volk auswählen. Die Einträge des alten Volkes bleiben im Arbeitsspeicher und werden geladen, sobald sie es wieder auswählen."));

		if (getGame() == WH40K) {
			buildaChooserAllies.setBounds(5, 24, 200, 18);
			buildaChooserAllies.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
			buildaChooserAllies.addActionListener(volkChangeListener);
			BuildaHQ.newGUIComponent(buildaChooserAllies);
			buildaChooserAllies.setMaximumRowCount(99);
			buildaChooserAllies.setToolTipText(BuildaHQ.translate("Hier können Sie Ihre Alliierten auswählen. Die Einträge der alten Alliierten bleiben im Arbeitsspeicher und werden geladen, sobald sie sie wieder auswählen."));
			buildaChooserAllies.setEnabled(false);
			errorLabel.setBounds(210,24,180,18);
			errorLabel.setForeground(Color.red);
			dualFOC.setBounds(400,24,300,18);
			dualFOC.setBackground(Color.WHITE);
			dualFOC.addItemListener(FoCClickedListener);
		}

		if (getGame() == WHFB) {
			budget.setEnabled(false);
			budget.setBounds(210, 4, 40, 18);
			budget.addKeyListener(budgetChangeListener);
			budget.setFont(new Font("arial", Font.BOLD, 12));
			budget.setBackground(Color.WHITE);
			budget.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			budget.setText("2000");

			kostenLabel.setBounds(255, 4, 180, 16);
			kostenLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 14));
			kostenLabel.setBackground(Color.GREEN);
		} else {
			kostenLabel.setBounds(210, 4, 180, 16);
			kostenLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 14));
			kostenLabel.setBackground(Color.GREEN);
		}

		menu = new BuildaMenu();
		credits = new Credits();

		menuPanel.add(buildaChooser);
		if (getGame() == WH40K) {
			menuPanel.add(buildaChooserAllies);
			menuPanel.add(dualFOC);
		}
		if (getGame() == WHFB) {
			menuPanel.add(budget);
		}
		menuPanel.add(kostenLabel);
		menuPanel.add(errorLabel);
		menuPanel.setLayout(null);
		menuPanel.setBounds(-1, -1, 2500 + 1, menuHöhe + (getGame()==WH40K?22:1) ); // -1 damit border oben net sichtbar ist    soll nur den unterens schwarzen Trennstrich machen
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setBorder(BorderFactory.createLineBorder(new Color(10, 40, 160)));

		openMenu.setText(BuildaHQ.translate("Menü"));
		openMenu.setBounds(BILDSCHIRMBREITE - 75, 4, 65, 16);
		BuildaHQ.newGUIComponent(openMenu);
		openMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				menu.setVisible(true);
			}
		});
		menuPanel.add(openMenu);

		openCredits.setText(BuildaHQ.translate("Credits"));
		openCredits.setBounds(BILDSCHIRMBREITE - 155, 4, 75, 16);
		BuildaHQ.newGUIComponent(openCredits);
		openCredits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				credits.setVisible(true);
			}
		});
		menuPanel.add(openCredits);

		saveTextWindow = new SaveTextWindow(myWindow, prefs.get(PREFERENCES_SAVE_DIRECTORY, null));
		loadWindow = new LoadWindow(prefs.get(PREFERENCES_LOAD_DIRECTORY, null));

		saveButton.setText(BuildaHQ.translate("Speichern"));
		saveButton.setBounds(BILDSCHIRMBREITE - 240, 4, 80, 16);
		saveButton.setBorder(null);
		saveButton.setMargin(new Insets(0, 0, 0, 0));
		BuildaHQ.newGUIComponent(saveButton);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				saveTextWindow = new SaveTextWindow(myWindow, prefs.get(PREFERENCES_SAVE_DIRECTORY, null));
				if(getGame()==WH40K){
					saveTextWindow.setSaveTextAllies(getSaveTextAllies());
				}
				saveTextWindow.setSaveText(getSaveText());
				String armyListHumanReadable =myBuilder.getText(); //neuGerri
				saveTextWindow.setArmyList(armyListHumanReadable.replaceAll("\n", System.getProperty("line.separator")));//neuGerri
				saveTextWindow.save();
			}
		});
		menuPanel.add(saveButton);

		loadButton.setText(BuildaHQ.translate("Laden"));
		loadButton.setBounds(BILDSCHIRMBREITE - 305, 4, 60, 16);
		loadButton.setBorder(null);
		loadButton.setMargin(new Insets(0, 0, 0, 0));
		loadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				loadWindow.load(getGame());
				loadWindow.setVisible(true);

				if(loadWindow.getLoadElement() != null) {
					loadElement(loadWindow.getLoadElement(), true);
				} else if (!loadWindow.getLoadText().trim().equals("")) {
					load(loadWindow.getLoadText(), true);
					if(getGame()==WH40K){
						//Speichern der Hauptarmee
						aktVolk=BuildaHQ.formZuKlassenName(loadWindow.getLoadText().substring(0, loadWindow.getLoadText().indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)));
						dokumente.put(aktVolk, getSaveText());
						//Laden der Verbündeten
						setSelectedItemInBuildaChooserAllies(loadWindow.getLoadTextAllies().substring(0, loadWindow.getLoadTextAllies().indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)));
						load(loadWindow.getLoadTextAllies(), false);
					}
				}

			}
		});
		menuPanel.add(loadButton);

		final Color dunkelgrau = new Color(90, 90, 90);

		loadButton.setForeground(dunkelgrau);
		saveButton.setForeground(dunkelgrau);
		openMenu.setForeground(dunkelgrau);
		openCredits.setForeground(dunkelgrau);

		myBuilder = new LeererBuilder();
		buildaPanel = myBuilder.getPanel();

		panel.add(buildaPanel);
		panel.setLocation(0, menuHöhe + (getGame()==WH40K?21:0));
		panel.setSize(2500, 1400);

		myWindow.add(panel);
		myWindow.add(menuPanel);

		myWindow.addWindowListener(
				new WindowListener() {

					@Override
					public void windowClosing(WindowEvent event) {

						savePreferences();

						myWindow.dispose();
						try {
							System.exit(0);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} // WICHTIG! sonst bleibt der Thread bestehen   (im Task Manager beenden).   Online: Acces denid...

					@Override
					public void windowDeactivated(WindowEvent event) {
					}

					@Override
					public void windowDeiconified(WindowEvent event) {
					}

					@Override
					public void windowIconified(WindowEvent event) {
					}

					@Override
					public void windowOpened(WindowEvent event) {
					}

					@Override
					public void windowActivated(WindowEvent event) {
					}

					@Override
					public void windowClosed(WindowEvent event) {
						myWindow.dispose();

						try {
							System.exit(0);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} // WICHTIG! sonst bleibt der Thread bestehen   (im Task Manager beenden).   Online: Acces denid...
				});

		myWindow.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent event) {
				int BILDSCHIRMBREITE = myWindow.getSize().width;

				if (BILDSCHIRMBREITE < FRAME_MIN_WIDTH) {
					myWindow.setSize(FRAME_MIN_WIDTH, myWindow.getSize().height);
					BILDSCHIRMBREITE = FRAME_MIN_WIDTH;
				}

				openMenu.setLocation(BILDSCHIRMBREITE - 75, 4);
				openCredits.setLocation(BILDSCHIRMBREITE - 155, 4);
				saveButton.setLocation(BILDSCHIRMBREITE - 240, 4);
				loadButton.setLocation(BILDSCHIRMBREITE - 305, 4);
			}

			@Override
			public void componentHidden(ComponentEvent event) {
			}

			@Override
			public void componentShown(ComponentEvent event) {
			}

			@Override
			public void componentMoved(ComponentEvent event) {
			}
		});

		BuildaHQ.newGUIComponent(myWindow);

		myWindow.setVisible(true);

		// Try to check oC website for any new update. If server is not reachable, ignore any errors.
		if (getGame() == WHFB || getGame() == WH40K || getGame() == NECROMUNDA) {
			UpdateCheck updateChedck = new UpdateCheck(getGame());
			try {
				updateChedck.run();
			} catch (Throwable ex) {
				// ignore connection error!
			}
		}

		// neuGerri
		if(args.length > 0) {
			loadWindow.loadFile(new java.io.File(args[0]), getGame());
			if (!loadWindow.getLoadText().trim().equals("")) {
				load(loadWindow.getLoadText(), true);
			}
		}

	}

	public MouseListener getDragAndDropMouseListener() {
		return dragAndDropMouseListener;
	}

	public MouseMotionListener getDragAndDropMouseMotionListener() {
		return dragAndDropMouseMotionListener;
	}
	private MouseListener dragAndDropMouseListener = new MouseListener() {

		@Override
		public void mousePressed(MouseEvent event) {
			if (event.getSource() instanceof JLabel) {
				clickXWindow = event.getX() + (int) ((JLabel) event.getSource()).getLocationOnScreen().getX();
				clickYWindow = event.getY() + (int) ((JLabel) event.getSource()).getLocationOnScreen().getY();
			} else {
				clickXWindow = event.getX();
				clickYWindow = event.getY();
			}

			anfangsXPanel = (int) (buildaPanel.getLocation().getX());
			anfangsYPanel = (int) (buildaPanel.getLocation().getY());
		}

		@Override
		public void mouseExited(MouseEvent event) {
		}

		@Override
		public void mouseEntered(MouseEvent event) {
		}

		@Override
		public void mouseClicked(MouseEvent event) {
		}

		@Override
		public void mouseReleased(MouseEvent event) {
		}
	};
	private MouseMotionListener dragAndDropMouseMotionListener = new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent event) {
			if (event.getSource() instanceof JLabel) {
				setBuildaLocation(anfangsXPanel - (clickXWindow - (event.getX() + (int) ((JLabel) event.getSource()).getLocationOnScreen().getX())), anfangsYPanel - (clickYWindow - (event.getY() + (int) ((JLabel) event.getSource()).getLocationOnScreen().getY())));
			} // beim ico muss auchnoch die position vom JLabel berücksichtigt werden, weil event.getX() ansich viel kleiner ausfällt....
			else {
				setBuildaLocation(anfangsXPanel - (clickXWindow - event.getX()), anfangsYPanel - (clickYWindow - event.getY()));
			}
		}

		@Override
		public void mouseMoved(MouseEvent event) {
		}
	};

	public void setBuildaLocation(int x, int y) {
		if (y > 0) {
			y = 0;
		}  // damit mans nicht zu weit nach links bzw. oben schieben kann

		if (x > 0) {
			x = 0;
		}

		buildaPanel.setLocation(x, y);
	}

	public boolean dokumenteContains(String s) {
		s = BuildaHQ.formZuKlassenName(s);
		return dokumente.get(s) != null;
	}
	private ActionListener volkChangeListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			String name = "";
			try {

				Vector<Object[]> allyEintraege = new Vector<Object[]>();
				Vector<Vector<String>> allySpezialEinträge = new Vector<Vector<String>>(); //Spezialeinträge die gleich beim Laden des Volkes eingetragen sind.
				String alliesString="";

				if(event.getSource()==buildaChooser){
					if(getGame()==WH40K){
						buildaChooserAllies.setSelectedIndex(0);
					}
					aktAlly="";
				}
				if(event.getSource()==buildaChooserAllies){
					dokumente.put("ALLY_"+aktAlly, getSaveTextAllies());
					aktAlly = BuildaHQ.formZuKlassenName((buildaChooserAllies.getSelectedObjects()[0]).toString());
					if (aktAlly.equals("")) {
					}else{
						//Die Verbündete Armee wird zuerst angelegt und alle Einheiten zwischengespeichert
						BuildaVater allies = (BuildaVater) (Class.forName(armyPackage + "armies.VOLK" + aktAlly).newInstance());
						alliesString=reflectionKennungAllies;
						for(int i=0;i<5;i++){
							ChooserGruppe cg=allies.getChooserGruppe(i);
							allyEintraege.add(cg.statischeEinträge);
							allySpezialEinträge.add(cg.spezialEinträge);
						}
					}
				}

				budget.setEnabled(true);
				name = BuildaHQ.formZuKlassenName((buildaChooser.getSelectedObjects()[0]).toString());
				dokumente.put(aktVolk, getSaveText());
				

				aktVolk = name; // switch to new active army

				BuildaHQ.instancesLeeren();// den static vector vom BuildaPanel leeren
				RefreshListener.addRefreshListener(refreshListener);  // weil obendrüber ja alles geleert wurde...
				kostenLabel.setText("");

				if (name.equals("")) {
					myBuilder = new LeererBuilder();
					buildaChooserAllies.setEnabled(false);
				} else {
					BuildaHQ.leereStatischeInformationen(); // siehe BuildaHQ. Wird für SpezialAuswahlen benötigt (und dem informationsVector)
					myBuilder = (BuildaVater) (Class.forName(armyPackage + "armies.VOLK" + name).newInstance());
					if(getGame()==WH40K){
						buildaChooserAllies.setEnabled(true);
					}
				}
				
				setReflectionKennungAllies(alliesString);
				panel.removeAll();
				buildaPanel = myBuilder.getPanel(); // fürs mouseDraggedEvent...
				panel.add(buildaPanel);


				

				//Die zwischengespeicherten Verbündeten-Einheiten werden in den aktuellen Builder übertragen
				for(int i=0;i<allyEintraege.size();i++){
					Object[] o = allyEintraege.get(i);
					myBuilder.getChooserGruppe(i).setReflectionKennungForAllies(reflectionKennungAllies);
					myBuilder.getChooserGruppe(i).setAllyString("["+aktAlly+"] ");
					for(int j=0;j<o.length;j++){
						if(((String)o[j]).equals("")){
							myBuilder.getChooserGruppe(i).addAllyAuswahl("");
						}else{
							myBuilder.getChooserGruppe(i).addAllyAuswahl("["+aktAlly+"] "+(String)o[j]);
						}
					}
					Vector<String> v=allySpezialEinträge.get(i);
					for(int j=0;j<v.size();j++){
						if(v.get(j).equals("")){
							myBuilder.getChooserGruppe(i).allySpezialEinträge.add("");
						}else{
							myBuilder.getChooserGruppe(i).allySpezialEinträge.add("["+aktAlly+"] "+v.get(j));
						}
					}
					
					myBuilder.getChooserGruppe(i).aktualisiereComboBoxAuswahlen();
				}
				
				if (loadWithDokumenteHashtable && dokumente.get(name) != null) {
					load(dokumente.get(name), false);
				}
				
				if (!aktAlly.equals("") && loadWithDokumenteHashtable && dokumente.get("ALLY_"+aktAlly) != null) {
					load(dokumente.get("ALLY_"+aktAlly), false);
				}

				if(noAllies.contains(reflectionKennungAllies)){
					errorLabel.setText("Kein gültiger Verbündeter");
				}else{
					errorLabel.setText("");
				}
				
				myWindow.repaint();
			} catch (Exception e) {
				fehler("VOLK" + name + ".class nicht gefunden.\nBitte melden!!");
				e.printStackTrace();
			}
		}
	};
	
	private ItemListener FoCClickedListener = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			RefreshListener.fireRefresh();
		}
	};
	
	private KeyListener budgetChangeListener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			refreshListener.refresh();
		}
	};
	private RefreshListener refreshListener = new RefreshListener((byte) 15) {

		@Override
		public void refresh() {
			if (getKosten() != 0) {
				if(dualFOC!=null && dualFOC.isSelected() && getKosten()<2000){
					kostenLabel.setForeground(Color.RED);
				}else{
					kostenLabel.setForeground(Color.BLACK);
				}
				kostenLabel.setText(BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Pkt."));
			} else {
				kostenLabel.setText("");
			}
		}
	};

	public final void fehler(String s) {
		myDialog = new JDialog(myWindow, "Fehler", true);
		JTextPane myTextPane = new JTextPane();

		int i = BuildaHQ.countStringsInString(s, "\n") + 1;

		myTextPane.setBounds(2, 2, BuildaHQ.maxStringWidth(myTextPane, s.split("\n")) + 15, i * 16);
		myTextPane.setVisible(true);
		myTextPane.setText(s);
		myTextPane.setEditable(false);

		JButton myButton = new JButton("OK");

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myDialog.setVisible(false);
			}
		};

		myButton.addActionListener(listener);
		myButton.setBounds(myTextPane.getWidth() / 2 - 75 / 2, myTextPane.getHeight() + 15, 75, 25);
		myButton.setVisible(true);

		myDialog.getContentPane().setBackground(Color.white);
		myDialog.setLayout(null);
		myDialog.setResizable(false);

		myDialog.add(myTextPane);
		myDialog.add(myButton);

		myDialog.setSize(myTextPane.getWidth() + 10, myTextPane.getHeight() + 90);
		myDialog.setLocation(BILDSCHIRMBREITE / 2 - myDialog.getWidth() / 2, BILDSCHIRMHÖHE / 2 - myDialog.getHeight() / 2);
		myDialog.setVisible(true);
	}

	@Override
	public double getKosten() {
		return myBuilder.getKosten();
	}

	public String getSaveText() {
		//System.out.println(buildaChooser.getSelectedObjects()[0].toString() + SAVETEXT_UEBERSCHRIFTTRENNER2 + myBuilder.getSaveText());
		return buildaChooser.getSelectedObjects()[0].toString() + SAVETEXT_UEBERSCHRIFTTRENNER2 + myBuilder.getSaveText();
	}
	
	public String getSaveTextAllies() {
		//System.out.println(buildaChooserAllies.getSelectedObjects()[0].toString() + SAVETEXT_UEBERSCHRIFTTRENNER2 + myBuilder.getSaveTextAllies());
		return buildaChooserAllies.getSelectedObjects()[0].toString() + SAVETEXT_UEBERSCHRIFTTRENNER2 + myBuilder.getSaveTextAllies();
	}

	public Element getSaveElement() {
		Element root = myBuilder.getSaveElement();
		root.setAttribute("choice", buildaChooser.getSelectedObjects()[0].toString());
		if(budget != null && budget.isEnabled() && !budget.getText().equals("")) {
			root.setAttribute("budget", Integer.toString(getBudget()));
		}

		return root;
	}

	public BuildaVater getBuilder() {
		return myBuilder;
	}

	public JComboBox getChooser() {
		return buildaChooser;
	}

	public JComboBox getAlliesChooser() {
		return buildaChooserAllies;
	}

	public void loadElement(Element e, boolean chooserUmstellen) {
		try {
			if(chooserUmstellen) {
				loadWithDokumenteHashtable = false;
				setSelectedItemInBuildaChooser(e.getAttribute("choice"));
				loadWithDokumenteHashtable = true;
			}

			myBuilder.loadElement(e);

			if(!e.getAttribute("budget").equals("")) {
				budget.setText(e.getAttribute("budget"));
			}

			BuildaHQ.loadWindow = false;
			loadWindow.setVisible(false);
		} catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden"));
		}
	}

	public void load(String saveText, boolean chooserUmstellen) {
		if (saveText.trim().equals("")) {
			return;
		}

		try {
			if (chooserUmstellen) {
				loadWithDokumenteHashtable = false;
				setSelectedItemInBuildaChooser(saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)));
				loadWithDokumenteHashtable = true;
			}
			myBuilder.load(saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2) + SAVETEXT_UEBERSCHRIFTTRENNER2.length(), saveText.length()));

			BuildaHQ.loadWindow = false;
			loadWindow.setVisible(false);



		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden."));
		}

	}

	public void dokumentLeeren() {
		loadWithDokumenteHashtable = false;
		setSelectedItemInBuildaChooser(buildaChooser.getSelectedItem()); // ruft actionPerformed(ActionEvent event) auf
		loadWithDokumenteHashtable = true;

	}

	public void setSelectedItemInBuildaChooser(Object s) {
		Object[] buildaz = getGame() == WHFB ? buildazWHFB : getGame() == WH40K ? buildazWh40k : getGame() == WH30K ? buildazWh30k : buildazNECRO;
		for (int i = 0; i < buildaz.length; ++i) {
			if (buildaz[i].toString().equals(s.toString())) {
				buildaChooser.setSelectedItem(buildaz[i]);
			}
		}

		if (getGame() == WHFB) {
			budget.setEnabled(true);
		}
	}
	
	public void setSelectedItemInBuildaChooserAllies(Object s) {
		Object[] buildaz = buildazWh40k;
		for (int i = 0; i < buildaz.length; ++i) {
			if (buildaz[i].toString().equals(s.toString())) {
				buildaChooserAllies.setSelectedItem(buildaz[i]);
			}
		}
	}

	public String getCurrentArmy() {
		return this.aktVolk;
	}

	public Preferences getPrefs() {
		return prefs;
	}

	public void savePreferences() {
		prefs.put(PREFERENCES_SAVE_DIRECTORY, saveTextWindow.getCurrentDir());
		prefs.put(PREFERENCES_LOAD_DIRECTORY, loadWindow.getCurrentDir());

		menu.savePrefs();
	}

	public boolean isCurrentArmy(Class<?> army) {
		return ("VOLK" + getCurrentArmy()).equals(army.getSimpleName());
	}
}
