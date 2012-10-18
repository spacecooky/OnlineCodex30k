package oc.wh40k.units.rh;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RHArtilleryStrike extends Eintrag {

	OptionsUpgradeGruppe barrage;

	public RHArtilleryStrike() {
		name="Artillery Barrage";
		überschriftSetzen=true;
		kategorie = 5;

		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/TLArtilleryBarrage.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Bombard Strike", 100));
		ogE.addElement(new OptionsGruppeEintrag("Manticore Strike", 90));
		ogE.addElement(new OptionsGruppeEintrag("Basilisk Strike", 70));
		ogE.addElement(new OptionsGruppeEintrag("Griffon Strike", 50));
		ogE.addElement(new OptionsGruppeEintrag("Mortar Strike", 50));

		barrage = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(barrage);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

	}
}
