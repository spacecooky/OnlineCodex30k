package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DAKompanieveteranentrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	RuestkammerStarter ot;

	public DAKompanieveteranentrupp() {
		name = "Kompanieveteranentrupp";
		grundkosten = 0;
		
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Kompanieveteranen", 5, 10, 20));

		add(ico = new oc.Picture("oc/wh40k/images/DACompanyVeteransSquad.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 30));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Parierschild", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		ot.initKammer(false, true, true);
		ot.setButtonText("Transporter");
		add(ot);

		complete();
	}

	@Override
	public void refreshen() {
		o3.setMaxAnzahl(squad.getModelle() - (o4.isSelected() ? 1 : 0) - (o5.isSelected() ? 1 : 0));
		o2.setMaxAnzahl(squad.getModelle());
		o1.setMaxAnzahl(squad.getModelle());
	}

}
