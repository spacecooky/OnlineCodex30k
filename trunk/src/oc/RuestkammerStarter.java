package oc;import java.awt.Color;import java.awt.Font;import java.awt.FontMetrics;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.FocusEvent;import java.awt.event.FocusListener;import java.awt.event.MouseEvent;import java.awt.event.WindowEvent;import java.awt.event.WindowListener;import java.util.StringTokenizer;import javax.swing.JButton;import javax.swing.JDialog;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JTextArea;import oc.whfb.armies.VOLKBretonia;import org.w3c.dom.Element;public class RuestkammerStarter extends OptionsVater {	private RuestkammerVater myKammer;	private String name;	private boolean selected;		public void setSelected(boolean selected) {		aktivieren(selected);			}	private boolean aktiv = true;	private boolean legal = true;	private boolean ueberschriftTrotzNullKostenAusgeben = false;	private JLabel ico;	private JButton startButton = new JButton();	private JTextArea textArea = new JTextArea("");	public int einrueckIndex = -1;	private int seperator = -88; // -88 wichtig um in optionscollection �berpr�fen zu k�nnen obs ge�ndert wurde und das statt dem default zu benutzen	public RuestkammerVater getKammer() {		return this.myKammer;	}	public int getEinrueckIndex() {		return this.einrueckIndex;	}	public int getSeperator() {		return this.seperator;	}	public void setSeperator(int i) {		this.seperator = i;	}	public void setEinrueckIndex(int i) {		this.einrueckIndex = i;	}	public void setUeberschriftTrotzNullKostenAusgeben(boolean b) {		this.ueberschriftTrotzNullKostenAusgeben = b;	}    @Override	public boolean isSelected() {		return this.selected;	}	public void setToolTipText(String s) {		startButton.setToolTipText(s);	}	public void setName(String s) {		this.name = s;		myKammer.name = s;	}	public String getName() {		return this.name;	}	public JButton getButton() {		return this.startButton;	}	public RuestkammerStarter(int ID, int lX, int lY, String kammer, String name) {		init(ID, lX, lY, kammer, name);	}	public RuestkammerStarter(int ID, int lX, int lY, String kammer, String name, int einrueckIndex) {		this.einrueckIndex = einrueckIndex;		init(ID, lX, lY, kammer, name);	}		public RuestkammerStarter(int ID, int lX, int lY, RuestkammerVater abteilung) {		init(ID, lX, lY, abteilung);	}	public void init(int ID, int lX, int lY, String kammer, String name) {		this.selected = false;		this.name = name;		panel.setLocation(lX - 5, lY);		ico = BuildaHQ.createPictureJLabel("oc/sysimages/RuestkammerIcon.jpg");		ico.setBounds(randAbstand - 2, 6, ruestkammerIconBreite, 12);		panel.add(ico);		startButton.setBounds(ruestkammerIconBreite + randAbstand, 0, buttonBreite, buttonHoehe + 4);		startButton.addMouseListener(this);		BuildaHQ.newGUIComponent(startButton);		startButton.setBorder(null);		startButton.setToolTipText(BuildaHQ.translate("�ffnet ein extra Fenster. Rechtsklick: Die Einstellungen bleiben im R�stkammer-Fenster zwar bestehen, z�hlen aber NICHT zu den Gesamtkosten."));		fontSetzen(false);		panel.add(startButton);		textArea.setForeground(Color.GRAY);		textArea.setEditable(false);		textArea.setFocusable(false);		textArea.setLocation(randAbstand + einrueckAbstand + 1, buttonHoehe + 6);		BuildaHQ.newGUIComponent(textArea);		panel.add(textArea);		String kammerName = BuildaHQ.formZuKlassenName(kammer);        String armyPackage = OnlineCodex.armyPackage;		try {			try{				//System.out.println(armyPackage + "units." + kammerName);				myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + kammerName).newInstance();			}catch (Exception e) {				try{					//System.out.println(armyPackage + "units." + reflectionKennungAllies.toLowerCase() + "." + kammerName);					myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + reflectionKennungAllies.toLowerCase() + "." + kammerName).newInstance();				}catch (Exception ex) {					//System.out.println(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + kammerName);					myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + kammerName).newInstance();				}			}				} catch (Exception e) {            OnlineCodex.getInstance().fehler(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + kammerName + ".class nicht gefunden. R�stkammer kann nicht ge�ffnet werden." + ZEILENUMBRUCH + "Bitte melden!");			System.out.println(kammerName + ".class nicht gefunden. R�stkammer kann nicht ge�ffnet werden.");			e.printStackTrace();		}		myKammer.setCloseListener(closeListenerWindow, closeListenerFocus, closeListenerAction);		myKammer.setzteRefreshListener(ID);        myKammer.setName(name);        myKammer.setUeberschrift(name);		if (!name.equals("")) {			myKammer.setUeberschrift(name + " " + BuildaHQ.translate("R�stkammer"));			myKammer.name = name;		}		sizeSetzen();		new RefreshListener((byte) 6) {            @Override			public void refresh() {				if (isSelected()) {					textUebernehmen();				}			}		};	}			public void init(int ID, int lX, int lY, RuestkammerVater abteilung) {		this.selected = false;		this.name = abteilung.getName();		panel.setLocation(lX - 5, lY);		ico = BuildaHQ.createPictureJLabel("oc/sysimages/RuestkammerIcon.jpg");		ico.setBounds(randAbstand - 2, 6, ruestkammerIconBreite, 12);		panel.add(ico);		startButton.setBounds(ruestkammerIconBreite + randAbstand, 0, buttonBreite, buttonHoehe + 4);		startButton.addMouseListener(this);		BuildaHQ.newGUIComponent(startButton);		startButton.setBorder(null);				fontSetzen(false);		panel.add(startButton);		textArea.setForeground(Color.GRAY);		textArea.setEditable(false);		textArea.setFocusable(false);		textArea.setLocation(randAbstand + einrueckAbstand + 1, buttonHoehe + 6);		BuildaHQ.newGUIComponent(textArea);		panel.add(textArea);		try {			myKammer = (RuestkammerVater) abteilung;		} catch (Exception e) {			JOptionPane.showMessageDialog(this.getPanel(), abteilung.getName() + ".class" + BuildaHQ.translate("nicht gefunden. R�stkammer kann nicht ge�ffnet werden:") + " " + e.getMessage());		}		myKammer.setCloseListener(closeListenerWindow, closeListenerFocus, closeListenerAction);		myKammer.setzteRefreshListener(ID);		if (!abteilung.getName().equals("")) {			myKammer.setUeberschrift(abteilung.getName() + " " + BuildaHQ.translate("R�stkammer"));			myKammer.name = abteilung.getName();		}		sizeSetzen();		new RefreshListener((byte) 6) {            @Override			public void refresh() {				if (isSelected()) {					textUebernehmen();				}			}		};	}	public void initKammer(boolean... b) {		myKammer.initButtons(b);		labelSetzen();	}	public void setGrundkosten(int i) {		myKammer.grundkosten = i;		labelSetzen();	}	private void labelSetzen() {		FontMetrics fm = startButton.getFontMetrics(startButton.getFont());		StringBuilder abstandshalter = new StringBuilder("");		String punkteString = "";		if (myKammer.grundkosten == 0) {			punkteString = BuildaHQ.translate("kostenlos");		} else {			punkteString = entferneNullNachkomma(myKammer.grundkosten) + " " + BuildaHQ.translate("Pkt.");		}		int cnt = (buttonBreite - (fm.stringWidth(name + punkteString) + 30)) / fm.stringWidth(" .");		for (int i = 0; i < cnt; ++i) {			abstandshalter.append(" .");		}		startButton.setText(name + abstandshalter.toString() + punkteString);	}	public void setButtonText(String s) {		startButton.setText(s);		myKammer.name = "";	}	public void setButtonText(String s, boolean hideKammerName) {		startButton.setText(s);		if(hideKammerName) myKammer.name = "";	}    @Override	public void setLegal(boolean b) {		if (b) {			startButton.setForeground(Color.BLACK);		} else {			startButton.setForeground(Color.RED);		}		legal = b;	}    @Override	public boolean isLegal() {		return this.legal;	}	public void setAktiv(boolean b) {		boolean pufferAktiv = aktiv;		aktiv = b;		startButton.setEnabled(b);		ico.setEnabled(b);		if (!b) {			textLeeren();		} else if (selected && !pufferAktiv) {			textUebernehmen();		}	}    public boolean isAktiv() {        return this.aktiv;    }    @Override	public double getKosten() {		if (aktiv && selected) {			try {				return myKammer.getKosten();			} catch (Exception e) {			}		}		return 0;	}	static final int ruestkammerIconBreite = 20;	private void sizeSetzen() {		int textAreaHoehe;		if (textArea.getText().equals("")) {			textAreaHoehe = -5;		} else {			textAreaHoehe = (vorkommen(textArea.getText(), ZEILENUMBRUCH) + 1);			FontMetrics fm = textArea.getFontMetrics(textArea.getFont());			textAreaHoehe *= fm.getHeight();		}		textArea.setSize(buttonBreite + 20, textAreaHoehe);		panel.setSize(ruestkammerIconBreite + randAbstand + buttonBreite, ((int) (textArea.getLocation().getY())) + textAreaHoehe + 5);	}    @Override	public String getLabel() {		return "";	}	private void uebernehmen() {		myKammer.setVisible(false);		RefreshListener.fireRefresh();	}	private void textLeeren() {		textArea.setText("");		sizeSetzen();	}	boolean abwaehlbar = true;	public void setAbwaehlbar(boolean b) {  // ACHTUNG: IMMER ALS LETZTES AUFRUFEN!!!! also vor complete erst!!! weil refresh manchmal was benutzt was erst weiter unten initialisiert wird...		this.abwaehlbar = b;		if (!b) {			selected = true;			fontSetzen(true);		}	}	private void aktivieren(boolean visible) {		selected = true;		fontSetzen(true);		myKammer.setVisible(visible);		RefreshListener.fireRefresh();	}    @Override	public void mouseReleased(MouseEvent event) { // liegt auf dem RuestkammerStartButton		if (!aktiv) {			return;		}		setSelected(event.getButton() == MouseEvent.BUTTON1, true);	}	private void setSelected(boolean select, boolean visible) {		if (select) {			boolean wasSelected = selected;			aktivieren(visible);						if ( !wasSelected && !BuildaHQ.loadWindow ) addSelection();		} else if (abwaehlbar) {						if ( !(myKammer.toString().indexOf("Abteilung") == -1) ) {				if ( myKammer.getKosten() > 0 ) {					JOptionPane op = new JOptionPane("Bitte die Anzahl der Modelle auf '0' setzen.",JOptionPane.WARNING_MESSAGE);					JDialog dialog = op.createDialog("Hinweis");					dialog.setAlwaysOnTop(true); //<-- this line					dialog.setModal(true);					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);					dialog.setVisible(true);					return;				}							}						selected = false;			fontSetzen(false);			myKammer.setVisible(false);						removeSelection ();						textLeeren();			RefreshListener.fireRefresh();		}	}		private void removeSelection () {		if(!(myKammer.toString().indexOf("MagicItems") == -1 ) || !(myKammer.toString().indexOf("Banner")== -1 ) || !(myKammer.toString().indexOf("Gabe")== -1 ) 		|| !(myKammer.toString().indexOf("GiftsOf")== -1 ) || !(myKammer.toString().indexOf("Spites")== -1 ) || !(myKammer.toString().indexOf("Assassin")== -1 ) ) {													StringTokenizer tokenizer = new StringTokenizer( myKammer.getText(),",");			while(tokenizer.hasMoreElements()){				String tok = BuildaHQ.translate(tokenizer.nextToken().trim());										if(!(tok.indexOf("Tugend")==-1) && reflectionKennung.equals("BT")){					int kost = 2;					if(VOLKBretonia.Vows.containsKey(tok)){						kost = VOLKBretonia.Vows.get(tok);						kost --;						if(kost <= 1){							kost = 1;							VOLKBretonia.Vows.remove(tok);						}else{							VOLKBretonia.Vows.put(tok, kost);						}					}						}else {					if(BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)){						BuildaHQ.Items.remove(tok);					}								}			}		} 	}		private void addSelection () {		if(!(myKammer.toString().indexOf("MagicItems") == -1 ) || !(myKammer.toString().indexOf("Banner")== -1 ) || !(myKammer.toString().indexOf("Gabe")== -1 ) 		|| !(myKammer.toString().indexOf("GiftsOf")== -1 ) || !(myKammer.toString().indexOf("Spites")== -1 ) || !(myKammer.toString().indexOf("Assassin")== -1 ) ) {													StringTokenizer tokenizer = new StringTokenizer( myKammer.getText(),",");			while(tokenizer.hasMoreElements()){				String tok = BuildaHQ.translate(tokenizer.nextToken().trim());										if(!(tok.indexOf("Tugend")==-1) && reflectionKennung.equals("BT")){					int kost = 2;					if(VOLKBretonia.Vows.containsKey(tok)){						kost = VOLKBretonia.Vows.get(tok);						kost ++;													}					VOLKBretonia.Vows.put(tok, kost);					} else {					if(BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)){						JOptionPane op = new JOptionPane(tok + " " + BuildaHQ.translate("darf nur einmal enthalten sein."),JOptionPane.ERROR_MESSAGE);						JDialog dialog = op.createDialog(BuildaHQ.translate("Fehler"));						dialog.setAlwaysOnTop(true); //<-- this line						dialog.setModal(true);						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);						dialog.setVisible(true);								}					if(BuildaHQ.Items != null) BuildaHQ.Items.add(tok);				}								}		} 	}        public void deselectYourself() {            if(this.abwaehlbar) {                selected = false;                fontSetzen(false);                myKammer.setVisible(false);                textLeeren();                RefreshListener.fireRefresh();                            }        }	static final Font bold = new Font("arial", Font.BOLD, 12);	static final Font plain = new Font("arial", Font.PLAIN, 12);	private void fontSetzen(boolean b) { // 0_Plain  1_Bold  2_Italic    oder einfach die Font.BOLD usw. Konstanten benutzen... ist dasgleiche		if (b) {			startButton.setFont(bold);			textUebernehmen();		} else {			startButton.setFont(plain);			textLeeren();		}	}	private FocusListener closeListenerFocus = new FocusListener() {        @Override		public void focusLost(FocusEvent event) {			ruestkammerClosed();		}        @Override		public void focusGained(FocusEvent event) {		}	};	private WindowListener closeListenerWindow = new WindowListener() {        @Override		public void windowClosing(WindowEvent e) {			ruestkammerClosed();                        deselectYourself();		}        @Override		public void windowClosed(WindowEvent e) {			ruestkammerClosed();		}        @Override		public void windowActivated(WindowEvent e) {		}        @Override		public void windowDeactivated(WindowEvent e) {/*ruestkammerClosed();*/		} // kommandozug imps...        @Override		public void windowDeiconified(WindowEvent e) {		}        @Override		public void windowIconified(WindowEvent e) {		}        @Override		public void windowOpened(WindowEvent e) {		}	};	private ActionListener closeListenerAction = new ActionListener() {        @Override		public void actionPerformed(ActionEvent event) {			ruestkammerClosed();		}	};	private void ruestkammerClosed() {		textUebernehmen();		uebernehmen();	}	public String getText() {		String result;		if (aktiv && selected) {			StringBuilder textPuffer = new StringBuilder();			if (myKammer.grundkosten != 0 || ueberschriftTrotzNullKostenAusgeben) {				if (BuildaHQ.allePunktkosten && myKammer.grundkosten != 0 ) {					textPuffer.append(BuildaHQ.formatierFett(name + punkteAbstandHalter + entferneNullNachkomma(myKammer.grundkosten) + " " + BuildaHQ.translate("Pkt.")));				} else {					textPuffer.append(BuildaHQ.formatierFett(name));				}			}			textPuffer.append(myKammer.getText());			// If no text is containes, do not append anything			if(textPuffer.toString().length() == 0) return "";			if (BuildaHQ.kurzerText) {				result = textPuffer.toString() + "  -> " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Pkt.");			} else {				result = textPuffer.toString();			}			final String einrueckString = BuildaHQ.getEinrueckString();			String randabstand = BuildaHQ.getStringXMal(einrueckString, einrueckIndex);			return "\n" + randabstand + "+ " + result.replace("\n", "\n" + randabstand + einrueckString);  // wenn einr�ckIndex == 0  dann �nderts nix		} else {			return "";		}	}    @Override	public String getSaveText() {		return (isSelected() ? "Y" : "N") + SAVETEXT_SELECTEDTRENNER + myKammer.getSaveText(einrueckIndex > 0 ? SAVETEXT_TRENNER1_6 : SAVETEXT_TRENNER1_5);	}            @Override        public Element getSaveElement() {            Element root = myKammer.getSaveElement();            //            Element root = BuildaHQ.getNewXMLElement(this.getClass().getSimpleName());            root.setAttribute("selected", Boolean.toString(isSelected()));            //            root.appendChild(myKammer.getSaveElement());                        return root;        }    @Override	public void load(String s) {		myKammer.load(s.substring(s.indexOf(SAVETEXT_SELECTEDTRENNER) + SAVETEXT_SELECTEDTRENNER.length(), s.length()), einrueckIndex > 0 ? SAVETEXT_TRENNER1_6 : SAVETEXT_TRENNER1_5);		textArea.setText(myKammer.getText().replace(", ", "\n- ").trim());		sizeSetzen();		this.setSelected(s.substring(0, 1).equals("Y"), false);		myKammer.setVisible(false);	}            @Override        public void loadElement(Element e) {            myKammer.loadElement(e);            textArea.setText(myKammer.getText().replace(", ", "\n- ").trim());            sizeSetzen();            this.setSelected(Boolean.parseBoolean(e.getAttribute("selected")), false);            myKammer.setVisible(false);        }	public void deleteYourself() {		removeSelection();		myKammer.deleteYourself();				}	public static int vorkommen(String Sa, String b) {  // wie oft b in a vorkommt     Hilfsmethode		int vorkommen = 0;		String a = Sa;		if (a.equals("") || b.equals("")) {			return 0;		}		for (;;) {			if (!a.contains(b)) {				break;			}			a = a.substring(a.indexOf(b) + 1, a.length());			++vorkommen;		}		return vorkommen;	}		public void textUebernehmen() {		textArea.setText(myKammer.getText().replace(", ", "\n- ").trim());		sizeSetzen();	}}