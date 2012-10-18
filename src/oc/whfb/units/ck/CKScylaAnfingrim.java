package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;

public class CKScylaAnfingrim extends Eintrag {

	public CKScylaAnfingrim() {
		name = BuildaHQ.translate("Scyla Anfingrim");
		grundkosten = 105;

		BuildaHQ.addToInformationVector("CKScylaAnfingrim", 1);

		add(ico = new oc.Picture("oc/whfb/images/CKScylaAnfingrim.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("CKScylaAnfingrim") > 1) {
			setFehlermeldung(BuildaHQ.translate("0-1 Auswahl"));
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("CKScylaAnfingrim", -1);
		super.deleteYourself();
	}

}
