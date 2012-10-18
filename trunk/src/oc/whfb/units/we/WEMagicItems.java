package oc.whfb.units.we;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsVater;
import oc.RuestkammerChooser;
import oc.RuestkammerVater;

public class WEMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	OptionsUpgradeGruppeUnique sprites;
	int maxCosts = 100;
	
	boolean isWardancer = false;
	boolean isWildHunter = false;
	boolean isWaywatcher = false;
	boolean isMage = false;
	boolean isAST = false;
	
	OptionsPanelSwitcher weapons;
	OptionsPanelSwitcher armour;
	OptionsPanelSwitcher enchanted;
	OptionsPanelSwitcher talismans;
	OptionsPanelSwitcher arcane;
	
	Vector<String> items = null;
	RuestkammerChooser box = null;
	OptionsVater[] off = new OptionsVater[]{ };
	OptionsVater[] on = null;	
	int bufferCnt;

	public WEMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) maxCosts = 50;
		
		try{
			if(defaults[1])isMage = true;
		}catch(Exception e){}
		
		items = new Vector<String>();
		items.add(BuildaHQ.translate("Magische Waffen"));
		items.add(BuildaHQ.translate("Verzauberte Gegenstände"));
		items.add(BuildaHQ.translate("Talismane"));
		items.add(BuildaHQ.translate("Magische Rüstungen"));
		items.add(BuildaHQ.translate("Arkane Artefakte"));

        box = new RuestkammerChooser(20, 10, buttonBreite, 20, items);
        box.addActionListener(this);
        panel.add(box.getPanel());
		
		seperator(35);
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schreckensfeen"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wirrlichter"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutfeen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Giftfeen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Spinnlinge"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elmsfeuer"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchfeen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schicksalsschwestern"), 25));
		add(sprites = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, 1));
		setHeadline(sprites, BuildaHQ.translate("Feen"));
		
		seperator();
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if( maxCosts == 100 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Seelenklinge"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Daiths Schnitter"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Bogen von Loren"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klingen des Loec"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer der Morgenröte"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwielichtspeer"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Callachs Klaue"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kralle des Jägers"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Winter"), BuildaHQ.translate("Schwert der tausend Winter"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rageths flammende Klingen"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Asyendis Fluch"), 10));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 30, 25, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seelenstein"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hexenfluchpfeil"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mondstein"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pfeilhagel des Verderbens"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternenfeuerpfeile"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Horn der Asrai"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Arkane Dolchpfeile"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elynetts Brosche"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenzahlpfeile"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gwythercs Horn"), 15));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if( maxCosts == 100 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Harfe des Barden"), 75));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amarantbrosche"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bernsteinamulett"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kristallweiherjuwel"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Funkelstern"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stein des Lebens"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Frostsplitter"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Merciws Ehre"), 20));
				
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eichenrüstung"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Railarians Mantel"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feenrüstung"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm der Jagd"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dornenrüstung"), 15));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 10);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if( maxCosts == 100 ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der Bergulme"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Calaingors Stab"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seherkristall"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kugel des tiefen Waldes"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ranus Herzstein"), 20));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 50, 25, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o4.setAktiv(isMage);		
		
		o2.setAktiv(!isMage && !isWardancer && !isWaywatcher);
		
		o1.setAktiv(BuildaHQ.translate("Die Seelenklinge"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Daiths Schnitter"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Der Bogen von Loren"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Klingen des Loec"), isWardancer);
		o1.setAktiv(BuildaHQ.translate("Speer der Morgenröte"), !isWardancer);
		o1.setAktiv(BuildaHQ.translate("Zwielichtspeer"), !isWardancer);
		o1.setAktiv(BuildaHQ.translate("Behände Klinge"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Callachs Klaue"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Kralle des Jägers"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Schlachtenklinge"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Schwert der tausend Winter"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Schwert der Macht"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Rageths flammende Klingen"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Asyendis Fluch"), !isWardancer && !isWildHunter);
		o1.setAktiv(BuildaHQ.translate("Reißende Klinge"), !isWardancer && !isWildHunter);
		
		//Mag. Schilde fuer AST deaktivieren
		o2.setAktiv(BuildaHQ.translate("Schild des Ptolos"), !isAST);
		o2.setAktiv(BuildaHQ.translate("Zauberspruch-Schild"), !isAST);
		o2.setAktiv(BuildaHQ.translate("Verzauberter Schild"), !isAST);
		o2.setAktiv(BuildaHQ.translate("Glückbringender Schild"), !isAST);
		
		if(isWildHunter){
			//o2.setAktiv(BuildaHQ.translate("Helm der Jagd"), false );//Im FAQ der 8ten Edition erlaubt ?!?!
			o2.setAktiv(BuildaHQ.translate("Verzauberter Schild"), false);
		}

		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten() /*+ oz1.getKosten()*/ + sprites.getKosten();
		if(totalCosts > maxCosts) {
			showErrorMessage("Max. " +  maxCosts + " " + BuildaHQ.translate("Punkte"));
			setButtonState(false);
		} else {
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
			setButtonState(true);
		}
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(!isWardancer && !isWaywatcher) if(o2.contains(name)) o2.setAktiv(name, aktiv);
		if(o3.contains(name)) o3.setAktiv(name, aktiv);

		if(name.equals( BuildaHQ.translate("Kampftänzer-Sippe"))) this.isWardancer = aktiv;
		if(name.equals( BuildaHQ.translate("Wilde Jäger-Sippe"))) this.isWildHunter = aktiv;
		if(name.equals( BuildaHQ.translate("Waldläufer-Sippe"))) this.isWaywatcher = aktiv;
		if(name.equals( "WEast")) this.isAST = aktiv;
		
		refreshen();
	}
	
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
        int index = cb.getSelectedIndex();
        weapons.switchPanel(0);
        weapons.getPanel().setVisible(index == 0 ? true : false);
		
        enchanted.switchPanel(0);
        enchanted.getPanel().setVisible(index == 1 ? true : false);
        
        talismans.switchPanel(0);
		talismans.getPanel().setVisible(index == 2 ? true : false);
		
		armour.switchPanel(0);
		armour.getPanel().setVisible(index == 3 ? true : false);
		
		arcane.switchPanel(0);
		arcane.getPanel().setVisible(index == 4 ? true : false);
			
		refreshen();
	}
}
