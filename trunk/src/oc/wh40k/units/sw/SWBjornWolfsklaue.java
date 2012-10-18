package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SWBjornWolfsklaue extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SWBjornWolfsklaue() {
		name = "Bjorn Wolfsklaue";
		grundkosten = 270;

                BuildaHQ.addToInformationVector("SWHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SWBjornWolfsklaue.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		complete();
	}

	@Override
	public void refreshen() {
                setUnikat(true);
                if(!o1.isSelected()) o1.setSelected(0, true);

                // If this is the only HQ, count it as 1 (otherwise 0.5)
                if( BuildaHQ.getCountFromInformationVector("SWHQ") == 1 ) {
                                setEintragsCNT(1);
                } else {
                                setEintragsCNT(0.5);
                }
	}

	@Override
	public void deleteYourself() {
                super.deleteYourself();
		BuildaHQ.addToInformationVector("SWHQ", -1);
	}

}
