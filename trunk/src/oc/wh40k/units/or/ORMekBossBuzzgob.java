package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORMekBossBuzzgob extends Eintrag {

	public ORMekBossBuzzgob() {

		kategorie = 1;
		name = "Mek Boss Buzzgob";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/MekBossBuzzgob.gif"));
		

		//TODO falls es eine Apo-Erweiterung gibt: Kustom Stompa hinzufügen

		complete();
	}

	public void deleteYourself() {

		//TODO falls es eine Apo-Erweiterung gibt: Kustom Stompa entfernen
		super.deleteYourself();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
