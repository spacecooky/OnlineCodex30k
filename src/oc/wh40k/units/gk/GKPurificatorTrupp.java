package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class GKPurificatorTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
	OptionsEinzelUpgrade stab;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

	public GKPurificatorTrupp() {
		name = "Purificator-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Purificatoren", 5, 10, 24);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/GKPurificatorTrupp.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(stab = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wehrstab", "1 x Nemesis-Wehrstab", 25));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psipulser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

   		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Psi-Aktive Munition", 20));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "GKPurificatorRitter", "Upgrade zum Ritter der Flamme");
		rkBoss.initKammer();
        rkBoss.setButtonText("Upgrade zum Ritter der Flamme", false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "GKTransporterKammer", "Transporter");
		rkTransport.initKammer(true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		int subtractor = o2.getAnzahl() + (stab.isSelected()? 1 : 0) + 1; // last one is the boss

		o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);

        o2.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5) * 2);

        o3.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        o3.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        
        stab.setAktiv(!((Boolean) rkBoss.getKammer().getSpecialValue()));
        
        rkBoss.getKammer().switchEntry("WEHRSTAB", !stab.isSelected());

		rkTransport.getPanel().setLocation(
			(int) rkTransport.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	}

}
