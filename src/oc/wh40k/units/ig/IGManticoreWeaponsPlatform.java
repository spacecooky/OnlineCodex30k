package oc.wh40k.units.ig;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class IGManticoreWeaponsPlatform extends Eintrag {

	AnzahlPanel Buggies;
	OptionsEinzelZaehler Rot‰Farb‰;

	public IGManticoreWeaponsPlatform() {

		kategorie = 4;
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Manticore Weapons Platform","Manticore Weapons Platforms", 1, 3, 100);
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
