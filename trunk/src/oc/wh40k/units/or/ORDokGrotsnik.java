package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORDokGrotsnik extends Eintrag {

	public ORDokGrotsnik() {
		name = "Dok Grotsnik";
		kategorie = 1;
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/DokGrotsnik.gif"));
		

		BuildaHQ.addToInformationVector("ORDokGrotsnik", 1);
		
		complete();
	}

	@Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("ORDokGrotsnik", -1);
        super.deleteYourself();
    }
	
	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}

}
