package oc.whfb.units.de;

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
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerChooser;
import oc.RuestkammerVater;

public class DEMagicItems extends RuestkammerVater implements ActionListener {

	OptionsZaehlerGruppe oe2;
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

	public DEMagicItems() {
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

		if(maxCosts >= 80) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Axt des Henkers"), 80));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge der Zerstörung"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schattennetz"), 50));
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisklinge"), 50));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Herzsucher"), 35));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hydraklinge"), 35));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Caledors Fluch"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dolch des Hotek"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenzahnschleuder"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutroter Tod"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schächter"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Peitsche der Qualen"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seelenschnitter"), 15));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 15, 15, 15, 5);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Todesmaske"), 50));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Fänge der Hydra"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mitternachtskristall"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzes Drachenei"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stärketrank"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Alptraumjuwel"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das leitende Auge"), 25));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 70) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzes Amulett"), 70));
		if(maxCosts >= 40) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ring der Finsternis"), 40));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kette von Khaeleth"), 35));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Siegel von Ghrond"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Perle der Gleichgültigkeit"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ring des Hotek"), 25));
		
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE);
		on = new OptionsVater[2];		
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Talisman der Leere"), 15));		
		oe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3);
		oe2.setHeadline("");
		
		on[0] = o3;		
		on[1] =  oe2;
		
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 60) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Fluchrüstung"), 60));
		if(maxCosts >= 35) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung der Knechtschaft"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Umhang von Hag Graef"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung der Finsternis"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schild von Ghrond"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutrüstung"), 15));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 55) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzer Stab"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberhomunkulus"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sternenlichtmantel"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Opferdolch"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Buch des Furion"), 15));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!this.mage) {
			o4.setAktiv(false);
		}

		oe2.setAktiv(!o3.isSelected());
		o3.setAktiv(!oe2.isSelected());
		o2.setAktiv(!this.mage);
		
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten() /*+ oe1.getKosten()*/ + oe2.getKosten();
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
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
