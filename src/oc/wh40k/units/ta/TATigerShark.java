package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TATigerShark extends Eintrag {
        OptionsUpgradeGruppe o1;

	public TATigerShark() {
		name = "Tiger Shark";
		grundkosten = 520;

		add(ico = new oc.Picture("oc/wh40k/images/TigerShark.jpg"));
		

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nachtsichtgerät", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Störsystem", 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohnen", "14 Angriffsdrohnen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lenkraketen", "sechs Lenkraketen", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
        o1.alwaysSelected();
	}

}
