package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DAKompaniemeister extends Eintrag {

	public DAKompaniemeister() {
		name = "Kompaniemeister";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/DACompanyMaster.gif"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasmapistole", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 30));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodul", 20));

		BuildaHQ.addToInformationVector("DAKompaniemeister", 1);

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("DAKompaniemeister", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
	}

}
