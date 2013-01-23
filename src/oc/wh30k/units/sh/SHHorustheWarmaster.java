package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;

public class SHHorustheWarmaster extends Eintrag {

	public SHHorustheWarmaster() {
		name = "Horus the Warmaster";
		grundkosten = 500;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("SHPraetor", 1);

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Justaerin Terminator Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Justaerin Terminator Squad");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SHPraetor", -1);
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Justaerin Terminator Squad");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Justaerin Terminator Squad");
		super.deleteYourself();
	}

}
