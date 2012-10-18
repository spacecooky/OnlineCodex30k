package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;

public class CMTyphus extends Eintrag {


	public CMTyphus() {
		name = "Typhus";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/Typhus.gif"));
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Seuchenmarines");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Seuchenmarines");

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Seuchenzombies");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Seuchenmarines");
		
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Seuchenzombies");
		super.deleteYourself();
	}

}
