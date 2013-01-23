package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SHMoritat extends Eintrag {

	RuestkammerStarter Servo;

	public SHMoritat() {
		name = "Moritat";
		grundkosten = 85;

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "SHConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, false, true, false, false, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);		
		

		complete();
	}

	

	@Override
	public void refreshen() {
				
		
	}

}
