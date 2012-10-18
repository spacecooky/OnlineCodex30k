package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DEHarpyien extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
	RuestkammerStarter rkBoss;

	public DEHarpyien() {
		name = "Harpyien-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Harpyien", 3, 10, 22);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEHarpyien.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shredder", 5));
        ogE.addElement(new OptionsGruppeEintrag("Splitterkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Impulsblaster", 10));
        ogE.addElement(new OptionsGruppeEintrag("Hitzelanze", 12));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkatapult", 15));
        ogE.addElement(new OptionsGruppeEintrag("Schattenlanze", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DESolarith", "Upgrade zum Solarith");
		rkBoss.initKammer();
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 5)).intValue() * 2);
	}

}
