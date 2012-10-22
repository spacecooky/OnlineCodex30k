package oc.wh30k.units.fo;

import oc.Eintrag;

public class FOHimmelsschildLandeplattform extends Eintrag {
	

	public FOHimmelsschildLandeplattform() {
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