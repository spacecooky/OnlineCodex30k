package oc.whfb.units.vf;

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

public class VFMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	
	private int maxCosts = 50;
	boolean isVampir = false;
	boolean isNekro = false;
	boolean isFluchfürst = false;
	
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

	public VFMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isVampir = defaults[0];
		isNekro = defaults[1];
		isFluchfürst = defaults[2];

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
		box.setMaximumRowCount(5);
		box.setEditable(false);
		box.addActionListener(this); 
		box.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		panel.add(box);

		if(maxCosts >= 100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Frostklinge"), 100));
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schreckenslanze"), 60));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarze Axt des Krell"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bluttrinker"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge der Qualen"), BuildaHQ.translate("Klinge der Todesqualen"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Könige"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grabklinge"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hexenfeuerlanze"), 10));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 15, 15, 15, 5);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };			
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Staubhand"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab d. Flammentods"), BuildaHQ.translate("Stab des Flammentods"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Helm d. Kontrolle"), BuildaHQ.translate("Helm der absoluten Kontrolle"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verfluchtes Buch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Amulett der Bestie"), 10));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Carsteinring"), 75));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Krone d. Verdammten"), BuildaHQ.translate("Krone der Verdammten"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goldene Armbänder"), BuildaHQ.translate("Armbänder aus schwarzem Gold"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutjuwel"), 25));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 45) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutrüstung"), BuildaHQ.translate("Shaitaans Blutrüstung"), 45));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verfluchte Rüstung"), BuildaHQ.translate("Die verfluchte Rüstung"), 25));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung d. Gehäuteten"), BuildaHQ.translate("Rüstung des Gehäuteten"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung der Nacht"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichentuch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichenkürass"), 15));
		
		if (!isNekro)
			CommonMagicItems.addCommonArmour(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 65) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelstab"), 65));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab d. Verdammnis"), BuildaHQ.translate("Stab der Verdammnis"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Buch des Arkhan"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Szepter des Noirot"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutrotes Juwel"), BuildaHQ.translate("Blutrotes Juwel von Lahmia"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzer Periapt"), 15));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen(100, 100, 570, KAMMER_HOEHE + BuildaHQ.wasIstHoeher(bufferCnt, cnt));
	}

	@Override
	public void refreshen() {
		o4.setAktiv(!isFluchfürst);	
		
		o1.setAktiv(BuildaHQ.translate("Schwarze Axt des Krell"), isFluchfürst);
		o1.setAktiv(BuildaHQ.translate("Bluttrinker"), isVampir);
		
		o2.setAktiv(BuildaHQ.translate("Rüstung der Nacht"), !isNekro);
		o2.setAktiv(BuildaHQ.translate("Shaitaans Blutrüstung"), !isNekro);
		o2.setAktiv(BuildaHQ.translate("Die verfluchte Rüstung"), !isNekro);
		o2.setAktiv(BuildaHQ.translate("Rüstung des Gehäuteten"), !isNekro);		
		o2.setAktiv(BuildaHQ.translate("Leichenkürass"), isVampir );
		o2.setAktiv(BuildaHQ.translate("Verzauberter Schild"), !isNekro);
		
		o5.setAktiv(BuildaHQ.translate("Amulett der Bestie"), isVampir);
		
		o3.setAktiv(BuildaHQ.translate("Carsteinring"), isVampir);
		
		o4.setAktiv(BuildaHQ.translate("Blutrotes Juwel"), isVampir);

		boolean error = false;
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();//  + oe1.getKosten(); //+ scrolls.getKosten()gems.getKosten();
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			error = true;
			showErrorMessage("Max. " + this.maxCosts + " "+BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			error = false;
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
		
		if(!error)setButtonState(BuildaHQ.noErrors);
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(o2.contains(name)){
			o2.setAktiv(name, aktiv);
		}
		
		if(name.equals("Ritter der Nacht")) {
			o2.setAktiv(BuildaHQ.translate("Rüstung der Nacht"), false);
		}
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
