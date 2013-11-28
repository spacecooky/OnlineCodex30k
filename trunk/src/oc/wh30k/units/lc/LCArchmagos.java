package oc.wh30k.units.lc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class LCArchmagos extends Eintrag {

	RuestkammerStarter Servo;

	public LCArchmagos() {
		name = "Archmagos Dominus";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("LCArchmagos", 1);

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "LCMagosKammer", "");
		Servo.initKammer();
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("LCArchmagos", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
		
	}

}
