package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class WELegionPraetor extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter Servo;
	RuestkammerStarter Termi;

	public WELegionPraetor() {
		name = "Legion Praetor";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("WEPraetor", 1);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "WEPraetorServoKammer", "");
		Servo.initKammer();
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		
		seperator();
		
		Termi = new RuestkammerStarter(ID, randAbstand, cnt, "WEPraetorTermiKammer", "");
		Termi.initKammer();
		Termi.setButtonText(BuildaHQ.translate("Terminatorweapons & Equipment"));
		add(Termi);
		Termi.setAbwaehlbar(false);
		
		
		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("WEPraetor", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		Servo.setAktiv(!o1.isSelected());
		Termi.setAktiv(o1.isSelected());
		
	}

}
