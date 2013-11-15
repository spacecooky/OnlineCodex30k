package oc.wh30k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ORArchmagos extends Eintrag {

	RuestkammerStarter Servo;

	public ORArchmagos() {
		name = "Archmagos Reductor";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("ORArchmagos", 1);

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "ORMagosKammer", "");
		Servo.initKammer();
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("ORArchmagos", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
		
	}

}
