package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYDerParasitvonMortrex extends Eintrag {

	public TYDerParasitvonMortrex() {
		name = "Der Parasit von Mortrex";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/TYDerParasitvonMortrex.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
