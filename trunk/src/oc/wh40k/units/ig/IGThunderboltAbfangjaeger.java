package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGThunderboltAbfangjaeger extends Eintrag {

	public IGThunderboltAbfangjaeger() {
		name = "Thunderbolt-Abfangj�ger";
		grundkosten = 180;


		add(ico = new oc.Picture("oc/wh40k/images/ThunderboltAbfangjaeger.gif"));
		

                ogE.addElement(new OptionsGruppeEintrag("Donnerkeil-Raketen","vier Donnerkeil-Raketen", 40));
		ogE.addElement(new OptionsGruppeEintrag("Bomben","vier Bomben",40));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	public void refreshen() {
	}
}
