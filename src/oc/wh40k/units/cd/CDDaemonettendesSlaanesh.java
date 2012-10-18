package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDDaemonettendesSlaanesh extends Eintrag {

	AnzahlPanel CDDaemonettendesSlaanesh;

	public CDDaemonettendesSlaanesh() {

		name = "Dämonetten des Slaanesh";
		grundkosten = 0;

		CDDaemonettendesSlaanesh = new AnzahlPanel(ID, randAbstand, cnt, "Dämonetten des Slaanesh", 5, 20, 14);
		add(CDDaemonettendesSlaanesh);

		add(ico = new oc.Picture("oc/wh40k/images/CDDaemonettendesSlaanesh.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lähmender Blick", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosikone", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] Zarakynel");

		complete();

	}

	@Override
	public void refreshen() {
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] Zarakynel");
    }
}
