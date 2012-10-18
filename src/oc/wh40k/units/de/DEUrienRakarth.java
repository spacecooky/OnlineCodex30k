package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEUrienRakarth extends Eintrag {

    public DEUrienRakarth() {
        name = "Urien Rakarth";
        grundkosten = 190;

        BuildaHQ.addToInformationVector("DEHaemonculus", 1);
        BuildaHQ.addToInformationVector("DEUrienRakarth", 1);

        add(ico = new oc.Picture("oc/wh40k/images/DEUrienRakarth.jpg"));
        

		seperator();

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Folterer");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Folterer");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        
        BuildaHQ.addToInformationVector("DEHaemonculus", -1);
        BuildaHQ.addToInformationVector("DEUrienRakarth", -1);

        if(BuildaHQ.getCountFromInformationVector("DEHaemonculus") < 1) {
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Folterer");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Folterer");
        }
	}

}
