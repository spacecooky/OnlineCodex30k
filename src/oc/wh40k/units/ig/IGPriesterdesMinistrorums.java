package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IGPriesterdesMinistrorums extends Eintrag {

	public IGPriesterdesMinistrorums() {
		name = "Priester des Ministorums";
		grundkosten = 45;
		this.setEintragsCNT(0);

		BuildaHQ.addToInformationVector("IGPriesterdesMinistrorum", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGMinistrorumPriest.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Schrotflinte", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Eviscerator", 15));

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("IGPriesterdesMinistrorum") > 5) {
			setFehlermeldung("0-5 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("IGPriesterdesMinistrorum", -1);
	}

}
