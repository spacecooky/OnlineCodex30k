package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEBaronSathonyx extends Eintrag {

    public DEBaronSathonyx() {
        name = "Baron Sathonyx";
        grundkosten = 105;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/DEBaronSathonyx.jpg"));
        

		seperator();

		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Hellion");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Hellion");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        BuildaHQ.addToInformationVector("DEHQ", -1);
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Hellion");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Hellion");
	}

}
