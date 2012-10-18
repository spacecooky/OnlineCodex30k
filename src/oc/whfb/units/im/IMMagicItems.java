package oc.whfb.units.im;

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

public class IMMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	OptionsUpgradeGruppeUnique o6;
	
	private int maxCosts = 25;
	private boolean mage = false;
	
	OptionsPanelSwitcher weapons;
	OptionsPanelSwitcher armour;
	OptionsPanelSwitcher enchanted;
	OptionsPanelSwitcher talismans;
	OptionsPanelSwitcher arcane;
	OptionsPanelSwitcher mysticArtefacts;
	
	Vector<String> items = null;
	JComboBox box = null;
	OptionsVater[] off = new OptionsVater[]{ };
	OptionsVater[] on = null;	
	int bufferCnt;
	
	public IMMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Mage yes/no
		// defaults[1] = maxCosts 25
		// defaults[2] = maxCosts 50
		// defaults[3] = maxCosts 100
		// defaults[4] = technikus
		// defaults[5] = siegmarpriester
		// defaults[6] = general
		
		if(defaults[0]) mage = true;
		if(defaults[2]) maxCosts = 50;
		if(defaults[3]) maxCosts = 100;
		
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
		box.setMaximumRowCount( 5);
		box.setEditable(false);
		box.addActionListener(this); 
		box.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		panel.add(box);

		if(maxCosts >= 100 && defaults[6]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Runenklinge"), 100));
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helsturms Streitkolben"), 60));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert des Sigismund"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Stärke"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schicksalsklinge"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gesegnete Schwert"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hammer der Rechtschaffenen"), 25));			
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenbogen"), 25));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Gerechtigkeit"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wyrmtöter"), 15));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 15, 15, 15, 5);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };			
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 55)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Siegeslorbeer"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der Befehlsgewalt"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Silberhorn"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Aldreds Spruchschatulle"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Van Horstman's Speculum"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feuerring"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Donnerkugel"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone des Magnus"), 25));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ring des Volans"), 20));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichentuch des Magnus"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Heilige Reliquie"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Jadeamulett"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der weiße Mantel"), 35));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das purpurne Amulet"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Zeichen des Sigmar"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schutztalisman"), 15));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 55 && !mage) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Güldene Rüstung"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung von Tarnus"), 35));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung der Dämmerung"), 35));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schild der Gorgo"), 25));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meteoreisenrüstung"), 25));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm des Rattentöters"), 25));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bronzeschild"), 20));
		if(!mage){
			CommonMagicItems.addCommonArmour(ogE, maxCosts, 15);
		}
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		seperator();

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Siegel der Zerstörung"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grauer Stab"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberstab der Macht"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Glücksstein"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kristallkugel"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Magierstab"), 10));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
			
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen(100, 100, 570, KAMMER_HOEHE + BuildaHQ.wasIstHoeher(bufferCnt, cnt));

	}

	@Override
	public void refreshen() {
		if(!this.mage) {
			o4.setAktiv(false);
		}

		boolean error = false;
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();// + oe1.getKosten();
		
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
}
