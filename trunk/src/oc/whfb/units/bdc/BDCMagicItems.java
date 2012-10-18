package oc.whfb.units.bdc;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OptionsEinzelUpgradeUnique;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsVater;
import oc.RuestkammerChooser;
import oc.RuestkammerVater;

public class BDCMagicItems extends RuestkammerVater implements ActionListener {

	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;

	OptionsEinzelUpgradeUnique oe1;
	OptionsEinzelUpgradeUnique oe2;
	OptionsEinzelUpgradeUnique oe3;
	OptionsEinzelUpgradeUnique oe4;
	OptionsEinzelUpgradeUnique oe5;
	OptionsEinzelUpgradeUnique oe6;	
	OptionsEinzelUpgradeUnique oe7;
	OptionsEinzelUpgradeUnique oe8;
	
	OptionsPanelSwitcher weapons;
	OptionsPanelSwitcher armour;
	OptionsPanelSwitcher enchanted;
	OptionsPanelSwitcher talismans;
	OptionsPanelSwitcher arcane;
	
	private int maxCosts = 25;
	private boolean mage = false;
	private boolean minotaur = false;
	
	Vector<String> items = null;
	RuestkammerChooser box = null;
	OptionsVater[] off = new OptionsVater[]{ };
	OptionsVater[] on = null;	
	int bufferCnt;
	
	public BDCMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Mage yes/no
		// defaults[1] = maxCosts 50
		// defaults[2] = maxCosts 100
		// defaults[3] = minotaur

		if(defaults[0]) mage = true;
		if(defaults[1]) maxCosts = 50;
		if(defaults[2]) maxCosts = 100;
		if(defaults[3]) minotaur = true;
		
		items = new Vector<String>();
		items.add(BuildaHQ.translate("Magische Waffen"));
		items.add(BuildaHQ.translate("Verzauberte Gegenstände"));
		items.add(BuildaHQ.translate("Talismane"));
		items.add(BuildaHQ.translate("Magische Rüstungen"));
		items.add(BuildaHQ.translate("Arkane Artefakte"));

        box = new RuestkammerChooser(20, 10, buttonBreite, 20, items);
        box.addActionListener(this);
        panel.add(box.getPanel());
		
		int hoehe = 35;
		
		JLabel label = new JLabel(BuildaHQ.translate("Gaben des Chaos"));//Quick & Dirty
		label.setBounds(30, hoehe, buttonBreite + 30, 30);
		label.setFont(new Font("Lucida Blackletter", Font.BOLD, 16));
		panel.add(label);
		
		seperator(60); 
		
		if(maxCosts >= 75)add(oe1 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Hörnerkrone"), 75));
		add(oe2 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Schneckenhaut"), 30));
		add(oe3 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Vielarmige Bestie"), 20));
		add(oe4 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Gewaltige Hauer"), 15));
		add(oe5 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Verwachsene Haut"), 15));
		add(oe6 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Rune der wahren Bestie"), 15));
		add(oe7 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Übernatürliche Sinne"), 10));
		add(oe8 = new OptionsEinzelUpgradeUnique(ID, randAbstand, cnt, "", BuildaHQ.translate("Schattenfell"), 5));
				
		seperator();
		
		if(maxCosts >= 100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Urkeule"), 100));
		if(maxCosts >= 75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Menschenfäller"), 75));
		if(maxCosts >= 65) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Steinbrecher"), 65));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Entmanner"), 50));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer der Jagd"), 50)); 
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Äxte des Khorgor"), 40));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Stahlklauen"), 35));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Bronzespalter"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ausbluter"), 25));	
		
		CommonMagicItems.addCommonWeapons(ogE, maxCosts, 25, 15, 20, 10);
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Herdensteinsplitter"), 50));
		if(!mage && !minotaur)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Horn der großen Jagd"), 50));
		if(!mage && !minotaur)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Horn der ersten Bestie"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Trotzstein"), 25));
		if(mage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Menschenhaut"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klagehorn"), 15));		
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Auge der Nacht"), 45));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kelch d. schw. Regens"), BuildaHQ.translate("Kelch des schwarzen Regens"), 40));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();		
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klingenbrecherrüstung"), 50));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Trollhaut"), 50));
		if(maxCosts > 25)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pelz des Schattengeb."), BuildaHQ.translate("Pelz des Schattengeborenen"), 45));							
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Geschw. Plattenrüstung"), BuildaHQ.translate("Geschwärzte Plattenrüstung"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Widderhornhelm"), 15));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if (maxCosts >= 60)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädel des Rarkos"), 60));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stab des Darkoth"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hexenbaum Fetisch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gezackter Dolch"), 10));
		
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
			o4.setAktiv(true);
			o2.setAktiv(false);
		} else {
			o4.setAktiv(false);
			o2.setAktiv(true);
		}
		
		if(this.minotaur && maxCosts == 25){
			oe2.setAktiv(false);
			oe3.setAktiv(false);
			oe4.setAktiv(false);
			oe5.setAktiv(false);
			oe6.setAktiv(false);
			oe7.setAktiv(false);
			oe8.setAktiv(false);
		}
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten()+ //oz1.getKosten()
							+ oe2.getKosten() + oe3.getKosten() + oe4.getKosten()
							+ oe5.getKosten() + oe6.getKosten() + oe7.getKosten() + oe8.getKosten();
		if ( maxCosts > 50 ) totalCosts = totalCosts + oe1.getKosten();
		
		if ( totalCosts > this.maxCosts ) {
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
