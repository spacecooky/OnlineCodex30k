package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMKorsarroKhan extends Eintrag {

	boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Moondrakkan"
	OptionsEinzelUpgrade o1;

	public SMKorsarroKhan() {
		name = "Kor'sarro Khan";
		grundkosten = 160;

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Monddrache", 45));

		complete();
	}

	@Override
	public void deleteYourself() {
		if (addedSpezialAuswahl) {
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Angriffs-Bike-Schwadron");
		}

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);

		super.deleteYourself();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
		if (o1.isSelected() && !addedSpezialAuswahl) {
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Angriffs-Bike-Schwadron");
			addedSpezialAuswahl = true;
		} else if (!o1.isSelected() && addedSpezialAuswahl) {
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Angriffs-Bike-Schwadron");
			addedSpezialAuswahl = false;
		}
	}

}
