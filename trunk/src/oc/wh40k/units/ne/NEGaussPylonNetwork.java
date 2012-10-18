package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class NEGaussPylonNetwork extends Eintrag {

	OptionsEinzelZaehler pylons;

	public NEGaussPylonNetwork() {
		name = "Gauss Pylon Network";
		grundkosten = 200;
		add(ico = new oc.Picture("oc/wh40k/images/GaussPylon.gif"));
		
		pylons = new OptionsEinzelZaehler(ID, randAbstand, cnt,"","Gauss Pylons", 5, 420);
		add(pylons);

		complete();
	}

	@Override
	public void refreshen() {
		if(pylons.getAnzahl()<2){
			pylons.setAnzahl(2);
		}
	}
}
