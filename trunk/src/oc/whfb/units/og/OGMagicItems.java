package oc.whfb.units.og;

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


public class OGMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	
	boolean mage = false;
	boolean ironfist = false;
	int maxCosts = 50;
	
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

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Tyrann
		// defaults[1] = Fleischermeister
		// defaults[2] = Fleischer
		// defaults[3] = Jäger

		mage = (defaults[1] || defaults[2]);
		
		if(defaults[0]) maxCosts = 100;
		if(defaults[1]) maxCosts = 100;
		if(defaults[2]) maxCosts = 50;
		if(defaults[3]) maxCosts = 50;
		
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

		if(maxCosts >= 85) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Donnerkeule"), 85));
		if(maxCosts >= 85) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Festungsknacker"), 85));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 15, 20, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };			
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Steinauge"), 5));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gnoblar Diebstein"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gierfaust"), 40));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[]{ o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlundplatte"), 45));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 5);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gruts Sichel"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenherz"), 50));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
			
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen(100, 100, 570, KAMMER_HOEHE + BuildaHQ.wasIstHoeher(bufferCnt, cnt));
	}

	@Override
	public void refreshen() {
		if(this.mage) {
			o2.setAktiv(this.ironfist);
		} else {
			o4.setAktiv(false);
		}

		boolean error = false;
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			error = true;
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			error = false;
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		
			if(totalCosts > this.maxCosts) {
				setButtonState(false);
				error = true;
				showErrorMessage("Max. " + this.maxCosts + " " +BuildaHQ.translate("Punkte"));
			} else {
				setButtonState(true);
				error = false;
				hideErrorMessage();
				showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
			}
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
	public void specialAction(boolean... action) {
		super.specialAction(action);
		this.ironfist = action[0];
		o2.setAktiv(this.ironfist);
	}	
}
