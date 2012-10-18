package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;

public class DMMekBossBuzzgob extends Eintrag {

	public DMMekBossBuzzgob() {

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
