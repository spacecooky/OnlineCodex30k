package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class WEForgelord extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter Servo;
	RuestkammerStarter Termi;
	RuestkammerStarter Forge;

	public WEForgelord() {
		name = "Forge lord";
		grundkosten = 85;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "WEConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, true, false, false, false, false, false, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		
		seperator();
		
		Termi = new RuestkammerStarter(ID, randAbstand, cnt, "WEConsulTermiKammer", "");
		Termi.initKammer();
		Termi.setButtonText(BuildaHQ.translate("Terminatorweapons & Equipment"));
		add(Termi);
		Termi.setAbwaehlbar(false);
		
		seperator();
		
		Forge = new RuestkammerStarter(ID, randAbstand, cnt, "WEForgeKammer", "");
		Forge.initKammer();
		Forge.setButtonText(BuildaHQ.translate("Techmarine Equipment"));
		add(Forge);
		Forge.setAbwaehlbar(false);


		complete();
	}


	@Override
	public void refreshen() {
				
		Servo.setAktiv(!o1.isSelected());
		Termi.setAktiv(o1.isSelected());
	}

}
