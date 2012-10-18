package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DATaktischerTrupp extends Eintrag {

	OptionsUpgradeGruppe trupp;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkBoss;

	public DATaktischerTrupp() {
		name = "Taktischer Trupp";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DATacticalSquad.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("5 Space Marines", 90));
		ogE.addElement(new OptionsGruppeEintrag("10 Space Marines", 165));
		add(trupp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		rkTransport.initKammer(false, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		if (!trupp.isSelected()) {
			trupp.setSelected(0, true);
		}

		o1.setAktiv(trupp.isSelected("10 Space Marines"));
	}

}
