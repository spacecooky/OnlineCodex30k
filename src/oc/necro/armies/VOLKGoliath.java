package oc.necro.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKGoliath extends BuildaVater {

	public VOLKGoliath() {

		String[] Gangbosse = {"", "Gangboss"};
		String[] Spezialisten = {"", "Spezialist"};
		String[] Ganger = {"", "Ganger"};
		String[] Kids = {"", "Kid"};


		adden(new ChooserGruppe("", cnt, 0, 1, Gangbosse));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe("", cnt, 0, 2, Spezialisten));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe("", cnt, 0, 3, Ganger));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe("", cnt, 0, 4, Kids));
		cnt += 480;

		nameDerArtDerArmee = "Haus Goliath";
		nameDerArtDerArmeeDekliniert = "Goliath-Gang";
		textAreaUeberschrift = "Meine Goliath-Gang";

		complete();
	}

	protected void finalize() {
		System.out.println("Object gel�scht in " + nameDerArtDerArmee + "Builda !!");
	}

}
