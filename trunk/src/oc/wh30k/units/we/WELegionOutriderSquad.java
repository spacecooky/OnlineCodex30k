package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionOutriderSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o1, o3, o4;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public WELegionOutriderSquad() {
		name = "Legion Outrider Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Outriders", 3, 10, 30);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chainswords", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainaxes", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked melta-gun", 25));
		ogE.addElement(new OptionsGruppeEintrag("Twin-linked plasma gun", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Outrider Sergeant");
		rkBoss.setGrundkosten(15);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, true, false, false, false, false, false, false, false, false, false, false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
		
		if(!o4.isSelected()) {o4.setSelected(0, true);}
        
		if (!o3.isSelected()) o3.setSelected(0, true);
		
		o1.setPreis(0, squad.getModelle()*5);
		
		o2.setMaxAnzahl(squad.getModelle()/3);
		
		o3.setPreis(1, squad.getModelle()*15);
		o3.setPreis(2, squad.getModelle()*25);
		o3.setPreis(3, squad.getModelle()*25);
	}

}
