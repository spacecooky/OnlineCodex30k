package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDBluthundedesKhorne extends Eintrag {

	AnzahlPanel CDBluthundedesKhorne;
	OptionsEinzelUpgrade karanak;

	boolean karanakSelected  = false;

	public CDBluthundedesKhorne() {

		name = "Bluthunde des Khorne";

		grundkosten = 0;



		CDBluthundedesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Bluthunde des Khorne", 5, 20, 15);

		add(CDBluthundedesKhorne);





		add(ico = new oc.Picture("oc/wh40k/images/CDBluthundedesKhorne.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zorn des Khorne", 10));

		seperator();

		add(karanak = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade zu Karanak", "Upgrade zu Karanak, Bestie der Vernichtung", 35));

		complete();

	}

	public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafr wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt

		if (karanakPuffer) {
			BuildaHQ.addToInformationVector("Karanak", -1);
		}

		super.deleteYourself();

	}
	boolean karanakPuffer;

	@Override
	public void refreshen() {

	// Unique entry: Karanak
		boolean karanakGlobal = ( BuildaHQ.getCountFromInformationVector("CDKaranak") > 0 ? true : false );
		if(karanakGlobal && !karanakSelected) karanak.setAktiv(false);
		else karanak.setAktiv(true);

		if(karanak.isSelected()) {
			karanakSelected = true;
			BuildaHQ.addToInformationVector("CDKaranak", 1);
		} else {
			if(karanakSelected) {
				karanakSelected = false;
				BuildaHQ.setInformationVectorValue("CDKaranak", 0);
			}
		}

	}
}
