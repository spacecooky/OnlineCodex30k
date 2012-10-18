package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDSeuchenhueterdesNurgle extends Eintrag {

	AnzahlPanel CDSeuchenhueterdesNurgle;

	public CDSeuchenhueterdesNurgle() {

		name = "Seuchenhüter des Nurgle";
		grundkosten = 0;

		CDSeuchenhueterdesNurgle = new AnzahlPanel(ID, randAbstand, cnt, "Seuchenhüter des Nurgle", 5, 20, 15);
		add(CDSeuchenhueterdesNurgle);

		add(ico = new oc.Picture("oc/wh40k/images/CDSeuchenhueterdesNurgle.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ätzende Berührung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosikone", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] Scabeiathrax the Bloated");

		complete();

	}

	@Override
	public void refreshen() {
	}
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] Scabeiathrax the Bloated");
    }
}
