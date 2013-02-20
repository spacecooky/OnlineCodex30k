package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionJetbikeSkyHunterSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o1, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public WELegionJetbikeSkyHunterSquadron() {
		name = "Legion Jetbike Sky Hunter Squadron Squad\n";
		grundkosten = 30;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sky Hunter", 3, 10, 35);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Culvarin", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chainswords", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainaxes", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Sky Hunter Sergeant");
		rkBoss.setGrundkosten(15);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, true, false, false, false, false, false, false, false, false, false, false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
        
		if(!o3.isSelected()) {o3.setSelected(0, true);}
		
		o1.setPreis(0, squad.getModelle()*5);
		
		o2.setMaxAnzahl(squad.getModelle()/3);
	}

}
