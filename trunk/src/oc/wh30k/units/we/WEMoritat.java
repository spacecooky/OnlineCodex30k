package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class WEMoritat extends Eintrag {

	RuestkammerStarter Servo;

	public WEMoritat() {
		name = "Moritat";
		grundkosten = 85;
		setCountToMinimum(false);

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "WEConsulServoKammer", "");
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
