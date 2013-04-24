package oc;import java.awt.Color;import java.awt.Font;import java.awt.FontMetrics;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.util.Vector;import javax.swing.JLabel;import javax.swing.JPanel;import org.w3c.dom.Element;import org.w3c.dom.Node;import org.w3c.dom.NodeList;public class ChooserGruppe extends BuildaPanel {	int kategorie;	String reflectionKennung;	String reflectionKennungAllies;	String allyString="";	Object[] statischeEinträge;	Object[] alleEinträge;	JLabel Lueberschrift = new JLabel("");	JPanel chooserPanel = new JPanel(null, true);	Vector<Chooser> mC = new Vector<Chooser>();		public Vector<Chooser> getmC() {		return mC;	}	public void setmC(Vector<Chooser> mC) {		this.mC = mC;	}	Vector<String> spezialEinträge = new Vector<String>(); // wenn 2 Waaghbosse, werden auch 2 mal "Garbgosse" hinzugefügt, und erst wenn beide waaghbosse abgewählt werden sind beide "Garbgosse" Stirngs aus dem Vector draussen.	Vector<String> allyEinträge = new Vector<String>(); // wenn 2 Waaghbosse, werden auch 2 mal "Garbgosse" hinzugefügt, und erst wenn beide waaghbosse abgewählt werden sind beide "Garbgosse" Stirngs aus dem Vector draussen.	Vector<String> allySpezialEinträge = new Vector<String>(); // wenn 2 Waaghbosse, werden auch 2 mal "Garbgosse" hinzugefügt, und erst wenn beide waaghbosse abgewählt werden sind beide "Garbgosse" Stirngs aus dem Vector draussen.		public double getAnzahl(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {		if(kategorie == 6) return mC.size() - 1;		double anzahl = 0;		for(int i = 0; i < mC.size(); ++i) {			Eintrag entry = mC.elementAt(i).getEintrag();			if(entry == null) continue; // step over empty entries			boolean ally=false;			for(int j=0;j<allyEinträge.size();j++){				if(mC.elementAt(i).selectedEntry().equals(allyEinträge.get(j))){					ally=true;					break;				}			}			for(int j=0;j<allySpezialEinträge.size();j++){				if(mC.elementAt(i).selectedEntry().equals(allySpezialEinträge.get(j))){					ally=true;					break;				}			}			if(ally) continue; // Ally entries are counted separately			if(!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?				if(!includeMinIgnoreUnits) {					anzahl += ( entry.isCountToMinimum() ? entry.getEintragsCNT() : 0 );				}				if(!includeMaxIgnoreUnits) {					anzahl += ( entry.isCountToMaximum() ? entry.getEintragsCNT() : 0 );				}			} else {				anzahl += entry.getEintragsCNT();			}		}		return anzahl;	}		public double getAllyAnzahl(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {				double anzahl = 0;		for(int i = 0; i < mC.size(); ++i) {			Eintrag entry = mC.elementAt(i).getEintrag();			if(entry == null) continue; // step over empty entries			boolean ally=false;			for(int j=0;j<allyEinträge.size();j++){				if(mC.elementAt(i).selectedEntry().equals(allyEinträge.get(j))){					ally=true;					break;				}			}			for(int j=0;j<allySpezialEinträge.size();j++){				if(mC.elementAt(i).selectedEntry().equals(allySpezialEinträge.get(j))){					ally=true;					break;				}			}			if(ally==false) continue; // Non-Ally entries are counted separately			if(!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?				if(!includeMinIgnoreUnits) {					anzahl += ( entry.isCountToMinimum() ? entry.getEintragsCNT() : 0 );				}				if(!includeMaxIgnoreUnits) {					anzahl += ( entry.isCountToMaximum() ? entry.getEintragsCNT() : 0 );				}			} else {				anzahl += entry.getEintragsCNT();			}		}		return anzahl;	}	public double getAnzahl() {		return getAnzahl(true, true);	}		public double getAllyAnzahl() {		return getAllyAnzahl(true, true);	}	public int getKategorie() {		return this.kategorie;	}    @Override	public JPanel getPanel() {		return this.panel;	}	public ChooserGruppe(String reflectionKennung, int lX, int lY, int kategorie, Object[] statischeEinträge) {		this.kategorie = kategorie;		this.reflectionKennung = reflectionKennung;		this.statischeEinträge = statischeEinträge;		this.alleEinträge = statischeEinträge;		panel.setBounds(lX, lY, auswahlBreite + (randAbstand * 3), CHOOSER_Y);		panel.add(Lueberschrift);		Lueberschrift.setFont(new Font("arial", Font.BOLD, 12));		Lueberschrift.setBounds(randAbstand, randAbstand, auswahlBreite + (randAbstand * 3), 20);		chooserPanel.setBounds(0, lY + 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y - 25);  // +30 -30 is halt der BuildaHQ.abstand		chooserPanel.setBackground(Color.WHITE);		panel.add(chooserPanel);		Chooser c= new Chooser(randAbstand, randAbstand, reflectionKennung, reflectionKennungAllies, alleEinträge, kategorie, cloneListener);		c.setStatischeEinträge(statischeEinträge);		c.setSpezialEinträge(spezialEinträge);		c.setAllyEinträge(allyEinträge);		c.setAllySpezialEinträge(allySpezialEinträge);		c.allyString=allyString;		adden(c);		überschriftLabelSetzen();		new RefreshListener((byte) 11) {			public void refresh() {				chooserLocationCheck();				überschriftLabelSetzen();				panel.repaint(); // damit es keine überlappenden Einträge beim Eintrags-Wechsel gibt, wenn beide genau gleichgroß sind. Also wichtig!!			}		};		BuildaHQ.registerNewChooserGruppe(this, kategorie);	}	public void addSpezialAuswahl(String s) {		try{			//System.out.println(Thread.currentThread().getStackTrace().length);			String volk = Thread.currentThread().getStackTrace()[2].getClassName().toString().split("\\.")[3];			//System.out.println(volk);			if(reflectionKennungAllies!=null && volk.toUpperCase().equals(reflectionKennungAllies)){				if(!allySpezialEinträge.contains(s))allySpezialEinträge.addElement(allyString+s);				aktualisiereComboBoxAuswahlen();			}else{				if(!spezialEinträge.contains(s))spezialEinträge.addElement(s);				aktualisiereComboBoxAuswahlen();			}					}catch(ArrayIndexOutOfBoundsException e){			e.printStackTrace();		}					}		public void removeSpezialAuswahl(String s) {				String volk = Thread.currentThread().getStackTrace()[2].getClassName().toString().split("\\.")[3];		if(reflectionKennungAllies!=null && volk.toUpperCase().equals(reflectionKennungAllies)){			for(int i = 0; i < allySpezialEinträge.size(); ++i) {				if(allySpezialEinträge.elementAt(i).equals(allyString+s)) {					allySpezialEinträge.remove(i);					break; // nur ein String wird gelöscht! es wurde ja auch nur ein Vatereintrag geschlossen!				}			}		}else{			for(int i = 0; i < spezialEinträge.size(); ++i) {				if(spezialEinträge.elementAt(i).equals(s)) {					spezialEinträge.remove(i);					break; // nur ein String wird gelöscht! es wurde ja auch nur ein Vatereintrag geschlossen!				}			}		}		aktualisiereComboBoxAuswahlen();	}		public void addAllyAuswahl(String s) {		if(!allyEinträge.contains(s) || s.equals(""))allyEinträge.addElement(s);		aktualisiereComboBoxAuswahlen();	}		public void removeAllyAuswahl(String s) {		for(int i = 0; i < allyEinträge.size(); ++i) {			if(allyEinträge.elementAt(i).equals(s)) {				allyEinträge.remove(i);				break; // nur ein String wird gelöscht! es wurde ja auch nur ein Vatereintrag geschlossen!			}		}		aktualisiereComboBoxAuswahlen();	}	public void refreshAllEntries() {		for(int i=0; i<mC.size(); i++) {			if(mC.get(i).getEintrag() == null) continue;			mC.get(i).getEintrag().refreshen();		}	}	public void aktualisiereComboBoxAuswahlen() {		Vector<Object> auswahlen = new Vector<Object>();		for(int i = 0; i < statischeEinträge.length; ++i) {			auswahlen.add(statischeEinträge[i]);		}		if(spezialEinträge.size() != 0) {			for(int i = 0; i < spezialEinträge.size(); ++i) {				if(!auswahlen.contains(spezialEinträge.elementAt(i))) {					auswahlen.add(spezialEinträge.elementAt(i));				}			}		}				if(allyEinträge.size() != 0) {			for(int i = 0; i < allyEinträge.size(); ++i) {				if(!auswahlen.contains(allyEinträge.elementAt(i)) || allyEinträge.elementAt(i).equals("")) {					auswahlen.add(allyEinträge.elementAt(i));				}			}		}				if(allySpezialEinträge.size() != 0) {			for(int i = 0; i < allySpezialEinträge.size(); ++i) {				if(!auswahlen.contains(allySpezialEinträge.elementAt(i)) || allySpezialEinträge.elementAt(i).equals("")) {					auswahlen.add(allySpezialEinträge.elementAt(i));				}			}		}		alleEinträge = auswahlen.toArray();		// aktualisiert die Auswahlen von allen Choosern, die es bereits gibt.		for(int i = 0; i < mC.size(); ++i) {			mC.elementAt(i).setAuswahlen(auswahlen);		}	}	public String kategorieText() {		if(getAnzahl() < 2) {			if(BuildaHQ.getSprache() == Sprache.German) {				return gerSg[kategorie];			} else {				return engSg[kategorie];			}		} else {			if(BuildaHQ.getSprache() == Sprache.German) {				return gerPl[kategorie];			} else {				return engPl[kategorie];			}		}	}		public String allyText() {		if(getAllyAnzahl() <= 0) {			return "";		}else if(getAllyAnzahl() < 2) {			if(BuildaHQ.getSprache() == Sprache.German) {				return "Verbündeter";			} else {				return "Ally";			}		} else {			if(BuildaHQ.getSprache() == Sprache.German) {				return "Verbündete";			} else {				return "Allies";			}		}	}	public String getAnzahlText(boolean textErlaubt) {		double anzahl = getAnzahl();		if(anzahl <= 0 && textErlaubt) {			if(BuildaHQ.getSprache() == Sprache.German) {				return gerNullText[kategorie];			} else {				return engNullText[kategorie];			}		} else { // returnt die anzahl ohne .0   aber mit .5			int letzteGanzzahl = new Double(Math.floor(anzahl)).intValue();			double diff = anzahl - letzteGanzzahl;			// Floating point Ungenauigkeit umgehen - aber nur fuer Werte die sehr			// nahe an der naechsten Ganzzahl sind, damit sowas wie 0.5 weiterhin			// moeglich ist.			if(diff > 0.9) {				anzahl = Math.ceil(anzahl);			} else if (diff < 0.1) {				anzahl = Math.floor(anzahl);			}			if(anzahl == (double) ((int) anzahl)) {				return String.valueOf((int) anzahl);			} else {				return String.valueOf(anzahl).replace(".", ",");			}		}	}		public String getAllyAnzahlText(boolean textErlaubt) {		double anzahl = getAllyAnzahl();		if(anzahl <= 0 && textErlaubt) {			return "";		} else { // returnt die anzahl ohne .0   aber mit .5			int letzteGanzzahl = new Double(Math.floor(anzahl)).intValue();			double diff = anzahl - letzteGanzzahl;			// Floating point Ungenauigkeit umgehen - aber nur fuer Werte die sehr			// nahe an der naechsten Ganzzahl sind, damit sowas wie 0.5 weiterhin			// moeglich ist.			if(diff > 0.9) {				anzahl = Math.ceil(anzahl);			} else if (diff < 0.1) {				anzahl = Math.floor(anzahl);			}			if(anzahl == (double) ((int) anzahl)) {				return (" + "+String.valueOf((int) anzahl));			} else {				return (" + "+String.valueOf(anzahl).replace(".", ","));			}		}	}	public void überschriftLabelSetzen() {		FontMetrics fm = Lueberschrift.getFontMetrics(Lueberschrift.getFont());//		StringBuilder abstandshalter = new StringBuilder("");		String punkteString = BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate(OnlineCodex.getGame() == OnlineCodex.NECROMUNDA ? "Credits" : "Punkte");		String kategorieString = " " + getAnzahlText(true) + " " + kategorieText() + getAllyAnzahlText(true) + " " + allyText();		int cnt = (Lueberschrift.getSize().width - (fm.stringWidth(kategorieString + punkteString) + 30)) / fm.stringWidth(" ");		for(int i = 0; i < cnt; ++i) {			abstandshalter.append(" ");		}		Lueberschrift.setText(kategorieString + abstandshalter.toString() + punkteString);		if ( getGame() == OnlineCodex.WH40K || getGame() == OnlineCodex.WH40K_LEGACY ){			if(OnlineCodex.dualFOC.isSelected()){//doppelter FOC				if(getAnzahl(true, false) > (kategorienMaxAnzahl[kategorie - 1]*2) 						|| getAnzahl(false, true) < (kategorienMinAnzahl[kategorie - 1]*2) 						|| kategorie == 3 && getAllyAnzahl()>4 						|| kategorie !=3 && getAllyAnzahl()>2						|| (kategorie == 3 || kategorie == 1) && allyString!="" && getAllyAnzahl() < 1) {					Lueberschrift.setForeground(Color.RED);				} else {					Lueberschrift.setForeground(Color.BLACK);				}			}else{				if(getAnzahl(true, false) > kategorienMaxAnzahl[kategorie - 1] 						|| getAnzahl(false, true) < kategorienMinAnzahl[kategorie - 1] 						|| kategorie == 3 && getAllyAnzahl()>2 						|| kategorie !=3 && getAllyAnzahl()>1						|| (kategorie == 3 || kategorie == 1) && allyString!="" && getAllyAnzahl() < 1) {					Lueberschrift.setForeground(Color.RED);				} else {					Lueberschrift.setForeground(Color.BLACK);				}			}		} else if(getGame() == OnlineCodex.WHFB) {            if(getKosten(true, false) > Double.parseDouble(budget.getText()) * kategorienMaxProzent[kategorie - 1] / 100.0 || getKosten(false, true) < Double.parseDouble(budget.getText()) * kategorienMinProzent[kategorie - 1] / 100) {				Lueberschrift.setForeground(Color.RED);            } else {                Lueberschrift.setForeground(Color.BLACK);            }        } else {			Lueberschrift.setForeground(Color.BLACK);		} 		//WH30K Kategorienextrema ohne Ally		if ( getGame() == OnlineCodex.WH30K){						if(getAnzahl(true, false) > kategorienMaxAnzahl[kategorie - 1] 					|| getAnzahl(false, true) < kategorienMinAnzahl[kategorie - 1]) {				Lueberschrift.setForeground(Color.RED);			} else {				Lueberschrift.setForeground(Color.BLACK);				}			}	}    @Override    public double getKosten() {        return getKosten(true, true);    }	public double getKosten(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {        double kosten = 0;		for(int i = 0; i < mC.size(); ++i) {			Eintrag entry = mC.elementAt(i).getEintrag();			if(entry == null) continue; // step over empty entries			if(!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?				if(!includeMinIgnoreUnits) {					kosten += ( entry.isCountToMinimum() ? entry.getKosten() : 0 );				}				if(!includeMaxIgnoreUnits) {					kosten += ( entry.isCountToMaximum() ? entry.getKosten() : 0 );				}			} else {				kosten += entry.getKosten();			}		}		return kosten;	}	public void chooserLocationCheck() {		for(int i = 0; i < mC.size() - 1; ++i) {			if(mC.elementAt(i).getComboBox().getSelectedObjects()[0].equals("")) {				removen(i);				--i;			}		}		if(!mC.lastElement().getComboBox().getSelectedObjects()[0].equals("")) {			Chooser c= new Chooser(randAbstand, 109, reflectionKennung, reflectionKennungAllies, alleEinträge, kategorie, cloneListener);			c.setStatischeEinträge(statischeEinträge);			c.setSpezialEinträge(spezialEinträge);			c.setAllyEinträge(allyEinträge);			c.setAllySpezialEinträge(allySpezialEinträge);			c.allyString=allyString;			adden(c);			}		for(int i = 0; i < mC.size(); ++i) {			int höhe = randAbstand;			for(int e = 0; e < i; ++e) {				höhe += mC.elementAt(e).getPanel().getSize().height + randAbstand;			}			mC.elementAt(i).getPanel().setLocation(randAbstand, höhe);		}		überschriftLabelSetzen();	}	public void adden(Chooser c) {		mC.addElement(c);		chooserPanel.add(mC.lastElement().getPanel());	}	public void adden(Chooser c, int index) {		mC.add(index, c);		chooserPanel.add(mC.elementAt(index).getPanel(), index);	}	public void removen(int i) {		mC.remove(i);		chooserPanel.remove(i);	}	public String getText() {		StringBuilder text;		String sterne = BuildaHQ.sterneAnzeigen ? "***************  " : "";		if(BuildaHQ.kurzerText) {			text = new StringBuilder(BuildaHQ.formatierItalic(sterne + getAnzahlText(true) + " " + kategorieText() +( getAllyAnzahl()>0?(" "+getAllyAnzahlText(true)+" "+allyText()):"") + " " + sterne) + ZEILENUMBRUCH);		} else {			text = new StringBuilder(ZEILENUMBRUCH + BuildaHQ.formatierItalic(sterne + getAnzahlText(true) + " " + kategorieText() + (getAllyAnzahl()>0?(" "+getAllyAnzahlText(true)+" "+allyText()):"") + "  " + sterne) + ZEILENUMBRUCH + ZEILENUMBRUCH);		}		boolean leereGruppe = true;		for(int i = 0; i < mC.size(); ++i) {			String nächsterText = mC.elementAt(i).getText();			String allyPrefix="";			if(!nächsterText.equals("")) {				leereGruppe = false;			}						if(allyEinträge.size() != 0) {				for(int j = 0; j < allyEinträge.size(); ++j) {					if(allyEinträge.get(j).equals(mC.elementAt(i).selectedEntry()) && !mC.elementAt(i).selectedEntry().equals("")) {						allyPrefix=allyString;					}				}			}						if(allySpezialEinträge.size() != 0) {				for(int j = 0; j < allySpezialEinträge.size(); ++j) {					if(allySpezialEinträge.get(j).equals(mC.elementAt(i).selectedEntry()) && !mC.elementAt(i).selectedEntry().equals("")) {						allyPrefix=allyString;					}				}			}						text.append(allyPrefix+nächsterText);		}		if(leereGruppe) return "";		return text.toString();	}	public String getSaveText() {		StringBuilder sammler = new StringBuilder();		for(int i = 0; i < mC.size(); ++i) {			if(!allyString.equals("") && mC.elementAt(i).selectedEntry().contains(allyString)){							}else{				sammler.append(mC.elementAt(i).getComboBox().getSelectedObjects()[0] + SAVETEXT_UEBERSCHRIFTTRENNER1 + mC.elementAt(i).getSaveText(SAVETEXT_TRENNER2));				sammler.append(SAVETEXT_TRENNER3);			}		}		return sammler.toString();	}		public String getSaveTextAllies() {		StringBuilder sammler = new StringBuilder();		for(int i = 0; i < mC.size(); ++i) {			if(!allyString.equals("") && mC.elementAt(i).selectedEntry().contains(allyString) || mC.elementAt(i).selectedEntry().equals("")){				sammler.append(mC.elementAt(i).getComboBox().getSelectedObjects()[0] + SAVETEXT_UEBERSCHRIFTTRENNER1 + mC.elementAt(i).getSaveText(SAVETEXT_TRENNER2));				sammler.append(SAVETEXT_TRENNER3);			}		}		return sammler.toString();	}                public Element getSaveElement() {            Element root = BuildaHQ.getNewXMLElement("Category");            root.setAttribute("id", Integer.toString(kategorie));                        for(int i=0;i<mC.size();i++) {                Element e = mC.elementAt(i).getSaveElement();                if(e != null) {                    root.appendChild(e);                }            }                        return root;        }	public void load(String saveText) {		String[] splittet = saveText.split(SAVETEXT_TRENNER3);		for(int i = 0; i < BuildaHQ.countStringsInString(saveText, SAVETEXT_TRENNER3); ++i) {			erstelleEintrag(splittet[i], i);		}	}                public void loadElement(Element e) {                NodeList children = e.getChildNodes();                            int index = 0;                                for(int i=0;i<children.getLength();i++) {                    if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {//                        System.out.println(children.item(i).getNodeName());                        erstelleEintrag((Element)children.item(i), index);                        index++;                    }                }        }	ActionListener cloneListener = new ActionListener() {		public void actionPerformed(ActionEvent event) {			Object source = event.getSource();			for(int i = 0; i < mC.size(); ++i) { // zum rausfinden von welchem chooser der Button stammt				if(mC.elementAt(i).getCloneButton() == source) {					erstelleEintrag(mC.elementAt(i).getComboBox().getSelectedObjects()[0] + SAVETEXT_UEBERSCHRIFTTRENNER1 + mC.elementAt(i).getEintrag().getSaveText(SAVETEXT_TRENNER2), i);					break;				}			}		}	};	public void erstelleEintrag(String saveText, int index) {		String klassenname = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1));		if(mC.size() <= index + 1 || !(mC.elementAt(index + 1).getEintrag() instanceof LeererEintrag)) { // an der Stelle index+1 wird ein neuer chooser geaddet			Chooser c= new Chooser(randAbstand, 109, reflectionKennung, reflectionKennungAllies, alleEinträge, kategorie, cloneListener);			c.setStatischeEinträge(statischeEinträge);			c.setSpezialEinträge(spezialEinträge);			c.setAllyEinträge(allyEinträge);			c.setAllySpezialEinträge(allySpezialEinträge);			c.allyString=allyString;			adden(c,index+1);		}		Chooser c = mC.elementAt(index + 1); // WICHTIG!!!!!!!!"!!  WENN MANS 2mal mit elementAt(index+1) geht NIX mehr!		c.getComboBox().setSelectedItem(klassenname);		c.load(saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1) + SAVETEXT_UEBERSCHRIFTTRENNER1.length(), saveText.length()), SAVETEXT_TRENNER2);		RefreshListener.fireRefresh();  // für die setAktiv() dinger bei Bossen, Sergeants usw.    wichtig!	}                public void erstelleEintrag(Element e, int index) {                String klassenname = e.getAttribute("selection");                                if(mC.size() <= index + 1 || !(mC.elementAt(index + 1).getEintrag() instanceof LeererEintrag)) { // an der Stelle index+1 wird ein neuer chooser geaddet                	Chooser c= new Chooser(randAbstand, 109, reflectionKennung, reflectionKennungAllies, alleEinträge, kategorie, cloneListener);            		c.setStatischeEinträge(statischeEinträge);            		c.setSpezialEinträge(spezialEinträge);            		c.setAllyEinträge(allyEinträge);        			c.setAllySpezialEinträge(allySpezialEinträge);        			c.allyString=allyString;            		adden(c,index+1);		}		Chooser c = mC.elementAt(index + 1); // WICHTIG!!!!!!!!"!!  WENN MANS 2mal mit elementAt(index+1) geht NIX mehr!		c.getComboBox().setSelectedItem(klassenname);		c.loadElement(e);		RefreshListener.fireRefresh();  // für die setAktiv() dinger bei Bossen, Sergeants usw.    wichtig!        }		public double getProzentKosten() {		double kosten = 0;		if ( reflectionKennung.equals("BT") && this.kategorie == 1){			kosten = kosten - BuildaHQ.getCountFromInformationVector("Grail");		}		for(int i = 0; i < mC.size(); ++i) {			if (  mC.elementAt(i).getEintrag() != null && mC.elementAt(i).getEintrag().getEintragsCNT() != 0 && mC.elementAt(i).getEintrag().isCountToMinimum() )				kosten += mC.elementAt(i).getKosten();						if ( reflectionKennung.equals("IM") && mC.elementAt(i).getEintrag() != null ) {				kosten = kosten - mC.elementAt(i).getEintrag().getProzentKosten();			}		}		return kosten;	}	public void setReflectionKennungForAllies(String reflectionKennungAllies) {		this.reflectionKennungAllies=reflectionKennungAllies;		removen(0);		Chooser c= new Chooser(randAbstand, randAbstand, reflectionKennung, reflectionKennungAllies, alleEinträge, kategorie, cloneListener);		c.setStatischeEinträge(statischeEinträge);		c.setSpezialEinträge(spezialEinträge);		c.setAllyEinträge(allyEinträge);		c.setAllySpezialEinträge(allySpezialEinträge);		c.allyString=allyString;		adden(c);	}		public void setAllyString(String allyString) {		this.allyString=allyString;	}}