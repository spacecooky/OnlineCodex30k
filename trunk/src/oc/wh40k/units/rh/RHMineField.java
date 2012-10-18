package oc.wh40k.units.rh;


import oc.BuildaHQ;
import oc.Eintrag;

public class RHMineField extends Eintrag {

	public RHMineField() {
		name="Minefield";
		überschriftSetzen=true;
		kategorie = 5;

		add(ico = new oc.Picture("oc/wh40k/images/RHMineField.gif"));
		
		
		grundkosten = 50;

		
		
		complete();

	}

	//@OVERRIDE
	public void refreshen() {

	}
}
