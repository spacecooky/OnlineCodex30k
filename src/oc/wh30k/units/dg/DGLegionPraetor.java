package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DGLegionPraetor extends Eintrag {

	OptionsUpgradeGruppe o0, o1;
	RuestkammerStarter Servo;
	RuestkammerStarter Termi;

	public DGLegionPraetor() {
		name = "Legion Praetor";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("DGPraetor", 1);
		
		/*seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angel's wrath", 0));
		ogE.addElement(new OptionsGruppeEintrag("Armoured spearhead", 0));
		ogE.addElement(new OptionsGruppeEintrag("Orbital assault", 0));
		ogE.addElement(new OptionsGruppeEintrag("Pride of the Legion", 0));
		add(o0 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));*/
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 35));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		Servo = new RuestkammerStarter(ID, randAbstand, cnt, "DGPraetorServoKammer", "");
		Servo.initKammer();
		Servo.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Servo);
		Servo.setAbwaehlbar(false);
		
		seperator();
		
		Termi = new RuestkammerStarter(ID, randAbstand, cnt, "DGPraetorTermiKammer", "");
		Termi.initKammer();
		Termi.setButtonText(BuildaHQ.translate("Terminatorweapons & Equipment"));
		add(Termi);
		Termi.setAbwaehlbar(false);
				
		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("DGPraetor", -1);
		if (o1.isSelected()) {BuildaHQ.addToInformationVector("DGTermiPraetor", -1);}
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		Servo.setAktiv(!o1.isSelected());
		Termi.setAktiv(o1.isSelected());
		
		if (o1.isSelected()) {
		BuildaHQ.addToInformationVector("DGTermiPraetor", 1);	
		}
		else {
		BuildaHQ.addToInformationVector("DGTermiPraetor", -1);	
		}
		
		int TermiLegal = BuildaHQ.getCountFromInformationVector("DGTermiPraetor");
		if (TermiLegal < 0) {
			BuildaHQ.setInformationVectorValue("DGTermiPraetor", 0);
		}
		
	}

}
