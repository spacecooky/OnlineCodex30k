package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DADevastortrupp extends Eintrag {

	RuestkammerStarter rkTransport;
	RuestkammerStarter rkBoss;
	OptionsUpgradeGruppe trupp;

	public DADevastortrupp() {
		name = "Devastortrupp";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DADevastatorSquad.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("5 Space Marines", 90));
		ogE.addElement(new OptionsGruppeEintrag("10 Space Marines", 165));
		add(trupp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

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
	}

}
