package oc.wh40k.units.cm2007;

import oc.Eintrag;

public class CM2007Dreadclaw extends Eintrag {


	public CM2007Dreadclaw() {
                name = "Dreadclaw";
                grundkosten = 85;

                add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));


                complete();
	}

	@Override
	public void refreshen() {
	}

}
