package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDZerfleischerdesKhorne extends Eintrag {

	AnzahlPanel CDZerfleischerdesKhorne;

	public CDZerfleischerdesKhorne() {

		name = "Zerfleischer des Khorne";

		grundkosten = 0;



		CDZerfleischerdesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Zerfleischer des Khorne", 5, 20, 16);

		add(CDZerfleischerdesKhorne);





		add(ico = new oc.Picture("oc/wh40k/images/CDZerfleischerdesKhorne.gif"));

		seperator();







		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zorn des Khorne", 10));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosikone", 25));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

        BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] An'ggrath the Unbound");

		complete();

	}

	@Override
	public void refreshen() {
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("[Forgeworld] An'ggrath the Unbound");
    }
}
