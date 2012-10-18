package oc.wh40k.units.tl;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TLAuxiliaFireSupportCohort extends Eintrag {

	AnzahlPanel teams;
	OptionsZaehlerGruppe teamsFK;

	public TLAuxiliaFireSupportCohort() {

		name = "Auxilia Fire Support Cohort\n";
		überschriftSetzen = true;
		kategorie = 5;
		grundkosten = 0;

		teams = new AnzahlPanel(ID, randAbstand, cnt, "Weapon teams", "Weapon teams", 3, 6, 15);
		add(teams);

		add(ico = new oc.Picture("oc/wh40k/images/TLAuxiliaFireSupportCohort.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL heavy stubber", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 10));

		teamsFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3);
		add(teamsFK);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		teamsFK.setMaxAnzahl(teams.getModelle());
		teamsFK.setLegal(teamsFK.getAnzahl()==teamsFK.getMaxAnzahl());

	}
}
