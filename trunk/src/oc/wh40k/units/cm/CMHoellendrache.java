package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMHoellendrache extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public CMHoellendrache() {
		name = "H�llendrache";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/H�llendrache.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hades-MaschKa", "Hades-Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hexenfeuerwerfer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
