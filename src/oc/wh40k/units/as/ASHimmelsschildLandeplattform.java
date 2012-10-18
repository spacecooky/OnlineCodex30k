package oc.wh40k.units.as;

import oc.Eintrag;

public class ASHimmelsschildLandeplattform extends Eintrag {
	

	public ASHimmelsschildLandeplattform() {
		name = "Himmelsschild-Landeplattform";
		grundkosten = 75;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Landeplattform.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
	}
}