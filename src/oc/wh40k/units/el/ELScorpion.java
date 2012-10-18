package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELScorpion extends Eintrag {

        OptionsUpgradeGruppe o1;
        
	public ELScorpion() {

		name = "Scorpion";
		grundkosten = 500;

		add(ico = new oc.Picture("oc/wh40k/images/ELScorpion.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("shuriken cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("scatter laser", 10));
		ogE.addElement(new OptionsGruppeEintrag("missile launcher", "Eldar missile launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("star cannon", 20));
		ogE.addElement(new OptionsGruppeEintrag("bright lance", 30));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
