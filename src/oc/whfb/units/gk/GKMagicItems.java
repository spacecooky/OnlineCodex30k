package oc.whfb.units.gk;

import java.awt.Color;
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
import oc.RuestkammerVater;

public class GKMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1; 	// magische Waffen
	OptionsUpgradeGruppeUnique o2;	// Magische Rüstungen
	OptionsUpgradeGruppeUnique o3;	// Talismane
	OptionsUpgradeGruppeUnique o4;	// Arkane Artefakte
	OptionsUpgradeGruppeUnique o5;	// Verzauberte Gegenstände

	private int maxCosts = 25;
	private boolean mage = false;
	
	OptionsPanelSwitcher weapons;
	OptionsPanelSwitcher armour;
	OptionsPanelSwitcher enchanted;
	OptionsPanelSwitcher talismans;
	OptionsPanelSwitcher arcane;
	
	Vector<String> items = null;
	JComboBox box = null;
	OptionsVater[] off = new OptionsVater[]{ };
	OptionsVater[] on = null;	
	int bufferCnt;

	public GKMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Mage yes/no
		// defaults[1] = maxCosts 50
		// defaults[2] = maxCosts 100

		if(defaults[0]) mage = true;
		if(defaults[1]) maxCosts = 50;
		if(defaults[2]) maxCosts = 100;
		
		items = new Vector<String>();
		items.add(BuildaHQ.translate("Magische Waffen"));
		items.add(BuildaHQ.translate("Verzauberte Gegenstände"));
		items.add(BuildaHQ.translate("Talismane"));
		items.add(BuildaHQ.translate("Magische Rüstungen"));
		items.add(BuildaHQ.translate("Arkane Artefakte"));
		
		box = new JComboBox(items); 
		box.setBounds(20, 10, buttonBreite, 20);
		BuildaHQ.newGUIComponent(box);
		box.setBackground(Color.WHITE);
		box.setMaximumRowCount(5);
		box.setEditable(false);
		box.addActionListener(this); 
		box.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		panel.add(box);

		if(maxCosts > 50 && !mage) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zerstörer der Ewigkeiten"), 80));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge von Antarhak"), 50));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 15, 20, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };			
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Totenmaske des Kharnut"), 60));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Staubmantel"), 50));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 5);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Neferras Schriftrollen"), BuildaHQ.translate("Neferras Schriftrollen der Mächtigen Anrufungen"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Enkhils Kanope"), 25));

		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen(100, 100, 570, KAMMER_HOEHE + BuildaHQ.wasIstHoeher(bufferCnt, cnt));
	}

	@Override
	public void refreshen() {
		double totalCosts;
		if(this.mage) {
			totalCosts = o1.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();
			
		} else {
			o4.setAktiv(false);
			totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();
			
		}

		o2.setAktiv(!this.mage);

		boolean error = false;
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			error = true;
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			error = false;
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
		
		if(!error)setButtonState(BuildaHQ.noErrors);
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
	
	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(o1.contains(name)) o1.setAktiv(name, aktiv);
		if(o2.contains(name)) o2.setAktiv(name, aktiv);
		if(o3.contains(name)) o3.setAktiv(name, aktiv);
		if(o4.contains(name)) o4.setAktiv(name, aktiv);
		if(o5.contains(name)) o5.setAktiv(name, aktiv);
	}
}
