package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DATechmarineKammer extends RuestkammerVater {

	RuestkammerStarter rkTransport;

	public DATechmarineKammer() {
		grundkosten = 75;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/DATechmarine.gif"));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasma-Pistole", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servoharnisch", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servitor: Servoarm", "Servitor mit Servoarm", 25));
		ogE.addElement(new OptionsGruppeEintrag("Servitor: SchweBo", "Servitor mit Schwerem Bolter", 25));
		ogE.addElement(new OptionsGruppeEintrag("Servitor: Multimelta", "Servitor mit Multimelter", 25));
		ogE.addElement(new OptionsGruppeEintrag("Servitor: PlasKa", "Servitor mit Plasmakanone", 35));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter", 1); // ,1 wegen ruestkammer in ruestkammer
		rkTransport.initKammer(false, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}
	
}
