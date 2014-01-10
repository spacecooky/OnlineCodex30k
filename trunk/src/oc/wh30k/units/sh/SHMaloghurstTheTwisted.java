package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SHMaloghurstTheTwisted extends Eintrag {
	
	OptionsUpgradeGruppe o0;

	public SHMaloghurstTheTwisted() {
		name = "Maloghurst The Twisted";
		grundkosten = 140;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("SHPraetor", 1);

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Reaver Attack Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Reaver Attack Squad");
				
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
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Reaver Attack Squad");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Reaver Attack Squad");
		super.deleteYourself();
	}

}
