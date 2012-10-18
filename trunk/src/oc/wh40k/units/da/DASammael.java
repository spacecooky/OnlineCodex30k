package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DASammael extends Eintrag {

	public DASammael() {
		name = "Sammael, Meister des Ravenwing";
		grundkosten = 205;

		add(ico = new oc.Picture("oc/wh40k/images/DASammael.gif"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Land Speeder", 0));

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Ravenwing-Angriffsschwadron");
		BuildaHQ.addToInformationVector("DASammael", 1);

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Ravenwing-Angriffsschwadron");
		BuildaHQ.addToInformationVector("DASammael", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
