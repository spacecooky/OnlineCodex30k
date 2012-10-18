package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTyrannofex extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public TYTyrannofex() {
		name = "Tyrannofex";
		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/TYTyrannofex.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Säurezyste", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bohrkäfernest", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kapselkanone", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stachelsalve", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelhagel", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schockmaden", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sauglarven", 0));
		ogE.addElement(new OptionsGruppeEintrag("Splitterschalenkäfer", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 30));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
	}

}
