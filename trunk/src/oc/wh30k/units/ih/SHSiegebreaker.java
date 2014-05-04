package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SHSiegebreaker extends Eintrag {

	OptionsZaehlerGruppe o0;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter Servo;
	RuestkammerStarter Termi;

	public SHSiegebreaker() {
		name = "Siege breaker";
		grundkosten = 95;

		BuildaHQ.addToInformationVector("ECSiege", 1);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Phosphex bomb", 10));
		add(o0 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "SHConsulServoKammer", "");
		//Centurion, Champion, Chaplain, Forge, Librarian, Master, Moritat, Primus, Siege, Vigilator
		Servo.initKammer(false, false, false, false, false, false, false, false, true, false);
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		
		seperator();
		
		Termi = new RuestkammerStarter(ID, randAbstand, cnt, "SHConsulTermiKammer", "");
		//Consul, Librarian
		Termi.initKammer(true, false);
		Termi.setButtonText(BuildaHQ.translate("Terminatorweapons & Equipment"));
		add(Termi);
		Termi.setAbwaehlbar(false);


		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SHSiege", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
				
		Servo.setAktiv(!o1.isSelected());
		Termi.setAktiv(o1.isSelected());
	}

}
