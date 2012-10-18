package oc.whfb.units.bt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsUpgradeGruppeVows;
import oc.OptionsVater;
import oc.RuestkammerChooser;
import oc.RuestkammerVater;
import oc.whfb.armies.VOLKBretonia;

public class BTMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	
	OptionsUpgradeGruppeVows oTugend;

	private int maxCosts = 25;
	private boolean mage = false;
	private boolean quest = false;
	private boolean gral = false;
	
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

	public BTMagicItems() {
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
		
		seperator(35);
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des ritterlichen Zorns"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Tapferkeit"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Entsagung"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend d. ungest. Ritters"), BuildaHQ.translate("Tugend des ungestümen Ritters"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des ritterlichen Ideals"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Sturheit"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des Heldenmuts"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Pflicht"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend des Selbstvertrauens"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Tjoste"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend d. ritterl. Verachtung"), BuildaHQ.translate("Tugend der ritterlichen Verachtung"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Reinheit"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tugend der Barmherzigkeit"), 10));		
		
		add(oTugend = new OptionsUpgradeGruppeVows(ID, randAbstand, cnt, "", ogE));
		setHeadline(oTugend, BuildaHQ.translate("Tugenden"));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 65) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die gesegnete Silberlanze"), 65));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Schwert der Queste"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Schwert der Champions"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Geburtsschwert"), BuildaHQ.translate("Geburtsschwert von Carcassonne"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Kernholzlanze"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Heldenschwert"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Morgenstern von Fracasse"), 25));	
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Lanze von Artois"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feuerlanze"), 20));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 30, 25, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Falkenhorn des Fredemund"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gesegnete Ikone"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Rubin Kelch"), 30));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Trophäen der großen Jagd"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Mähne des Vollbluts"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Locke der Isolde"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Fehdehandschuh"), 10));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 55 && !mage) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Siriennes Medaillon"), 55));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Gunst der Maid"), 35));
		if(!mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Questinsignie"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Drachenklaue"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Zopf von Bordeleaux"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Mantel der Elena"), 20));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 55) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goldener Kürass"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüst. d. Mitternachtssonne"), BuildaHQ.translate("Rüstung der Mitternachtssonne"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Gralsschild"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Gromril-Vollhelm"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung des Agilulf"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kürass des Glücks"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Orkfluch"), 15));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 10);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Silberspiegel"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Herz des Lebens"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ikone von Quenelles"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kelch von Malfleur"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gesegneter Trank"), 10));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 50, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
        
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		@SuppressWarnings("unused")
		boolean error = false;
		refreshVows();
		
		if(this.mage) {
			o2.setAktiv(false);
			o1.setAktiv(false);
		} else {
			o4.setAktiv(false);
		}

		o2.setAktiv(!this.mage);
		oTugend.setAktiv(!this.mage);
		
		double totalCosts = oTugend.getKosten();
		if(!oTugend.isSelected(BuildaHQ.translate("Tugend der Entsagung")))
			totalCosts = totalCosts + o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten();
		
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " "+ BuildaHQ.translate("Punkte"));
			error = true;
		} else {
			setButtonState(true);
			hideErrorMessage();
			error = false;
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
	}
	
	public void specialAction(boolean... action) {
		refreshen();
		boolean entsagung = oTugend.isSelected(BuildaHQ.translate("Tugend der Entsagung"));
		if(entsagung){
			o1.deselectAll();
			o2.deselectAll();
			o3.deselectAll();
			o5.deselectAll();
		}
		
		o1.setAktiv(!entsagung);
		o2.setAktiv(!entsagung);
		o3.setAktiv(!entsagung);
		o5.setAktiv(!entsagung);
				
		quest = action[1];
		gral = action[2];
		
		
		try {//Waffen
			if(maxCosts >= 65){o1.setAktiv(BuildaHQ.translate("Die gesegnete Silberlanze"), !quest && !entsagung);}
			o1.setAktiv(BuildaHQ.translate("Das Schwert der Queste"), quest && !entsagung);
			o1.setAktiv(BuildaHQ.translate("Das Schwert der Champions"), gral && !entsagung);
			o1.setAktiv(BuildaHQ.translate("Die Kernholzlanze"), !quest /*&& ! ast*/ && !entsagung);
			o1.setAktiv(BuildaHQ.translate("Die Lanze von Artois"), !quest /*&& ! ast*/ && !entsagung);
			o1.setAktiv(BuildaHQ.translate("Feuerlanze"), !quest /*&& ! ast*/ && !entsagung);
		} catch(Exception ex) {/* ignore*/ }
		
		try {//Talismane
			o3.setAktiv(BuildaHQ.translate("Die Questinsignie"), quest && !entsagung);
		} catch(Exception ex) {/* ignore*/ }
		
		if(!mage){
			try {
				if(maxCosts >= 55){
					o2.setAktiv(BuildaHQ.translate("Goldener Kürass"), gral && !entsagung);
				}
				o2.setAktiv(BuildaHQ.translate("Der Gralsschild"), gral && !entsagung);
				o2.setAktiv(BuildaHQ.translate("Rüstung des Agilulf"), !entsagung);
				o2.setAktiv(BuildaHQ.translate("Orkfluch"), !entsagung);
				o2.setAktiv(BuildaHQ.translate("Verzauberter Schild"), !entsagung);
			} catch(Exception ex) {/* ignore*/ }
		} else {
			o2.setAktiv(false);
			o1.setAktiv(false);
		}
	}
	
	public int getKost(String txt, int kost){
		if(!VOLKBretonia.Vows.containsKey(txt))return kost;
		int i = VOLKBretonia.Vows.get(txt);		
		return i * kost;
	}
	
	public void refreshVows(){
		String txt = BuildaHQ.translate("Tugend des ritterlichen Zorns");
		int cost = 40;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));

		txt = BuildaHQ.translate("Tugend der Tapferkeit");
		cost = 40;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Entsagung");
		cost = 40;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend d. ungest. Ritters");
		cost = 35;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend des ritterlichen Ideals");
		cost = 35;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Sturheit");
		cost = 35;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend des Heldenmuts");
		cost = 30;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Pflicht");
		cost = 30;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend des Selbstvertrauens");
		cost = 25;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Tjoste");
		cost = 25;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend d. ritterl. Verachtung");
		cost = 20;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Reinheit");
		cost = 20;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
		
		txt = BuildaHQ.translate("Tugend der Barmherzigkeit");
		cost = 10;
		if(!oTugend.isSelected(txt))oTugend.setPreis(txt,  getKost(txt, cost));
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
			
		specialAction(false, quest, gral); 
	}
}
