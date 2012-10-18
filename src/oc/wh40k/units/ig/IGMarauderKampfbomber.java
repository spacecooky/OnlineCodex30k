package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGMarauderKampfbomber extends Eintrag {

        OptionsUpgradeGruppe o1;

	public IGMarauderKampfbomber() {
		name = "Marauder-Abfangjäger";
		grundkosten = 400;


		add(ico = new oc.Picture("oc/wh40k/images/MarauderKampfbomber.gif"));
		

                ogE.addElement(new OptionsGruppeEintrag("Bomben","zwölf Bomben", 0));
		ogE.addElement(new OptionsGruppeEintrag("Höllensturm-Bomben","zwei Höllensturm-Bomben",0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	public void refreshen() {
            if (!o1.isSelected()) o1.setSelected(0,true);
	}
}
