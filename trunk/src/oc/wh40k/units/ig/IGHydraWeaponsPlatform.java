package oc.wh40k.units.ig;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class IGHydraWeaponsPlatform extends Eintrag {

	AnzahlPanel Buggies;
	OptionsEinzelZaehler Rot‰Farb‰;

	public IGHydraWeaponsPlatform() {

		kategorie = 4;
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Hydra Weapons Platform","Hydra Weapons Platforms", 1, 3, 50);
		add(Buggies);

		add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
		seperator();

		
		add(Rot‰Farb‰ = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Camo-netting", 3, 20));
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		Rot‰Farb‰.setMaxAnzahl(Buggies.getModelle());
	}
}
