package oc.wh40k.units.da;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DASturmtrupp extends Eintrag {

	OptionsUpgradeGruppe trupp;
	OptionsEinzelUpgrade jump;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkBoss;

	public DASturmtrupp() {
		name = "Sturmtrupp";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DAAssaultSquad.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("5 Space Marines", 125));
		ogE.addElement(new OptionsGruppeEintrag("10 Space Marines", 235));
		add(trupp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Plasmapistole", 2, 15));
		add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(true, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		rkTransport.initKammer(true, false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		jump.setSelected(!rkTransport.isSelected());
		jump.setAktiv(!rkTransport.isSelected());
		
		if (!trupp.isSelected()) {
			trupp.setSelected(0, true);
		}
	}

}

