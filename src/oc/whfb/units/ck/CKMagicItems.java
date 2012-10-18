package oc.whfb.units.ck;

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

public class CKMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;

	private int maxCosts = 25;
	private boolean mage = false;
	private boolean isAuserkorenerChamp = false;
	
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

	public CKMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Mage yes/no
		// defaults[1] = maxCosts 25
		// defaults[2] = maxCosts 50
		// defaults[3] = maxCosts 100

		if(defaults[0]) mage = true;
		if(defaults[2]) maxCosts = 50;
		if(defaults[3]) maxCosts = 100;

		// Champion der Auserkorenen darf nur max. 1 Gegenstand bekommen
		if(defaults.length >= 5) {
			if(defaults[4] == true) this.isAuserkorenerChamp = true;
		}
		
		items = new Vector<String>();
		items.add(BuildaHQ.translate("Magische Waffen"));
		items.add(BuildaHQ.translate("Verzauberte Gegenstände"));
		items.add(BuildaHQ.translate("Talismane"));
		items.add(BuildaHQ.translate("Magische Rüstungen"));
		items.add(BuildaHQ.translate("Arkane Artefakte"));

        box = new RuestkammerChooser(20, 10, buttonBreite, 20, items);
        box.addActionListener(this);
        panel.add(box.getPanel());

        seperator(50);

		if(maxCosts >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dämonenschwert"), 75));
		if(maxCosts >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenfeuerschwert"), 75));
		if(maxCosts >= 65) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Veränderung"), 65));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Chaos-Runenschwert"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Berserkerschwert"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ätherklinge"), 50));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rapier der Ekstase"), 45));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt des Khorne"), 45));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Vater aller Klingen"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eiterkeule"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Reißzahn"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gleve der Verwesung"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Peitsche der Unterwerfung"), 25));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 30, 25, 20, 5);
				
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der Qualen"), 45));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutschädel-Amulett"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Buch der Geheimnisse"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm der vielen Augen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amulett des Slaanesh"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schrumpfkopf"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gunst der Götter"), 5));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Betörender Kristall"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Krone des Ewigen Kampfes"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Schwarze Zunge"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blasphemisches Amulett"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Halsband des Khorne"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tzeentchs Goldauge"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Nekrotische Schatulle"), 10));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE)};
		add(talismans = new OptionsPanelSwitcher(randAbstand, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verwachsene Rüstung"), 60));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Chaos-Runenschild"), 50));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung der Verdammnis"), 45));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Karmesinrote Rüstung"), BuildaHQ.translate("Karmesinrote Rüstung des Dargan"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung des Morrslieb"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bronzerüstung des Zhrakk"), 15));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädel des Katam"), 50));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenmarionette"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blut des Tzeentch"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energie-Homunkulus"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampf-Homunkulus"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Spruch-Homunkulus"), 15));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE)};
		add(arcane = new OptionsPanelSwitcher(randAbstand, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!this.mage) {
			o4.setAktiv(o5.isSelected(BuildaHQ.translate("Buch der Geheimnisse")));
		}
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();// + oe1.getKosten();
		int totalItems = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() + o4.getAnzahl() + o5.getAnzahl();
		if(totalCosts > this.maxCosts) {
			if(isAuserkorenerChamp && totalItems > 1) {
				setButtonState(false);
				showErrorMessage("Max. 1 " + BuildaHQ.translate("Gegenstand"));
			} else {
				setButtonState(false);
				showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
			}
		} else {
			if(isAuserkorenerChamp && totalItems > 1) {
				setButtonState(false);
				showErrorMessage("Max. 1 " + BuildaHQ.translate("Gegenstand"));
			} else {
				setButtonState(true);
				hideErrorMessage();
				showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
			}
		}
	}

	@Override
	public void specialAction(boolean... action) {
		
		try {
			o5.setAktiv(BuildaHQ.translate("Buch der Geheimnisse"), action[0]);
		} catch(Exception ex) {
			// ignore
		}
		try {
			o5.setAktiv(BuildaHQ.translate("Blutschädel-Amulett"), action[1]);
		} catch(Exception ex) {
			// ignore
		}
		try {
			o1.setAktiv(BuildaHQ.translate("Berserkerschwert"), action[1]);
		} catch(Exception ex) {
			// ignore
		}
		refreshen();
	}
	
	 @Override
    public Object getSpecialValue() {
        if(o5.isSelected("Buch der Geheimnisse")) return("Buch der Geheimnisse");
        return("");
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
