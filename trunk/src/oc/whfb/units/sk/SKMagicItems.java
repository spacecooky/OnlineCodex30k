package oc.whfb.units.sk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import oc.BuildaHQ;
import oc.CommonMagicItems;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsVater;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class SKMagicItems extends RuestkammerVater implements ActionListener {

	OptionsZaehlerGruppe oe2;
	OptionsUpgradeGruppeUnique o1;
	OptionsUpgradeGruppeUnique o2;
	OptionsUpgradeGruppeUnique o3;
	OptionsUpgradeGruppeUnique o4;
	OptionsUpgradeGruppeUnique o5;
	OptionsUpgradeGruppeUnique o6;
	
	OptionsEinzelUpgrade bh1;
	OptionsEinzelUpgrade bh2;
	OptionsEinzelUpgrade bh3;
	OptionsEinzelUpgrade bh4;
	OptionsEinzelUpgrade bh5;

	private int maxCosts = 15;
	private boolean mage, ast = false;
	private boolean eshin = false;
	private boolean seuche = false;
	private boolean skyre = false;
	private boolean moulder = false;
	
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

	public SKMagicItems() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Mage yes/no
		// defaults[1] = maxCosts 30
		// defaults[2] = maxCosts 50
		// defaults[3] = maxCosts 100
		// defaults[4] = eshinklan
		// defaults[5] = seuchenklan
		// defaults[6] = skyreklan
		// defaults[7] = züchterklan

		if(defaults[0]) mage = true;
		if(defaults[1]) maxCosts = 30;
		if(defaults[2]) maxCosts = 50;
		if(defaults[3]) maxCosts = 100;
		if(defaults[4]) eshin = true;
		if(defaults[5]) seuche = true;
		if(defaults[6]) skyre = true;
		if(defaults[7]) moulder = true;
		
		
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
		
		JLabel label = new JLabel(BuildaHQ.translate("Der Beutehaufen"));//Quick & Dirty
		label.setBounds(30, 35, buttonBreite + 30, 30);
		label.setFont(new Font("Lucida Blackletter", Font.BOLD, 16));
		panel.add(label);
		
		seperator(60); 
		
		add(bh1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Warpsteinmuskete"), 15));
		add(bh2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftattacken"), 15));
		add(bh3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schwanzwaffe"), 8));
		add(bh4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Warpsteinpistole"), 8));
		add(bh5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wachratte"), 5));	
		
		
		if(maxCosts >= 100 && !moulder) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Grimmklinge"), 100));
		if(maxCosts >= 50 && !moulder) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpklinge"), 50));
		if(maxCosts >= 50 && eshin)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpstein-Wurfsterne"), 50));
		if(maxCosts >= 45 && !moulder) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warlockmodifizierte Waffe"), 45));
		if(maxCosts >= 35 && !moulder) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seuchenklinge"), 35));
		if(maxCosts >= 30 && !moulder) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tränenklinge"), 30));
		if(maxCosts >= 30 && skyre)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verdammnisrakete"), 30));
		if(maxCosts >= 25 && moulder)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schockstab"), 25));
		if(maxCosts >= 25 && skyre)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Todeswindkugel"), 25));
		if(maxCosts >= 25 && !moulder) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwergenfluch"), 25));
		if(maxCosts >= 15 && moulder)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elektropeitsche"), 15));
		if(!moulder)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Klinge des Nurglitsch"), 10));
		
		if( !moulder ){
			CommonMagicItems.addCommonWeapons(ogE, maxCosts, 30, 25, 20, 5);
		}
		
		bufferCnt = cnt;
		cnt = randAbstand;
		
		on = new OptionsVater[] { o1 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "",ogE) };			
		add(weapons = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skavenbräu"), 50));
		if(maxCosts >= 50 && skyre)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bronzesphäre"), 50));
		if(maxCosts >= 30 && eshin)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höllenbombe"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skalm"), 30));
		if(maxCosts >= 25) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Scheckfells Röhre"), 25));
		if(maxCosts >= 20) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Omen des verlausten Unheils"), 20));
		if(maxCosts >= 20 && skyre)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warlock-Okulare"), 20));
		if(maxCosts >= 10 && eshin)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rauchbomben"), 10));
		
		CommonMagicItems.addCommonEnchanted(ogE, maxCosts);
		
		on = new OptionsVater[] {o5 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(enchanted = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));

		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Widerwärtiger Talisman"), 30));
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schattenmagnet"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rivalenhaut-Talisman"), 15));
		
		CommonMagicItems.addCommonTalismans(ogE, maxCosts, 15);
		
		on = new OptionsVater[] {o3 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(talismans = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 30) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsteinrüstung"), 30));
		if(maxCosts >= 25) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Weltrandrüstung"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schild der Verwirrung"), 15));
		
		CommonMagicItems.addCommonArmour(ogE, maxCosts, 10);
		
		on = new OptionsVater[] {o2 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE)};				
		add(armour = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
		
		ogE = new Vector<OptionsGruppeEintrag>();
		if(maxCosts >= 50) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsturmspruchrolle"), 50));
		if(maxCosts >= 35 && seuche)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpspruchrolle"), 35));
		if(maxCosts >= 20) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpenergie-Kondensator"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kristallkugel"), 15));
		
		CommonMagicItems.addCommonArcane(ogE, maxCosts, 35, 20, 25);
		
		o4 = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE);				
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsteinhappen"), 15));
		oe2 = new OptionsZaehlerGruppe(ID, randAbstand + 570, cnt, "", ogE, 0);
		oe2.setHeadline("");
		
		on = new OptionsVater[2];		
		on[0] = o4;
		on[1] = oe2;
		
		add(arcane = new OptionsPanelSwitcher(randAbstand + 280, cnt, on, off));
				
		box.setSelectedIndex(0);
		setUeberschrift(BuildaHQ.translate("Magische Gegenstände"));
		sizeSetzen(100, 100, 570, KAMMER_HOEHE + BuildaHQ.wasIstHoeher(bufferCnt, cnt));
	}

	@Override
	public void refreshen() {
		if(this.mage) {
			oe2.setMaxAnzahl(this.maxCosts == 100 ? 6 : 3);
			oe2.setAktiv(true);
			o4.setAktiv(true);
		} else {
			oe2.setAktiv(false);
			o4.setAktiv(false);
		}
		
		o2.setAktiv(!this.mage);
		
		if(ast){
			 o5.setAktiv(false);
			 o2.setAktiv(false);
			 o3.setAktiv(false);		 
			 o1.setAktiv(false);
		}else{
			o5.setAktiv(true);
			 if(!this.mage){
				 o2.setAktiv(true);
			 }
			 o3.setAktiv(true);		 
			 o1.setAktiv(true);
		}
		
		if(moulder){
			 o5.setAktiv(false);
			 o2.setAktiv(false);
			 o3.setAktiv(false);
		}
		
		if(seuche){
			oe2.setAktiv(false);
			o4.setAktiv(BuildaHQ.translate("Warpenergie-Kondensator"), false);
		}
		
		if(skyre && mage){
			o2.setAktiv(true);
			o2.setAktiv(BuildaHQ.translate("Weltrandrüstung"), false);
			o2.setAktiv(BuildaHQ.translate("Schild der Verwirrung"), false);
			o2.setAktiv(BuildaHQ.translate("Rüstung des Schicksals"), false);
			o2.setAktiv(BuildaHQ.translate("Schurkenhelm"), false);
			o2.setAktiv(BuildaHQ.translate("Silberstahlrüstung"), false);
			o2.setAktiv(BuildaHQ.translate("Rüstung des Glücks"), false);
			o2.setAktiv(BuildaHQ.translate("Helm der Zwietracht"), false);
			o2.setAktiv(BuildaHQ.translate("Schuppenrüstung"), false);
			o2.setAktiv(BuildaHQ.translate("Schild des Ptolos"), false);
			o2.setAktiv(BuildaHQ.translate("Zauberspruch-Schild"), false);
			o2.setAktiv(BuildaHQ.translate("Rüstung des Glücksritters"), false);
			o2.setAktiv(BuildaHQ.translate("Verzauberter Schild"), false);
			o2.setAktiv(BuildaHQ.translate("Drachenhelm"), false);
			o2.setAktiv(BuildaHQ.translate("Glückbringender Schild"), false);
			
			o2.setAktiv(BuildaHQ.translate("Warpsteinrüstung"), true); 
		}
		
		boolean error = false;
		double totalCosts = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + oe2.getKosten()
							+ bh1.getKosten() + bh2.getKosten() + bh3.getKosten() + bh4.getKosten() + bh5.getKosten(); 

		if(maxCosts > 15){
			totalCosts = totalCosts + o5.getKosten(); 
		}
		if(totalCosts > this.maxCosts || getKosten() > this.maxCosts) {
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
	
	@Override
	public void specialAction(boolean... action) {
		try{
			this.mage = action[0];
			this.ast = action[1];
		}catch (Exception e) { }		
		
		refreshen();
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
