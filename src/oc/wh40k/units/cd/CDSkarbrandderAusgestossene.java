package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;

public class CDSkarbrandderAusgestossene extends Eintrag {

	public CDSkarbrandderAusgestossene() {

		name = "Skarbrand, der Ausgesto�ene";

		grundkosten = 300;

		add(ico = new oc.Picture("oc/wh40k/images/CDSkarbrandderAusgestossene.gif"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
