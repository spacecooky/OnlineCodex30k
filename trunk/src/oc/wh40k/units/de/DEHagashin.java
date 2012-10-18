package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DEHagashin extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;
    RuestkammerStarter rkViper;

	public DEHagashin() {
		name = "Hagashîn-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hagashîn", 5, 15, 10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEHagashin.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Klingenpeitschen", 10));
        ogE.addElement(new OptionsGruppeEintrag("Hydraklingen", 10));
        ogE.addElement(new OptionsGruppeEintrag("Dornennetz & Pfähler", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Impulsminen", 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEHekatrix", "Upgrade zur Hekatrix");
		rkBoss.initKammer();
		add(rkBoss);

		seperator();

		rkBarke = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenbarke", "Schattenbarke");
		rkBarke.initKammer();
		add(rkBarke);

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenviper", "Schattenviper");
		rkViper.initKammer();
		add(rkViper);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 5)).intValue());
        
        oe1.setPreis(squad.getModelle() * 2);

        rkBarke.setAktiv(squad.getModelle() <= 10 && !rkViper.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 5 && !rkBarke.isSelected());
	}

}
