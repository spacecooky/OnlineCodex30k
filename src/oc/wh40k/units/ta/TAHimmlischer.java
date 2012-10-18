package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class TAHimmlischer extends Eintrag {

	OptionsEinzelUpgrade o2;
	RuestkammerStarter o5;

	public TAHimmlischer() {
		name = "Himmlischer";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/Himmlischer.gif"));
		

		seperator();

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "option", "Himmelsklinge", 10));

		seperator();

		o5 = new RuestkammerStarter(ID, randAbstand, cnt, "TAInfanterieKammer", "");
		o5.setGrundkosten(0);
		o5.initKammer(false, true);
		o5.setButtonText("Rüstkammer");
		add(o5);

		complete();
	}

	@Override
	public void refreshen() {
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova) setFehlermeldung("Nicht erlaubt!");
        else setFehlermeldung("");
	}

}
