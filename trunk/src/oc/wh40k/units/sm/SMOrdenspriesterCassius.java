package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMOrdenspriesterCassius extends Eintrag {

	public SMOrdenspriesterCassius() {
		name = "Ordenspriester Cassius";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/SMOrdenspriesterCassius.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
