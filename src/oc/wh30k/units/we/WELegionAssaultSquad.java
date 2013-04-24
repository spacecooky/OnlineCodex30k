package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionAssaultSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o3;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;

	public WELegionAssaultSquad() {
		name = "Legion Assault Squad\n";
		grundkosten = 100;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Assault Marine", 10, 20, 15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combat shields", 3));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chainswords", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainaxes", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Assault Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(true, false, false, false, false, false, false, false, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
		
		if(!o3.isSelected()) {o3.setSelected(0, true);}
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
                
        o1.setPreis(0, squad.getModelle() * 5);
        o1.setPreis(1, squad.getModelle() * 3);
		o2.setMaxAnzahl(squad.getModelle() / 5);
	}

}
