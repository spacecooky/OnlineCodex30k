package oc;import java.awt.Color;import java.awt.Toolkit;import javax.swing.BorderFactory;import javax.swing.border.Border;public interface BuildaSTK { // konstanten die �berall im oC geraucht werden	final static int BILDSCHIRMH�HE = Toolkit.getDefaultToolkit().getScreenSize().height;	final static int BILDSCHIRMBREITE = Toolkit.getDefaultToolkit().getScreenSize().width;	final static int buttonBreite = 230;	final static int buttonHoehe = 18;	final static int buttonAbstandY = 2;	final static int DEFAULT_KAMMERSTARTER_Abstand_Y = 5;	final static int CHOOSER_Y = 9000;	final static int CHOOSERGRUPPEN_X_ABSTAND = 420;	final static int CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND = 80;	final static int KAMMER_HOEHE = 85;	final static int MAXIMAL_OPTIONS_WIDTH = 260;	final static int BUILDAVATER_TEXTAREA_MAXROWS = 37; // ab wievielen Zeilenumbr�chen die verticale Scrollleiste eingeblendet wird	final static int auswahlBreite = 400;	final static int randAbstand = 10;	final static int einrueckAbstand = 15;	final static int headlineAbstand = 30;	final static String punkteAbstandHalter = "   ";	final static String ZEILENUMBRUCH = "\n"; // ACHTUNG: Wird nicht nur in der Ameelistentextarea benutzt!   z.b. auch im BuildaMenu oda bei getLabel() bei einzelUpgrade / einzelZ�hler	final static int DEFAULT_MAUSWHEELLSPEED = 40;	final static int DEFAULT_PFEILTASTENSPEED = 50;		public static String JPG = ".jpg";	final static String SAVETEXT_TRENNER1 = "_1T";	final static String SAVETEXT_TRENNER1_5 = "_2T"; // R�stkammercomponententrenner. Beim laden von R�stkammern das hier �bergeben	final static String SAVETEXT_TRENNER1_6 = "_2U"; // R�stkammercomponententrenner. Beim laden von R�stkammern das hier �bergeben	final static String SAVETEXT_TRENNER2 = "_3T"; // Eintragcomponententrenner. Beim loaden f�r Eintr�ge das hier �bergeben	final static String SAVETEXT_TRENNER3 = "_4T"; // trennt die chooser	final static String SAVETEXT_TRENNER4 = "_5T"; // trennt Choosergruppen	final static String SAVETEXT_TRENNER5 = "_6T"; // trennt Zusatzinfos vom Rest	final static String SAVETEXT_TRENNER6 = "_7T"; // trennt Zusatzinfos vom Rest	final static String SAVETEXT_UEBERSCHRIFTTRENNER1 = "_1H"; // trennt name des Eintrags vom Eitnrag selbst	final static String SAVETEXT_UEBERSCHRIFTTRENNER2 = "_2H"; // trennt name des Volkes von allem anderen!	final static String SAVETEXT_SELECTEDTRENNER = "|"; // RuestkammerStarter	final static String SAVETEXT_PANELSWITCHERTRENNER = "_1P"; // OptionsPanelSwitcher	final static String SAVETEXT_CURRNETPANELTRENNER = "_2P"; // OptionsPanelSwitcher                final static String PREFERENCES_SAVE_DIRECTORY = "saveDirectory";        final static String PREFERENCES_LOAD_DIRECTORY = "loadDirectory";        final static String PREFERENCES_SHOW_PICTURES = "showPictures";        final static String PREFERENCES_ENABLE_APOCALYPSE = "enableApocalpyse";        final static String PREFERENCES_SCROLL_VERTICAL = "scrollVertical";        final static String PREFERENCES_MOUSE_WHEEL_SPEED = "mouseWheelSpeed";        final static String PREFERENCES_ARROW_KEYS_SPEED = "arrowKeysSpeed";                final static String ELEMENT_NAME_CATEGORY = "Category";        final static String ELEMENT_NAME_SONSTIGESGRUPPE = "CategoryNecro";        final static String ELEMENT_NAME_ONLINECODEX = "OnlineCodex";        final static String ELEMENT_NAME_COUNTER = "Counter";        	final static Border redBorder = BorderFactory.createLineBorder(Color.red);	final static Border blackBorder = BorderFactory.createLineBorder(Color.black);	final static int[] kategorienMaxAnzahl = {		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 2 : 1,		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 3 : 2,		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 6 : 99,		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 3 : 99,		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 3 : 99,		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 1 : 99,		99,		99	};	final static int[] kategorienMinAnzahl = {		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 0 : 1,		0,		OnlineCodex.getGame() == OnlineCodex.NECROMUNDA ? 0 : 2,		0,		0,		0,		0,		0	};    final static int[] kategorienMaxProzent = {        25,        25,        100,        50,        25,        0,        0,        0,    };    final static int[] kategorienMinProzent = {        0,        0,        25,        0,        0,        0,        0,        0,    };    String [] spalte1Sg = {"HQ", "Kommandant", "Gangboss", "HQ", "Kommandant", "HQ"};    String [] spalte2Sg = {"Elite", "Held", "Spezialist", "Elite", "Held", "Elite"};    String [] spalte3Sg = {"Standard", "Kerneinheit", "Ganger", "Standard", "Kerneinheit", "Standard"};    String [] spalte4Sg = {"Sturm", "Eliteeinheit", "Kid", "Sturm", "Eliteeinheit", "Sturm"};    String [] spalte5Sg = {"Unterst�tzung", "Seltene Einheit", "S�ldner", "Unterst�tzung", "Seltene Einheit", "Unterst�tzung"};    String [] spalte6Sg = {"Befestigung", "Befestigung", "Befestigung", "Befestigung", "Befestigung", "Befestigung"};    String [] spalte1Pl = {"HQ", "Kommandanten", "Gangbosse", "HQ", "Kommandanten", "HQ"};    String [] spalte2Pl = {"Elite", "Helden", "Spezialisten", "Elite", "Helden", "Elite"};    String [] spalte3Pl = {"Standard", "Kerneinheiten", "Ganger", "Standard", "Kerneinheiten", "Standard"};    String [] spalte4Pl = {"Sturm", "Eliteeinheiten", "Kids", "Sturm", "Eliteeinheiten", "Sturm"};    String [] spalte5Pl = {"Unterst�tzung", "Seltene Einheiten", "S�ldner", "Unterst�tzung", "Seltene Einheiten", "Unterst�tzung"};    String [] spalte6Pl = {"Befestigungen", "Befestigungen", "Befestigungen", "Befestigungen", "Befestigungen", "Befestigungen"};	final static String[] gerSg = {		"",		spalte1Sg[OnlineCodex.getGame()],		spalte2Sg[OnlineCodex.getGame()],		spalte3Sg[OnlineCodex.getGame()],		spalte4Sg[OnlineCodex.getGame()],		spalte5Sg[OnlineCodex.getGame()],		spalte6Sg[OnlineCodex.getGame()],		"Apokalyptische Einheit",		"Apokalyptische Formation"	};	final static String[] gerPl = {		"",		spalte1Pl[OnlineCodex.getGame()],		spalte2Pl[OnlineCodex.getGame()],		spalte3Pl[OnlineCodex.getGame()],		spalte4Pl[OnlineCodex.getGame()],		spalte5Pl[OnlineCodex.getGame()],		spalte6Pl[OnlineCodex.getGame()],		"Apokalyptische Einheiten",		"Apokalyptische Formationen"	};	final static String[] engSg = {"", "HQ", "Elite", "Troop", "Fast Attack", "Heavy Support", "Fortification", "Apocalypse Unit", "Apocalypse Formation"};	final static String[] engPl = {"", "HQ", "Elites", "Troops", "Fast Attack", "Heavy Supports", "Fortification", "Apocalypse Unit", "Apocalypse Formation"};	final static String[] gerNullText = {		"",		"kein",		"kein",		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? "keine" : "kein",		OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? "keine" : "kein",		"keine",		"keine",		"keine",		"keine"	};	final static String[] engNullText = {"", "no", "no", "no", "no", "no", "no", "no", "no"};}