package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECMasterofsignal extends Eintrag {

	RuestkammerStarter Servo;

	public ECMasterofsignal() {
		name = "Master of signal";
		grundkosten = 85;

		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "ECConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, true, false, false, false, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		

		complete();
	}

	

	@Override
	public void refreshen() {
				
		
	}

}
