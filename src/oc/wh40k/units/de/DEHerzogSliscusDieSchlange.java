package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEHerzogSliscusDieSchlange extends Eintrag {

    public DEHerzogSliscusDieSchlange() {
        name = "Herzog Sliscus, Die Schlange";
        grundkosten = 150;

        BuildaHQ.addToInformationVector("DEHQ", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/DEHerzogSliscusDieSchlange.jpg"));
        

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
	}

}
