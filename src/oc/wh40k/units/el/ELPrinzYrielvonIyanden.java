package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;

public class ELPrinzYrielvonIyanden extends Eintrag {

	public ELPrinzYrielvonIyanden() {

		name = "Prinz Yriel von Iyanden";

		grundkosten = 155;





		add(ico = new oc.Picture("oc/wh40k/images/PrinzYrielvonIyanden.gif"));





		complete();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
