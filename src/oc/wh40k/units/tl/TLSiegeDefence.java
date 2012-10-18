package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TLSiegeDefence extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;

	boolean paskSelected = false;

	public TLSiegeDefence() {
		grundkosten = 0;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/TLSiegeDefence.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Thunderer", 140));
		ogE.addElement(new OptionsGruppeEintrag("Medusa", 135));
		ogE.addElement(new OptionsGruppeEintrag("Basilisk", 125));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer blade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 15));
		
		seperator();
		
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Enclosed crew compartment", 15));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bastion breacher shells", 5));
		oe3.setAktiv(false);
		oe4.setAktiv(false);

		sizeSetzen();
	}

  @Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());	
		
		oe3.setAktiv(o1.getSelectedIndex()==1 || o1.getSelectedIndex()==2);
		oe4.setAktiv(o1.getSelectedIndex()==1);
		
		
	}
}
