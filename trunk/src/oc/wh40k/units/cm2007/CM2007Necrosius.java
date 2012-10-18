package oc.wh40k.units.cm2007;

import oc.Eintrag;

public class CM2007Necrosius extends Eintrag {

	

	public CM2007Necrosius() {
		name = "Necrosius";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/Necrosius.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
