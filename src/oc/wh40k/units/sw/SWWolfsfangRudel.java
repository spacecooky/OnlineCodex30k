package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SWWolfsfangRudel extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;

	public SWWolfsfangRudel() {
		name = "Wolfsfang-Rudel\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolfsfänge", 2, 6, 15);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWWolfsfangrudel.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SWWolfsfangBoss", "Upgrade zum Rudelführer");
		rkBoss.initKammer();
		rkBoss.setAbwaehlbar(false);
		rkBoss.setButtonText("Upgrade zum Rudelführer");
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator(20);

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SWTransporterKammer", "Transportfahrzeug");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transportfahrzeug");
		add(rkTransport);

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SWDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setMaxAnzahl(squad.getModelle() - 1);
		o1.setLegal(o1.getAnzahl() == squad.getModelle() - 1);

		rkTransport.setAktiv(!rkPod.isSelected() && squad.getModelle() <= 10);
		rkPod.setAktiv(!rkTransport.isSelected() && squad.getModelle() <= 12);
	}

}
