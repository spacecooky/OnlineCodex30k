package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DKEngineerSquad extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	RuestkammerStarter rkTransport;
    AnzahlPanel squad;

	public DKEngineerSquad() {
		name = "Death Corps Engineer Squad";
		grundkosten = 0;
        überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

		seperator();

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Engineers", 5, 10, 10));
        squad.setNichtDieErsteOption(true);

		seperator();
        
		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Gas grenades", 20));

        seperator();

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mole launcher-team", "Heavy Weapons Team with Mole Launcher", 5));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Demolition charge", 20));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Upgrade to Watchmaster", 10));

        seperator(5);

		add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Melta bombs", 5));

        seperator();

		add(o2 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Hades Breaching Drill", 50));

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);

        setEintragsCNT(o2.isSelected() ? 2 : 1);
	}

}
