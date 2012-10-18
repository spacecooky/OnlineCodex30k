package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDJaegerinnendesSlaanesh extends Eintrag {

	AnzahlPanel CDJaegerinnendesSlaanesh;

	public CDJaegerinnendesSlaanesh() {

		name = "Jägerinnen des Slaanesh";

		grundkosten = 0;



		CDJaegerinnendesSlaanesh = new AnzahlPanel(ID, randAbstand, cnt, "Jägerinnen des Slaanesh", 5, 20, 17);

		add(CDJaegerinnendesSlaanesh);





		add(ico = new oc.Picture("oc/wh40k/images/CDJaegerinnendesSlaanesh.gif"));

		seperator();







		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lähmender Blick", 5));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosikone", 25));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des  Chaos", 5));





		complete();

	}

	@Override
	public void refreshen() {
	}
}
