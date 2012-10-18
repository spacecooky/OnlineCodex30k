package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.UncertainDarkEldarCorsairAllies;

public class DEKabalenkrieger extends UncertainDarkEldarCorsairAllies {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;
    RuestkammerStarter rkViper;

	public DEKabalenkrieger() {
		name = "Kabalenkrieger-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Kabalenkrieger", 5, 20, 9);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEKabalenkrieger.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shredder", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkatapult", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Splitterkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Schattenlanze", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DESybarith", "Upgrade zum Sybarith");
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
        super.refreshen();
        
        o2.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 10)).intValue());

        rkBarke.setAktiv(squad.getModelle() <= 10 && !rkViper.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 5 && !rkBarke.isSelected());
	}
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
