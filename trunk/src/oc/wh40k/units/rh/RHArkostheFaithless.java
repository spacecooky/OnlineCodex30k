package oc.wh40k.units.rh;


import oc.BuildaHQ;
import oc.Eintrag;

public class RHArkostheFaithless extends Eintrag {

	public RHArkostheFaithless() {
		name="Arkos the Faithless";
		überschriftSetzen=true;
		kategorie = 1;

		add(ico = new oc.Picture("oc/wh40k/images/RHArkostheFaithless.gif"));
		
		
		grundkosten = 150;

		
		
		complete();

	}

	//@OVERRIDE
	public void refreshen() {

	}
}
