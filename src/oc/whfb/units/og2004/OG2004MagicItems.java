package oc.whfb.units.og2004;

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


public class OG2004MagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	OptionsZaehlerGruppe oe2;

	boolean mage = false;
	boolean canUseSilverback = false;
	int maxCosts = 50;
	
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

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Tyrann
		// defaults[1] = Fleischermeister
		// defaults[2] = Fleischer
		// defaults[3] = Jäger

		mage = (defaults[1] || defaults[2]);
		canUseSilverback = defaults[0] || defaults[3];

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

        box = new RuestkammerChooser(20, 10, buttonBreite, 20, items);
        box.addActionListener(this);
        panel.add(box.getPanel());

		if(maxCosts >= 55) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Donnerkeule"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Fleischklopfer"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Festungsknacker"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelpflücker"), 30));
		if(mage) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutbeil"), 25));
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 30, 25, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brahmir-Statue"), 35));
		if(defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dämonenblut"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Silberrückenpelz"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Jadelöwe"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Steinauge"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hand voll Lorbeerkränze"), 15));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Cathay-Gagat"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gemmensplitter"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Morrssteinkette"), 20));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[2];
		o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE);
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gnoblar-Diebstein"), 15));
		oe2 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 3);
		oe2.setHeadline("");
		
		on[0] = o3;
		on[1] = oe2;
				
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mastodonrüstung"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelplatte"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schmetterbauch"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlundplatte"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gierfaust"), 20));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 5);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab der Zauberei"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenherz"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gruts Sichel"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Halbling-Kochbuch"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Knallstab"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelmaske"), 20));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 50, 25, 25);
		
		on = new OptionsVater[] {o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));			
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(this.mage) {
			oe2.setMaxAnzahl(3);
			o2.setAktiv(false);
		} else {
			o4.setAktiv(false);
		}

		oe2.setAktiv(!o3.isSelected());
		o3.setAktiv(!oe2.isSelected());

		// Enable/disable Silberrückenpelz
		o5.setAktiv(BuildaHQ.translate("Silberrückenpelz"), ( canUseSilverback && BuildaHQ.getCountFromInformationVector("OGYhetis") == 0 ));
		
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten() + oe2.getKosten();
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
