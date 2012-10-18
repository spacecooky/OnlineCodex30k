package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RHHellhound extends Eintrag {

	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public RHHellhound() {
		grundkosten = 130;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Searchlight", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launcher", 5));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Storm bolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy stubber", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Dozer Blade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));

		complete();
	}

  @Override
	public void refreshen() {
        if(!o2.isSelected()) o2.setSelected(0,true);
		
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
	}

}
