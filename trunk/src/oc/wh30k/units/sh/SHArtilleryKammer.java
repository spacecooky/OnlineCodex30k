package oc.wh30k.units.sh;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class SHArtilleryKammer extends RuestkammerVater {

	OptionsUpgradeGruppe typ;
	OptionsUpgradeGruppe rhinoWeapons;
	OptionsPanelSwitcher switcher;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	public SHArtilleryKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Legion Basilisk", 140));
		ogE.addElement(new OptionsGruppeEintrag("Legion Medusa", 155));
		ogE.addElement(new OptionsGruppeEintrag("Legion Whirlwind", 75));
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		OptionsVater[] imp = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10),	
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin-linked bolter", 5),
		};
		
		OptionsVater[] whirlwind = new OptionsVater[]{
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxiliary drive", 10),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10),	
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Twin-linked bolter", 5),
			new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hyperios missiles", "Hyperios air-defence missiles", 0),
		};
		
		add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, imp, whirlwind));
		
		

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if (!typ.isSelected()) {
			typ.setSelected(0, true);
		}

		if (!typ.isSelected("Whirlwind")) {
			switcher.forceSwitchPanel(0);
		} else {
			switcher.forceSwitchPanel(1);
		}
				
	}
	
}
