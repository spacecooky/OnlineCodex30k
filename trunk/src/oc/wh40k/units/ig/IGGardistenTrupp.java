package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IGGardistenTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkTransport;

//	boolean lastState = false;

	public IGGardistenTrupp() {
		name = "Gardisten-Trupp";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Gardisten", 5, 10, 16);
		squad.setGrundkosten(5);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Gefechtsaufklärung", "Spezialoperation: Gefechtsaufklärung", 0));
		ogE.addElement(new OptionsGruppeEintrag("Luftlandung", "Spezialoperation: Luftlandung", 0));
		ogE.addElement(new OptionsGruppeEintrag("Infiltration", "Spezialoperation: Infiltration", 0));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade zum Sergeant", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
	}

}
