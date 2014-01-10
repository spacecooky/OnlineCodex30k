package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SHMasterofsignal extends Eintrag {

	RuestkammerStarter Servo;

	public SHMasterofsignal() {
		name = "Master of signal";
		grundkosten = 85;

		BuildaHQ.addToInformationVector("SHSignal", 1);
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "SHConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, true, false, false, false, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		

		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SHSignal", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
				
		
	}

}
