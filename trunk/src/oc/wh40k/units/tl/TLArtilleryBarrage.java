package oc.wh40k.units.tl;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TLArtilleryBarrage extends Eintrag {

	OptionsUpgradeGruppe barrage;

	public TLArtilleryBarrage() {
		name="Artillery Barrage\n";
		überschriftSetzen=true;
		kategorie = 5;

		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/TLArtilleryBarrage.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Bombard Strike", 100));
		ogE.addElement(new OptionsGruppeEintrag("Basilisk Strike", 70));
		ogE.addElement(new OptionsGruppeEintrag("Mortar Strike", 50));

		barrage = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(barrage);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

	}
}
