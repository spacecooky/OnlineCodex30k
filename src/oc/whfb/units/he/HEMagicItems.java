package oc.whfb.units.he;

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

public class HEMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;

	private int maxCosts = 25;
	private boolean mage = false;
	
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

	public HEMagicItems() {
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
		
		items = new Vector<String>();
		items.add(BuildaHQ.translate("Magische Waffen"));
		items.add(BuildaHQ.translate("Verzauberte Gegenstände"));
		items.add(BuildaHQ.translate("Talismane"));
		items.add(BuildaHQ.translate("Magische Rüstungen"));
		items.add(BuildaHQ.translate("Arkane Artefakte"));

        box = new RuestkammerChooser(20, 10, buttonBreite, 20, items);
        box.addActionListener(this);
        panel.add(box.getPanel());

		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schnelle Goldklinge"), 60));
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bogen des Seefahrers"), 60));
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Schwert von Hoeth"), 60));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternenlanze"), 40));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Jagdbogen"), 40));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Weiße Schwert"), 40));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meeresgoldklinge"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge des Verderbens"), 25));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 25, 20, 15, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bannstein"), 100));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heiltrank"), 50));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Strahlender Stein von Hoeth"), 45));
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Folariaths Robe"), 45));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ring des Zorns"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bartmantel"), 35));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amulett der Runenrache"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenhorn"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Splitter der Sternenkrone"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amulett des Lichts"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Juwel der Tapferkeit"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Talisman des Loec"), 10));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 55) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Magische Armschienen"), 55));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goldene Krone von Atrazar"), 40));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Umhang des Lehrmeisters"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Talisman von Saphery"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heiliger Weihrauch"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Phönixwächter"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feueramulett"), 20));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 10);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung des Schutzes"), 45));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goldener Schild"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternenrüstung"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heldenrüstung"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Temakadors Handschuhe"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schattenrüstung"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung von Caledor"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm des Glücks"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenschuppenschild"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Maske des Meeresfürsten"), 10));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 10);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Buch von Hoeth"), 100));
		if(maxCosts >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Vortexsplitter"), 75));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Annulianischer Kristall"), 40));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Siegel des Asuryan"), 40));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternenholzstab"), 40));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seherstab von Saphery"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Anhänger des Schattentänzers"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Juwel des Sonnenfeuers"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ring des Corin"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der Stärke"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rubin der Dämmerung"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Silberstab"), 10));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 40, 20, 20);
		
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
			// If "Strahlender Stein" is selected, the model counts as mage
			boolean star = (maxCosts > 45 && o5.isSelected(BuildaHQ.translate("Strahlender Stein von Hoeth")) ? true : false);
			o4.setAktiv(star ? true : false);
		}

		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();//  + oe1.getKosten(); //+ scrolls.getKosten()gems.getKosten();
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
	
	 public boolean getSternSelected() {
        return o5.isSelected("Strahlender Stein von Hoeth");
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
