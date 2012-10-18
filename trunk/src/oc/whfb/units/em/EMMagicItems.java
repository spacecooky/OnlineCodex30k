package oc.whfb.units.em;

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

public class EMMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;

	private int maxCosts = 25;
	private boolean mage = false;
	private boolean isSlann = false;
	private boolean isSaurus = false;
	private boolean isChief = false;
	private boolean isShaman = false;
	
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

	public EMMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Mage yes/no
		// defaults[1] = maxCosts 25
		// defaults[2] = maxCosts 50
		// defaults[3] = maxCosts 100
		// defaults[4] = Slann
		// defaults[5] = Saurus
		// defaults[6] = Skink Chief
		// defaults[7] = Skink Shaman

		if(defaults[0]) mage = true;
		if(defaults[2]) maxCosts = 50;
		if(defaults[3]) maxCosts = 100;

		isSlann = defaults[4];
		isSaurus = defaults[5];
		isChief = defaults[6];
		isShaman = defaults[7];
		
		items = new Vector<String>();
		items.add(BuildaHQ.translate("Magische Waffen"));
		items.add(BuildaHQ.translate("Verzauberte Gegenstände"));
		items.add(BuildaHQ.translate("Talismane"));
		items.add(BuildaHQ.translate("Magische Rüstungen"));
		items.add(BuildaHQ.translate("Arkane Artefakte"));

        box = new RuestkammerChooser(20, 10, buttonBreite, 20, items);
        box.addActionListener(this);
        panel.add(box.getPanel());

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Klinge der Alten"), 75));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge des Ehrw. Tzunki"), BuildaHQ.translate("Klinge des Ehrwürdigen Tzunki"), 65));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Säbel d. strahlenden Sonne"), BuildaHQ.translate("Säbel der strahlenden Sonne"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stegadon-Kriegsspeer"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der verlorenen Sonne"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Piranhaklinge"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dolch des Sotek"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hornissenschwert"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brennende Klinge d. Chotek"), BuildaHQ.translate("Brennende Klinge des Chotek"), 20));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 25, 20, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Horn des Kygor"), 100));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hörnerechse"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tafel des Göttl. Schutzes"), BuildaHQ.translate("Tafel des Göttlichen Schutzes"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kriegstrommel von Xahutec"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bluttotem des Xapati"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amulett des Jaguarkriegers"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Federumhang"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Carnosaurierkette"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchamulett des Tepok"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchschädel"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Silberlibelle"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feuerfroschgift"), 10));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Aura des Quetzl"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Glyphenhalsband"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amulett des Itzl"), 30));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampfechsenhaut"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heiliger Stegadonhelm"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schild des Spiegelsees"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Reisszahnschild"), 30));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bewahrende Hände d. Alten"), BuildaHQ.translate("Bewahrende Hände der Alten"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kubus der Dunkelheit"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gewitterstab"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Diadem der Macht"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Itxi-Larven"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tafel des Tepok"), 15));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 40, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(this.mage) {
			o2.setAktiv(false);
		} else {
			o4.setAktiv(false);
			o2.setAktiv(true);
		}

		/* Switch available items ON/OFF */
		if(isSlann) {
			o1.setAktiv(BuildaHQ.translate("Stegadon-Kriegsspeer"), false);

			o5.setAktiv(BuildaHQ.translate("Amulett des Jaguarkriegers"), false);
			o5.setAktiv(BuildaHQ.translate("Hörnerechse"), false);
			o5.setAktiv(BuildaHQ.translate("Federumhang"), false);
		}
		if(isSaurus) {
			o1.setAktiv(BuildaHQ.translate("Stegadon-Kriegsspeer"), false);
			o1.setAktiv(BuildaHQ.translate("Stab der verlorenen Sonne"), false);
			o1.setAktiv(BuildaHQ.translate("Dolch des Sotek"), false);

			o5.setAktiv(BuildaHQ.translate("Tafel des Göttlichen Schutzes"), false);
			o5.setAktiv(BuildaHQ.translate("Federumhang"), false);

			o2.setAktiv(BuildaHQ.translate("Heiliger Stegadonhelm"), false);
		}
		if(isChief) {
			o1.setAktiv(BuildaHQ.translate("Die Klinge der Alten"), false);
			o1.setAktiv(BuildaHQ.translate("Klinge des Ehrwürdigen Tzunki"), false);
			
			o5.setAktiv(BuildaHQ.translate("Horn des Kygor"), false);
			o5.setAktiv(BuildaHQ.translate("Tafel des Göttlichen Schutzes"), false);

			o2.setAktiv(BuildaHQ.translate("Kampfechsenhaut"), false);
		}
		if(isShaman) {
			o1.setAktiv(BuildaHQ.translate("Die Klinge der Alten"), false);
			o1.setAktiv(BuildaHQ.translate("Klinge des Ehrwürdigen Tzunki"), false);
			o1.setAktiv(BuildaHQ.translate("Säbel der strahlenden Sonne"), false);
			o1.setAktiv(BuildaHQ.translate("Stegadon-Kriegsspeer"), false);

			o5.setAktiv(BuildaHQ.translate("Horn des Kygor"), false);
			o5.setAktiv(BuildaHQ.translate("Tafel des Göttlichen Schutzes"), false);
		}

		if(maxCosts < 100) {
			o1.setAktiv(BuildaHQ.translate("Die Klinge der Alten"), false);
			o1.setAktiv(BuildaHQ.translate("Klinge des Ehrwürdigen Tzunki"), false);

			o5.setAktiv(BuildaHQ.translate("Horn des Kygor"), false);
		}
		if(maxCosts < 50) {
			o1.setAktiv(BuildaHQ.translate("Säbel der strahlenden Sonne"), false);
			o1.setAktiv(BuildaHQ.translate("Stegadon-Kriegsspeer"), false);
			o1.setAktiv(BuildaHQ.translate("Stab der verlorenen Sonne"), false);
			o1.setAktiv(BuildaHQ.translate("Piranhaklinge"), false);

			o5.setAktiv(BuildaHQ.translate("Hörnerechse"), false);
			o5.setAktiv(BuildaHQ.translate("Tafel des Göttlichen Schutzes"), false);
			o5.setAktiv(BuildaHQ.translate("Kriegstrommel von Xahutec"), false);
			//o5.setAktiv("Bluttotem des Xapati", false);

			o3.setAktiv(BuildaHQ.translate("Aura des Quetzl"), false);
			o3.setAktiv(BuildaHQ.translate("Glyphenhalsband"), false);
			o3.setAktiv(BuildaHQ.translate("Amulett des Itzl"), false);

			o2.setAktiv(BuildaHQ.translate("Kampfechsenhaut"), false);
			o2.setAktiv(BuildaHQ.translate("Heiliger Stegadonhelm"), false);
			o2.setAktiv(BuildaHQ.translate("Schild des Spiegelsees"), false);
			o2.setAktiv(BuildaHQ.translate("Reisszahnschild"), false);

			o4.setAktiv(BuildaHQ.translate("Bewahrende Hände der Alten"), false);
			o4.setAktiv(BuildaHQ.translate("Kubus der Dunkelheit"), false);
			o4.setAktiv(BuildaHQ.translate("Stab der Zauberei"), false);
		}
			
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();// + oe1.getKosten();
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(o1.contains(name)) o1.setAktiv(name, aktiv);
		if(o2.contains(name)) o2.setAktiv(name, aktiv);
		if(o3.contains(name)) o3.setAktiv(name, aktiv);
		if(o4.contains(name)) o4.setAktiv(name, aktiv);
		if(o5.contains(name)) o5.setAktiv(name, aktiv);
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
